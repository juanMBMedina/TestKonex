package co.com.konex.test.stepdefinitions;

import co.com.konex.test.models.WikipediaUser;
import co.com.konex.test.questions.ValidationCaptchaMessage;
import co.com.konex.test.tasks.CreateWikiAccount;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static co.com.konex.test.constants.Constants.VOID_STR;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.equalTo;

public class CreateAccountWikipediaStepDefinitions {

    @When("I want to create an Account using")
    public void iWantToCreateAnAccountUsing(WikipediaUser user) {
        theActorInTheSpotlight().attemptsTo(CreateWikiAccount.with(user));
    }

    @Then("Validate Alert of Captcha's Edit Text")
    public void validateAlertOfCaptchaSEditText() {
        theActorInTheSpotlight().should(
                seeThat(ValidationCaptchaMessage.inCaptcha(), equalTo(VOID_STR))
        );
    }

}
  