package com.testauto.marv.questions;

import com.testauto.marv.models.bodyKO;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class GetKoResponse implements Question {

    @Override
    public bodyKO answeredBy(Actor actor) {
        return SerenityRest.lastResponse().as(bodyKO.class);
    }
}
