package com.testauto.marv.questions;

import com.testauto.marv.models.body;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class GetResponse implements Question {
    @Override
    public body answeredBy(Actor actor) {
        return SerenityRest.lastResponse().as(body.class);
    }
}
