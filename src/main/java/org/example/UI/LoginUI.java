package org.example.UI;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginUI {

    public static final Target USERNAME_FIELD = Target.the("Campo de usuario")
            .located(By.xpath("//android.widget.EditText[@content-desc='test-Username']"));

    public static final Target PASSWORD_FIELD = Target.the("Campo de contraseña")
            .located(By.xpath("//android.widget.EditText[@content-desc='test-Password']"));

    public static final Target LOGIN_BUTTON = Target.the("Botón de login")
            .located(By.xpath("//android.view.ViewGroup[@content-desc='test-LOGIN']"));
}