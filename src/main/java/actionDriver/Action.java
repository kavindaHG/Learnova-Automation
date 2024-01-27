package actionDriver;
import base.BaseClass;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Action extends BaseClass  {

    public static boolean findElement(WebDriver webDriver, WebElement element) {
        boolean flag =false;
        try {
            element.isDisplayed();
            flag = true;
        }catch (Exception e){
            flag = false;
        }finally {
            if (flag){
                System.out.println("Successfully found Element at");
            }else {
                System.out.println("Element not found at");
            }
        }
        return flag;
    }

    public static boolean isDisplayed(WebDriver webDriver, WebElement element) {
        boolean flag = false;
        flag = findElement(webDriver, element);
        if (flag) {
            flag = element.isDisplayed();
            if (flag) {
                System.out.println("The element is Displayed");
            } else {
                System.out.println("The element is not Displayed");
            }
        } else {
            System.out.println("Not displayed ");
        }
        return flag;
    }

    public static void moveAndThenClick(WebDriver webDriver, WebElement element) {
        Actions action = new Actions(webDriver);
        action.moveToElement(element).click().build().perform();
    }

    public static void click(WebDriver webDriver, WebElement element){
        element.click();
    }

    public static boolean type(WebElement element, String text) {
        boolean flag = false;
        try {
            flag = element.isDisplayed();
            element.clear();
            element.sendKeys(text);
            flag = true;
        }catch (Exception e){
            System.out.println("Element not found");
        }finally {
            if (flag){
                System.out.println("Value Entered Successfully");
            }else{
                System.out.println("Unable to enter the value");
            }
        }
        return flag;
    }

    public static String getCurrentURL(WebDriver webDriver) {
        boolean flag = false;
        String text = webDriver.getCurrentUrl();
        if (flag){
            System.out.println("Current URL is \""+text+"\"");
        }
        return text;
    }

    public static void fluentWait(WebDriver webDriver, WebElement element, int timeOut) {
        Wait<WebDriver> wait = null;
        try {
            wait = new FluentWait<WebDriver>((WebDriver) webDriver)
                    .withTimeout(Duration.ofSeconds(20))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(Exception.class);
            wait.until(ExpectedConditions.visibilityOf(element));
            element.click();
        }catch(Exception e) {
        }
    }

    public static void implicitWait(WebDriver webDriver, int timeOut) {
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public static void explicitWait(WebDriver webDriver, WebElement element, int timeout) {
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(timeout));
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void pageLoadTimeOut(WebDriver webDriver, int timeOut) {
        webDriver.manage().timeouts().pageLoadTimeout(timeOut,TimeUnit.SECONDS);

    }

    public static String screenShot(WebDriver webDriver, String fileName) {
        String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot takesScreenshot = (TakesScreenshot) webDriver;
        File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
        String destination = System.getProperty("user.dir") + "\\ScreenShots\\" + fileName + "_" + dateName + ".png";

        try {
            FileUtils.copyFile(source, new File(destination));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String newImageString = "https://localhost:8082/job/learnova/screenshots" + fileName + "_" + dateName + ".png";
        return newImageString;
    }

    public static String getCurrentDateTime() {
        String currentDateTime = new SimpleDateFormat("yyyy-MM-dd-hhmmss").format(new Date());
        return currentDateTime;
    }
}
