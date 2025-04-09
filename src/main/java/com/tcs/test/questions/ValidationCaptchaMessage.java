package com.tcs.test.questions;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.WebElement;

public class ValidationCaptchaMessage implements Question<String> {

    private final Target target;

    public ValidationCaptchaMessage(Target target) {
        this.target = target;
    }

    public static ValidationCaptchaMessage inCaptcha() {
       // return new ValidationCaptchaMessage(CreateAccountPage.CAPTCHA_EDIT_TEXT);
        return null;
    }

    @Override
    public String answeredBy(Actor actor) {
        WebElement element = target.resolveFor(actor);
        return element.getText();
    }
}