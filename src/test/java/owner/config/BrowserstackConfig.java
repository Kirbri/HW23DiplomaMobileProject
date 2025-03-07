package owner.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:properties/${deviceHost}.properties",
})
public interface BrowserstackConfig extends Config {

    @Key("browserstackUser")
    String getProfileLogin();

    @Key("browserstackKey")
    String getProfilePassword();

    @Key("deviceName")
    String getDeviceName();

    @Key("platformVersion")
    String getPlatformVersion();

    @Key("browserstackApp")
    String getBrowserstackApp();

    @Key("projectName")
    String getProjectName();

    @Key("buildName")
    String getBuildName();

    @Key("testName")
    String getTestName();
}