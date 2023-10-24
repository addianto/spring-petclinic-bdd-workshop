package starter.owner;

import net.serenitybdd.screenplay.targets.Target;

public class NewOwnerForm {

    public static Target FIRST_NAME_FIELD = Target
            .the("first name field")
            .locatedBy("//input[@id='firstName']");

    public static Target LAST_NAME_FIELD = Target
            .the("last name field")
            .locatedBy("//input[@id='lastName']");

    public static Target ADDRESS_FIELD = Target
            .the("address field")
            .locatedBy("//input[@id='address']");
}
