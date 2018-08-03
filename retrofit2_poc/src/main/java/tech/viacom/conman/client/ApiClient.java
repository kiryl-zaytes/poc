package tech.viacom.conman.client;

import com.viacom.vip.infrastructure.jwt.TokenBuilder;
import com.viacom.vip.utils.ResourceUtils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.impl.DefaultClaims;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.joda.time.DateTime;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;
import tech.viacom.conman.model.Device;
import tech.viacom.conman.model.StreamModel;
import tech.viacom.conman.model.UserData;
import tech.viacom.conman.service.StreamService;

import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * Created by kiryl_zayets on 2/26/17.
 */
public class ApiClient {

    final String API_URL = "https://concurrency-dev.mtvnservices.com/";
    final static byte[] cert = ResourceUtils.read("/token/test_private_key.der");

    public <S> S createService(Class<S> serviceClass, UserData userData) {
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(JacksonConverterFactory.create());
        OkHttpClient.Builder defaultHttpClient = new OkHttpClient.Builder();

        defaultHttpClient.addInterceptor(chain -> {
            Request authorisedRequest = chain.request().newBuilder()
                    .addHeader("Authorization", buildToken(userData)).
                            addHeader("Content-Type", "application/json")
                    .build();
            return chain.proceed(authorisedRequest);
        });
        defaultHttpClient.connectTimeout(10, TimeUnit.SECONDS);
        defaultHttpClient.writeTimeout(10, TimeUnit.SECONDS);
        defaultHttpClient.readTimeout(30, TimeUnit.SECONDS);

        Retrofit retrofit = builder.client(defaultHttpClient.build()).build();
        return retrofit.create(serviceClass);
    }


    public String buildToken(UserData userData) {
        TokenBuilder tb = new TokenBuilder(cert);
        Claims claims = new DefaultClaims();
        claims.put("brandProfileId", userData.getBrandProfileId());
        claims.put("authProvider", userData.getAuthProvider());
        claims.put("mvpdId", userData.getMpvdId());
        claims.put("authId", userData.getAuthId());
        claims.put("brandId", userData.getBrandId());
        claims.put("appId", userData.getAppId());
        claims.put("validUntil", userData.getValidUntil());
        return " Bearer " + tb.encrypt(claims, userData.getOffset());
    }

    public static void main(String[] args) {
        ApiClient apiClient = new ApiClient();

        UserData userData = new UserData("mtv", "tve", "test", "qwsxcdfwyg",
                "mtv", "mtvplay", DateTime.now().plus(30000).toString(),
                DateTime.now().plus(30000));

        StreamService streamService = apiClient.createService(StreamService
                .class, userData);

        Call<StreamModel> streamServiceCall = streamService.create(new Device
                (UUID.randomUUID().toString()));

        System.out.println(UUID
                .randomUUID().toString());
        try {
            StreamModel stream = streamServiceCall.execute().body();
            System.out.println(stream.estimatedEnd);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
