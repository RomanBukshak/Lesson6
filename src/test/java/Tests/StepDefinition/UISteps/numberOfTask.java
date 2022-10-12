package Tests.StepDefinition.UISteps;

import com.codeborne.selenide.Condition;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import io.qameta.allure.Step;

import static Tests.PageObject.TestProjectPageElem.numberOfTaskList;
import static Tests.PageObject.TestProjectPageElem.taskList;

public class numberOfTask {

    @Step
    @И("^пользователь зашел на проект$")
    public static void пользовательЗашелНаПроект() {
        openProject.пользовательКликаетНаВыпадающийСписок();
        openProject.пользовательВыбираетПроект();
        openProject.открываетсяПроект();
    }

    @Step
    @Когда("^пользователь переходит в Список задач$")
    public void пользовательПереходитВСписокЗадач(){
        taskList.shouldBe(Condition.visible).click();
    }

    @Step
    @Тогда("^пользователь видит общее количество задач$")
    public void пользовательВидитОбщееКоличетсвоЗадач() {
        String str = numberOfTaskList.getText();
        String[] subStr;
        String delimiter = " ";
        subStr = str.split(delimiter);
        System.out.println("Общее количество задач: " + subStr[0]);
    }

}
