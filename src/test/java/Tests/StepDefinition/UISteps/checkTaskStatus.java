package Tests.StepDefinition.UISteps;

import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import io.qameta.allure.Step;


import static Tests.PageObject.TestProjectPageElem.*;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

public class checkTaskStatus {

    @Step
    @Когда("^пользователь переходит в задачу TestSelenium_bug$")
    public void пользовательПереходитВЗадачуTesSelenium_bug() {
        taskSearchInput.sendKeys("TestSelenium_bug");
        testSelenium_bug.shouldBe(visible).click();
    }

    @Step
    @Тогда("^пользователь видит статус задачи$")
    public void пользовательВидитСтатусЗадачи() {
        testSelenium_bugStatus.shouldBe(visible);
        System.out.println("Статус проекта TestSelenium_bug: " + testSelenium_bugStatus.getText());
        getTestSelenium_bugVersion.shouldBe(visible).shouldHave(text("Version 2.0"));
        System.out.println("Затронутая версия проекта: " + getTestSelenium_bugVersion.getText());
    }

}
