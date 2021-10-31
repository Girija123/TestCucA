package stepDefintions;

import functionLibrary.CommonFunctions;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class MenuSteps extends CommonFunctions {

    @When("I hover over menu option {string}")
    public void i_hover_over_menu_option(String menuOption) {
        WebElement menu = driver.findElement(By.xpath("//span[text()='"+menuOption+"']"));
        mouseOver(menu);
        menu.click();
    }
    @Then("I should be in the appropriate with title {string}")
    public void i_should_be_in_the_appropriate_with_title(String expectedTitle) {
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));
    }

}
