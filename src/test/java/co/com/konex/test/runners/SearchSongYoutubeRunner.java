package co.com.konex.test.runners;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        glue = {"co.com.konex.test.stepdefinitions",
                "co.com.konex.test.hooks"
        },
        features = "src/test/resources/features/search_song.feature",
        snippets = SnippetType.CAMELCASE
)

public class SearchSongYoutubeRunner {

}

