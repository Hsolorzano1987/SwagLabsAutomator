package org.example.Tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import org.example.UI.LoginUI;
import org.example.Utils.CredentialsReader;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class LoginTask implements Task {

    private final String usuario;
    private final String contrasena;

    public LoginTask(String usuario, String contrasena) {
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    public static LoginTask loginWithDefaultCredentials() {
        return instrumented(LoginTask.class,
                CredentialsReader.getUsuario(),
                CredentialsReader.getContrasena());
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(usuario).into(LoginUI.USERNAME_FIELD),
                Enter.theValue(contrasena).into(LoginUI.PASSWORD_FIELD),
                Click.on(LoginUI.LOGIN_BUTTON)
        );
    }
}
