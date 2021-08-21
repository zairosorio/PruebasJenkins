package oi.swagger.petstore.runner;


import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/hacerpedido.feature",
        snippets = SnippetType.CAMELCASE,
        glue = "oi.swagger.petstore.stepsdefinitions",
        tags = ""
)

public class CrearUsuarioRunner {
}
