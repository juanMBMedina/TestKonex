package co.com.konex.test.hooks;

import co.com.konex.test.models.WikipediaUser;
import io.cucumber.java.DataTableType;

import java.util.List;
import java.util.Map;

public class ConvertToModels {

    @DataTableType
    public WikipediaUser convertToWikiUser(List<String> data) {
        return new WikipediaUser(
                data.get(0),
                data.get(1),
                data.get(2)
        );
    }

}
