package pageObject;

import actionDriver.Action;
import base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass {

//input[@name='email'][2] - ===EMAIL===
//*[@id=\"app-view-container\"]/div[1]/div/div/div/section/div/div/div[2]/form/div[3]/div/div/div/div/div/input - ===PWD===
//*[@id="root"]/div/div[3]/div/div/section/div/div/div[2]/form/div[4]/div[1]/label/input - ===CHECKBOX===
//*[@id="app-view-container"]/div[1]/div/div/div/section/div/div/div[2]/form/div[5]/div/button - ===LOGIN BUTTON===
//@FindBy(xpath = "//input[@type='checkbox']") === checkbox
//button[@type='submit'][2] === login button

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[3]/div/div/section/div/div/div[2]/form/div[2]/div/div/div/div/div/input")
    private WebElement loginEmail;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[3]/div/div/section/div/div/div[2]/form/div[3]/div/div/div/div/div/input")
    private WebElement loginPassword;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[3]/div/div/section/div/div/div[2]/form/div[5]/div/button")
    private WebElement rememberMeCheckBox;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[3]/div/div/section/div/div/div[2]/form/div[5]/div/button")
    private WebElement loginButton;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[3]/div/div/section/div/div/div[2]/form/div[6]/div/span[2]")
    private WebElement signUpLink;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[3]/div/div/section/div/div/div[2]/form/div[1]/div")
    private WebElement pageTitle;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[3]/div/div/section/div/div/div[2]/form/div[2]/div/div/div/div/span")
    private WebElement emptyUsernameText;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[3]/div/div/section/div/div/div[2]/form/div[3]/div/div/div/div/span")
    private WebElement emptyPasswordText;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[3]/div/div/section/div/div/div[2]/form/div[2]/div/div/div/div/span")
    private WebElement invalidEmailPatternInputErrorText;

    @FindBy(xpath = "//*[@id=\"1\"]/div[1]/div[2]")
    private WebElement invalidCredentialsToastMessage;

    public LoginPage (){
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

    public String emptyUsernameText(){
        return emptyUsernameText.getText();
    }

    public String emptyPasswordText(){
        return emptyPasswordText.getText();
    }

    public String invalidCredentialsToastMessageText(){
        return invalidCredentialsToastMessage.getText();
    }

    public String invalidEmailPatternText(){
        return invalidEmailPatternInputErrorText.getText();
    }



    public MyCoursesPage login(String userName, String password) throws InterruptedException {
        Action.type(loginEmail, userName);
        Action.type(loginPassword, password);
        Thread.sleep(500);
        Action.click(webDriver, loginButton);
        return new MyCoursesPage();
    }

    public RegistrationPage clickSignUpLink(){
        String methodName = "click signUpLink Method";
        System.out.println(methodName + "Is Called");
        Action.click(webDriver,signUpLink);
        return new RegistrationPage();
    }
}
