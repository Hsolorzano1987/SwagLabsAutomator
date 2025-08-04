package org.example.driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class AppiumAndroidDriver {
    private static AppiumDriver<MobileElement> driver;

    private AppiumAndroidDriver() {
    }

    public static AppiumDriver<MobileElement> getDriver() {
        if (driver == null || driver.getSessionId() == null) {
            InicializarDriver();
        }
        return driver;
    }

    private static void InicializarDriver() {
        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("deviceName", "emulator-5554");
            capabilities.setCapability("platformName", "Android");
            capabilities.setCapability("platformVersion", "16");
            capabilities.setCapability("appPackage", "com.swaglabsmobileapp");
            capabilities.setCapability("appActivity", "com.swaglabsmobileapp.MainActivity");
            capabilities.setCapability("autoGrantPermissions", true);
            capabilities.setCapability("noReset", true);
            driver = new AppiumDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException("Error al inicializar el driver de Appium", e);
        }
    }
}