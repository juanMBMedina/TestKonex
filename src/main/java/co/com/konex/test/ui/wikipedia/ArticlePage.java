package co.com.konex.test.ui.wikipedia;

import net.serenitybdd.screenplay.targets.Target;

import static co.com.konex.test.utils.Utils.getTarget;

public class ArticlePage {

    public static Target getTitleToSearch(String wordToSearch) {
        return getTarget("Title to Search", "//h3//span[text()='%s']", wordToSearch);
    }

}
