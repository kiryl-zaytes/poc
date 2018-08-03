package com.poc.pubcentral.tests.amazon;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClient;
import com.amazonaws.services.sqs.model.DeleteMessageRequest;
import com.amazonaws.services.sqs.model.Message;
import com.amazonaws.services.sqs.model.ReceiveMessageRequest;
import com.poc.pubcentral.bo.SeriesPojo;
import com.poc.pubcentral.page.content.Series;
import com.poc.pubcentral.page.drupal.Configuration.AWSConfiguration;
import com.poc.pubcentral.page.drupal.Extend;
import com.poc.pubcentral.tests.base.BaseTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by kiryl_zayets on 10/16/15.
 */
public class CheckQueue extends BaseTest {

    @Value("${amazon.key}") public String key;
    @Value("${amazon.secret}") public String secret;
    @Value("${amazon.queue}") public String queue;

    @Autowired Extend extendPage;
    @Autowired AWSConfiguration awsConfiguration;
    @Autowired Series series;

    SeriesPojo seriesPojoBO;
    AmazonSQS sqs;
    ReceiveMessageRequest receiveMessageRequest;
    List<Message> messages;

    @BeforeClass(groups = "amazon")
    public void setup() {
//        extendPage.navigate(pageMapping.EXTEND);
//        String text = extendPage.installModule("Pubcentral", "pc queue");
//        Assert.assertTrue(text.contains("4 modules have been enabled:"));
        awsConfiguration.navigate(pageMapping.AWS);
        awsConfiguration.configure(key, secret);
        seriesPojoBO = dao.getById(SeriesPojo.class, 3);
        AWSCredentials credentials = new BasicAWSCredentials(key, secret);
        sqs = new AmazonSQSClient(credentials);
        sqs.setEndpoint(queue);
        receiveMessageRequest = new
                ReceiveMessageRequest(queue).withMaxNumberOfMessages(10);
        messages = sqs.receiveMessage(receiveMessageRequest)
                .getMessages();

        for (Message msg : messages) {
            logger.info(msg.getBody());
            if (msg.toString().contains(seriesPojoBO.getTitle())) {
                sqs.deleteMessage(new DeleteMessageRequest().
                        withQueueUrl(queue).
                        withReceiptHandle(msg.getReceiptHandle()));
            }
        }
    }

    @Test(groups = "amazon")
    public void checkQueueContentIsPublished() {
        series.navigate(pageMapping.CREATE_SERIES);
        String message = series.create(seriesPojoBO);
        Assert.assertEquals(
                "Status message\nSeries " + seriesPojoBO.getTitle() +
                        " has been created.", message);
        String msg = "";
        while (!msg.contains(seriesPojoBO.getTitle())) {
            messages = sqs.receiveMessage(receiveMessageRequest).getMessages();
            msg = getExpectedItem(seriesPojoBO.getTitle(), messages);
        }
        Assert.assertTrue(msg.contains(seriesPojoBO.getTitle()));
    }

    public String getExpectedItem(String item, List<Message> messages) {
        String result = "";
        for (Message msg : messages) {
            if (msg.getBody().toString().contains(item)) {
                result = msg.getBody().toString();
                logger.info(msg.getBody());
                break;
            }
        }
        return result;
    }
}
