package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.ui.Button;
import net.serenitybdd.screenplay.ui.InputField;
import net.serenitybdd.screenplay.ui.Link;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import starter.navigation.SpringPetclinicHomePage;

public class SpecialtyStepDefinitions {

    @Given("a system operator named {actor} is looking at the specialties page")
    public void lookingAtSpecialtiesPage(Actor actor) {
        actor.wasAbleTo(
                Open.browserOn()
                    .the(SpringPetclinicHomePage.class),
                // TODO: Refactor the two actions below into a new Performable class
                HoverOverBy.over(Link.withText("Specialties")),
                Click.on(Link.withText("Specialties"))
        );
    }

    @When("{actor} adds a new specialty called {string}")
    public void addsNewSpecialty(Actor actor, String name) {
        actor.attemptsTo(
                // TODO: Refactor the Click action into a new Performable class
                Click.on(Button.withText("Add")),
                Enter.theValue(name)
                     .into(InputField.withNameOrId("name"))
                     .thenHit(Keys.ENTER)
        );
    }

    @When("{actor} edits the first specialty to {string}")
    public void editsFirstSpecialty(Actor actor, String name) {
        actor.attemptsTo(
                Click.on(Button.located(By.xpath("//table[@id='specialties']/tbody/tr[1]/td[2]/button[1]"))),
                Clear.field(InputField.withNameOrId("name")),
                Enter.theValue(name)
                     .into(InputField.withNameOrId("name")),
                Click.on(Button.withText("Update"))
        );
    }

    @Then("{actor} should see the specialty {string} on the list of specialties")
    public void shouldSeeTheSpecialty(Actor actor, String name) {
        actor.attemptsTo(
                Ensure.thatAmongst(InputField.withNameOrId("spec_name"))
                      .anyMatch(name + " should be on the list",
                              (field) -> field.getValue()
                                              .equals(name)
                      )
        );
    }
}
