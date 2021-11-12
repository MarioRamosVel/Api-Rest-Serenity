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

import java.util.function.Predicate;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;


public class getStatus {

    private static final String restApiUrl = "http://api.geonames.org";
    Actor Tester1;

    @Given("el Tester1 quiere conocer las caracteristicas la ubicicacion")
    public void elTester1QuiereConocerLasCaracteristicasLaUbicicacion() {

        Tester1 = Actor.named("Tester1, SmokeTest")
                .whoCan(CallAnApi.at(restApiUrl));
        throw new io.cucumber.java.PendingException();
    }

    @When("el envia la latitud y longitud")
    public void elEnviaLaLatitudYLongitud() {

        Tester1.attemptsTo(
                GetLocatio.header(-10,20,"qa_mobile_easy")
        );
        System.out.printf("Navigating to login\n");
        //throw new io.cucumber.java.PendingException();
    }

    @Then("el debe obtener las caraacteristicas del lugar donde se encuentra")
    public void elDebeObtenerLasCaraacteristicasDelLugarDondeSeEncuentra() {

        Tester1.should(
                seeThat("El codigo de respuesta", ResponseCode.was(), equalTo( 200 ))
        );

        body data = new GetResponse().answeredBy(Tester1);

        Tester1.should(
                seeThat( "El pais es ", act -> data.getCountryName(), equalTo("Angola")),
                seeThat( "El TimeZone ID es", act -> data.getTimezoneId(), equalTo("Africa/Luanda"))
        );
        throw new io.cucumber.java.PendingException();
    }


}
