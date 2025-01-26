package com.tcs.test.ui.evalart;

import com.tcs.test.exceptions.NotFoundTextException;
import com.tcs.test.utils.Utils;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.targets.Target;

public class FormPage {
    // Revisar por texto CYLE_TEXT !!!
    public static final Target CYLE_TEXT =
            Target.the("Text of number cycle").locatedBy("//p[contains(text(),'Se encuentra en el ciclo')" +
                    "]");
    // Revisar por texto EMOJI_TEXT_TITLE !!!
    public static final Target EMOJI_TEXT_TITLE =
            Target.the("Text contains emoji").locatedBy("//p[contains(text(),'Indique cuantos')" +
                    "]/parent::div//p[1]");
    // Revisar por texto EMOJI_TEXT_TITLE !!!
    public static final Target EMOJI_TEXT_BODY =
            Target.the("Text contains all emojis").locatedBy("//p[contains(text(),'Indique cuantos')]/parent::div//p[2]");
    public static final Target INPUT_COUNT_EMOJI =
            Target.the("Input Text count Emoji").locatedBy("//input[@name='number']");
    // Revisar por texto WRITE_LETTER_TITLE !!!
    public static final Target WRITE_LETTER_TITLE =
            Target.the("Text contains letter to write").locatedBy("//p[contains(text(),'veces la letra')]");

    public static final Target INPUT_LETTER =
            Target.the("Input text of letter to write").locatedBy("//textarea[@name='text']");
    // Revisar por texto LIST_OPERATIONS_TEXT !!!
    public static final Target LIST_OPERATIONS_TEXT =
            Target.the("List of operations text").locatedBy("//*[contains(text(),'Complete la siguiente operación matemática :')]/parent::div//p[2]");
    public static final Target SELECT_NUMBER_INPUT =
            Target.the("List of numbers of select input").locatedBy("//select[@name='select']");
    public static final Target OPTION_NUMBER_SELECT =
            Target.the("Select option").locatedBy("//option[contains(text(),'{0}')]");
    public static final Target RADIO_BUTTON_NUMBER =
            Target.the("Radio button option").locatedBy("//input[@type='radio' and contains" +
                    "(@value,'{0}')]");
    public static final Target SEND_BUTTON =
            Target.the("Submit button").locatedBy("//button[@type='submit']");

    public static Integer MAX_CYCLE = 10;

    public static Integer getCycle(Actor actor) throws NotFoundTextException {
        String regExp = "Se encuentra en el ciclo (\\d+) de 10";
        return Integer.parseInt(Utils.extractTextUsing(actor, CYLE_TEXT, regExp));
    }

    public static String getEmoji(Actor actor) throws NotFoundTextException {
        String regExp = "Indique cuantos (.+) hay en la siguiente secuencia:";
        return Utils.extractTextUsing(actor, EMOJI_TEXT_TITLE, regExp);
    }

    public static String getLetter(Actor actor) throws NotFoundTextException {
        String regExp = "Escriba \\d+ veces la letra \"(\\w)\"";
        return Utils.extractTextUsing(actor, WRITE_LETTER_TITLE, regExp);
    }

    public static Integer getLetterCount(Actor actor) throws NotFoundTextException {
        String regExp = "Escriba (\\d+) veces la letra \"\\w\"";
        return Integer.parseInt(Utils.extractTextUsing(actor, WRITE_LETTER_TITLE, regExp));
    }
}
