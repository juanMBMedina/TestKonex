package com.juan.automation.runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
		glue = "com.juan.automation.stepdefinitions",
		features = "src/test/resources/features/init_test.feature",
		snippets = SnippetType.CAMELCASE,
		strict = true
		)

public class InitTest {

}

