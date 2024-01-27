package testCases;

import base.BaseClass;
import factoryData.UserFactoryData;
import model.UserModel;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageObject.EmailVerificationPage;
import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.RegistrationPage;

public class RegistrationPageTest extends BaseClass {

    HomePage homePage;
    LoginPage loginPage;
    RegistrationPage registrationPage;
    EmailVerificationPage emailVerificationPage;
    String userFirstName = UserFactoryData.createNewUserData().getFirstName();
    String userLastName = UserFactoryData.createNewUserData().getLastName();
    String password = UserFactoryData.createNewUserData().getPassword();
    String confirmPassword = UserFactoryData.createNewUserData().getConfirmPassword();
    String expectedEmailAddress = UserFactoryData.createNewUserData().getEmail();

    @Test
    public void verifyRegistrationPage() throws InterruptedException {

        homePage = new HomePage();
        loginPage = new LoginPage();
        registrationPage = new RegistrationPage();

        homePage.clickLoginButton();
        loginPage.clickSignUpLink();

//        Thread.sleep(3000);
        String actualRegistrationPageURL = registrationPage.validateNewURL();
        String expectedRegistrationPageURL = "https://learnova-dev.skillsurf.lk/register";
        String actualPageTitle = registrationPage.validatePageTitle();
        String expectedPageTitle = "Sign Up";

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualRegistrationPageURL, expectedRegistrationPageURL);
        softAssert.assertEquals(actualPageTitle, expectedPageTitle);
        softAssert.assertAll("Assert Failed");
    }

    @Test(priority = 1)
    public void newUserRegistrationTest() throws InterruptedException {

        homePage = new HomePage();
        loginPage = new LoginPage();
        registrationPage = new RegistrationPage();
        emailVerificationPage = new EmailVerificationPage();

        homePage.clickLoginButton();
        loginPage.clickSignUpLink();
        registrationPage.registrationFormFill(
                userFirstName, userLastName, expectedEmailAddress, password, confirmPassword);
        Thread.sleep(5000);

        String actualEmailVerificationURL = emailVerificationPage.validateNewURL();
        String expectedEmailVerificationURL = "https://learnova-dev.skillsurf.lk/verify-email";
        String actualEmailAddress = emailVerificationPage.validateEmailAddress();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualEmailVerificationURL, expectedEmailVerificationURL);
        softAssert.assertEquals(actualEmailAddress,expectedEmailAddress);
        softAssert.assertAll("Assert Failed");
    }
}

