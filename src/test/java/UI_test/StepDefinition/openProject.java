package UI_test.StepDefinition;

import com.codeborne.selenide.Condition;
import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import io.qameta.allure.Step;

import static UI_test.PageObject.PageElements.LoggedPageElem.projectTest;
import static UI_test.PageObject.PageElements.LoggedPageElem.projectsDropButton;
import static UI_test.PageObject.PageElements.TestProjectPageElem.imgTest;


public class openProject {

    @Step
    @Дано("^пользователь авторизован$")
    public static void пользовательАвторизован() {
        authorization.пользовательЗаходитНаСайт();
        authorization.пользовательВводитЛогин();
        authorization.пользовательВводитПароль();
        authorization.пользовательНажимаетКнопкуЛогина();
        authorization.пользовательАвторизуетсяВСистеме();
    }

    @Step
    @Когда("^пользователь кликает на выпадающий список$")
    public static void пользовательКликаетНаВыпадающийСписок() {
        projectsDropButton.shouldBe(Condition.visible).click();
    }

    @Step
    @И("^пользователь выбирает проект$")
    public static void пользовательВыбираетПроект() {
        projectTest.click();
    }

    @Step
    @Тогда("^открывается проект$")
    public static void открываетсяПроект() {
        imgTest.shouldBe(Condition.visible).shouldHave(Condition.attribute("alt", "Test"));
    }

}
