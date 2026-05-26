package pages;

import org.openqa.selenium.WebElement;
import tools.PropertiesLoader;

import static org.junit.Assert.*;
import static tools.CommonTools.getByObject;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.Keys;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;

public class JoinCirclePage extends BasePage {
    private static final String JOIN_CIRCLE_ENTIRE_PAGE_VERIFICATION = "xpath=//div[contains(@class,'login_auth_body')]//h1[text()='Join Circle']";
    private static final String JOIN_CIRCLE_CIRCLE_NAME_INPUT_FIELD = "name=circleId";
    private static final String JOIN_CIRCLE_PASSCODE_INPUT_FIELD = "name=passCode";
    private static final String JOIN_CIRCLE_FIRST_NAME_INPUT_FIELD = "name=firstName";
    private static final String JOIN_CIRCLE_LAST_NAME_INPUT_FIELD = "name=lastName";
    private static final String JOIN_CIRCLE_EMAIL_INPUT_FIELD = "name=email";
    private static final String JOIN_CIRCLE_PASSWORD_INPUT_FIELD = "name=password";
    private static final String JOIN_CIRCLE_JOIN_SUBMIT_BUTTON = "xpath=//button[@type='submit']//span[text()='Join']";
    private static final String JOIN_CIRCLE_SIGN_IN_REDIRECT_BUTTON = "xpath=//button[@type='button']//span[text()='Sign in']";
    private static final String JOIN_CIRCLE_CREATE_CIRCLE_REDIRECT_BUTTON = "xpath=//button[@type='button']//span[text()='Create Circle']";
    private static final String JOIN_CIRCLE_POP_UP_MESSAGE_SUCCESS_REGISTRATION = "xpath=//div[@class='ant-notification-notice-description']//span[text()='You have successfully registered.']";
    private static final String JOIN_CIRCLE_POP_UP_MESSAGE_INCORRECT_PASSCODE = "xpath=//div[@class='ant-notification-notice-description']/span";
    private static final String JOIN_CIRCLE_FIRST_NAME_FIELD_MESSAGE_FIELD_ACCEPTS = "xpath=//ul[contains(@class, 'form_text_danger')]//li[contains(text(), 'Field accepts alphabetical')]";
    private static final String JOIN_CIRCLE_CIRCLE_FIELD_MESSAGE = "xpath=//label[@for='circleId']/following-sibling::ul[contains(@class,'form_text_danger')]/li";
    private static final String JOIN_CIRCLE_PASSCODE_FIELD_MESSAGE = "xpath=//label[@for='passCode']/following-sibling::ul[contains(@class,'form_text_danger')]/li";
    private static final String JOIN_CIRCLE_FIRST_NAME_FIELD_MESSAGE = "xpath=//label[@for='firstName']/following-sibling::ul[contains(@class,'form_text_danger')]/li";
    private static final String JOIN_CIRCLE_LAST_NAME_FIELD_MESSAGE = "xpath=//label[@for='lastName']/following-sibling::ul[contains(@class,'form_text_danger')]/li";
    private static final String JOIN_CIRCLE_PASSWORD_FIELD_MESSAGE = "xpath=//label[@for='password']/following-sibling::ul[contains(@class,'form_text_danger')]/li";
    private static final String JOIN_CIRCLE_EMAIL_FIELD_WARNING_MESSAGE = "xpath=//ul[contains(@class,'form_text_danger')]//li";
    private static final String JOIN_CIRCLE_POP_UP_MESSAGE_EMAIL_EXIST = "xpath=//span[text()='A user with such an email exists.']";
    private static final String JOIN_CIRCLE_POP_UP_MESSAGE_INCORRECT_CIRCLE_NAME = "xpath=//div[contains(@class,'ant-notification-notice-description')]//span[text()='Incorrect Circle Name. Please try again']";

    public static String getJoinCircleCircleNameInputField() {
        return JOIN_CIRCLE_CIRCLE_NAME_INPUT_FIELD;
    }

    public static String getJoinCirclePasscodeInputField() {
        return JOIN_CIRCLE_PASSCODE_INPUT_FIELD;
    }

    public static String getJoinCircleFirstNameInputField() {
        return JOIN_CIRCLE_FIRST_NAME_INPUT_FIELD;
    }

    public static String getJoinCircleLastNameInputField() {
        return JOIN_CIRCLE_LAST_NAME_INPUT_FIELD;
    }

    public static String getJoinCircleEmailInputField() {
        return JOIN_CIRCLE_EMAIL_INPUT_FIELD;
    }

    public static String getJoinCirclePasswordInputField() {
        return JOIN_CIRCLE_PASSWORD_INPUT_FIELD;
    }

