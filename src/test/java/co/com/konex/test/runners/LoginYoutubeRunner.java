package co.com.konex.test.runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
		glue = "co.com.konex.test.stepdefinitions",
		features = "src/test/resources/features/login_youtube.feature",
		snippets = SnippetType.CAMELCASE
		)

public class LoginYoutubeRunner {

}

