package com.inkbox.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.inkbox.utils.WaitElementTimeout.MEDIUM;
import static com.inkbox.utils.WaitUtils.waitUntilDisplayed;

public class HeaderNavBar extends BasePage {

    private SelenideElement headerUserLink = $("#header-user button");

    @Step
    public LoginPage clickOnHeaderUserLink() {
        waitUntilDisplayed(headerUserLink, MEDIUM);
        headerUserLink.click();
        return new LoginPage();
    }

    @Step
    public String getHeaderUserText() {
        return headerUserLink.$("span:nth-child(2)").getText();
    }
}
