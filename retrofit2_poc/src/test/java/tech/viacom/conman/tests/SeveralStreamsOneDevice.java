package tech.viacom.conman.tests;

import org.joda.time.DateTime;
import org.testng.Assert;
import org.testng.annotations.Test;
import retrofit2.Response;
import tech.viacom.conman.client.ApiClient;
import tech.viacom.conman.model.Device;
import tech.viacom.conman.model.StreamModel;
import tech.viacom.conman.model.UserData;
import tech.viacom.conman.service.StreamService;

import java.io.IOException;
import java.util.UUID;

/**
 * Created by kiryl_zayets on 2/27/17.
 */
public class SeveralStreamsOneDevice {

    @Test
    public void create() throws IOException {
        ApiClient apiClient = new ApiClient();
        Device newDevice1 = new Device(UUID.randomUUID().toString());


        UserData userData = new UserData("mtv", "tve", "test", "qwsxcdfwyg",
                "mtv", "mtvplay", DateTime.now().plus(30000).toString(),
                DateTime.now().plus(30000));

        StreamService streamService = apiClient.createService(StreamService
                .class, userData);

        streamService.create(newDevice1).execute();
        streamService.create(newDevice1).execute();
        streamService.create(newDevice1).execute();
        streamService.create(newDevice1).execute();
        Response<StreamModel> response = streamService.create(newDevice1).execute();
        Assert.assertEquals(200, response.code());

    }

}
