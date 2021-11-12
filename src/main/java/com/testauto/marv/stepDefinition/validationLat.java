package com.testauto.marv.stepDefinition;

import com.testauto.marv.tasks.GetLocatio;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;

public class validationLat {

    Actor Tester1;

    @When("el envia una langitud de valores permitidos")
    public void elEnviaUnaLangitudDeValoresPermitidos() {
        Tester1.attemptsTo(
                GetLocatio.header(-10,20,"qa_mobile_easy")
        );
        throw new io.cucumber.java.PendingException();
    }

    @When("el envia una latitud de valores debajo del permitido")
    public void elEnviaUnaLatitudDeValoresDebajoDelPermitido() {
        Tester1.attemptsTo(
                GetLocatio.header(-100,20,"qa_mobile_easy")
        );
        throw new io.cucumber.java.PendingException();
    }

    @When("el envia una latitud de valores mayores al permitido")
    public void elEnviaUnaLatitudDeValoresMayoresAlPermitido() {
        Tester1.attemptsTo(
                GetLocatio.header(1000,20,"qa_mobile_easy")
        );
        throw new io.cucumber.java.PendingException();
    }

    @When("el envia una latitud con valores decimales")
    public void elEnviaUnaLatitudConValoresDecimales() {
        Tester1.attemptsTo(
                GetLocatio.header(-10,20,"qa_mobile_easy")
        );
        throw new io.cucumber.java.PendingException();
    }

}
