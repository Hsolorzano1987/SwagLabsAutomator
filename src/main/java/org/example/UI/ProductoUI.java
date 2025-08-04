package org.example.UI;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class ProductoUI {

    public static Target productoConIndice(int indice) {
        return Target.the("producto con índice")
                .located(By.xpath("(//div[@class='producto'])[" + indice + "]"));
    }

    public static Target botonAgregarPorNombre(String nombreProducto) {
        return Target.the("botón agregar por nombre")
                .locatedBy("//android.widget.TextView[@text='{0}']/../..//android.view.ViewGroup[@content-desc='test-ADD TO CART']")
                .of(nombreProducto);
    }
}

