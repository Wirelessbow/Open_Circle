package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ChangePasswordPage;
import pages.SignInPage;
import pages.ProfilePage;

import static tools.CommonTools.*;

public class ChangePasswordSteps {

    ChangePasswordPage changePasswordPage = new ChangePasswordPage();
    ProfilePage profilePage = new ProfilePage();

    @When("they click Change password section")
    public void theyClickChangePasswordSection() {
        changePasswordPage.clickChangePasswordSection();
    }

    @And("they enter {string} in Current password input field on Change password page")
    public void theyEnterPasswordInCurrentPasswordInputFieldOnChangePasswordPage(String Password) {
        changePasswordPage.enterPasswordInCurrentPasswordInputFieldOnChangePasswordPage(Password);
    }

    @And("they enter {string} in New password input field on Change password page")
    public void theyEnterPasswordInNewPasswordInputFieldOnChangePasswordPage(String Password) {
        changePasswordPage.enterPasswordInNewPasswordInputFieldOnChangePasswordPage(Password);
    }

    @And("they click Save button on Change password page")
    public void theyClickSaveButtonOnChangePasswordPage() {
        changePasswordPage.clickSaveButtonOnChangePasswordPage();
    }

    @Then("assert warning message pops-up {string}")
    public void assertWarningMessagePopsUp(String message) {
        changePasswordPage.assertPopUpMessageDescriptionIsDisplayed(message);
    }

    @Then("success message Password Has Been Changed displayed")
    public void verifySuccessMessage() {
        changePasswordPage.assertWarningMessagePopsUp("Password has been changed");
        putInContext("passwordWasChanged", true);
    }

    @And("they enter current valid password in Current password input field on Change password page")
    public void theyEnterCurrentValidPasswordInCurrentPasswordInputFieldOnChangePasswordPage() {
        changePasswordPage.enterPasswordInCurrentPasswordInputFieldOnChangePasswordPage(SignInPage.getValidPassword());
    }

    @Then("they see an {string} under the New password input field on Change password page")
    public void theySeeAnUnderTheNewPasswordInputFieldOnChangePasswordPage(String invalidNewPassword) {
        changePasswordPage.assertErrorMessageUnderNewPasswordField (invalidNewPassword);
    }

    @And("they click Log out button")
    public void theyLoggedOutFromTheAccount() {
        profilePage.clickLogOutButton();
    }

    @And("they enter existing password in New password input field on Change password page")
    public void theyEnterExistingPasswordInNewPasswordInputFieldOnChangePasswordPage() {
        changePasswordPage.enterExistingPasswordInNewPasswordInputFieldOnChangePasswordPage(SignInPage.getValidPassword());
    }


    @Then("they verify that current password visibility toggle enabled by default on Change password page")
    public void theyVerifyThatCurrentPasswordVisibilityToggleEnabledByDefaultOnChangePasswordPage() {
        changePasswordPage.verifyCurrentPasswordVisibilityToggleEnabledByDefaultOnChangePasswordPage();
    }

    @Then("they verify that new password visibility toggle enabled by default on Change password page")
    public void theyVerifyThatNewPasswordVisibilityToggleEnabledByDefaultOnChangePasswordPage() {
        changePasswordPage.verifyNewPasswordVisibilityToggleEnabledByDefaultOnChangePasswordPage();
    }
}