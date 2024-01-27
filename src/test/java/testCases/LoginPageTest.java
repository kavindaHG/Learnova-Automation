package testCases;

import base.BaseClass;
import org.testng.annotations.Test;
import pageObject.HomePage;
import pageObject.LoginPage;

public class LoginPageTest extends BaseClass {

    HomePage homePage;
    LoginPage loginPage;

    @Test(priority = 1)
    public void loginTest() throws InterruptedException {
        homePage = new HomePage();
        loginPage = homePage.clickLoginButton();
        homePage = loginPage.login(properties.getProperty("LOGIN_EMAIL"), properties.getProperty("LOGIN_PASSWORD"));
    }
}
