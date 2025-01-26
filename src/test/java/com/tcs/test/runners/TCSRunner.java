package com.tcs.test.runners;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        glue = {"com.tcs.test.stepdefinitions",
                "com.tcs.test.hooks"
        },
        features = "src/test/resources/features/test_tcs.feature",
        snippets = SnippetType.CAMELCASE
)

public class TCSRunner {

}

