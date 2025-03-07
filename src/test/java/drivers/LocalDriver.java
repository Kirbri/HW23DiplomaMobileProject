package drivers;

import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import owner.config.EmulationConfig;

import javax.annotation.Nonnull;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import static io.appium.java_client.remote.AutomationName.ANDROID_UIAUTOMATOR2;
import static io.appium.java_client.remote.MobilePlatform.ANDROID;
import static org.apache.commons.io.FileUtils.copyInputStreamToFile;

public class LocalDriver implements WebDriverProvider {

    public static final EmulationConfig EMULATION_CONFIG = ConfigFactory.create(EmulationConfig.class, System.getProperties());

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        UiAutomator2Options options = new UiAutomator2Options();

        options.setAutomationName(ANDROID_UIAUTOMATOR2)
                .setPlatformName(ANDROID)
                .setPlatformVersion(EMULATION_CONFIG.getPlatformVersion())
                .setDeviceName(EMULATION_CONFIG.getDeviceName())
                .setApp(getAppPath())
                .setAppPackage(EMULATION_CONFIG.getAppPackage())
                .setAppActivity(EMULATION_CONFIG.getAppActivity());
        try {
            return new AndroidDriver(new URL(EMULATION_CONFIG.getAppiumServerUrl()), options);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    private String getAppPath() {
        String appVersion = EMULATION_CONFIG.getAppVersion();
        String appUrl = EMULATION_CONFIG.getAppUrl() + appVersion;
        String appPath = "src/test/resources/apps/" + appVersion;

        File app = new File(appPath);
        if (!app.exists()) {
            try (InputStream in = new URL(appUrl).openStream()) {
                copyInputStreamToFile(in, app);
            } catch (IOException e) {
                throw new AssertionError("Failed to download application", e);
            }
        }
        return app.getAbsolutePath();
    }
}