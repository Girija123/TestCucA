package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Header {

    //driver.findElement(By.id("")).click();

    public Header(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="")
    public WebElement nextLogo;

    @FindBy(id="sli_search_1")
    public WebElement searchTxtFld;

    @FindBy(xpath="//input[@title='Search Items']")
    public WebElement searchIcon;

    @FindBy(xpath="")
    public WebElement myAccountLink;

    @FindBy(xpath="")
    public  WebElement helpLink;

    @FindBy(xpath="")
    public WebElement storeLocatorLink;

    @FindBy(xpath="")
    public WebElement bagIcon;

    @FindBy(xpath="")
    public WebElement favouritesIcon;


    public void enterSearchTerm(String searchTerm)
    {
        searchTxtFld.sendKeys(searchTerm);
    }

    public void clickSearchIcon()
    {
        searchIcon.click();
    }



}
