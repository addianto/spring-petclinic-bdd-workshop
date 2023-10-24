package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import starter.navigation.NavigateTo;
import starter.navigation.NavigationBar;
import starter.owner.NewOwnerForm;

public class OwnerStepDefinitions {

    @Given("{actor} is managing pet owners")
    public void managingOwners(Actor actor) {
        actor.wasAbleTo(
                NavigateTo.theSpringPetclinicHomePage()
        );
    }

    @When("{actor} adds new pet owner")
    public void addingOwner(Actor actor, String firstName,
                            String lastName, String address,
                            String city, String telephone) {
        actor.attemptsTo(
                Click.on(NavigationBar.OWNERS_MENU),
                Click.on(NavigationBar.NEW_OWNER_BUTTON),
                Enter.theValue(firstName).into(NewOwnerForm.FIRST_NAME_FIELD),
                Enter.theValue(lastName).into(NewOwnerForm.LAST_NAME_FIELD),
                Enter.theValue(address).into(NewOwnerForm.ADDRESS_FIELD)
        );
    }
}