    public static String getJoinCircleJoinSubmitButton() {
        return JOIN_CIRCLE_JOIN_SUBMIT_BUTTON;
    }

    public static String getJoinCircleEntirePageVerification() {
        return JOIN_CIRCLE_ENTIRE_PAGE_VERIFICATION;
    }

    public static String getJoinCirclePopUpMessageIncorrectPasscode() {
        return JOIN_CIRCLE_POP_UP_MESSAGE_INCORRECT_PASSCODE;
    }

    public static String getJoinCircleWarningMessageUnderEmailField() { return JOIN_CIRCLE_EMAIL_FIELD_WARNING_MESSAGE; }

    public static String getJoinCircleMessageIncorrectFirstName() {
        return JOIN_CIRCLE_FIRST_NAME_FIELD_MESSAGE;
    }

    public void openJoinCirclePage() {
        driver.get(PropertiesLoader.getProperties("joinCircleUrl"));
    }

    public static String getJoinCircleMessageIncorrectLastNameField() {
        return JOIN_CIRCLE_LAST_NAME_FIELD_MESSAGE;
    }

    public static String getJoinCircleMessageIncorrectPassword() {
        return JOIN_CIRCLE_PASSWORD_FIELD_MESSAGE;
    }

    public void enterCircleNameOnJoinCirclePage(String circleName) {
        wait.forElementToBeDisplayed(10, getByObject(getJoinCircleCircleNameInputField()),
                "Circle name input field");
        WebElement foundElement = driver.findElement(getByObject(getJoinCircleCircleNameInputField()));
        foundElement.sendKeys(circleName);
    }

    public void enterPasscodeOnJoinCirclePage(String Passcode) {
        wait.forElementToBeDisplayed(10, getByObject(getJoinCirclePasscodeInputField()),
                "Passcode input field");
        WebElement foundElement = driver.findElement(getByObject(getJoinCirclePasscodeInputField()));
        foundElement.sendKeys(Passcode);
    }

    public void enterFirstNameOnJoinCirclePage(String FirstName) {
        wait.forElementToBeDisplayed(10, getByObject(getJoinCircleFirstNameInputField()),
                "First name input field");
        WebElement foundElement = driver.findElement(getByObject(getJoinCircleFirstNameInputField()));
        foundElement.sendKeys(FirstName);
    }

    public void enterLastNameOnJoinCirclePage(String LastName) {
        wait.forElementToBeDisplayed(10, getByObject(getJoinCircleLastNameInputField()),
                "Last Name input field");
        WebElement foundElement = driver.findElement(getByObject(getJoinCircleLastNameInputField()));
        foundElement.sendKeys(LastName);
    }

    public void enterEmailOnJoinCirclePage(String Email) {
        wait.forElementToBeDisplayed(10, getByObject(getJoinCircleEmailInputField()),
                "Email input field");
        WebElement foundElement = driver.findElement(getByObject(getJoinCircleEmailInputField()));
        foundElement.sendKeys(Email);
    }

    public void enterPasswordOnJoinCirclePage(String password) {
        wait.forElementToBeDisplayed(10, getByObject(getJoinCirclePasswordInputField()),
                "Password input field");
        WebElement passwordField = driver.findElement(getByObject(getJoinCirclePasswordInputField()));
        passwordField.sendKeys(password);
    }

    public void clickJoinButtonOnJoinCirclePage() {
        wait.forElementToBeDisplayed(10, getByObject(getJoinCircleJoinSubmitButton()),
                "SIGN UP BUTTON");
        WebElement signUpButton = driver.findElement(getByObject(getJoinCircleJoinSubmitButton()));
        signUpButton.click();
    }

    public void assertTheyAreOnJoinCirclePage() {
        wait.forElementToBeDisplayed(10, getByObject(getJoinCircleEntirePageVerification()),
                "JOIN CIRCLE PAGE LOCATE/VERIFY");
        WebElement foundElement = driver.findElement(getByObject(getJoinCircleEntirePageVerification()));
        assertTrue(foundElement.isDisplayed());
    }

    public void assertWarningMessageIncorrectPasscodeOnJoinCirclePageIsDisplayed(String incorrectPasscode) {
        wait.forElementToBeDisplayed(10, getByObject(getJoinCirclePopUpMessageIncorrectPasscode()),
                "Incorrect Passcode. Please try again");
        WebElement foundElement = driver.findElement(getByObject(getJoinCirclePopUpMessageIncorrectPasscode()));
        String elementText = foundElement.getText();

        String message = "Text '" + incorrectPasscode + "' in " + getJoinCirclePopUpMessageIncorrectPasscode() + " is not presented. 'Actual text is '" + elementText + "'";
        assertTrue(message, elementText.contains(incorrectPasscode));
    }

