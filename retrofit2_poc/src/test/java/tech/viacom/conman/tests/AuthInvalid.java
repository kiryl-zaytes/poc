package tech.viacom.conman.tests;

import org.joda.time.DateTime;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tech.viacom.conman.client.ApiClient;
import tech.viacom.conman.model.Device;
import tech.viacom.conman.model.UserData;

import java.util.UUID;

/**
 * Created by kiryl_zayets on 2/27/17.
 */
public class AuthInvalid {

    @DataProvider(name = "auth_illegal")
    public Object[][] generateAuthIllegalCases(){
        return new Object[][]{
                {"illegal_provider_id", new UserData("mtv", "tve", "illegal", "qwsxcdfwyg",
                        "mtv", "mtvplay", DateTime.now().plus(30000).toString(),
                        DateTime.now().plus(30000))},
                {"illegal_auth_provider",new UserData("mtv", "illegal", "test", "qwsxcdfwyg",
                        "mtv", "mtvplay", DateTime.now().plus(30000).toString(),
                        DateTime.now().plus(30000))},
                {"missing_values", new UserData("mtv", "", "", "qwsxcdfwyg",
                        "mtv", "mtvplay", DateTime.now().plus(30000).toString(),
                        DateTime.now().plus(30000))}
        };

    }
    @Test(dataProvider = "auth_illegal")
    public void createStream(UserData userData){
        ApiClient apiClient = new ApiClient();
        Device newDevice = new Device(UUID.randomUUID().toString());

    }
}
