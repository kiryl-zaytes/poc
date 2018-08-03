package tech.viacom.conman.model;

import org.joda.time.DateTime;

/**
 * Created by kiryl_zayets on 2/26/17.
 */
public class UserData {

    private String brandProfileId;
    private String authProvider;
    private String mpvdId;
    private String authId;
    private String brandId;
    private String appId;
    private String validUntil;

    public UserData(String brandProfileId,
            String authProvider,
            String mpvdId,
            String authId,
            String brandId,
            String appId,
            String validUntil, DateTime offset) {
        this.brandProfileId = brandProfileId;
        this.authProvider = authProvider;
        this.mpvdId = mpvdId;
        this.authId = authId;
        this.brandId = brandId;
        this.appId = appId;
        this.validUntil = validUntil;
        this.offset = offset;
    }

    public DateTime getOffset() {
        return offset;
    }

    public void setOffset(DateTime offset) {
        this.offset = offset;
    }

    private DateTime offset;

    public String getBrandProfileId() {
        return brandProfileId;
    }

    public void setBrandProfileId(String brandProfileId) {
        this.brandProfileId = brandProfileId;
    }

    public String getAuthProvider() {
        return authProvider;
    }

    public void setAuthProvider(String authProvider) {
        this.authProvider = authProvider;
    }

    public String getMpvdId() {
        return mpvdId;
    }

    public void setMpvdId(String mpvdId) {
        this.mpvdId = mpvdId;
    }

    public String getAuthId() {
        return authId;
    }

    public void setAuthId(String authId) {
        this.authId = authId;
    }

    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getValidUntil() {
        return validUntil;
    }

    public void setValidUntil(String validUntil) {
        this.validUntil = validUntil;
    }
}

