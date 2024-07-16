package co.com.konex.test.tasks;


import co.com.konex.test.ui.wikipedia.ArticlePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.targets.Target;

import static co.com.konex.test.ui.wikipedia.HomePage.SEARCH_BUTTON;
import static co.com.konex.test.ui.wikipedia.HomePage.SEARCH_EDIT_TEXT;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SearchWikipedia implements Task {

    private String wordToSearch;

    public SearchWikipedia(String wordToSearch) {
        this.wordToSearch = wordToSearch;
    }

    public static SearchWikipedia with(String wordToSearch) {
        return instrumented(SearchWikipedia.class, wordToSearch);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(wordToSearch).into(SEARCH_EDIT_TEXT),
                Click.on(SEARCH_BUTTON)
        );
    }
}
