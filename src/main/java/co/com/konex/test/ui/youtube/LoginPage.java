package co.com.konex.test.ui.youtube;

import net.serenitybdd.screenplay.targets.Target;

public class LoginPage {

    public static final Target EMAIL_EDIT_TEXT =
            Target.the("Email edit Text").locatedBy("//input[@type='email']");
    public static final Target NEXT_BUTTON =
            Target.the("Button Next").locatedBy("//button[@type='button']//span[contains(text()," +
                    "'Siguiente') or contains(text(),'Next')]");
    public static final Target PASSWORD_EDIT_TEXT =
            Target.the("Password edit Text").locatedBy("//input[@type='password']");


}
