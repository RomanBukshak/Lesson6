package Tests.PageObject;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class TestProjectPageElem {

    public static SelenideElement taskList = $x("//span[text()='Список задач']//parent::a");
    public static SelenideElement numberOfTaskList = $x("//div[text()='Список задач']//following-sibling::div[contains(text(),'проблем(ы)')]");
    public static SelenideElement taskSearchInput = $x("//input[@aria-label='Поиск задач']");
    public static SelenideElement testSelenium_bug = $x("//a[text()='TEST-21967']");
    public static SelenideElement testSelenium_bugStatus = $x("//strong[text()='Статус:']//following-sibling::span[@class='value']");
    public static SelenideElement getTestSelenium_bugVersion = $x("//span[@id='versions-field']");
    public static SelenideElement imgTest = $x("//img[@alt='Test']");

}
