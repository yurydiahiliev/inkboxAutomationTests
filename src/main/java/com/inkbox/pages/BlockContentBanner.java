package com.inkbox.pages;

import com.codeborne.selenide.SelenideElement;
import com.inkbox.utils.WaitElementTimeout;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;
import static com.inkbox.utils.WaitUtils.waitUntilDisplayed;
import static com.inkbox.utils.WaitUtils.waitUntilHidden;

public class BlockContentBanner extends BasePage {

    private SelenideElement blockBanner = $x("//div[@class='ub-emb-iframe-wrapper ub-emb-visible']");
    private SelenideElement closeBannerButton = $x("//div[@class='ub-emb-iframe-wrapper ub-emb-visible']//button[@class='ub-emb-close']");

    @Step
    public void closeBlockBanner() {
        boolean isBannerVisible = waitUntilDisplayed(blockBanner, WaitElementTimeout.MEDIUM);
        if (isBannerVisible) {
            closeBannerButton.click();
            waitUntilHidden(blockBanner, WaitElementTimeout.SMALL);
        }
    }
}
