package com.inkbox.tests;

import com.inkbox.model.User;
import com.inkbox.pages.BlockContentBanner;
import com.inkbox.pages.HeaderNavBar;
import com.inkbox.pages.LoginPage;
import com.inkbox.pages.MainPage;
import com.inkbox.pages.SignUpPage;
import org.testng.annotations.Test;

import static com.inkbox.pages.BasePage.at;
import static com.inkbox.pages.BasePage.open;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class LoginPageTest extends BaseTest {

    private User user = new User("yu.dyagilev@gmail.com", "12345678");

    @Test
    public void checkUserCanLoginToSystem() {
        HeaderNavBar headerNavBar = open(MainPage.class).headerNavBar;

        LoginPage loginPage = headerNavBar.clickOnHeaderUserLink().clickOnLoginLink();

        at(BlockContentBanner.class).closeBlockBanner();
        headerNavBar.clickOnHeaderUserLink();

        String headerUserText = loginPage
                .loginAsUser(user)
                .headerNavBar
                .getHeaderUserText();

        assertThat("User should be logged in to the system", headerUserText, is("My Account"));
    }
}
