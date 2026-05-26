package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.HomePage;

public class HomePageSteps {

    HomePage homePage = new HomePage();

    @Then("they see a Circle Name on Home Page")
    public void theySeeCircleNameOnHomePage() {
        homePage.assertCircleNameIsDisplayedOnHomePage();
    }

    @And("they see a Circle Name {string} on Home Page")
    public void theyVerifyThatTheyAreOnThatCircleHomePage(String circleName) {
        homePage.assertCircleNameIsDisplayedOnHomePage(circleName);
    }
}