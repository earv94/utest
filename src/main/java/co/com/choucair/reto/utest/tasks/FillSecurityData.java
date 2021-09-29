package co.com.choucair.reto.utest.tasks;

import co.com.choucair.reto.utest.model.UtestData;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static co.com.choucair.reto.utest.userinterface.FillSecurityDataPage.*;

public class FillSecurityData implements Task {

    private UtestData fill;

    public FillSecurityData(UtestData fill){
        this.fill = fill;
    }

    public static FillSecurityData onTheSignUpForm(UtestData fill) {
        return Tasks.instrumented(FillSecurityData.class, fill);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Enter.theValue(fill.getStrPassword()).into(INPUT_PASSWORD),
                Enter.theValue(fill.getStrConfirmPass()).into(INPUT_PASSWORD_CONFIRMATION),
                Click.on(TERMS_CHECK),
                Click.on(POLICY_CHECK),
                Click.on(COMPLETE_BUTTON));
    }
}
