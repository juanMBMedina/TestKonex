package co.com.konex.test.tasks;

import co.com.konex.test.models.User;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;


import static co.com.konex.test.ui.youtube.HomePage.LOGIN_BUTTON;
import static co.com.konex.test.ui.youtube.LoginPage.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;

public class YoutubeLogin implements Task {

    private String strUser;
    private String strPassword;

    public YoutubeLogin(String strUser, String strPassword) {
        this.strUser = strUser;
        this.strPassword = strPassword;
    }

    public YoutubeLogin(User user) {
        this.strUser = user.getEmail();
        this.strPassword = user.getPassword();
    }

    public static YoutubeLogin withCredential(String strUser, String strPassword) {
        return instrumented(YoutubeLogin.class, strUser, strPassword);
    }

    public static YoutubeLogin withCredential(User user) {
        return instrumented(YoutubeLogin.class, user);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(LOGIN_BUTTON),
                Enter.theValue(strUser).into(EMAIL_EDIT_TEXT),
                Click.on(NEXT_BUTTON),
                WaitUntil.the(PASSWORD_EDIT_TEXT, isEnabled()).forNoMoreThan(30).seconds(),
                Enter.theValue(strPassword).into(PASSWORD_EDIT_TEXT),
                Click.on(NEXT_BUTTON)
        );
    }

}
