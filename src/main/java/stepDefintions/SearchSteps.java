package stepDefintions;

import functionLibrary.CommonFunctions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.bouncycastle.operator.MacCalculatorProvider;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pageObjects.Header;

import java.util.*;

public class SearchSteps extends CommonFunctions {

    Header header = new Header(driver);

    @Given("I'm on Home page {string}")
    public void i_m_on_home_page(String url) throws Exception {
        driver.get(readProperty("urlVal"));
        takeScreenShot("/homepage.png");
    }
    @When("I enter search term {string}")
    public void i_enter_search_term(String searchTerm) {
        header.enterSearchTerm(searchTerm);
    }
    @When("I click search icon")
    public void i_click_search_icon() throws Exception{
        header.clickSearchIcon();
        takeScreenShot("/searchResultsPage.png");
    }
    @Then("I should see relevant products realted to  {string} in search results page")
    public void i_should_see_relevant_products_realted_to_in_search_results_page(String expectedSearchTermInProductName) {

       List<WebElement> allProducts = driver.findElements(By.xpath("//a[@class='TitleText']/span"));

       for(WebElement eachProduct: allProducts)
       {
           String productName = eachProduct.getText();
           System.out.println(productName);
           Assert.assertTrue(productName.contains(expectedSearchTermInProductName));
       }

    }

    @Then("I shouldn't get results instead a message {string}")
    public void i_shouldn_t_get_results_instead_a_message(String noResultsReturnedMsg) {
      String actualNoResultsReturnedMsg = driver.findElement(By.xpath("")).getText();
        Assert.assertEquals(noResultsReturnedMsg, actualNoResultsReturnedMsg);
    }

}
