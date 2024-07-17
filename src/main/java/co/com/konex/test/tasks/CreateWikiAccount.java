package co.com.konex.test.tasks;

import co.com.konex.test.models.WikipediaUser;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static co.com.konex.test.constants.Constants.VOID_STR;
import static co.com.konex.test.ui.wikipedia.CreateAccountPage.*;
import static co.com.konex.test.ui.wikipedia.HomePage.CREATE_ACCOUNT_LINK;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CreateWikiAccount implements Task {

    private WikipediaUser user;

    public CreateWikiAccount(WikipediaUser user) {
        this.user = user;
    }

    public static CreateWikiAccount with(WikipediaUser user) {
        return instrumented(CreateWikiAccount.class, user);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(CREATE_ACCOUNT_LINK),
                Enter.theValue(user.getUserName()).into(USER_EDIT_TEXT),
                Enter.theValue(user.getPassword()).into(PASSWORD_EDIT_TEXT),
                Enter.theValue(user.getPassword()).into(RETYPE_PASS_EDIT_TEXT),
                Enter.theValue(user.getEmail()).into(EMAIL_EDIT_TEXT),
                Enter.theValue(VOID_STR).into(CAPTCHA_EDIT_TEXT),
                Click.on(BUTTON_CONFIRM)
        );
    }

}
