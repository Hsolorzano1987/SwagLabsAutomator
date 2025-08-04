package org.example.Questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CompraExitosaQuestion implements Question<Boolean> {

    private static final Target MENSAJE_COMPRA = Target.the("mensaje de compra exitosa")
            .located(By.xpath("//android.widget.ScrollView[@content-desc=\"test-CHECKOUT: COMPLETE!\"]/android.view.ViewGroup/android.widget.TextView[1]"));

    public static CompraExitosaQuestion esVisible() {
        return new CompraExitosaQuestion();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return MENSAJE_COMPRA.resolveFor(actor).isVisible()
                && MENSAJE_COMPRA.resolveFor(actor).getText().trim().equals("THANK YOU FOR YOU ORDER");
    }
}
