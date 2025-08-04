package org.example.Tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.example.interactions.ScrollUntilVisibleInteraction;

import java.util.List;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;


public class SeleccionarProductosTask implements Task {

    private final List<String> nombres;

    public SeleccionarProductosTask(List<String> nombres) {
        this.nombres = nombres;
    }

    public static SeleccionarProductosTask conNombres(List<String> nombres) {
        return Tasks.instrumented(SeleccionarProductosTask.class, nombres);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        for (String nombre : nombres) {
            Target boton = botonAgregarPorNombre(nombre);


            if (!boton.resolveFor(actor).isVisible()) {
                actor.attemptsTo(
                        ScrollUntilVisibleInteraction.hastaVer(botonAgregarPorNombre(nombre), 10)
                );
            }

           
            actor.attemptsTo(
                    WaitUntil.the(boton, isVisible()).forNoMoreThan(10).seconds(),
                    Click.on(boton)
            );
        }
    }

    private Target botonAgregarPorNombre(String nombreProducto) {
        return Target.the("Botón ADD TO CART para " + nombreProducto)
                .locatedBy("//android.widget.TextView[@text='{0}']/ancestor::android.view.ViewGroup//android.view.ViewGroup[@content-desc='test-ADD TO CART']")
                .of(nombreProducto);
    }
}
