package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.login;
import pageObject.registerUsers;

import java.io.IOException;

import static support.screenshots.evidencias;


public class loginDefinition {
    registerUsers register;
     login login;


    public loginDefinition() {
      
        login = new login(hook.driver);
        register = new registerUsers(hook.driver);
    }


    @When("Ingresa las credenciales {string} y {string}")
    public void ingresaLasCredencialesY(String user, String password) throws IOException {
        login.clickBtnLog_in();
        login.setUser(user,password);
        evidencias();
        login.clickBtnLogin();
    }


    @When("Ingresa las credenciales para registro {string} y {string}")
    public void ingresaLasCredencialesParaRegistroY(String user, String password) throws IOException {
        register.clickBtnSingUp();
        register.writingUser(user, password);
        evidencias();
        register.clickBtnRegister();

    }

    @Then("mostrar logueo exitoso {string}")
    public void mostrarLogueoExitoso(String user) throws IOException {
        login.validateLogin(user);
        evidencias();
    }

    @Given("Validar que la web este operativa")
    public void validarQueLaWebDeRegistroEsteOperativa() throws IOException {
        hook.driver.get("https://www.demoblaze.com/index.html");
        evidencias();
    }

    @Then("mostrar validacion de datos")
    public void mostrarValidacionDeDatos() throws IOException {
        register.validateRegisterInvalid();
        evidencias();
    }

    @And("salir de sesion")
    public void salirDeSesion() {
        login.clickLogOut();
    }


    @Then("mostrar pantalla de inicio con boton login")
    public void mostrarPantallaDeInicioConBotonLogin() {
        login.validateLogOut();
    }

    @Then("mostrar alerta con mensaje de reistro sactisfactorio")
    public void mostrarAlertaConMensajeDeReistroSactisfactorio() throws IOException {
        register.validateRegister();
        evidencias();
    }

    @When("selecciono un la categoria Laptops")
    public void seleccionoUnLaCategoriaLaptops() throws IOException {
        login.clickLaptops();
        evidencias();
    }

    @And("agrego una laptop al carrito")
    public void agregoUnaLaptopAlCarrito() throws IOException {
        login.addLaptop();
        evidencias();
    }

    @Then("mostrar producto en carrito")
    public void mostrarProcustoEnCarrito() throws IOException {
        login.verifyInCart();
        evidencias();
    }
}
