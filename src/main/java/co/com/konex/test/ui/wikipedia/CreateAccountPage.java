package co.com.konex.test.ui.wikipedia;

import net.serenitybdd.screenplay.targets.Target;

public class CreateAccountPage {

    public static final Target USER_EDIT_TEXT =
            Target.the("User Edit Text").locatedBy("//input[@id='wpName2']");

    public static final Target PASSWORD_EDIT_TEXT =
            Target.the("Password Edit Text").locatedBy("//input[@id='wpPassword2']");

    public static final Target RETYPE_PASS_EDIT_TEXT =
            Target.the("Retype Password Edit Text").locatedBy("//input[@id='wpRetype']");

    public static final Target EMAIL_EDIT_TEXT =
            Target.the("Email Edit Text").locatedBy("//input[@id='wpEmail']");

    public static final Target CAPTCHA_EDIT_TEXT =
            Target.the("Edit Text Captcha").locatedBy("//input[@id='mw-input-captchaWord']");

    public static final Target BUTTON_CONFIRM =
            Target.the("Button Confirm Form").locatedBy("//button[@value='Crea tu cuenta']");


}
