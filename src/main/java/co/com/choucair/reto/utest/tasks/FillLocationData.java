package co.com.choucair.reto.utest.tasks;

import co.com.choucair.reto.utest.model.UtestData;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Hit;
import org.openqa.selenium.Keys;

import static co.com.choucair.reto.utest.userinterface.FillLocationDataPage.*;

public class FillLocationData implements Task {

    private UtestData fill;

    public FillLocationData(UtestData fill){
        this.fill= fill;
    }

    public static FillLocationData onTheSignUpForm(UtestData fill) {
        return Tasks.instrumented(FillLocationData.class, fill);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Enter.theValue(fill.getStrCity()).into(INPUT_CITY),
                Hit.the(Keys.ARROW_DOWN).into(INPUT_CITY),
                Hit.the(Keys.ENTER).into(INPUT_CITY),
                Enter.theValue(fill.getStrZip()).into(INPUT_ZIP),
                Click.on(NEXT_BUTTON)
        );
    }
}
