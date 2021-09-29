package co.com.choucair.reto.utest.tasks;

import co.com.choucair.reto.utest.model.UtestData;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.actions.type.Type;
import org.openqa.selenium.Keys;

import static co.com.choucair.reto.utest.userinterface.FillPersonalDataPage.*;

public class FillPersonalData implements Task {

    private UtestData fill;

    public FillPersonalData(UtestData fill){
        this.fill= fill;
    }

    public static FillPersonalData onTheSignUpForm(UtestData fill) {
        return Tasks.instrumented(FillPersonalData.class, fill);
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Enter.theValue(fill.getStrFirstName()).into(INPUT_FIRST_NAME),
                Enter.theValue(fill.getStrLastName()).into(INPUT_LAST_NAME),
                Enter.theValue(fill.getStrEmail()).into(INPUT_EMAIL),
                SelectFromOptions.byVisibleText(fill.getStrBirthMonth()).from(INPUT_BIRTH_MONTH),
                SelectFromOptions.byVisibleText(fill.getStrBirthDay()).from(INPUT_BIRTH_DAY),
                SelectFromOptions.byVisibleText(fill.getStrBirthYear()).from(INPUT_BIRTH_YEAR),
                Type.theValue(fill.getStrlanguage()).into(INPUT_LANGUAGES).thenHit(Keys.ENTER),
                Click.on(NEXT_BUTTON)
        );
    }

}
