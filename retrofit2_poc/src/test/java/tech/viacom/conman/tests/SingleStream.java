package tech.viacom.conman.tests;

import org.joda.time.DateTime;
import org.testng.Assert;
import org.testng.annotations.Test;
import retrofit2.Call;
import retrofit2.Response;
import tech.viacom.conman.client.ApiClient;
import tech.viacom.conman.model.Device;
import tech.viacom.conman.model.StreamModel;
import tech.viacom.conman.model.UserData;
import tech.viacom.conman.service.StreamService;

import java.io.IOException;
import java.util.UUID;

/**
 * Created by kiryl_zayets on 2/26/17.
 */
public class SingleStream {

    @Test
    public void create() throws IOException {
        ApiClient apiClient = new ApiClient();
        Device newDevice = new Device(UUID.randomUUID().toString());
        UserData userData = new UserData("mtv", "tve", "test", "qwsxcdfwyg",
                "mtv", "mtvplay", DateTime.now().plus(30000).toString(),
                DateTime.now().plus(30000));

        StreamService streamService = apiClient.createService(StreamService
                .class, userData);
        Call<StreamModel> streamServiceCall = streamService.create(newDevice);
        Response<StreamModel> response = streamServiceCall.execute();
        Assert.assertEquals(200, response.code());
        Assert.assertEquals(response.body().providerId, userData.getMpvdId() );
        Assert.assertEquals(response.body().deviceId, newDevice.getDeviceId());
    }

}
