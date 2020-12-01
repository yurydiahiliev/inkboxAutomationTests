package com.inkbox.pages;

import com.codeborne.selenide.SelenideElement;
import com.inkbox.model.User;
import com.inkbox.utils.WaitElementTimeout;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;
import static com.inkbox.utils.WaitUtils.waitUntilHidden;

public class LoginPage extends BasePage {

    private SelenideElement userEmailInput = $x("//form[@id='accountLoginForm_popup']//input[@name='email']");
    private SelenideElement userPasswordInput = $x("//form[@id='accountLoginForm_popup']//input[@name='password']");
    private SelenideElement logInButton = $x("//form[@id='accountLoginForm_popup']//button[@type='submit']");

    @Step
    public MainPage loginAsUser(User user) {
        userEmailInput.setValue(user.getUserEmail());
        userPasswordInput.setValue(user.getUserPassword());
        logInButton.click();
        waitUntilHidden(logInButton, WaitElementTimeout.MEDIUM);
        return new MainPage();
    }
}
