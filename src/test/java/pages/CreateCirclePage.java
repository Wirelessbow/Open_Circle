package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import tools.PropertiesLoader;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static tools.CommonTools.*;

public class CreateCirclePage extends BasePage {
    private static final String ADMIN_PASSWORD_INPUT_FIELD = "xpath=//input[contains(@class, 'form_form_control')]";
    private static final String ADMIN_PAGE_SUBMIT_BUTTON = "xpath=//button[@type='submit']";
    private static final String CIRCLE_NAME_FIELD_ON_CREATE_CIRCLE_PAGE = "id=circleId";
    private static final String CREATE_CIRCLE_PASSCODE_INPUT_FIELD = "id=passCode";
    private static final String GENERATE_PASSCODE_BUTTON_ON_CREATE_CIRCLE_PAGE = "xpath=//button[@class='ant-btn css-o2xhy3 ant-btn-primary'][1]";
    private static final String COPY_PASSCODE_BUTTON_ON_CREATE_CIRCLE_PAGE = "xpath=//button[@class='ant-btn css-o2xhy3 ant-btn-primary'][2]";
    private static final String FIRSTNAME_ON_CREATE_CIRCLE_PAGE = "id=firstName";
    private static final String LASTNAME_ON_CREATE_CIRCLE_PAGE = "id=lastName";
    private static final String EMAIL_ON_CREATE_CIRCLE_PAGE = "id=email";
    private static final String CREATE_CIRCLE_PASSWORD_INPUT_FIELD = "id=password";
    private static final String CREATE_CIRCLE_CREATE_BUTTON = "xpath=//button[contains(@class, 'login_submit')]";
    private static final String CREATE_CIRCLE_FIRST_NAME_VALIDATION_MESSAGE = "xpath=//div[label[@for='firstName']]//li";
    private static final String CREATE_CIRCLE_LAST_NAME_VALIDATION_MESSAGE = "xpath=//div[label[@for='lastName']]//li";
    private static final String CREATE_CIRCLE_EMAIL_VALIDATION_MESSAGE = "xpath=//div[label[@for='email']]//li";
    private static final String CREATE_CIRCLE_PASSWORD_VALIDATION_MESSAGE = "xpath=//div[label[@for='password']]//li";
    private static final String CREATE_CIRCLE_CIRCLE_NAME_VALIDATION_MESSAGE = "xpath=//div[label[@for='circleId']]//li";

    public static String getAdminPassword() {
        String adminPassword = System.getenv("ADMIN_PASSWORD");
        if (adminPassword == null || adminPassword.isEmpty()) {
            adminPassword = PropertiesLoader.getProperties("adminPassword");
        }
        return adminPassword;
    }

    public static String getNewCircleEmail() {
        String newCircleEmail = System.getenv("NEW_CIRCLE_EMAIL");
        if (newCircleEmail == null || newCircleEmail.isEmpty()) {
            newCircleEmail = PropertiesLoader.getProperties("newCircleEmail");
        }
        return newCircleEmail;
    }

    public static String getNewCirclePassword() {
        String adminPassword = System.getenv("NEW_CIRCLE_PASSWORD");
        if (adminPassword == null || adminPassword.isEmpty()) {
            adminPassword = PropertiesLoader.getProperties("adminPassword");
        }
        return adminPassword;
    }

    public static String getAdminPasswordInputField() {
        return ADMIN_PASSWORD_INPUT_FIELD;
    }

    public static String getAdminPageSubmitButton() {
        return ADMIN_PAGE_SUBMIT_BUTTON;
    }

    public static String getCircleNameFieldOnCreateCirclePage() {
        return CIRCLE_NAME_FIELD_ON_CREATE_CIRCLE_PAGE;
    }

    public static String getPasscodeOnCreateCirclePage(){
        return CREATE_CIRCLE_PASSCODE_INPUT_FIELD;
    }

    public static String getGeneratePasscodeButtonOnCreateCirclePage() {
        return GENERATE_PASSCODE_BUTTON_ON_CREATE_CIRCLE_PAGE;
    }

    public static String getCopyPasscodeButtonOnCreateCirclePage(){
        return COPY_PASSCODE_BUTTON_ON_CREATE_CIRCLE_PAGE;
    }

    public static String getFirstnameOnCreateCirclePage() {
        return FIRSTNAME_ON_CREATE_CIRCLE_PAGE;
    }

    public static String getLastnameOnCreateCirclePage() {
        return LASTNAME_ON_CREATE_CIRCLE_PAGE;
    }

    public static String getEmailOnCreateCirclePage() {
        return EMAIL_ON_CREATE_CIRCLE_PAGE;
    }

