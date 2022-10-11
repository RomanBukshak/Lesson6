package UI_test.StepDefinition;

import com.codeborne.selenide.Condition;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import io.qameta.allure.Step;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;


import static UI_test.PageObject.PageElements.AuthorizationPageElem.*;
import static com.codeborne.selenide.Selenide.open;
import static utils.Configuration.getConfigurationValue;

public class authorization {

    public static void openUrl(String url) {
        open(url);
    }


    @Когда("^пользователь заходит на сайт$")
    public static void пользовательЗаходитНаСайт() {
        openUrl(getConfigurationValue("jiraUrl"));
    }


    @И("пользователь вводит логин")
    public static String пользовательВводитЛогин() {
        loginLane.shouldBe(Condition.visible).click();
        loginLane.sendKeys(getConfigurationValue("login"));
        return getConfigurationValue("login");
    }


    @И("^пользователь вводит пароль$")
    public static void пользовательВводитПароль() {
        passwordLane.click();
        passwordLane.sendKeys(getConfigurationValue("password"));
    }


    @И("^пользователь нажимает кнопку логина$")
    public static void пользовательНажимаетКнопкуЛогина() {
        loginButton.click();
    }


    @Тогда("^пользователь авторизуется в системе$")
    public static void пользовательАвторизуетсяВСистеме() {
        welcomeJira.shouldBe(Condition.visible);
    }

}
