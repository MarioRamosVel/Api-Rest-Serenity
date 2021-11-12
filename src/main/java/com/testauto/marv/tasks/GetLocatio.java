package com.testauto.marv.tasks;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class GetLocatio implements Task {
    
    private final float lat, lng;
    private final String uss;

    public GetLocatio(float lat, float lng, String uss) {
        this.lat = lat;
        this.lng =lng;
        this.uss = uss;
    }

    public static Performable header(float lat, float lng, String uss){
        return instrumented(GetLocatio.class, lat, lng, uss);

    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Get.resource("/timezoneJSON?formatted=true&lat=" + lat +"&lng=" + lng +"&username="+ uss + "&style=full")
                        .with(requestSpecification -> requestSpecification.contentType(ContentType.JSON))
        );

    }
}
