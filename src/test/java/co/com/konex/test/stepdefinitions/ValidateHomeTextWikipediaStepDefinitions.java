package co.com.konex.test.stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.konex.test.constants.Constants.HOME_LABEL;
import static co.com.konex.test.ui.wikipedia.HomePage.WELCOME_TEXT;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.containsText;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;
import static org.hamcrest.CoreMatchers.equalTo;

public class ValidateHomeTextWikipediaStepDefinitions {

    @When("I can get text of the home page in wikipedia")
    public void iCanGetTextOfTheHomePageInWikipedia() {
        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(WELCOME_TEXT, isVisible()).forNoMoreThan(30).seconds()
        );
        String tempText = WELCOME_TEXT.resolveAllFor(theActorInTheSpotlight()).get(0).getText();
        theActorInTheSpotlight().remember(HOME_LABEL, tempText);
    }

    @Then("Observe the home text {string}")
    public void observeTheHomeText(String labelText) {
        String tempText = theActorInTheSpotlight().recall(HOME_LABEL);
        theActorInTheSpotlight().should(
                seeThat(the(WELCOME_TEXT), containsText(labelText)),
                seeThat(Text.of(WELCOME_TEXT).asString(), equalTo(tempText))
        );
    }

}
  