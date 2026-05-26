package pages;

import org.openqa.selenium.WebElement;
import tools.PropertiesLoader;

import static org.junit.Assert.assertTrue;
import static tools.CommonTools.getByObject;

public class SignInPage extends BasePage {

    private static final String SIGN_IN_BUTTON_ON_SIGN_IN_PAGE_LOCATOR = "xpath=//button/span[contains(text(), 'Sign in')]";
    private static final String EMAIL_INPUT_FIELD_LOCATOR = "id=email";
    private static final String PASSWORD_INPUT_FIELD_LOCATOR = "id=password";
    private static final String WARNING_MESSAGE_LOCATOR = "xpath=(.//*[normalize-space(text()) and normalize-space(.)='Warning'])[1]/following::span[1]";
    private static final String LOGIN_PAGE_EMAIL_FIELD_MESSAGE_INVALID_EMAIL = "xpath=//ul[contains(@class,'form_text_danger')]/li[contains(text(),'Invalid email address')]";
    private static final String LOGIN_PAGE_PASSWORD_FIELD_MESSAGE = "xpath=//input[@name='password']/following-sibling::ul/li";
    private static final String SIGN_IN_MESSAGE_POPUP_INVALID_EMAIL_PASSWORD = "xpath=//span[text()='Invalid email or password.']";
    private static final String LOGIN_PAGE_H1_HEADER = "xpath=//h1[text()='Sign in']";
    private static final String LOGIN_PAGE_LINK_TO_JOIN_CIRCLE = "xpath=//a[contains(@href,'join')]";
    private static final String LOGIN_PAGE_LINK_TO_CREATE_CIRCLE = "xpath=//a[contains(@href,'create')]";
    private static final String LOGIN_PAGE_EMAIL_FIELD_MESSAGE_THIS_INPUT_IS_REQUIRED = "xpath=//input[@name='email']/following-sibling::ul/li[contains(text(),'This input is required.')]";
    private static final String LOGIN_PAGE_MESSAGE_POP_UP_USER_NOT_FOUND = "xpath=//div[@class='ant-notification-notice-description']/span[text()='User not found.']";
    private static final String CHAT_PAGE_HEADER_LOCATOR = "xpath=//div[starts-with(@class,'header_organization')]";

    public static String getExistingEmail(){
        String email = System.getenv("EMAIL");
        if (email == null || email.isEmpty()) {
            email = PropertiesLoader.getProperties("email");
        }
        return email;
    }

    public static String getSecondUserEmail(){
        String email = System.getenv("EMAIL2");
        if (email == null || email.isEmpty()) {
            email = PropertiesLoader.getProperties("email2");
        }
        return email;
    }

    public static String getValidPassword() {
        String password = System.getenv("PASSWORD");
        if (password == null || password.isEmpty()) {
            password = PropertiesLoader.getProperties("password");
        }
        return password;
    }

    public static String getSecondUserPassword() {
        String password = System.getenv("PASSWORD2");
        if (password == null || password.isEmpty()) {
            password = PropertiesLoader.getProperties("password2");
        }
        return password;
    }

    public static String getEmailInputFieldLocator() {
        return EMAIL_INPUT_FIELD_LOCATOR;
    }

    public static String getSignInButtonOnSignInPageLocator() {
        return SIGN_IN_BUTTON_ON_SIGN_IN_PAGE_LOCATOR;
    }

    public static String getPasswordInputFieldLocator() {
        return PASSWORD_INPUT_FIELD_LOCATOR;
    }

    public static String getWarningMessageLocator() { return WARNING_MESSAGE_LOCATOR;    }

    public static String getLoginPageEmailFieldMessageInvalidEmail() {
        return LOGIN_PAGE_EMAIL_FIELD_MESSAGE_INVALID_EMAIL;
    }

    public static String getLoginPageEmailFieldMessageThisInputIsRequired(){
        return LOGIN_PAGE_EMAIL_FIELD_MESSAGE_THIS_INPUT_IS_REQUIRED;
    }

    public static String getLoginPageMessageInvalidPassword(){
        return LOGIN_PAGE_PASSWORD_FIELD_MESSAGE;
    }
    public void openSignInPage() {
        driver.get(PropertiesLoader.getProperties("signInUrl"));
    }

    public void clickSignInButton() {
        wait.forElementToBeDisplayed(10, getByObject(getSignInButtonOnSignInPageLocator()), "Sign In button");
        driver.findElement(getByObject(getSignInButtonOnSignInPageLocator())).click();
    }

    public void enterEmailOnSignInPage(String email) {
        wait.forElementToBeDisplayed(10, getByObject(getEmailInputFieldLocator()), "Email input field");
        driver.findElement(getByObject(getEmailInputFieldLocator())).sendKeys(email);
    }

    public void enterEmailOnSignInPage() {
        wait.forElementToBeDisplayed(10, getByObject(getEmailInputFieldLocator()), "Email input field");
        driver.findElement(getByObject(getEmailInputFieldLocator())).sendKeys(getExistingEmail());
    }

    public void enterPasswordOnSignInPage(String email) {
        wait.forElementToBeDisplayed(10, getByObject(getPasswordInputFieldLocator()), "Password input field");
        driver.findElement(getByObject(getPasswordInputFieldLocator())).sendKeys(email);
    }

    public void assertNoUserWarningMessage() {
        wait.forElementToBeDisplayed(10, getByObject(getWarningMessageLocator()),
                "Warning message");
        assert driver.findElement(getByObject(getWarningMessageLocator())).getText().contains("User not found.");
    }

    public void assertLoginPageEmailFieldMessageInvalidEmail(String InvalidEmailAddress) {
        wait.forElementToBeDisplayed(10, getByObject(getLoginPageEmailFieldMessageInvalidEmail()), "Element");
        WebElement foundElement = driver.findElement(getByObject(getLoginPageEmailFieldMessageInvalidEmail()));
        assertTrue(foundElement.isDisplayed());
    }

    public void clearEmailInputField() {
        wait.forElementToBeDisplayed(10, getByObject(getEmailInputFieldLocator()), "Element");
        WebElement foundElement = driver.findElement(getByObject(getEmailInputFieldLocator()));
        foundElement.clear();
    }

    public void assertLoginPageEmailFieldRequired(String ThisInputIsRequired) {
        wait.forElementToBeDisplayed(10, getByObject(getLoginPageEmailFieldMessageThisInputIsRequired()), "Element");
        WebElement foundElement = driver.findElement(getByObject(getLoginPageEmailFieldMessageThisInputIsRequired()));
        assertTrue(foundElement.isDisplayed());
    }

    public void assertLoginPagePasswordFieldMessageInvalidPassword(String InvalidPassword) {
        wait.forElementToBeDisplayed(10, getByObject(getLoginPageMessageInvalidPassword()), "Error message under password field");
        WebElement foundElement = driver.findElement(getByObject(getLoginPageMessageInvalidPassword()));
        assertTrue(foundElement.isDisplayed());
        String elementText = foundElement.getText();

        String message = "Text '" + InvalidPassword + "' in " + getLoginPageMessageInvalidPassword() + " is not presented. 'Actual text is '" + elementText + "'";
        assertTrue(message, elementText.contains(InvalidPassword));

    }
}