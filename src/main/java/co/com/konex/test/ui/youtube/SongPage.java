package co.com.konex.test.ui.youtube;

import net.serenitybdd.screenplay.targets.Target;

public class SongPage {

    public static final Target TITLE_TEXT =
            Target.the("Title Text").locatedBy("//div[@id='title']//h1//yt-formatted-string");

}
