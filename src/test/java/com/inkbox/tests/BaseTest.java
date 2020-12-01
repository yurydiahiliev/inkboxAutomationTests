package com.inkbox.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.inkbox.core.ProjectConfig;
import org.aeonbits.owner.ConfigFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

/**
 * This is a base test class for configuring browser settings
 */
public class BaseTest {

    private static ProjectConfig uiConfig = ConfigFactory.create(ProjectConfig.class);

    @BeforeSuite
    public void setUp() {
        Configuration.browser = uiConfig.browser();
        Configuration.baseUrl = uiConfig.url();
        Configuration.timeout = uiConfig.browserTimeout();
    }

    @AfterSuite
    public void tearDown() {
        if (WebDriverRunner.getWebDriver() != null)
            WebDriverRunner.getWebDriver().quit();
    }
}
