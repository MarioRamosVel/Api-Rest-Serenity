package com.testautomation.marv;

import com.testauto.marv.models.body;
import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import org.junit.Test;
import org.junit.runner.RunWith;
import com.testauto.marv.questions.GetResponse;
import com.testauto.marv.questions.ResponseCode;
import com.testauto.marv.tasks.GetLocatio;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features="src/test/resources/features")
public class FristCase {

    private static final String restApiUrl = "http://api.geonames.org";

    @Test
    public void getStatusOk(){

        Actor Tester1 = Actor.named("Tester1, SmokeTest")
                .whoCan(CallAnApi.at(restApiUrl));

        Tester1.attemptsTo(
                GetLocatio.header(-10,20,"qa_mobile_easy")
        );


        Tester1.should(
                seeThat("El codigo de respuesta", ResponseCode.was(), equalTo( 200 ))
        );

        body data = new GetResponse().answeredBy(Tester1);

        Tester1.should(
                seeThat( "El pais es ", act -> data.getCountryName(), equalTo("Angola")),
                seeThat( "El pais es ", act -> data.getTimezoneId(), equalTo("Africa/Luanda"))
        );

    }

    @Test
    public void getStatusOk2(){

        Actor Tester1 = Actor.named("Tester1, SmokeTest")
                .whoCan(CallAnApi.at(restApiUrl));

        Tester1.attemptsTo(
                GetLocatio.header(-10,20,"qa_mobile_easy")
        );


        Tester1.should(
                seeThat("El codigo de respuesta", ResponseCode.was(), equalTo( 200 ))
        );

        body data = new GetResponse().answeredBy(Tester1);

        Tester1.should(
                seeThat( "El pais es ", act -> data.getCountryName(), equalTo("Angola")),
                seeThat( "El pais es ", act -> data.getTimezoneId(), equalTo("Africa/Luanda"))
        );

    }
}
