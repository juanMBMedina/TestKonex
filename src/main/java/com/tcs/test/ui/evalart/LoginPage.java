package com.tcs.test.ui.evalart;

import net.serenitybdd.screenplay.targets.Target;

public class LoginPage {

    public static final String URL = "https://tasks.evalartapp.com/automatization/";

    public static final Target USER_NAME_INPUT =
            Target.the("User name Input Text").locatedBy("//input[@name='username']");

    public static final Target PASSWORD_INPUT =
            Target.the("Password Input Text").locatedBy("//input[@name='password']");

    public static final Target SEND_BUTTON =
            Target.the("Password Input Text").locatedBy("//button[@type='submit']");

}
