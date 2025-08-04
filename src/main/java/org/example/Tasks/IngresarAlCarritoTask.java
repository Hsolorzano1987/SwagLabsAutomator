package org.example.Tasks;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class IngresarAlCarritoTask implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        Target iconoCarrito = Target.the("Ícono del carrito de compras")
                .located(By.xpath("//android.view.ViewGroup[@content-desc='test-Cart']/android.view.ViewGroup/android.widget.ImageView"));

        actor.attemptsTo(
                WaitUntil.the(iconoCarrito, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(iconoCarrito)
        );
    }

    public static IngresarAlCarritoTask ahora() {
        return instrumented(IngresarAlCarritoTask.class);
    }
}
