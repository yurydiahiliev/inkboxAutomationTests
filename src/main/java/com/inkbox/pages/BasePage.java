package com.inkbox.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.inkbox.core.PageUrl;
import com.inkbox.core.ProjectConfig;
import com.inkbox.utils.WaitElementTimeout;
import org.aeonbits.owner.ConfigFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Selenide.sleep;

public class BasePage {

    private static ProjectConfig uiConfig = ConfigFactory.create(ProjectConfig.class);
    private static final Logger log = LoggerFactory.getLogger(BasePage.class);
    private long step = 300;

    /**
     * This method opening url in connection with page object class
     * @param tClass
     * @param <T>
     * @return
     */
    public static <T> T open(Class<T> tClass) {
        String urlPath;
        try {
            PageUrl pageUrl = tClass.getDeclaredAnnotation(PageUrl.class);
            if (pageUrl == null) {
                urlPath = "";
            } else {
                urlPath = pageUrl.value();
            }

            T pageObject = tClass.newInstance();
            open(uiConfig.url() + urlPath);
            return pageObject;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * This is a whole url which will be opened
     * @param url
     */
    public static void open(String url) {
        Selenide.open(url);
    }

    /**
     * This method creates new instance of object in runtime of tests
     * @param tClass
     * @param <T>
     * @return new instance of class
     */
    public static <T> T at(Class<T> tClass) {
        try {
            return tClass.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isPageObjectLoaded(SelenideElement element, WaitElementTimeout timeout, String assertionText) {
        int counter = 0;
        while (!element.isDisplayed() && counter <= timeout.getValue()) {
            sleep(step);
            counter += step;

            // Show progress of loading every 1000 milliseconds
            if (counter % 1000 == 0) {
                log.info("Loading page (element) '" + assertionText + "', counting: " + counter + " ms...");
            }
        }
        if (counter <= timeout.getValue()) {
            log.info("Page (element) '" + assertionText + "' was loaded!");
            return true;
        } else {
            throw new AssertionError("'" + assertionText + "' page (element) was not loaded or opened after " + timeout + " milliseconds!");
        }
    }
}
