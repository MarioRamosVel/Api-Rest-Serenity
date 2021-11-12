package com.testauto.marv.stepDefinition;

import com.testauto.marv.models.body;
import com.testauto.marv.models.bodyKO;
import com.testauto.marv.questions.GetKoResponse;
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

public class validateLong {

    private static final String restApiUrl = "http://api.geonames.org";
    Actor Tester1;

    @Given("el Tester1 intenta conocer diferentes ubicaciones")
    public void elTester1IntentaConocerDiferentesUbicaciones() {

            Tester1 = Actor.named("Tester1, SmokeTest")
                    .whoCan(CallAnApi.at(restApiUrl));
            throw new io.cucumber.java.PendingException();
    }

    @When("el envia una longitud de valores permitidos")
    public void elEnviaUnaLongitudDeValoresPermitidos() {
            Tester1.attemptsTo(
                    GetLocatio.header(-10,20,"qa_mobile_easy")
            );

        throw new io.cucumber.java.PendingException();
    }

    @When("el envia una longitud de valores debajo del permitido")
    public void elEnviaUnaLongitudDeValoresDebajoDelPermitido() {
            Tester1.attemptsTo(
                    GetLocatio.header(-190,20,"qa_mobile_easy")
            );
        throw new io.cucumber.java.PendingException();
    }

    @Then("el debo obetener un mensaje de latitud erronea")
    public void elDeboObetenerUnMensajeDeLatitudErronea() {
            Tester1.should(
                    seeThat("El codigo de respuesta", ResponseCode.was(), equalTo( 200))
            );

        bodyKO data = new GetKoResponse().answeredBy(Tester1);

        Tester1.should(
                seeThat( "El mensaje de error es", act -> data.getStatus().getMessage(), equalTo("invalid lat/lng"))
            );
        throw new io.cucumber.java.PendingException();
    }

    @When("el envia una longitud de valores mayores al permitido")
    public void elEnviaUnaLongitudDeValoresMayoresAlPermitido() {
            Tester1.attemptsTo(
                    GetLocatio.header(190,20,"qa_mobile_easy")
            );
        throw new io.cucumber.java.PendingException();
    }

    @When("el envia una longitud con valores decimales")
    public void elEnviaUnaLongitudConValoresDecimales() {
            Tester1.attemptsTo(
                    GetLocatio.header(25.5F,20,"qa_mobile_easy")
            );
        throw new io.cucumber.java.PendingException();
    }
}
