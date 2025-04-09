package co.com.konex.test.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.WebElement;

import static co.com.konex.test.ui.wikipedia.CreateAccountPage.CAPTCHA_EDIT_TEXT;

public class ValidationCaptchaMessage implements Question<String> {

    private final Target target;

    public ValidationCaptchaMessage(Target target) {
        this.target = target;
    }

    public static ValidationCaptchaMessage inCaptcha() {
        return new ValidationCaptchaMessage(CAPTCHA_EDIT_TEXT);
    }

    @Override
    public String answeredBy(Actor actor) {
        WebElement element = target.resolveFor(actor);
        return element.getText();
    }
}