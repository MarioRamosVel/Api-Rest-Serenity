package com.testauto.marv.stepDefinition;

import com.testauto.marv.models.body;
import com.testauto.marv.questions.GetResponse;
import com.testauto.marv.questions.ResponseCode;
import com.testauto.marv.tasks.GetLocatio;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class validationUser {

    private static final String restApiUrl = "http://api.geonames.org";
    Actor Tester1;

    @Given("el Tester1 intenta conocer su ubicacion")
    public void elTester1IntentaConocerSuUbicacion() {
        Tester1 = Actor.named("Tester1, SmokeTest")
                .whoCan(CallAnApi.at(restApiUrl));
        throw new io.cucumber.java.PendingException();
    }

    @When("el envia su usuario valido")
    public void elEnviaSuUsuarioValido() {
        Tester1.attemptsTo(
                GetLocatio.header(-10,20,"qa_mobile_easy")
        );
        System.out.printf("Navigating to login\n");
        throw new io.cucumber.java.PendingException();
    }

    @Then("el debe obtener su  información de manera correcta")
    public void elDebeObtenerSuInformaciónDeManeraCorrecta() {
        Tester1.should(
                seeThat("El codigo de respuesta", ResponseCode.was(), equalTo( 200 ))
        );

        throw new io.cucumber.java.PendingException();
    }

    @When("el envia su usuario invalido")
    public void elEnviaSuUsuarioInvalido() {
        Tester1.attemptsTo(
                GetLocatio.header(-10,20,"qa_mobile")
        );

        throw new io.cucumber.java.PendingException();
    }

    @Then("el debe obtener respuesta de Usuario no existe")
    public void elDebeObtenerRespuestaDeUsuarioNoExiste() {
        Tester1.should(
                seeThat("El codigo de respuesta", ResponseCode.was(), equalTo( 401))
        );

        body data = new GetResponse().answeredBy(Tester1);

        Tester1.should(
                seeThat( "El mensaje de error es", act -> data.getCountryName(), equalTo("user does not exist."))
        );
        throw new io.cucumber.java.PendingException();
    }

    @When("no envia el usuario")
    public void noEnviaElUsuario() {
        Tester1.attemptsTo(
                GetLocatio.header(-10,20,"")
        );
        System.out.printf("Navigating to login\n");
        throw new io.cucumber.java.PendingException();
    }

    @Then("el debe obtener respuesta de Usuario invalido")
    public void elDebeObtenerRespuestaDeUsuarioInvalido() {
        Tester1.should(
                seeThat("El codigo de respuesta", ResponseCode.was(), equalTo( 401))
        );

        body data = new GetResponse().answeredBy(Tester1);

        Tester1.should(
                seeThat( "El mensaje de error es", act -> data.getCountryName(), equalTo("invalid user"))
        );
        throw new io.cucumber.java.PendingException();
    }

}
