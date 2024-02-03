package base;

import actionDriver.Action;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BaseClass {

    public static Properties properties;
    public static WebDriver webDriver;

    @BeforeTest
    public void loadConfig(){
        try {
            properties = new Properties();
            System.out.println("Base Class Constructor invoked");
            FileInputStream fileInputStream =
                    new FileInputStream(
                            System.getProperty("user.dir")+"\\configuration\\configuration.properties");
            properties.load(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @BeforeMethod
    public static void init(){
        String browserName = properties.getProperty("BROWSER");
        if (browserName.contains("Chrome")){
            webDriver = new ChromeDriver();
        }else if (browserName.contains("Firefox")){
            webDriver = new FirefoxDriver();
        }else if (browserName.contains("Edge")){
            webDriver = new EdgeDriver();
        }else if(browserName.contains("Explorer")){
            webDriver = new InternetExplorerDriver();
        }

        webDriver.get(properties.getProperty("URL"));

        webDriver.manage().deleteAllCookies();
        webDriver.manage().window().maximize();
        Action.implicitWait(webDriver, 100);
        Action.pageLoadTimeOut(webDriver, 10);
    }

    @AfterMethod
    public static void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        webDriver.quit();
    }
}

