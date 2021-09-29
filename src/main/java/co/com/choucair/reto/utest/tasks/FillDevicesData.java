package co.com.choucair.reto.utest.tasks;

import co.com.choucair.reto.utest.model.UtestData;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import org.openqa.selenium.Keys;

import static co.com.choucair.reto.utest.userinterface.FillDevicesDataPage.*;

public class FillDevicesData implements Task {

    private UtestData fill;

    public FillDevicesData(UtestData fill){
        this.fill= fill;
    }

    public static FillDevicesData onTheSignUpForm(UtestData fill) {
        return Tasks.instrumented(FillDevicesData.class, fill);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(Click.on(DEVICE_BUTTON),
                Enter.theValue(fill.getStrDevice()).into(INPUT_DEVICE).thenHit(Keys.ENTER),
                Click.on(MODEL_BUTTON),
                Enter.theValue(fill.getStrModel()).into(INPUT_MODEL).thenHit(Keys.ENTER),
                Click.on(OS_BUTTON),
                Enter.theValue(fill.getStrOS()).into(INPUT_OS).thenHit(Keys.ENTER),
                Click.on(NEXT_BUTTON));
    }
}
