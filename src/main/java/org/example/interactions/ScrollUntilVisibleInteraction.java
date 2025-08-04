package org.example.interactions;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.webdriver.ThucydidesWebDriverSupport;
import org.openqa.selenium.Dimension;

import java.time.Duration;

public class ScrollUntilVisibleInteraction implements Interaction {

    private final Target objetivo;
    private final int maxScrolls;

    public ScrollUntilVisibleInteraction(Target objetivo, int maxScrolls) {
        this.objetivo = objetivo;
        this.maxScrolls = maxScrolls;
    }

    public static ScrollUntilVisibleInteraction hastaVer(Target objetivo, int maxScrolls) {
        return new ScrollUntilVisibleInteraction(objetivo, maxScrolls);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        MobileDriver<?> driver = (MobileDriver<?>) ThucydidesWebDriverSupport.getDriver();

        int scrollCount = 0;

        while (!objetivo.resolveFor(actor).isVisible() && scrollCount < maxScrolls) {
            Dimension size = driver.manage().window().getSize();

            int startY = (int) (size.height * 0.7);
            int endY = (int) (size.height * 0.3);
            int startX = size.width / 2;

            new TouchAction<>(driver)
                    .press(PointOption.point(startX, startY))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(800)))
                    .moveTo(PointOption.point(startX, endY))
                    .release()
                    .perform();

            scrollCount++;
        }
    }
}

