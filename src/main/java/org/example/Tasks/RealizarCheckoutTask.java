package org.example.Tasks;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class RealizarCheckoutTask implements Task {

    private static final Target BTN_CHECKOUT = Target.the("Botón Checkout")
            .located(By.xpath("//android.view.ViewGroup[@content-desc='test-CHECKOUT']"));
    

    public static RealizarCheckoutTask ahora() {
        return Tasks.instrumented(RealizarCheckoutTask.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        MobileDriver<?> driver = (MobileDriver<?>) BrowseTheWeb.as(actor).getDriver();

        int maxScrolls = 8;
        int scrollCount = 0;

        while (!BTN_CHECKOUT.resolveFor(actor).isVisible() && scrollCount < maxScrolls) {
            Dimension size = driver.manage().window().getSize();
            int startY = (int) (size.height * 0.7);
            int endY = (int) (size.height * 0.3);
            int startX = size.width / 2;

            new TouchAction<>(driver)
                    .press(PointOption.point(startX, startY))
                    .waitAction(WaitOptions.waitOptions(java.time.Duration.ofMillis(800)))
                    .moveTo(PointOption.point(startX, endY))
                    .release()
                    .perform();

            scrollCount++;
        }

        actor.attemptsTo(
                WaitUntil.the(BTN_CHECKOUT, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(BTN_CHECKOUT)
        );
    }
}