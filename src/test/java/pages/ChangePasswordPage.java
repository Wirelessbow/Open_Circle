package pages;

import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertTrue;
import static tools.CommonTools.*;

public class ChangePasswordPage extends BasePage {
    private static final String CHANGE_PASSWORD_SECTION = "xpath=//span[text()='Change password']";
    private static final String CURRENT_PASSWORD_INPUT_FIELD = "id=oldPassword";
    private static final String NEW_PASSWORD_INPUT_FIELD = "id=newPassword";
    private static final String SAVE_BUTTON = "xpath=//div[contains(@class,'profile_passwordSave')]//button";
    private static final String CURRENT_PASSWORD_VISIBILITY_TOGGLE = "xpath=//input[@id='oldPassword']/following-sibling::span/child::span";
    private static final String NEW_PASSWORD_VISIBILITY_TOGGLE = "xpath=//input[@id='newPassword']/following-sibling::span/child::span";
    private static final String CURRENT_PASSWORD_HIDDEN_BY_DOTS = "id=oldPassword";
    private static final String NEW_PASSWORD_HIDDEN_BY_DOTS = "id=newPassword";
    private static final String WARNING_MESSAGE_ON_CHANGE_PASSWORD_PAGE = "xpath=//div[@class='ant-notification-notice-content']";
    private static final String NEW_INVALID_PASSWORD_ERROR_MESSAGE = "xpath=//div[@id='newPassword_help']";

    public static String getNewInvalidPasswordErrorMessage() {
        return NEW_INVALID_PASSWORD_ERROR_MESSAGE;
    }

    public static String getChangePasswordSection() {
        return CHANGE_PASSWORD_SECTION;
    }

    public static String getCurrentPasswordInputFieldOnChangePasswordPage() {
        return CURRENT_PASSWORD_INPUT_FIELD;
    }

    public static String getNewPasswordInputFieldOnChangePasswordPage() {
        return NEW_PASSWORD_INPUT_FIELD;
    }

    public static String getSaveButtonOnChangePasswordPage() {
        return SAVE_BUTTON;
    }

    public static String getWarningMessageOnChangePasswordPage() {
        return WARNING_MESSAGE_ON_CHANGE_PASSWORD_PAGE;
    }

    public static String getCurrentPasswordHiddenByDots() {
        return CURRENT_PASSWORD_VISIBILITY_TOGGLE;
    }

    public static String getNewPasswordHiddenByDots() {
        return NEW_PASSWORD_VISIBILITY_TOGGLE;
    }

    public void clickChangePasswordSection() {
        wait.forElementToBeDisplayed(10,
                getByObject(getChangePasswordSection()),
                "Change password section");
        driver.findElement(getByObject(getChangePasswordSection())).click();
    }

    public void enterPasswordInCurrentPasswordInputFieldOnChangePasswordPage(String password) {
        wait.forElementToBeDisplayed(10,
                getByObject(getCurrentPasswordInputFieldOnChangePasswordPage()),
                "Current password input field");
        WebElement foundElement = driver.findElement(getByObject(getCurrentPasswordInputFieldOnChangePasswordPage()));
        foundElement.sendKeys(password);
    }

    public void enterPasswordInNewPasswordInputFieldOnChangePasswordPage(String password) {
        wait.forElementToBeDisplayed(10,
                getByObject(getNewPasswordInputFieldOnChangePasswordPage()),
                "New password input field");
        WebElement foundElement = driver.findElement(getByObject(getNewPasswordInputFieldOnChangePasswordPage()));
        foundElement.sendKeys(password);
        putInContext("newPassword", password);
    }

    public void clickSaveButtonOnChangePasswordPage() {
        wait.forElementToBeDisplayed(10,
                getByObject(getSaveButtonOnChangePasswordPage()),
                "Save button");
        driver.findElement(getByObject(getSaveButtonOnChangePasswordPage())).click();
        wait.forElementToBeDisplayed(10, getByObject(getPopUpMessageLocator()), "Pop-up message");
    }

    public void assertWarningMessagePopsUp(String warning) {
        wait.forElementToBeDisplayed(
                10,
                getByObject(getWarningMessageOnChangePasswordPage()),
                "Warning message");
        WebElement foundElement = driver.findElement(getByObject(getWarningMessageOnChangePasswordPage()));
        String elementText = foundElement.getText();

        assertTrue(warning, elementText.contains(warning));
        driver.findElement(getByObject(getClosePopupMessageLocator())).click();
    }

    public void assertErrorMessageUnderNewPasswordField(String InvalidPassword) {
        wait.forElementToBeDisplayed(10,
                getByObject(getNewInvalidPasswordErrorMessage()),
                "Error message");
        WebElement foundElement = driver.findElement(getByObject(getNewInvalidPasswordErrorMessage()));
        assertTrue(foundElement.isDisplayed());
    }

    public void enterExistingPasswordInNewPasswordInputFieldOnChangePasswordPage(String password) {
        wait.forElementToBeDisplayed(10,
                getByObject(getNewPasswordInputFieldOnChangePasswordPage()),
                "New password input field");
        WebElement foundElement = driver.findElement(getByObject(getNewPasswordInputFieldOnChangePasswordPage()));
        foundElement.sendKeys(password);
        putInContext("newPassword", password);
    }

    public void verifyCurrentPasswordVisibilityToggleEnabledByDefaultOnChangePasswordPage() {
        wait.forElementToBeDisplayed(10,
                getByObject(getCurrentPasswordHiddenByDots()),
                "Visibility toggle");
        WebElement toggleElement = driver.findElement(getByObject(getCurrentPasswordHiddenByDots()));
        assertTrue("Visibility toggle should be enabled by default", toggleElement.isDisplayed());
    }

    public void verifyNewPasswordVisibilityToggleEnabledByDefaultOnChangePasswordPage() {
        wait.forElementToBeDisplayed(10,
                getByObject(getNewPasswordHiddenByDots()),
                "Visibility toggle");
        WebElement toggleElement = driver.findElement(getByObject(getNewPasswordHiddenByDots()));
        assertTrue("Visibility toggle should be enabled by default", toggleElement.isDisplayed());
    }
}