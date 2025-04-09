package co.com.konex.test.stepdefinitions;

import co.com.konex.test.tasks.ScrollToTarget;
import co.com.konex.test.tasks.SearchWikipedia;
import co.com.konex.test.ui.wikipedia.ArticlePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.containsText;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;
import static org.hamcrest.CoreMatchers.equalTo;

public class ValidateTitleWithScrollWikipediaStepDefinitions {

    @When("I want to search a word {string}")
    public void iWantToSearchAWord(String wordToSearch) {
        theActorInTheSpotlight().attemptsTo(SearchWikipedia.with(wordToSearch));
    }

    @Then("Validate the title {string} doing Scroll")
    public void validateTheTitleDoingScroll(String title) {
        Target tempTarget = ArticlePage.getTitleToSearch(title);
        theActorInTheSpotlight().attemptsTo(ScrollToTarget.scrollTo(tempTarget));
        theActorInTheSpotlight().should(
                seeThat(the(tempTarget), containsText(title)),
                seeThat(Text.of(tempTarget).asString(), equalTo(title))
        );

    }

}
  