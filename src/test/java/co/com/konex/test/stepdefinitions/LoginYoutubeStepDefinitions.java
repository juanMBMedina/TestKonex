package co.com.konex.test.stepdefinitions;

import co.com.konex.test.tasks.LoginYoutube;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.konex.test.constants.Constants.ACTOR_NAME;
import static co.com.konex.test.ui.youtube.HomePage.USER_INFO_BUTTON;
import static co.com.konex.test.ui.youtube.HomePage.USER_INFO_TEXT;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

public class LoginYoutubeStepDefinitions {

    private String strActorName = ACTOR_NAME;

    @Before()
    public void setup() {
        setTheStage(new OnlineCast());
    }

    @Given("Navigate to the page {string}")
    public void navigateToThePage(String strUrl) {
        theActorCalled(strActorName).wasAbleTo(Open.url(strUrl));
    }

    @When("Login with the email {string} and password {string}")
    public void loginWithTheEmailAndPassword(String strEmail, String strPassword) {
        theActorInTheSpotlight().attemptsTo(LoginYoutube.withCredential(strEmail, strPassword));
    }

    @Then("Observe the user text {string}")
    public void observeTheUserTextJuanBlancoTest01(String userData) {
        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(USER_INFO_BUTTON, isVisible()).forNoMoreThan(30).seconds(),
                WaitUntil.the(USER_INFO_BUTTON, isEnabled()).forNoMoreThan(30).seconds(),
                Click.on(USER_INFO_BUTTON),
                WaitUntil.the(USER_INFO_TEXT, isVisible()).forNoMoreThan(30).seconds(),
                WaitUntil.the(USER_INFO_TEXT, isEnabled()).forNoMoreThan(30).seconds()
        );
        theActorInTheSpotlight().should(
                seeThat("The text is visible", the(USER_INFO_TEXT), isVisible()),
                seeThat("The text contains data", the(USER_INFO_TEXT), containsText(userData))
        );

    }

}
  