package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.TopicsPage;

public class CreateTopicSteps {

    TopicsPage topicsPage = new TopicsPage();

    @When("they click New Topic Plus Button")
    public void ClickCreateTopicPlusButton() {
        topicsPage.clickCreateTopicPlusButton();
    }

    @When("they create a new topic")
    public void CreateNewTopic() {
        topicsPage.clickCreateTopicPlusButton();
        topicsPage.generateNewUniqueTopicNameInPopUpWindow();
        topicsPage.clickCreateButtonOnTopicPage();
    }

    @And("they enter {string} in new topic name input field")
    public void enterNewTopicNameInputField(String NewTopicName) {
        topicsPage.enterNewTopicNameInputField(NewTopicName);
    }

    @And("they click on Create button on topic page")
    public void clickOnCreateButton() {
        topicsPage.clickCreateButtonOnTopicPage();
    }

    @Then("success message {string} pops-up on Topic page")
    public void successMessagePopsUpOnTopicPage(String TopicHasBeenCreated) {
        topicsPage.assertSuccessMessageOnTopicPageIsDisplayed(TopicHasBeenCreated);
    }
}