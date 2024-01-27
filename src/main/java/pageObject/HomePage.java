package pageObject;

import actionDriver.Action;
import base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BaseClass {

    @FindBy(xpath = "(//div[contains(text(),'LOGIN')])[2]")
    WebElement loginButton;

    public HomePage(){
        PageFactory.initElements(webDriver, this);
    }

    //redirects user to the login page after clicking login button
    public LoginPage clickLoginButton(){
        String methodName = "clickLoginButton  Method";
        System.out.println(methodName + " Is Called");
        Action.click(webDriver, loginButton);
        return new LoginPage();
    }
}
