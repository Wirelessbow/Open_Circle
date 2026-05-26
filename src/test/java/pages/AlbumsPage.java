package pages;

import org.openqa.selenium.WebElement;
import tools.PropertiesLoader;

import java.io.File;
import java.util.List;

import static org.junit.Assert.*;
import static tools.CommonTools.*;

public class AlbumsPage extends BasePage {
    private static final String ALBUMS_BUTTON_ON_HOME_PAGE = "xpath=//div[text()='Albums']";
    private static final String CREATE_NEW_ALBUM_BUTTON = "xpath=//img[@alt='Avatar']";
    private static final String INPUT_FIELD_CREATE_NEW_ALBUM_WINDOW = "xpath=//input[@id='form_in_modal_title']";
    private static final String CLOSE_BUTTON_NEW_ALBUM_WINDOW = "xpath=//span[@role='img']";
    private static final String CANCEL_BUTTON_NEW_ALBUM_WINDOW = "xpath=//span[text()='Cancel']";
    private static final String CREATE_BUTTON_NEW_ALBUM_WINDOW = "xpath=//span[text()='Create']";
    private static final String ERROR_MESSAGE_UNDER_ALBUM_NAME_INPUT = "xpath=//*[@class='ant-form-item-explain-error']";
    private static final String UPLOAD_PHOTOS_BUTTON = "xpath=//span[@class='ant-upload']";
    private static final String UPLOAD_PHOTOS_INPUT = "xpath=//span[@class='ant-upload']/input";

    private static final String PHOTO_CARD_LIST = "xpath=//div[contains(@class,'album_card')]";

    public static String getErrorMessageUnderAlbumNameInput() { return ERROR_MESSAGE_UNDER_ALBUM_NAME_INPUT; }

    public static String getAlbumsButtonOnHomePage() {
        return ALBUMS_BUTTON_ON_HOME_PAGE;
    }

    public static String getCreateNewAlbumButton() {
        return CREATE_NEW_ALBUM_BUTTON;
    }

    public static String getInputFieldCreateNewAlbumWindow() {
        return INPUT_FIELD_CREATE_NEW_ALBUM_WINDOW;
    }

    public static String getCreateButtonNewAlbumWindow() {
        return CREATE_BUTTON_NEW_ALBUM_WINDOW;
    }

    public static String getCloseButtonNewAlbumWindow() {
        return CLOSE_BUTTON_NEW_ALBUM_WINDOW;
    }

    public static String getCancelButtonNewAlbumWindow() {
        return CANCEL_BUTTON_NEW_ALBUM_WINDOW;
    }

    public static String getUploadPhotosButton() {
        return UPLOAD_PHOTOS_BUTTON;
    }

    public static String getUploadPhotosInput() {
        return UPLOAD_PHOTOS_INPUT;
    }

    public static String getPhotoCardList() {
        return PHOTO_CARD_LIST;
    }

    public static String deleteAlbumLocator(String albumTitle) {
        return "xpath=//div[contains(@class,'albums_text')]/descendant::b[text()='" +
                albumTitle + "']/../../div/div[2]";
    }

    public static String selectAlbumLocator(String albumTitle) {
        return "xpath=//div[contains(@class,'albums_text')]/b[text()='" + albumTitle + "']";
    }

    public static String openAlbumLocator(String albumTitle) {
        return "xpath=//div[contains(@class,'albums_text')]/descendant::b[text()='" +
                albumTitle + "']/../../div/div[1]";
    }

    public static String albumIconsListLocator(String albumTitle) {
        return  "xpath=//div[contains(@class,'albums_text')]/descendant::b[text()='" +
                albumTitle + "']/../../div/div";
    }

    public static void saveUniqueAlbumName(String albumName){
        putInContext("uniqueAlbumName", generateUniqueName(albumName));
    }

    public static String getUniqueAlbumName(String albumName){
        return getFromContext(albumName).toString();
    }

    public void clickAlbumsButtonOnHomePage() {
        wait.forElementToBeDisplayed(10, getByObject(getAlbumsButtonOnHomePage()), "Element");
        WebElement foundElement = driver.findElement(getByObject(getAlbumsButtonOnHomePage()));
        foundElement.click();
    }

    public void clickCreateNewAlbumButton() {
        wait.forElementToBeDisplayed(10, getByObject(getCreateNewAlbumButton()), "Element");
        WebElement foundElement = driver.findElement(getByObject(getCreateNewAlbumButton()));
        foundElement.click();
    }

    public void enterNewUniqueAlbumNameInPopUpWindow(String albumName) {
        wait.forElementToBeDisplayed(10, getByObject(getInputFieldCreateNewAlbumWindow()),
                "Input field create new album");
        WebElement foundElement = driver.findElement(getByObject(getInputFieldCreateNewAlbumWindow()));
        foundElement.sendKeys(albumName);
    }

    public void generateNewUniqueAlbumNameInPopUpWindow() {
        if (!scenarioContext.containsKey("uniqueAlbumName")){
            saveUniqueAlbumName("album");
        }
        enterNewUniqueAlbumNameInPopUpWindow(getUniqueAlbumName("uniqueAlbumName"));
    }

    public void clickCreateButtonNewAlbumWindow() {
        wait.forElementToBeDisplayed(10, getByObject(getCreateButtonNewAlbumWindow()), "Element");
        WebElement foundElement = driver.findElement(getByObject(getCreateButtonNewAlbumWindow()));
        foundElement.click();
    }

