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

public class dailyLimit {

    Actor Tester1;

    @When("el envia usuario con limite de consultas ssuperadas")
    public void elEnviaUsuarioConLimiteDeConsultasSsuperadas() {
        Tester1.attemptsTo(
                GetLocatio.header(-10,20,"demo")
        );
        throw new io.cucumber.java.PendingException();
    }

    @Then("el debo obetener un mensaje de error por limite diario")
    public void elDeboObetenerUnMensajeDeErrorPorLimiteDiario() {
        Tester1.should(
                seeThat("El codigo de respuesta", ResponseCode.was(), equalTo( 200))
        );

        bodyKO data = new GetKoResponse().answeredBy(Tester1);

        Tester1.should(
                seeThat( "El mensaje de error es", act -> data.getStatus().getMessage(), equalTo("the hourly limit of 1000 credits for demo has been exceeded. Please use an application specific account. Do not use the demo account for your application."))
        );
        throw new io.cucumber.java.PendingException();
    }

}