    public void assertFirstNameFieldWarningMessageIsDisplayed(String incorrectFirstName) {
        wait.forElementToBeDisplayed(10, getByObject(getJoinCircleMessageIncorrectFirstName()),
                "Field accepts alphabetical char and digits, no special chars allowed, limited to 32 character or This input is required");
        WebElement foundElement = driver.findElement(getByObject(getJoinCircleMessageIncorrectFirstName()));
        String elementText = foundElement.getText();

        String message = "Text '" + incorrectFirstName + "' in " + getJoinCircleMessageIncorrectFirstName() + " is not presented. 'Actual text is '" + elementText + "'";
        assertTrue(message, elementText.contains(incorrectFirstName));
    }

    public void copyHiddenPasswordOnJoinCirclePage() {
        clearClipboard();
        wait.forElementToBeDisplayed(10, getByObject(getJoinCirclePasswordInputField()),
                "Password input field");
        WebElement passwordField = driver.findElement(getByObject(getJoinCirclePasswordInputField()));

        Actions actions = new Actions(driver);
        actions
                .moveToElement(passwordField)
                .click()
                .keyDown(Keys.CONTROL)
                .sendKeys("a", "c")
                .keyUp(Keys.CONTROL)
                .perform();
    }

    public void assertPasswordIsNotCopiedIntoClipboardFromPasswordField(String password) {
        String clipboardContent = getClipboardContents();
        String actualPassword = getPasswordInputValue();

        assertEquals("Password field does not contain the expected value", password, actualPassword);
        assertNotEquals("ERROR: password should not be copied into clipboard", actualPassword, clipboardContent);
    }

    private String getClipboardContents() { // Additional method to get clipboard data
        try {
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            return (String) clipboard.getData(DataFlavor.stringFlavor);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private void clearClipboard() {
        try {
            StringSelection stringSelection = new StringSelection("");
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(stringSelection, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String getPasswordInputValue() { // Additional method get text from the password input field
        WebElement passwordField = driver.findElement(getByObject(getJoinCirclePasswordInputField()));
        return passwordField.getAttribute("value");
    }

    public void enterValidPasswordInPasswordFieldOnJoinCirclePage(String password) {
        wait.forElementToBeDisplayed(10, getByObject(getJoinCirclePasswordInputField()),
                "Password input field");
        driver.findElement(getByObject(getJoinCirclePasswordInputField())).sendKeys(password);
    }

    public void assertWarningMessageForLastNameOnJoinCirclePageIsDisplayed(String expectedMessage) {
        wait.forElementToBeDisplayed(10, getByObject(getJoinCircleMessageIncorrectLastNameField()), "Last Name warning message should appear");


        WebElement foundElement = driver.findElement(getByObject(getJoinCircleMessageIncorrectLastNameField()));
        String actualMessage = foundElement.getText();

        String message = "Expected: '" + expectedMessage + "', but found: '" + actualMessage + "'";
        assertTrue(message, actualMessage.contains(expectedMessage));
    }

    public void assertWarningMessageUnderEmailFieldOnJoinCirclePageIsDisplayed(String incorrectEmail) {
        wait.forElementToBeDisplayed(10, getByObject(getJoinCircleWarningMessageUnderEmailField()),
                "Invalid email address, limited to 32 characters");
        WebElement foundElement = driver.findElement(getByObject(getJoinCircleWarningMessageUnderEmailField()));
        String elementText = foundElement.getText();

        String message = "Text '" + incorrectEmail + "' in " + getJoinCircleWarningMessageUnderEmailField() + " is not presented. 'Actual text is '" + elementText + "'";
        assertTrue(message, elementText.contains(incorrectEmail));
    }

    public void assertUnderPasswordFieldOnJoinCircleWarningMessageIsDisplayed(String incorrectPasswordWarning) {
        wait.forElementToBeDisplayed(10, getByObject(getJoinCircleMessageIncorrectPassword()),
                "Field should contain at least one upper-case, at least one lower-case and at least one digit and be between 8 and 20");
        WebElement foundElement = driver.findElement(getByObject(getJoinCircleMessageIncorrectPassword()));
        String elementText = foundElement.getText();

        String message = "Text '" + incorrectPasswordWarning + "' in " + getJoinCircleMessageIncorrectPassword() + " is not presented. 'Actual text is '" + elementText + "'";
        assertTrue(message, elementText.contains(incorrectPasswordWarning));
    }
}
