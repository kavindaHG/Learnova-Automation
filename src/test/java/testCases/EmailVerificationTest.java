package testCases;

import actionDriver.Action;
import base.BaseClass;
import factoryData.UserFactoryData;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageObject.EmailVerificationPage;
import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.RegistrationPage;

public class EmailVerificationTest extends BaseClass {

    HomePage homePage;
    LoginPage loginPage;
    RegistrationPage registrationPage;
    EmailVerificationPage emailVerificationPage;

    String userFirstName = UserFactoryData.createNewUserData().getFirstName();
    String userLastName = UserFactoryData.createNewUserData().getLastName();
    String password = UserFactoryData.createNewUserData().getPassword();
    String confirmPassword = UserFactoryData.createNewUserData().getConfirmPassword();
    String expectedEmailAddress = UserFactoryData.createNewUserData().getEmail();

//    String actualUserRegistrationURL = emailVerificationPage.validateNewURL();


    @Test
    public void verifyEmailAddress() throws InterruptedException {

        homePage = new HomePage();
        loginPage = new LoginPage();
        registrationPage = new RegistrationPage();
        emailVerificationPage = new EmailVerificationPage();

        homePage.clickLoginButton();
        loginPage.clickSignUpLink();
        registrationPage.registrationFormFill(
                userFirstName, userLastName, expectedEmailAddress, password, confirmPassword);
        Thread.sleep(5000);

        String actualUserRegistrationURL = emailVerificationPage.validateNewURL();
        String expectedUserRegistrationURL = "https://learnova-dev.skillsurf.lk/verify-email";
        String actualEmailAddress = emailVerificationPage.validateEmailAddress();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualUserRegistrationURL, expectedUserRegistrationURL);
        softAssert.assertEquals(actualEmailAddress,expectedEmailAddress);
        softAssert.assertAll("Assert Failed");
    }


}
