package tech.viacom.conman.model;

/**
 * Created by kiryl_zayets on 2/26/17.
 */
public class Device {


    private String deviceId;

    public Device(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    @Override
    public String toString() {
        return "Device{" +
                "deviceId='" + deviceId + '\'' +
                '}';
    }
}
