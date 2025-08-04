package stepDefinitions;

import cucumber.api.DataTable;
import cucumber.api.java.Before;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import cucumber.api.java.es.Y;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.example.Questions.CompraExitosaQuestion;
import org.example.Tasks.CheckoutFlowTask;
import org.example.Tasks.EliminarProductoTask;
import org.example.Tasks.IngresarAlCarritoTask;
import org.example.Tasks.LoginTask;
import org.example.Tasks.RealizarCheckoutTask;
import org.example.Tasks.SeleccionarProductosTask;
import org.example.driver.AppiumAndroidDriver;

import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class FlujoCompraStepDefinitions {

    @Before
    public void prepararEscenario() {
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("Usuario")
                .can(BrowseTheWeb.with(AppiumAndroidDriver.getDriver()));
    }

    @Dado("^que estoy logueado en la aplicación SwagLabs$")
    public void queEstoyLogueadoEnLaAplicaciónSwagLabs() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                LoginTask.loginWithDefaultCredentials()
        );


    }

    @Cuando("^agrego al carrito los siguientes productos:$")
    public void agregoAlCarritoLosSiguientesProductos(DataTable productos) {
        List<String> nombres = productos.asList(String.class);
        OnStage.theActorInTheSpotlight().attemptsTo(
                SeleccionarProductosTask.conNombres(nombres)
        );
    }


    @Y("^voy al carrito de compras$")
    public void voyAlCarritoDeCompras() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                IngresarAlCarritoTask.ahora()
        );
    }

    @Y("^elimino un producto del carrito$")
    public void eliminoUnProductoDelCarrito() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                EliminarProductoTask.delSegundoProducto()
        );

    }

    @Y("^procedo a checkout$")
    public void procedoACheckout() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                RealizarCheckoutTask.ahora()
        );

    }

    @Y("^completo la información de envío con los datos del archivo \"([^\"]*)\"$")
    public void completoLaInformaciónDeEnvíoConLosDatosDelArchivo(String archivo) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                CheckoutFlowTask.conDatosCSV()
        );
    }


    @Y("^finalizo la compra$")
    public void finalizoLaCompra() {
        System.out.println("Compra finalizada");
    }

    @Entonces("^los productos confirmados en el checkout deben ser:$")
    public void losProductosConfirmadosEnElCheckoutDebenSer(DataTable productosEsperados) {

    }

    @Y("^la compra debería ser confirmada con el mensaje \"([^\"]*)\"$")
    public void laCompraDeberíaSerConfirmadaConElMensaje(String mensajeEsperado) {
        OnStage.theActorInTheSpotlight().should(
                seeThat("El mensaje de compra fue exitoso",
                        CompraExitosaQuestion.esVisible())

        );
    }
}