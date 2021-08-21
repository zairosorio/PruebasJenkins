package oi.swagger.petstore.stepsdefinitions;

import com.reqres.in.models.DataInjection;
import cucumber.api.java.Before;
import cucumber.api.java.ast.Cuando;
import cucumber.api.java.es.Entonces;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import org.apache.http.HttpStatus;


import static io.restassured.RestAssured.given;
import static net.serenitybdd.rest.SerenityRest.then;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;

public class HacerPedidoStepDefinition {

    @Before
    public void setUp() {

        DataInjection dataInjection = new DataInjection();


        RestAssured.baseURI = dataInjection.getBaseUri();
        RestAssured.basePath = dataInjection.getBasePath();
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setContentType(ContentType.JSON).build();
    }


    @Cuando("^se envia la siguiente operacion al servicio \"([^\"]*)\"$")
    public void seEnviaLaSiguienteOperacionAlServicio(String url) {
        given().body("" +
                "{\n" +
                "  \"id\": 6255633,\n" +
                "  \"petId\": 0,\n" +
                "  \"quantity\": 0,\n" +
                "  \"shipDate\": \"2021-07-28T19:10:43.663Z\",\n" +
                "  \"status\": \"placed\",\n" +
                "  \"complete\": true\n" +
                "}").post(url);
    }

    @Entonces("^valida que el codigo de estado sea$")
    public void validaQueElCodigoDeEstadoSea() {
        then().log().all().statusCode(HttpStatus.SC_OK);
    }

}
