package com.tcs.test.tasks;

import com.tcs.test.models.User;
import com.tcs.test.ui.evalart.LoginPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class LoginEvalart implements Task {

    private final String strUser;
    private final String strPassword;

    public LoginEvalart(String strUser, String strPassword) {
        this.strUser = strUser;
        this.strPassword = strPassword;
    }

    public LoginEvalart(User user) {
        this.strUser = user.getUserName();
        this.strPassword = user.getPassword();
    }

    public static LoginEvalart withCredential(String strUser, String strPassword) {
        return instrumented(LoginEvalart.class, strUser, strPassword);
    }

    public static LoginEvalart withCredential(User user) {
        return instrumented(LoginEvalart.class, user);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(strUser).into(LoginPage.USER_NAME_INPUT),
                Enter.theValue(strPassword).into(LoginPage.PASSWORD_INPUT),
                Click.on(LoginPage.SEND_BUTTON)
        );
    }

}
