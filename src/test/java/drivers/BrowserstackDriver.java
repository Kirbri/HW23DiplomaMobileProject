package drivers;

import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import owner.config.BrowserstackConfig;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;


public class BrowserstackDriver implements WebDriverProvider {

    public static final BrowserstackConfig BROWERSTACK_CONFIG = ConfigFactory.create(BrowserstackConfig.class, System.getProperties());

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", BROWERSTACK_CONFIG.getDeviceName());
        caps.setCapability("os_version", BROWERSTACK_CONFIG.getPlatformVersion());
        caps.setCapability("autoAcceptAlerts", true);
        caps.setCapability("app", BROWERSTACK_CONFIG.getBrowserstackApp());
        caps.setCapability("project", BROWERSTACK_CONFIG.getProjectName());
        caps.setCapability("build", BROWERSTACK_CONFIG.getBuildName());
        caps.setCapability("name", BROWERSTACK_CONFIG.getTestName());
        try {
            return new AndroidDriver(new URL("https://" + BROWERSTACK_CONFIG.getProfileLogin() + ":" + BROWERSTACK_CONFIG.getProfilePassword()
                    + "@hub-cloud.browserstack.com/wd/hub"), caps);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}