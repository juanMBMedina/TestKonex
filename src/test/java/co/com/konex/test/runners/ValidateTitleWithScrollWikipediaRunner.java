package co.com.konex.test.runners;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
		glue = "co.com.konex.test.stepdefinitions",
		features = "src/test/resources/features/home_page_wikipedia.feature",
		snippets = SnippetType.CAMELCASE
		)

public class ValidateHomeTextWikipediaRunner {

}

