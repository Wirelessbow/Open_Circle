package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import tools.PropertiesLoader;

import java.io.File;
import java.util.NoSuchElementException;

import static org.junit.Assert.assertTrue;
import static tools.CommonTools.getByObject;

public class ProfilePage extends BasePage {
    private static final String PROFILE_AVATAR_ICON = "xpath=//div[contains(@class, 'profile_container')]";
    private static final String PROFILE_PAGE_TITLE = "xpath=//*[text()='Profile']";
    private static final String PROFILE_FIRST_NAME_INPUT_FIELD = "id=firstName";
    private static final String PROFILE_LAST_NAME_INPUT_FIELD = "id=lastName";
    private static final String PROFILE_SAVE_BUTTON = "xpath=//button[contains(@class, 'profile_saveNames__LN7Zn')]";
    private static final String PROFILE_AVATAR_DELETE_BUTTON = "xpath=//*[@type='button'][contains(@class, 'profile_deleteImage')]";
    private static final String PROFILE_UPLOAD_BUTTON = "xpath=//input[@type='file']";
    private static final String PROFILE_VISIBLE_UPLOAD_BUTTON = "xpath=//div[text()='Upload']/ancestor::span[@role='button']";
    private static final String PROFILE_CLOSE_BUTTON = "xpath=//button[@class='ant-drawer-close']";
    private static final String PROFILE_RESET_BUTTON = "xpath=//button[contains(@class, 'profile_reset__m5oZY')]";
    private static final String ERROR_MESSAGE_PROFILE_PAGE = "xpath=//div[@class='ant-form-item-explain-error']";
    private static final String OK_BUTTON = "xpath=//*[@type='button']/span[contains(text(), 'OK')]";
    private static final String LOG_OUT_BUTTON = "xpath=//div[contains(@class,'profile_logout')]";
    private static final String PROFILE_PICTURE = "xpath=//span[@class='ant-upload']";

    public static String getProfileAvatarIcon() {
        return PROFILE_AVATAR_ICON;
    }

    public static String getProfileAvatarDeleteButton() {
        return PROFILE_AVATAR_DELETE_BUTTON;
    }

    public static String getProfileUploadButton() {
        return PROFILE_UPLOAD_BUTTON;
    }

    public static String getProfileLastNameInputField() {
        return PROFILE_LAST_NAME_INPUT_FIELD;
    }

    public static String getProfileSaveButton() {
        return PROFILE_SAVE_BUTTON;
    }

    public static String getProfilePageTitle() {
        return PROFILE_PAGE_TITLE;
    }

    public static String getProfileFirstNameInputField() {
        return PROFILE_FIRST_NAME_INPUT_FIELD;
    }

    public static String getProfileCloseButton() {
        return PROFILE_CLOSE_BUTTON;
    }

    public static String getProfileResetButton() {
        return PROFILE_RESET_BUTTON;
    }

    public static String getErrorMessageProfilePage() {
        return ERROR_MESSAGE_PROFILE_PAGE;
    }

    public static String getOkButton() {
        return OK_BUTTON;
    }

    public static String getProfileVisibleUploadButton() {
        return PROFILE_VISIBLE_UPLOAD_BUTTON;
    }

    public static String getProfilePicture() { return PROFILE_PICTURE; }

    public static String getLogOutButton() {
        return LOG_OUT_BUTTON;
    }

    public void clickOnTheAvatarIconOnTheProfilePage() {
        wait.forElementToBeDisplayed(20, getByObject(getProfileAvatarIcon()), "Avatar Icon");
        WebElement foundElement = driver.findElement(getByObject(getProfileAvatarIcon()));
        foundElement.click();
    }

    public void deleteProfilePictureIfExists() {
        try {
            wait.forElementToBeDisplayed(3, getByObject(getProfileAvatarDeleteButton()), "Delete Button");
            driver.findElement(getByObject(getProfileAvatarDeleteButton())).click();
        } catch (TimeoutException | NoSuchElementException e) {
            uploadAvatarPhoto();
            wait.forElementToBeDisplayed(10, getByObject(getProfileAvatarDeleteButton()), "Delete Button After Upload");
            driver.findElement(getByObject(getProfileAvatarDeleteButton())).click();
        }
    }

    private void uploadAvatarPhoto() {
        WebElement fileInput = driver.findElement(getByObject(getProfileUploadButton()));
        fileInput.sendKeys(new File(PropertiesLoader.getProperties("fileJpg")).getAbsolutePath());

        wait.forElementToBeDisplayed(10, getByObject(getOkButton()), "Ok Button");
        driver.findElement(getByObject(getOkButton())).click();

        wait.forElementToBeDisplayed(20, getByObject(getProfileAvatarDeleteButton()), "Avatar Delete Button");
    }

    public void assertTheUploadButtonOnTheProfilePageIsPresent() {
        wait.forPresenceOfElementLocated(10, getByObject(getProfileVisibleUploadButton()), "Visible Upload Button");
    }

