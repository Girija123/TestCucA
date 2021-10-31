package functionLibrary;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class CommonFunctions {

    public static WebDriver driver;
    public String screenshotPath =  new File("src/main/resources/errShots").getAbsolutePath();
    public String propertyFilePath = new File("src/main/resources/testData/config.properties").getAbsolutePath();

    public void openBrowser()
    {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
    }

    public void closeBrowser()
    {
        driver.quit();
    }

    public void mouseOver(WebElement element)
    {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
    }

    public void takeScreenShot(String fileName) throws Exception
    {
        TakesScreenshot screenshot = ((TakesScreenshot) driver);
        File virtualFile =  screenshot.getScreenshotAs(OutputType.FILE);
        File destFile = new File(screenshotPath +fileName);
        FileUtils.copyFile(virtualFile, destFile);
    }

    public String readProperty(String key) throws Exception
    {
        FileInputStream inputStream = new FileInputStream(propertyFilePath);
        Properties properties = new Properties();
        properties.load(inputStream);

        String value = properties.getProperty(key);
        return value;
    }

    public void clickJS(WebElement element)
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }

    public void scrollInaPage(int dim)
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, "+dim+")");
    }
}
