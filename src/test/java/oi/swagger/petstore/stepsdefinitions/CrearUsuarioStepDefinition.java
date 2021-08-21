package oi.swagger.petstore.stepsdefinitions;

import com.reqres.in.models.DataInjection;
import com.sqasa.rest.demo.utils.KrakenRest;
import cucumber.api.java.Before;
import cucumber.api.java.ast.Cuando;
import cucumber.api.java.es.Entonces;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;


public class CrearUsuarioStepDefinition extends KrakenRest {

    DataInjection dataInjection = new DataInjection();

    @Before
    public void setUp(){

        RestAssured.baseURI = dataInjection.getBaseUri();
        RestAssured.basePath = dataInjection.getBasePath();
        RestAssured.filters(new RequestLoggingFilter(),new ResponseLoggingFilter());
        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setContentType(ContentType.JSON).build();
    }

    @Cuando("^zair envia la siguiente operacion al servicio \"([^\"]*)\"$")
    public void zairEnviaLaSiguienteOperacionAlServicio(String url) {
        RestAssured
                .given().log().all()
                .body(
                "{\n" +
                        "  \"id\": 0,\n" +
                        "  \"username\": \"prueba\",\n" +
                        "  \"firstName\": \"rest\",\n" +
                        "  \"lastName\": \"primero\",\n" +
                        "  \"email\": \"prueba@gmail.com\",\n" +
                        "  \"password\": \"8este\",\n" +
                        "  \"phone\": \"3215600404\",\n" +
                        "  \"userStatus\": 0\n" +
                        "}").post(url).then().log().all().extract().asString();
    }

    @Entonces("^valida que el codigo de esta de estado sea$")
    public void validaQueElCodigoDeEstatusSea() {



    }


}
