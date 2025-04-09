package co.com.konex.test.stepdefinitions;

import co.com.konex.test.tasks.SearchSongYoutube;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static co.com.konex.test.constants.Constants.SONG_LABEL;
import static co.com.konex.test.ui.youtube.SongPage.TITLE_TEXT;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.containsText;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

public class SearchSongYoutubeStepDefinitions {

    @When("Search a son with name {string}")
    public void searchASonWithName(String songTitle) {
        theActorInTheSpotlight().attemptsTo(SearchSongYoutube.with(songTitle));
    }

    @Then("Successfully observe the song title")
    public void successfullyObserveTheSongTitle() {
        String expectedSong = theActorInTheSpotlight().recall(SONG_LABEL);
        theActorInTheSpotlight().should(
                seeThat("The text is visible", the(TITLE_TEXT), isVisible()),
                seeThat("The text contains data", the(TITLE_TEXT), containsText(expectedSong))
        );
    }
}
  