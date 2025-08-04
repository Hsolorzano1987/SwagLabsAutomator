package org.example.Tasks;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class EliminarProductoTask implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        Target botonEliminarSegundo = Target.the("Botón eliminar del segundo producto")
                .located(By.xpath("(//android.view.ViewGroup[@content-desc=\"test-REMOVE\"])[2]"));

        actor.attemptsTo(
                WaitUntil.the(botonEliminarSegundo, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(botonEliminarSegundo)
        );
    }

    public static EliminarProductoTask delSegundoProducto() {
        return instrumented(EliminarProductoTask.class);
    }
}
