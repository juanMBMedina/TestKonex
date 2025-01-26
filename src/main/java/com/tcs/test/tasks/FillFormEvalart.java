package com.tcs.test.tasks;

import com.tcs.test.exceptions.NotFoundTextException;
import com.tcs.test.ui.evalart.FormPage;
import com.tcs.test.utils.Utils;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import javax.script.ScriptException;
import java.util.List;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class FillFormEvalart implements Task {

    public static Performable go() {
        return instrumented(FillFormEvalart.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            Integer actualCycle = FormPage.getCycle(actor);
            while (actualCycle <= FormPage.MAX_CYCLE) {
                Integer countEmoji =
                        Utils.countItemIn(FormPage.EMOJI_TEXT_BODY.resolveFor(actor).getText(),
                                FormPage.getEmoji(actor));
                String repeatLetter = Utils.repeatItem(FormPage.getLetter(actor),
                        FormPage.getLetterCount(actor));

                List<String> operations =
                        FormPage.LIST_OPERATIONS_TEXT.resolveAllFor(actor).texts();

                String radioButtonText = Utils.evaluateExpression(operations.get(0)).toString().replace("=?","");
                String selectOptionText = Utils.evaluateExpression(operations.get(1)).toString();
                actor.attemptsTo(
                        Enter.theValue(countEmoji.toString()).into(FormPage.INPUT_COUNT_EMOJI),
                        Click.on(FormPage.RADIO_BUTTON_NUMBER.of(radioButtonText)),
                        Enter.theValue(repeatLetter).into(FormPage.INPUT_LETTER),
                        Click.on(FormPage.SELECT_NUMBER_INPUT),
                        Click.on(FormPage.OPTION_NUMBER_SELECT.of(selectOptionText)),
                        Click.on(FormPage.SEND_BUTTON)
                );
            }

        } catch (NotFoundTextException e) {
            throw new RuntimeException(e);
        }

    }
}
