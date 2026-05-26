package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.CreateCirclePage;
import tools.PropertiesLoader;

public class CreateCircleSteps {

    CreateCirclePage createCirclePage = new CreateCirclePage();

    @Given("a user opens Create Circle page")
    public void aUserOpensCreateCirclePage() {
        createCirclePage.openCreateCirclePage();
        createCirclePage.enterAdminPasswordOnAdminPage(CreateCirclePage.getAdminPassword());
        createCirclePage.clickSubmitButton();
    }

    @And("they enter {string} in the Circle name field on the Create Circle page")
    public void theyEnterInTheCircleNameFieldOnTheCreateCirclePage(String circleName) {
        createCirclePage.enterCircleNameOnCreateCirclePage(circleName);
    }

    @And("they click the Generate button on the Create Circle page")
    public void theyClickTheGenerateButtonOnTheCreateCirclePage() {
        createCirclePage.clickGenerateButtonOnCreateCirclePage();
    }

    @And("they enter {string} in the First Name field on the Create Circle Page")
    public void theyEnterInTheFirstNameFieldOnTheCreateCirclePage(String firstName) {
        createCirclePage.enterFirstNameOnCreateCirclePage(firstName);
    }

    @And("they enter {string} in the Last Name field on the Create Circle page")
    public void theyEnterInTheLastNameFieldOnTheCreateCirclePage(String lastName) {
        createCirclePage.enterLastNameOnCreateCirclePage(lastName);
    }

    @And("they enter {string} in the email field on the Create Circle page")
    public void theyEnterInTheEmailFieldOnTheCreateCirclePage(String email) {
        createCirclePage.enterEmailOnCreateCirclePage(email);
    }

    @And("they enter {string} in the password field on the Create Circle page")
    public void theyEnterInThePasswordFieldOnTheCreateCirclePage(String password) {
        createCirclePage.enterPasswordOnCreateCirclePage(password);
    }

    @And("they click the Create button on the Create Circle page")
    public void theyClickTheCreateButtonOnTheCreateCirclePage() {
        createCirclePage.clickCreateButtonOnCreateCirclePage();
    }

    @And("they click copy button on Create Circle page")
    public void theyClickCopyButton() {
        createCirclePage.clickCopyPasscodeButtonOnCreateCirclePage();
    }

    @And("they enter {string} in Passcode field on Create Circle page")
    public void theyEnterInPasscodeFieldOnCreateCirclePage(String passcodeInput) {
        createCirclePage.enterPasscodeOnCreateCirclePage(passcodeInput);
    }

    @Then("error message pops-up {string} below First Name field on Create Circle page")
    public void errorMessagePopsUp(String error) {
        createCirclePage.assertFirstNameValidationMessageOnCreateCirclePage(error);
    }

    @Then("Passcode field contains {string}")
    public void passcodeFieldContains(String passcode) {
        createCirclePage.assertCreateCirclePasscodeFieldInput(passcode);
    }

    @And("they enter a new email in the email field on the Create Circle page")
    public void theyEnterANewUserEmailInTheEmailFieldOnTheCreateCirclePage() {
        createCirclePage.enterEmailOnCreateCirclePage(PropertiesLoader.getProperties("newCircleEmail"));
    }

    @And("they enter new password in the password field on the Create Circle page")
    public void theyEnterNewPasswordInThePasswordFieldOnTheCreateCirclePage() {
        createCirclePage.enterPasswordOnCreateCirclePage(PropertiesLoader.getProperties("newCirclePassword"));
    }

    @And("they paste input into first name field on Create Circle form")
    public void theyPasteInputIntoFirstNameFieldOnCreateCircleForm() {
        createCirclePage.pasteValueIntoFirstNameField();
    }

    @Then("Input in first name field is the same as input in passcode field")
    public void inputInFirstNameFieldIsTheSameAsInputInPasscodeField() {
        createCirclePage.assertCopiedPasscodeMatchesDisplayedValue();
    }

    @Then("error message pops-up {string} below Last Name field on Create Circle page")
    public void errorMessagePopsUpBelowLastNameFieldOnCreateCirclePage(String error) {
        createCirclePage.assertLastNameValidationMessageOnCreateCirclePage(error);
    }

    @Then("error message pops-up {string} for Email field on Create Circle page")
    public void errorMessagePopsUpForEmailFieldOnCreateCirclePage(String error) {
        createCirclePage.assertEmailValidationMessageOnCreateCirclePage(error);
    }

    @Then("error message pops-up {string} for Password field on Create Circle page")
    public void errorMessagePopsUpForPasswordFieldOnCreateCirclePage(String error) {
        createCirclePage.assertPasswordValidationMessageOnCreateCirclePage(error);
    }

    @Then("error message pops-up {string} for Circle name field on Create Circle page")
    public void errorMessagePopsUpForCircleNameFieldOnCreateCirclePage(String error) {
        createCirclePage.assertCircleNameValidationMessageOnCreateCirclePage(error);
    }
}