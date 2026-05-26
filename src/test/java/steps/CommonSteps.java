package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.BasePage;
import tools.PropertiesLoader;

public class CommonSteps {

    BasePage basePage = new BasePage();

    @When("they reload the page")
    public void reloadPage() {
        basePage.reloadPage();
    }

    @When("they close the browser window")
    public void closeBrowserWindow() {
        basePage.closeWindowAndOpenNewWindow();
    }

    @When("they go back to the first browser tab")
    public void switchToTheFirstBrowserTab() {
        basePage.switchToTheFirstBrowserTab();
    }

    @And("they close the browser tab")
    public void closeAndOpenNeTab() {
        basePage.closeTabAndOpenNewTab();
    }

    @And("they open another browser tab")
    public void openNewBrowserTab() {
        basePage.openNewTab();
    }

    @Then("they verify that they see element {string}")
    public void theyVerifyThatTheySeeElement(String element) {
        basePage.assertElementIsDisplayed(element);
    }

    @Given("open page {string}")
    public void userIsOnThePage(String url) {
        basePage.openWebPage(url);
    }

    @When("they enter {string} in {string}")
    public void theyEnterIn(String text, String inputElement) {
        basePage.sendKeyToElement(text, inputElement);
    }

    @And("they click {string}")
    public void theyClick(String element) {
        basePage.clickElement(element);
    }

    @And("they clear field {string}")
    public void theyClearField(String element) {
        basePage.clearField(element);
    }

    @Then("assert text {string} presented in {string}")
    public void assertTextPresentedIn(String text, String target) {
        basePage.assertTextPresentedIn(text, target);
    }

    @And("wait for {string} is visible")
    public void waitForElementIsVisible(String target) {
        basePage.waitForElementIsVisible(target);
    }

    @And("they see a success popup message {string}")
    public void theyVerifyThatSuccessMessageAppears(String messageText) {
        basePage.assertPopUpMessageIsDisplayed(PropertiesLoader.getProperties("successfulMessage"));
        basePage.assertPopUpMessageDescriptionIsDisplayed(messageText);
        basePage.closePopUpWindow();
    }

    @And("they see a warning popup message {string}")
    public void theyVerifyThatWarningMessageAppears(String messageText) {
        basePage.assertPopUpMessageIsDisplayed(PropertiesLoader.getProperties("warningMessage"));
        basePage.assertPopUpMessageDescriptionIsDisplayed(messageText);
        basePage.closePopUpWindow();
    }
}