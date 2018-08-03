package tech.viacom.conman.service;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import tech.viacom.conman.model.Device;
import tech.viacom.conman.model.StreamModel;

/**
 * Created by kiryl_zayets on 2/26/17.
 */
public interface StreamService {

    @POST("streams")
    Call<StreamModel> create(@Body Device deviceId);

}