    public static String getCreateCirclePasswordInputField() {
        return CREATE_CIRCLE_PASSWORD_INPUT_FIELD;
    }

    public static String getCreateCircleCreateButton() {
        return CREATE_CIRCLE_CREATE_BUTTON;
    }

    public static String getCreateCircleFirstNameValidationMessage() {
        return CREATE_CIRCLE_FIRST_NAME_VALIDATION_MESSAGE;
    }

    public static String getCreateCircleLastNameValidationMessage() {
        return CREATE_CIRCLE_LAST_NAME_VALIDATION_MESSAGE;
    }

    public static String getCreateCircleEmailValidationMessage() {
        return CREATE_CIRCLE_EMAIL_VALIDATION_MESSAGE;
    }

    public static String getCreateCirclePasswordValidationMessage() {
        return CREATE_CIRCLE_PASSWORD_VALIDATION_MESSAGE;
    }

    public static String getCreateCircleCircleNameValidationMessage() {
        return CREATE_CIRCLE_CIRCLE_NAME_VALIDATION_MESSAGE;
    }

    public void openCreateCirclePage() {
        driver.get(PropertiesLoader.getProperties("createCircleUrl"));
    }

    public void enterAdminPasswordOnAdminPage(String adminPassword) {
        wait.forElementToBeDisplayed(
                10,
                getByObject(getAdminPasswordInputField()),
                "Admin password input field");
        WebElement foundElement = driver.findElement(getByObject(getAdminPasswordInputField()));
        foundElement.sendKeys(adminPassword);
    }

    public void clickSubmitButton() {
        wait.forElementToBeDisplayed(
                10,
                getByObject(getAdminPageSubmitButton()),
                "Admin page Submit button");
        WebElement foundElement = driver.findElement(getByObject(getAdminPageSubmitButton()));
        foundElement.click();
    }

    public void enterCircleNameOnCreateCirclePage(String circleName) {
        wait.forElementToBeDisplayed(
                10,
                getByObject(getCircleNameFieldOnCreateCirclePage()),
                "Circle name field");
        WebElement foundElement = driver.findElement(getByObject(getCircleNameFieldOnCreateCirclePage()));
        foundElement.sendKeys(circleName);
    }

    public void clickGenerateButtonOnCreateCirclePage() {
        wait.forElementToBeDisplayed(
                10,
                getByObject(getGeneratePasscodeButtonOnCreateCirclePage()),
                "Generate passcode button");
        WebElement foundElement = driver.findElement(getByObject(getGeneratePasscodeButtonOnCreateCirclePage()));
        foundElement.click();
    }

    public void clickCopyPasscodeButtonOnCreateCirclePage() {
        wait.forElementToBeDisplayed(10,
                getByObject(getCopyPasscodeButtonOnCreateCirclePage()),
                "Copy button in create circle");
        WebElement foundElement = driver.findElement(getByObject(getCopyPasscodeButtonOnCreateCirclePage()));
        foundElement.click();
    }

    public String getPasscodeValueOnCreateCirclePage(){
        wait.forElementToBeDisplayed(10,
                getByObject(getPasscodeOnCreateCirclePage()),
                "Passcode input field in create circle");
        WebElement foundElement = driver.findElement(getByObject(getPasscodeOnCreateCirclePage()));
        return foundElement.getAttribute("value");
    }

    public void enterFirstNameOnCreateCirclePage(String firstName) {
        wait.forElementToBeDisplayed(
                10,
                getByObject(getFirstnameOnCreateCirclePage()),
                "First name field");
        WebElement foundElement = driver.findElement(getByObject(getFirstnameOnCreateCirclePage()));
        foundElement.sendKeys(firstName);
    }

    public void enterLastNameOnCreateCirclePage(String lastName) {
        wait.forElementToBeDisplayed(
                10,
                getByObject(getLastnameOnCreateCirclePage()),
                "Last name field");
        WebElement foundElement = driver.findElement(getByObject(getLastnameOnCreateCirclePage()));
        foundElement.sendKeys(lastName);
    }

    public void enterEmailOnCreateCirclePage(String email) {
        wait.forElementToBeDisplayed(
                10,
                getByObject(getEmailOnCreateCirclePage()),
                "Email field");
        WebElement foundElement = driver.findElement(getByObject(getEmailOnCreateCirclePage()));
        foundElement.sendKeys(email);
    }

    public void enterPasswordOnCreateCirclePage(String password) {
        wait.forElementToBeDisplayed(
                10,
                getByObject(getCreateCirclePasswordInputField()),
                "Password field");
        WebElement foundElement = driver.findElement(getByObject(getCreateCirclePasswordInputField()));
        foundElement.sendKeys(password);
    }

