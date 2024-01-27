package testCases;

import base.BaseClass;
import factoryData.UserFactoryData;
import model.UserModel;
import org.testng.annotations.Test;
import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.RegistrationPage;

public class RegistrationPageTest extends BaseClass {

    HomePage homePage;
    LoginPage loginPage;
    RegistrationPage registrationPage;

    @Test(priority = 1)
    public void registerNewUser() throws InterruptedException {
        homePage = new HomePage();
        loginPage = new LoginPage();
        registrationPage = new RegistrationPage();

        homePage.clickLoginButton();
        loginPage.clickSignUpLink();

        registrationPage.registrationFormFill(
                UserFactoryData.createNewUserData().getFirstName(),
                UserFactoryData.createNewUserData().getLastName(),
                UserFactoryData.createNewUserData().getEmail(),
                UserFactoryData.createNewUserData().getPassword(),
                UserFactoryData.createNewUserData().getConfirmPassword()
        );
    }
}
