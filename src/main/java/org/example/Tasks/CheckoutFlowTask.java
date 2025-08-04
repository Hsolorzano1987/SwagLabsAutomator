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
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.example.UI.CheckoutUI;
import org.example.Utils.DatosCheckoutCSV;
import org.openqa.selenium.Dimension;

import java.time.Duration;
import java.util.Map;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class CheckoutFlowTask implements Task {

    public static CheckoutFlowTask conDatosCSV() {
        return Tasks.instrumented(CheckoutFlowTask.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Map<String, String> datos = DatosCheckoutCSV.obtenerDatos();
        MobileDriver<?> driver = (MobileDriver<?>) BrowseTheWeb.as(actor).getDriver();

        actor.attemptsTo(
                WaitUntil.the(CheckoutUI.FIRST_NAME, isVisible()).forNoMoreThan(5).seconds(),
                Enter.theValue(datos.get("First Name")).into(CheckoutUI.FIRST_NAME),
                Enter.theValue(datos.get("Last Name")).into(CheckoutUI.LAST_NAME),
                Enter.theValue(datos.get("Zip/Postal Code")).into(CheckoutUI.POSTAL_CODE),
                Click.on(CheckoutUI.CONTINUE_BUTTON)
        );


        int maxScrolls = 6;
        int scrollCount = 0;

        while (!CheckoutUI.FINISH_BUTTON.resolveFor(actor).isVisible() && scrollCount < maxScrolls) {
            Dimension size = driver.manage().window().getSize();
            int startX = size.width / 2;
            int startY = (int) (size.height * 0.8);
            int endY = (int) (size.height * 0.2);

            new TouchAction<>(driver)
                    .press(PointOption.point(startX, startY))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(400)))
                    .moveTo(PointOption.point(startX, endY))
                    .release()
                    .perform();

            scrollCount++;
        }

        actor.attemptsTo(
                WaitUntil.the(CheckoutUI.FINISH_BUTTON, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(CheckoutUI.FINISH_BUTTON)
        );

    }
}
