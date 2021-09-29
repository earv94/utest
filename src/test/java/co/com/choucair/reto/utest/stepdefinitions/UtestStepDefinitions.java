package co.com.choucair.reto.utest.stepdefinitions;

import co.com.choucair.reto.utest.model.UtestData;
import co.com.choucair.reto.utest.questions.Answer;
import co.com.choucair.reto.utest.tasks.*;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.actors.OnlineCast;

import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static net.serenitybdd.screenplay.actors.OnStage.*;

public class UtestStepDefinitions {

    @Before
    public void setStage (){ setTheStage(new OnlineCast());}

    @Given("^than brandom wants to signup at the Utest page$")
    public void thanBrandomWantsToSignupAtTheUtestPage() {
        theActorCalled("Brandon").wasAbleTo(
                OpenUp.thePage(),
                SignUp.onThePage());
    }


    @When("^he fill out the registration form on the Utest web page$")
    public void heFillOutTheRegistrationFormOnTheUtestWebPage(List<UtestData> utestData) throws Exception {
        theActorInTheSpotlight().attemptsTo(
                FillPersonalData.onTheSignUpForm(utestData.get(0)),
                FillLocationData.onTheSignUpForm(utestData.get(0)),
                FillDevicesData.onTheSignUpForm(utestData.get(0)),
                FillSecurityData.onTheSignUpForm(utestData.get(0)));
    }

    @Then("^he should see the confirmation page at the Utest web page$")
    public void heShouldSeeTheConfirmationPageAtTheUtestWebPage(List<UtestData> utestData) throws Exception {
        theActorInTheSpotlight().should(seeThat(Answer.toThe(utestData.get(0).getStrText())));
    }

}
