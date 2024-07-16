package co.com.konex.test.tasks;

import co.com.konex.test.models.User;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;

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

    }
}
