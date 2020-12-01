package com.inkbox.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class SignUpPage extends BasePage {

    private SelenideElement logInLink = $x("//span[text()='Log in']");

    @Step
    public LoginPage clickOnLoginLink() {
        logInLink.click();
        return new LoginPage();
    }
}
