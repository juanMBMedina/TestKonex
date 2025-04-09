package co.com.konex.test.utils;

import net.serenitybdd.screenplay.targets.Target;

public class Utils {

    public static Target getTarget(String description, String format, String strTitle) {
        return Target.the(description).locatedBy(String.format(format, strTitle));
    }

}
