package com.tcs.test.stepdefinitions;

import com.tcs.test.tasks.FillFormEvalart;
import com.tcs.test.tasks.LoginEvalart;
import com.tcs.test.ui.evalart.LoginPage;
import com.tcs.test.utils.Utils;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static com.tcs.test.constants.Constants.ACTOR_NAME;
import static net.serenitybdd.screenplay.actors.OnStage.*;

public class TestTcsStepDefinitions {

    @Before()
    public void setup() {
        setTheStage(new OnlineCast());
    }

    @Given("Ingresar a la url del sitio Evalart")
    public void ingresarALaUrlDelSitioEvalart() {
        theActorCalled(ACTOR_NAME).wasAbleTo(Open.url(LoginPage.URL));
    }

    @Given("Ingresar con el usuario {string} y clave {string}")
    public void ingresarConElUsuarioYClave(String userEnv, String passwordEnv) {
        theActorInTheSpotlight().attemptsTo(LoginEvalart.withCredential(System.getenv(userEnv),
                System.getenv(passwordEnv)));
    }

    @When("Se diligencia el formulario las veces necesarias")
    public void seDiligenciaElFormularioLasVecesNecesarias() {
        theActorInTheSpotlight().wasAbleTo(FillFormEvalart.go());
    }

    @And("Validar que el formulario se repitio {int} veces")
    public void validarQueElFormularioSeRepitioVeces(int arg0) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("validar la finalizacion correcta del formulario")
    public void validarLaFinalizacionCorrectaDelFormulario() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }



}
  