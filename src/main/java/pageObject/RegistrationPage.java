package pageObject;

import actionDriver.Action;
import base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage extends BaseClass {

    @FindBy(xpath = "/html/body/div/div/div[3]/div/div/section/div/div/div[2]/form/div[1]/div/div/div/div/div/input")
    private WebElement firstName;

    @FindBy(xpath = "/html/body/div/div/div[3]/div/div/section/div/div/div[2]/form/div[2]/div/div/div/div/div/input")
    private WebElement lastName;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[3]/div/div/section/div/div/div[2]/form/div[3]/div/div/div/div/div/input")
    private WebElement emailAddress;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[3]/div/div/section/div/div/div[2]/form/div[4]/div/div/div/div/div/input")
    private WebElement password;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[3]/div/div/section/div/div/div[2]/form/div[5]/div/div/div/div/div/input")
    private WebElement confirmPassword;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[3]/div/div/section/div/div/div[2]/form/div[6]/div/label/span[2]")
    private  WebElement agreementCheckbox;

    @FindBy(xpath="//*[@id=\"root\"]/div/div[3]/div/div/section/div/div/div[2]/form/div[7]/div/button/div")
    private WebElement registerButton;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[3]/div/div/section/div/div/div[2]/div/div")
    private WebElement pageTitle;

    public RegistrationPage(){
        PageFactory.initElements(webDriver, this);
    }

    public String validateNewURL() {
        String methodName = "validateNewURL Method";
        System.out.println(methodName + " Is Called");
        return webDriver.getCurrentUrl();
    }

    public String validatePageTitle() {
        String methodName = "validatePageTitle Method";
        System.out.println(methodName + " Is Called");
        return pageTitle.getText();
    }

    public EmailVerificationPage registrationFormFillAndEmailVerification(String firstNameParam,
                                                                          String lastNameParam,
                                                                          String emailParam,
                                                                          String passwordParam,
                                                                          String confirmPasswordParam) throws InterruptedException {
        String methodName = "registrationFormFill Method";
        System.out.println(methodName + " Is Called");
        Action.type(firstName, firstNameParam);
        Action.type(lastName, lastNameParam);
        Action.type(emailAddress, emailParam);
        Action.type(password, passwordParam);
        Action.type(confirmPassword, confirmPasswordParam);
        Thread.sleep(5000);

        if (!agreementCheckbox.isSelected()) {
            Action.click(webDriver, agreementCheckbox);
            Action.click(webDriver, registerButton);
        } else {
            Action.click(webDriver, registerButton);
        }
        return new EmailVerificationPage();
    }
}
