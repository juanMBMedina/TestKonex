package co.com.konex.test.ui.wikipedia;

import net.serenitybdd.screenplay.targets.Target;

public class HomePage {

    public static final Target WELCOME_TEXT =
            Target.the("Welcome text").locatedBy("//h1//span[@id='Bienvenidos_a_Wikipedia,']");

}
