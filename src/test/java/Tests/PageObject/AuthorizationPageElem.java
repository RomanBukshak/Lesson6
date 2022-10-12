package Tests.PageObject;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class AuthorizationPageElem {
    public static SelenideElement loginLane = $x("//label[text()='мя пользователя']//following-sibling::input");
    public static SelenideElement passwordLane = $x("//label[text()='ароль']//following-sibling::input");
    public static SelenideElement loginButton = $x("//input[@class='aui-button aui-button-primary']");
    public static SelenideElement welcomeJira = $x("//img[@class='intro-logo']//following-sibling::h3");
}
