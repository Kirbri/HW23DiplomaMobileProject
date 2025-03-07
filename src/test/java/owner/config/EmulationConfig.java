package owner.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:properties/${deviceHost}.properties",
})
public interface EmulationConfig extends Config {

    @Key("deviceName")
    String getDeviceName();

    @Key("platformVersion")
    String getPlatformVersion();

    @Key("appPackage")
    String getAppPackage();

    @Key("appActivity")
    String getAppActivity();

    @Key("appiumServerUrl")
    String getAppiumServerUrl();

    @Key("appVersion")
    String getAppVersion();

    @Key("appUrl")
    String getAppUrl();
}