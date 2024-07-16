package co.com.konex.test.ui.youtube;

import net.serenitybdd.screenplay.targets.Target;

public class HomePage {

    public static final Target SEARCH_EDIT_TEXT =
            Target.the("Search edit Text").locatedBy("//input[@id='search']");
    public static final Target SEARCH_BUTTON =
            Target.the("Search Button").locatedBy("//button[@id='search-icon-legacy']");

    public static final String TITLE_GROUP = "//a[@id='video-title' and contains(@aria-label," +
            "'%s')]";

    public static final Target LOGIN_BUTTON =
            Target.the("Login Button").locatedBy("//div[@id='end']//ytd-button-renderer");

    public static final Target USER_INFO_BUTTON =
            Target.the("User info Button").locatedBy("//button[@id='avatar-btn']");

    public static final Target USER_INFO_TEXT =
            Target.the("User info Text").locatedBy("//div[@id='header']//yt-formatted-string[@id" +
                    "='email']");

}
