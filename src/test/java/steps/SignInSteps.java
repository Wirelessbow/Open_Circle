package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.SignInPage;
import tools.PropertiesLoader;


public class SignInSteps {

    SignInPage signInPage = new SignInPage();
    HomePage homePage = new HomePage();

    @And("click Sign In button")
    public void clickSignInButton() {
        signInPage.clickSignInButton();
    }

    @Then("they see a warning message")
    public void theySeeWarningMessage() {
        signInPage.assertNoUserWarningMessage();
    }

    @Given("a user opens Login page")
    public void aUserOpensLoginPage() {
        signInPage.openSignInPage();
    }

    @When("they enter {string} in Email input field on Login page")
    public void enterValidEmail(String email) {
        email = email.replace("·", " ");
        signInPage.enterEmailOnSignInPage(email);
    }

    @When("they enter existing email in Email input field on Login page")
    public void theyEnterExistingEmailInEmailInputFieldOnLoginPage() {
        signInPage.enterEmailOnSignInPage();
    }

    @And("they enter new circle email in Email input field on Login page")
    public void theyEnterNewCircleEmailInEmailInputFieldOnLoginPage() {
        signInPage.enterEmailOnSignInPage(PropertiesLoader.getProperties("newCircleEmail"));
    }

    @And("they enter {string} in Password input field on Login page")
    public void theyEnterInPasswordInputFieldOnLoginPage(String password) {
        signInPage.enterPasswordOnSignInPage(password);
    }

    @And("they click Sign In button on Login page")
    public void theyClickSignInButton() {
        signInPage.clickSignInButton();
    }

    @Then("they verify that they are on Circle Home page")
    public void aUserVerifyThatTheyOnCircleHomePage() {
        homePage.assertCircleNameIsDisplayedOnHomePage();
    }

    @Given("a user is logged into the account")
    public void aUserIsLoggedIntoTheAccount() {
        signInPage.openSignInPage();
        signInPage.enterEmailOnSignInPage(SignInPage.getExistingEmail());
        signInPage.enterPasswordOnSignInPage(SignInPage.getValidPassword());
        signInPage.clickSignInButton();
        homePage.assertCircleNameIsDisplayedOnHomePage();
    }

    @Then("error message under the email field is displayed: {string}")
    public void errorMessageUnderTheEmailFieldIsDisplayed(String InvalidEmailAddress) {
        signInPage.assertLoginPageEmailFieldMessageInvalidEmail(InvalidEmailAddress);
    }

    @When("they clear email field")
    public void theyClearEmailField() {
        signInPage.clearEmailInputField();
    }

    @Then("error message under the required email field is displayed: {string}")
    public void errorMessageUnderTheRequiredEmailFieldIsDisplayed(String EmailRequired) {
        signInPage.assertLoginPageEmailFieldRequired(EmailRequired);
    }

    @Then("error message under the password field is displayed: {string}")
    public void errorMessageUnderThePasswordFieldIsDisplayed(String InvalidPassword) {
        signInPage.assertLoginPagePasswordFieldMessageInvalidPassword(InvalidPassword);
    }

    @And("they enter valid password in Password input field on Login page")
    public void theyEnterValidPasswordInPasswordInputFieldOnLoginPage() {
        signInPage.enterPasswordOnSignInPage(SignInPage.getValidPassword());
    }

    @And("they enter new circle password in Password input field on Login page")
    public void theyEnterNewCirclePasswordInPasswordInputFieldOnLoginPage() {
        signInPage.enterPasswordOnSignInPage(PropertiesLoader.getProperties("newCirclePassword"));
    }

    @And("another user is logged into the account")
    public void anotherUserIsLoggedIntoTheAccount() {
        signInPage.enterEmailOnSignInPage(SignInPage.getSecondUserEmail());
        signInPage.enterPasswordOnSignInPage(SignInPage.getSecondUserPassword());
        signInPage.clickSignInButton();
        homePage.assertCircleNameIsDisplayedOnHomePage();
    }
}