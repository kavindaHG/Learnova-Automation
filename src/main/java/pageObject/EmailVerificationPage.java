package pageObject;

import base.BaseClass;
import factoryData.UserFactoryData;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmailVerificationPage extends BaseClass {

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[3]/div/div/section/div/div/div[2]/div[2]/div/span/span")
    WebElement userEmailAddress;


    public EmailVerificationPage(){
        PageFactory.initElements(webDriver, this);
    }

    public String validateEmailAddress(){
        String methodName = "validateEmailAddress method";
        System.out.println(methodName + " Is Called");
        String newUserEnteredEmailAddress = userEmailAddress.getText();
        System.out.println(newUserEnteredEmailAddress);
        return newUserEnteredEmailAddress;
    }

//    public boolean isPageAvailable(){
//        return Action.isDisplayed(webDriver, userEmailAddress);
//    }
}