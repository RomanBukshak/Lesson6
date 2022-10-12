package Tests.PageObject;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class CreatNewTaskElem {
    public static SelenideElement issuesIcon = $x("//span[text()='Задачи']//parent::a");
    public static SelenideElement creatNewTask = $x("//div[@class='iic-trigger']");
    public static SelenideElement openInDialogBox = $x("//button[text()='Открыть в диалоговом окне']");
    public static SelenideElement typeTaskDropMenu = $x("//div[@id='issuetype-single-select']//child::span");
    public static SelenideElement typeTaskError = $x("//input[@id='issuetype-field']");
    public static SelenideElement creatThema = $x("//label[text()='Тема ']//following-sibling::input");
    public static SelenideElement textButton = $x("//button[text()='Текст']");
    public static SelenideElement textAreaDescription = $x("//textarea[@id='description']");
    public static SelenideElement creatButton = $x("//input[@value='Создать']");
    public static SelenideElement inWorkButton = $x("//span[text()='В работе']");
    public static SelenideElement businessProcessButton = $x("//span[text()='Бизнес-процесс']");
    public static SelenideElement doneButton = $x("//span[text()='Выполнено']");
    public static SelenideElement idTask = $x("//a[@class='issue-link']");
    public static SelenideElement statusTask = $x("//span[@id='status-val']//child::span");
    public static SelenideElement fixInVersionV2 = $x("//label[text()='Исправить в версиях']//parent::div//child::option[contains(text(),'Version 2.0')]");
    public static SelenideElement textAreaEnvironment = $x("//textarea[@id='environment']");
    public static SelenideElement appointMeButton = $x("//button[text()='Назначить меня']");
    public static SelenideElement priorityField = $x("//input[@aria-label='Приоритет']");


}
