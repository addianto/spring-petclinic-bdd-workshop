package starter.stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.HoverOverBy;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.ui.Button;
import net.serenitybdd.screenplay.ui.InputField;
import net.serenitybdd.screenplay.ui.Link;
import org.openqa.selenium.Keys;
import starter.navigation.SpringPetclinicHomePage;

import java.util.List;

public class PetTypeStepDefinitions {
    @Given("a system operator named {actor} is looking at the pet types page")
    public void lookingAtPetTypesPage(Actor actor) {
        actor.wasAbleTo(
                Open.browserOn()
                    .the(SpringPetclinicHomePage.class),
                // TODO: Refactor the two actions below into a new Performable class
                HoverOverBy.over(Link.withText("Pet Types")),
                Click.on(Link.withText("Pet Types"))
        );
    }

    @And("{actor} found the following pet types exist:")
    public void verifyingExistingPetTypes(Actor actor, DataTable table) {
        List<String> existingPetTypes = InputField
                .withNameOrId("pettype_name")
                .resolveAllFor(actor)
                .map(WebElementFacade::getValue);

        actor.wasAbleTo(
                Ensure.that(existingPetTypes)
                      .containsElementsFrom(table.asList())
        );
    }

    @When("{actor} adds a new pet type named {string}")
    public void addsNewPetType(Actor actor, String name) {
        actor.attemptsTo(
                // TODO: Refactor the click action below into a new Performable class
                Click.on(Button.withText("Add")),
                Enter.theValue(name)
                     .into(InputField.withNameOrId("name"))
                     .thenHit(Keys.ENTER)
        );
    }

    @Then("{actor} should see the pet type {string} on the list of pet types")
    public void shouldSeeThePetType(Actor actor, String name) {
        actor.attemptsTo(
                Ensure.thatAmongst(InputField.withNameOrId("pettype_name"))
                      .anyMatch(name + " should be on the list",
                              (field) -> field.getValue()
                                              .equals(name)
                      )
        );
    }
}