    public void clickCreateButtonOnCreateCirclePage() {
        wait.forElementToBeDisplayed(
                10,
                getByObject(getCreateCircleCreateButton()),
                "Create button");
        WebElement foundElement = driver.findElement(getByObject(getCreateCircleCreateButton()));
        foundElement.click();
    }

    public void assertFirstNameValidationMessageOnCreateCirclePage(String error) {
        wait.forElementToBeDisplayed(
                10,
                getByObject(getCreateCircleFirstNameValidationMessage()),
                "Error message");
        WebElement foundElement = driver.findElement(getByObject(getCreateCircleFirstNameValidationMessage()));
        String elementText = foundElement.getText();

        String message = "Text '" + error + "' 'in " + getCreateCircleFirstNameValidationMessage() + " is presented.";
        assertTrue(message, elementText.contains(error));
    }

    public void enterPasscodeOnCreateCirclePage(String passcode) {
        wait.forElementToBeDisplayed(10,
                getByObject(getPasscodeOnCreateCirclePage()),
                "Passcode input field in create circle");
        WebElement foundElement = driver.findElement(getByObject(getPasscodeOnCreateCirclePage()));
        foundElement.sendKeys(passcode);
    }

    public void assertCreateCirclePasscodeFieldInput(String passcodeInput) {
        WebElement foundElement = driver.findElement(getByObject(getPasscodeOnCreateCirclePage()));
        String elementText = foundElement.getText();

        String message = "Text '" + passcodeInput + "' 'in " + getPasscodeOnCreateCirclePage() + " is not presented. 'Actual text is '" + "" + "'";
        assertTrue(message, elementText.contains(passcodeInput));
    }

    public void pasteValueIntoFirstNameField() {
        wait.forElementToBeDisplayed(10,
                getByObject(getFirstnameOnCreateCirclePage()),
                "First name input field in create circle");
        WebElement foundElement = driver.findElement(getByObject(getFirstnameOnCreateCirclePage()));
        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("mac")) {
            foundElement.sendKeys(Keys.chord(Keys.COMMAND, "v", Keys.NULL));
        } else {
            foundElement.sendKeys(Keys.LEFT_CONTROL, "v", Keys.NULL);
        }
        putInContext("firstNameValue", foundElement.getAttribute("value"));
    }

    public void assertCopiedPasscodeMatchesDisplayedValue() {
        assertEquals("Assertion failed, passcode field value and first name field value are different",
                getFromContext("firstNameValue"),
                getPasscodeValueOnCreateCirclePage());
    }

    public void assertLastNameValidationMessageOnCreateCirclePage(String error) {
        wait.forElementToBeDisplayed(
                10,
                getByObject(getCreateCircleLastNameValidationMessage()),
                "Error message");
        WebElement foundElement = driver.findElement(getByObject(getCreateCircleLastNameValidationMessage()));
        String elementText = foundElement.getText();

        String message = "Text '" + error + "' 'in " + getCreateCircleLastNameValidationMessage() + " is presented.";
        assertTrue(message, elementText.contains(error));
    }

    public void assertEmailValidationMessageOnCreateCirclePage(String error) {
        wait.forElementToBeDisplayed(
                10,
                getByObject(getCreateCircleEmailValidationMessage()),
                "Error message");
        WebElement foundElement = driver.findElement(getByObject(getCreateCircleEmailValidationMessage()));
        String elementText = foundElement.getText();

        String message = "Text '" + error + "' 'in " + getCreateCircleEmailValidationMessage() + " is presented.";
        assertTrue(message, elementText.contains(error));
    }

    public void assertPasswordValidationMessageOnCreateCirclePage(String error) {
        wait.forElementToBeDisplayed(
                10,
                getByObject(getCreateCirclePasswordValidationMessage()),
                "Error message");
        WebElement foundElement = driver.findElement(getByObject(getCreateCirclePasswordValidationMessage()));
        String elementText = foundElement.getText();

        String message = "Text '" + error + "' 'in " + getCreateCirclePasswordValidationMessage() + " is presented.";
        assertTrue(message, elementText.contains(error));
    }

    public void assertCircleNameValidationMessageOnCreateCirclePage(String error) {
        wait.forElementToBeDisplayed(
                10,
                getByObject(getCreateCircleCircleNameValidationMessage()),
                "Error message");
        WebElement foundElement = driver.findElement(getByObject(getCreateCircleCircleNameValidationMessage()));
        String elementText = foundElement.getText();

        String message = "Text '" + error + "' 'in " + getCreateCircleCircleNameValidationMessage() + " is presented.";
        assertTrue(message, elementText.contains(error));
    }
}