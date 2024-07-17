package co.com.konex.test.tasks;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.jetbrains.annotations.NotNull;

import static co.com.konex.test.constants.Constants.SONG_LABEL;
import static co.com.konex.test.ui.youtube.HomePage.*;
import static co.com.konex.test.ui.youtube.SongPage.TITLE_TEXT;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SearchSongYoutube implements Task {

    private String songTitle;

    public SearchSongYoutube(String songTitle) {
        this.songTitle = songTitle;
    }

    public static SearchSongYoutube with(String songTitle) {
        return instrumented(SearchSongYoutube.class, songTitle);
    }

    @Override
    public <T extends Actor> void performAs(@NotNull T actor) {
        actor.attemptsTo(
                Enter.theValue(songTitle).into(SEARCH_EDIT_TEXT),
                Click.on(SEARCH_BUTTON)
        );
        Target tempTarget = getTitleGroup(songTitle);
        actor.attemptsTo(
                WaitUntil.the(tempTarget, isVisible()).forNoMoreThan(30).seconds(),
                Click.on(tempTarget.resolveAllFor(actor).get(0)),
                WaitUntil.the(TITLE_TEXT, isVisible()).forNoMoreThan(30).seconds()
        );
        actor.remember(SONG_LABEL, tempTarget.resolveAllFor(actor).get(0).getText());
    }

}
