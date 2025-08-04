package org.example.UI;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class CheckoutUI {

    public static final Target FIRST_NAME = Target.the("campo nombre")
            .located(By.xpath("//android.widget.EditText[@content-desc='test-First Name']"));

    public static final Target LAST_NAME = Target.the("campo apellido")
            .located(By.xpath("//android.widget.EditText[@content-desc='test-Last Name']"));

    public static final Target POSTAL_CODE = Target.the("código postal")
            .located(By.xpath("//android.widget.EditText[@content-desc='test-Zip/Postal Code']"));

    public static final Target CONTINUE_BUTTON = Target.the("botón continuar")
            .located(By.xpath("//android.view.ViewGroup[@content-desc='test-CONTINUE']"));

    public static final Target FINISH_BUTTON = Target.the("botón FINISH")
            .located(By.xpath("//android.view.ViewGroup[@content-desc='test-FINISH']"));

    public static final Target BACK_HOME_BUTTON = Target.the("botón Back Home")
            .located(By.xpath("//android.view.ViewGroup[@content-desc='test-BACK HOME']"));
}