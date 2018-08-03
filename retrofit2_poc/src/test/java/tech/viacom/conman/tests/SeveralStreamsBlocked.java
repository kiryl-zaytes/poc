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
public class SeveralStreamsBlocked {

    @Test
    public void create() throws IOException {
        ApiClient apiClient = new ApiClient();
        Device newDevice1 = new Device(UUID.randomUUID().toString());
        Device newDevice2 = new Device(UUID.randomUUID().toString());
        Device newDevice3 = new Device(UUID.randomUUID().toString());
        Device newDevice4 = new Device(UUID.randomUUID().toString());
        Device newDevice5 = new Device(UUID.randomUUID().toString());

        UserData userData = new UserData("mtv", "tve", "test", "qwsxcdfwyg",
                "mtv", "mtvplay", DateTime.now().plus(30000).toString(),
                DateTime.now().plus(30000));

        StreamService streamService = apiClient.createService(StreamService
                .class, userData);

        streamService.create(newDevice1).execute();
        streamService.create(newDevice2).execute();
        streamService.create(newDevice3).execute();
        streamService.create(newDevice4).execute();
        Response<StreamModel> response = streamService.create(newDevice1).execute();
        streamService.create(newDevice5).execute();

        Response<StreamModel> response2 = streamService.create(newDevice2).execute();
        Assert.assertEquals(403, response.code());
        Assert.assertEquals(403, response2.code());

    }


}