    public void assertAlbumIsDisplayed(String albumName) {
        wait.forElementToBeDisplayed(10, getByObject(selectAlbumLocator(albumName)), "Album Name");
        WebElement foundElement = driver.findElement(getByObject(selectAlbumLocator(albumName)));
        assertTrue(foundElement.isDisplayed());
    }

    public void assertUniqueAlbumIsDisplayed() {
        assertAlbumIsDisplayed(getUniqueAlbumName("uniqueAlbumName"));
    }

    public void clickDeleteAlbum(String album) {
        wait.forElementToBeDisplayed(10, getByObject(selectAlbumLocator(album)), "Select Album");
        WebElement foundElement = driver.findElement(getByObject(deleteAlbumLocator((album))));
        foundElement.click();
        wait.forElementToBeNotDisplayed(10, getByObject(selectAlbumLocator((album))), "Select Album");
    }

    public void clickDeleteUniqueAlbum(){
        clickDeleteAlbum(getUniqueAlbumName("uniqueAlbumName"));
    }

    public void clickCancelButtonNewAlbumWindow() {
        wait.forElementToBeDisplayed(10, getByObject(getCancelButtonNewAlbumWindow()), "Cancel button");
        WebElement cancelButton = driver.findElement(getByObject(getCancelButtonNewAlbumWindow()));
        cancelButton.click();
    }

    public void createAlbum(String albumName) {
        clickAlbumsButtonOnHomePage();
        clickCreateNewAlbumButton();
        enterNewUniqueAlbumNameInPopUpWindow(albumName);
        clickCreateButtonNewAlbumWindow();
    }

    public void createAlbumWithUniqueName(){
        clickAlbumsButtonOnHomePage();
        clickCreateNewAlbumButton();
        generateNewUniqueAlbumNameInPopUpWindow();
        clickCreateButtonNewAlbumWindow();
    }

    public void assertDuplicateAlbumNotCreated(String albumName) {
        List<WebElement> albums = driver.findElements(getByObject(selectAlbumLocator(albumName)));
        int albumCount = albums.size();
        assertTrue("Found " + albumCount + " albums with name '" + albumName +
                "'. Expected only one (no duplicate).", albumCount <= 1);
    }

    public void assertAlbumIsNotDisplayed(String albumName) {
        List<WebElement> listOfAlbums = driver.findElements(getByObject(selectAlbumLocator(albumName)));
            assertTrue(listOfAlbums.isEmpty());
    }

    public void assertAlbumIsNotDisplayed() {
        assertAlbumIsNotDisplayed(getUniqueAlbumName("uniqueAlbumName"));
    }

    public void assertBucketIconIsDisplayed(String albumName, boolean canDelete) {
        wait.forElementToBeDisplayed(10, getByObject(selectAlbumLocator(albumName)), "Album");
        List<WebElement> albumIcons = driver.findElements(getByObject(albumIconsListLocator(albumName)));
        if (canDelete){
            assertEquals(2,albumIcons.size());
        }else {
            assertEquals(1,albumIcons.size());
        }
    }

    public void assertBucketIconIsDisplayed(boolean canDelete){
        assertBucketIconIsDisplayed(getUniqueAlbumName("uniqueAlbumName"), canDelete);
    }

    public void assertErrorMessageUnderAlbumNameInputIsDisplayed(String errorMessage) {
        wait.forElementToBeDisplayed(10,
                getByObject(getErrorMessageUnderAlbumNameInput()), "Error Message");
        String elementText = driver.findElement(getByObject(getErrorMessageUnderAlbumNameInput())).getText();
        assertTrue(elementText.contains(errorMessage));
    }

    public void clickOpenUniqueAlbum(){
        wait.forElementToBeDisplayed(10, getByObject(selectAlbumLocator(getUniqueAlbumName("uniqueAlbumName"))), "Select Album");
        WebElement foundElement = driver.findElement(getByObject(openAlbumLocator((getUniqueAlbumName("uniqueAlbumName")))));
        foundElement.click();
        wait.forElementToBeNotDisplayed(10, getByObject(selectAlbumLocator((getUniqueAlbumName("uniqueAlbumName")))), "Select Album");
    }

    public void uploadPhotoToTheUniqueAlbum() {
        wait.forElementToBeDisplayed(10, getByObject(getUploadPhotosButton()), "Upload Photo Button");
        WebElement fileUpload = driver.findElement(getByObject(getUploadPhotosInput()));
        fileUpload.sendKeys(new File(PropertiesLoader.getProperties("fileJpg")).getAbsolutePath());
        wait.forElementToBeDisplayed(10,getByObject(ProfilePage.getOkButton()), "OK button on Edit image window");
        driver.findElement(getByObject(ProfilePage.getOkButton())).click();
        wait.forElementToBeNotDisplayed(10, getByObject(ProfilePage.getOkButton()), "OK button on Edit image window");
        wait.forAnyElementToBeDisplayed(10, "photo list", getByObject(getPhotoCardList()));
    }

    public void assertPhotoIsDisplayed() {
        List<WebElement> photos = driver.findElements(getByObject(getPhotoCardList()));
        assertEquals(2, photos.size());
    }

    public void openAlbumsPage() {
        openWebPage(PropertiesLoader.getProperties("albumsUrl"));
        wait.forElementToBeDisplayed(10, getByObject(getAlbumsButtonOnHomePage()), "Albums Button");
    }
}