    public void clearLastNameFieldOnTheProfilePage() {
        wait.forElementToBeInteractable(10, getByObject(getProfileLastNameInputField()), "Last Name Input Field");
        WebElement foundElement = driver.findElement(getByObject(getProfileLastNameInputField()));
        foundElement.click();
        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("mac")) {
            foundElement.sendKeys(Keys.chord(Keys.COMMAND, "a"), Keys.DELETE);
        } else {
            foundElement.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
        }
    }

    public void enterLastNameOnTheProfilePage(String lastName) {
        wait.forElementToBeDisplayed(10, getByObject(getProfileLastNameInputField()),
                "Last name input field");
        WebElement foundElement = driver.findElement(getByObject(getProfileLastNameInputField()));
        foundElement.sendKeys(lastName);
    }

    public void clickTheSaveButtonOnTheProfilePage() {
        wait.forElementToBeDisplayed(10, getByObject(getProfileSaveButton()),
                "Save button");
        WebElement foundElement = driver.findElement(getByObject(getProfileSaveButton()));
        foundElement.click();
    }

    public void assertLastNameInLastNameFieldOnProfilePageIsPresent(String lastName) {
        WebElement foundElement = driver.findElement(getByObject(getProfileLastNameInputField()));
        String elementText = foundElement.getAttribute("value");
        String message = "Text '" + lastName + "' 'in Last name input field is not presented. 'Actual text is '"
                + elementText + "'";
        assertTrue(message, elementText.contains(lastName));
    }

    public void clearFirstNameFieldOnTheProfilePage() {
        wait.forElementToBeInteractable(10, getByObject(getProfileFirstNameInputField()), "First Name Input Field");
        WebElement foundElement1 = driver.findElement(getByObject(getProfileFirstNameInputField()));
        foundElement1.click();
        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("mac")) {
            foundElement1.sendKeys(Keys.chord(Keys.COMMAND, "a"), Keys.DELETE);
        } else {
            foundElement1.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
        }
    }

    public void enterFirstNameOnProfilePage(String firstName) {
        wait.forElementToBeDisplayed(10, getByObject(getProfileFirstNameInputField()), "First Name Input Field");
        WebElement foundElement = driver.findElement(getByObject(getProfileFirstNameInputField()));
        foundElement.sendKeys(firstName);
    }

    public void assertFirstNameOnProfilePageIsDisplayed(String firstName) {
        WebElement foundElement = driver.findElement(getByObject(getProfileFirstNameInputField()));
        String elementText = foundElement.getAttribute("value");
        String message = "Text '" + firstName + "' 'in Last name input field is not presented. 'Actual text is '"
                + elementText + "'";
        assertTrue(message, elementText.contains(firstName));
    }

    public void clickLogOutButton() {
        wait.forElementToBeDisplayed(10,
                getByObject(getLogOutButton()),
                "Logout Button");
        driver.findElement(getByObject(getLogOutButton())).click();
        wait.forElementToBeNotDisplayed(10, getByObject(getLogOutButton()),"Logout Button");
    }

    public void assertErrorMessageOnProfilePageIsDisplayed(String errorMessage) {
        wait.forElementToBeDisplayed(10,getByObject(getErrorMessageProfilePage()),"Error message");
        WebElement foundElement = driver.findElement(getByObject(getErrorMessageProfilePage()));
        String elementText = foundElement.getText();
        String message = "Text '" + errorMessage + "' 'in "  + " is not presented. 'Actual text is '"
                + elementText + "'";
        assertTrue(message, elementText.contains(errorMessage));
    }

    public void replaceProfilePictureIfExists() {
        try {
            wait.forElementToBeDisplayed(3, getByObject(getProfilePicture()), "Profile Picture");
            driver.findElement(getByObject(getProfilePicture())).click();
            changeAvatarPhoto();
        } catch (TimeoutException | NoSuchElementException e) {
            uploadAvatarPhoto();
            wait.forElementToBeDisplayed(10, getByObject(getProfilePicture()), "Profile Picture");
            driver.findElement(getByObject(getProfilePicture())).click();
            uploadAvatarPhoto();
        }
    }

    private void changeAvatarPhoto() {
        WebElement fileInput = driver.findElement(getByObject(getProfilePicture()));
        fileInput.sendKeys(new File(PropertiesLoader.getProperties("fileJpg")).getAbsolutePath());

        wait.forElementToBeDisplayed(10, getByObject(getOkButton()), "Ok Button");
        driver.findElement(getByObject(getOkButton())).click();

        wait.forElementToBeDisplayed(10, getByObject(getProfileAvatarDeleteButton()), "Avatar Delete Button");
    }

    public void assertTheDeleteButtonOnTheProfilePageIsPresent() {
        wait.forPresenceOfElementLocated(10, getByObject(getProfileAvatarDeleteButton()), "Visible Delete Button");
    }
}