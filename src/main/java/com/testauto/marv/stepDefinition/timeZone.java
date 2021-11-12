package com.testauto.marv.stepDefinition;

import com.testauto.marv.models.body;
import com.testauto.marv.models.bodyKO;
import com.testauto.marv.questions.GetKoResponse;
import com.testauto.marv.questions.GetResponse;
import com.testauto.marv.questions.ResponseCode;
import com.testauto.marv.tasks.GetLocatio;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class timeZone {

    Actor Tester1;

    @When("el envia una ubicacion conocida")
    public void elEnviaUnaUbicacionConocida() {
        Tester1.attemptsTo(
                GetLocatio.header(-10,20,"qa_mobile_easy")
        );
        throw new io.cucumber.java.PendingException();
    }

    @When("el envia una ubicacion desconocida")
    public void elEnviaUnaUbicacionDesconocida() {
        Tester1.attemptsTo(
                GetLocatio.header(0.1F,180,"qa_mobile_easy")
        );
        throw new io.cucumber.java.PendingException();
    }

    @Then("el debo obetener un mensaje de sin informacion")
    public void elDeboObetenerUnMensajeDeSinInformacion() {
        Tester1.should(
                seeThat("El codigo de respuesta", ResponseCode.was(), equalTo( 200))
        );

        bodyKO data = new GetKoResponse().answeredBy(Tester1);

        Tester1.should(
                seeThat( "El mensaje de error es", act -> data.getStatus().getMessage(), equalTo("no timezone information found for lat/lng"))
        );
        throw new io.cucumber.java.PendingException();
    }

    @When("el envia una ubicacion poco conocida")
    public void elEnviaUnaUbicacionPocoConocida() {
        Tester1.attemptsTo(
                GetLocatio.header(80,10,"qa_mobile_easy")
        );
        throw new io.cucumber.java.PendingException();
    }

    @Then("el debo obetener un mensaje con poca informacion")
    public void elDeboObetenerUnMensajeConPocaInformacion() {
        Tester1.should(
                seeThat("El codigo de respuesta", ResponseCode.was(), equalTo( 200))
        );

        body data = new GetResponse().answeredBy(Tester1);

        Tester1.should(
                seeThat( "El mensaje de error es", act -> data.getGmtOffset(), equalTo(1))
        );
        throw new io.cucumber.java.PendingException();
    }
}
