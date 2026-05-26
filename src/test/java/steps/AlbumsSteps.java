package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AlbumsPage;
import tools.PropertiesLoader;

public class AlbumsSteps {

    AlbumsPage albumsPage = new AlbumsPage();

    @And("they click the Albums button")
    public void clickAlbumsButtonOnHomePage() {
        albumsPage.clickAlbumsButtonOnHomePage();
    }

    @And("click Create new album button on Albums page")
    public void clickCreateNewAlbumButton() {
        albumsPage.clickCreateNewAlbumButton();
    }

    @And("they enter {string} unique Album name in the pop up field in create new album window")
    public void enterNewUniqueAlbumNameInPopUpWindow(String uniqueAlbumNameInPopUpWindow) {
        albumsPage.enterNewUniqueAlbumNameInPopUpWindow(uniqueAlbumNameInPopUpWindow);
    }

    @And("they click Create button in create new album window")
    public void clickCreateButtonNewAlbumWindow() {
        albumsPage.clickCreateButtonNewAlbumWindow();
    }

    @Then("they assert the album name {string} presented on Album Page")
    public void assertAlbumNamePresentedOnAlbumPage(String albumTitle) {
        albumsPage.assertAlbumIsDisplayed(albumTitle);
    }

    @Then("they assert the unique album name is present on Album Page")
    public void assertUniqueAlbumNamePresentedOnAlbumPage() {
        albumsPage.assertUniqueAlbumIsDisplayed();
    }

    @And("they delete album named {string} from Album Page")
    public void deleteAlbumNamed(String album) {
        albumsPage.clickDeleteAlbum(album);
    }

    @And("they delete unique album from Album Page")
    public void deleteUniqueAlbum() {
        albumsPage.clickDeleteUniqueAlbum();
    }

    @And("they click Cancel button on Create New Album Window")
    public void theyClickTheCancelButton() {
        albumsPage.clickCancelButtonNewAlbumWindow();
    }

    @And("they create new album with the name {string}")
    public void theyCreateNewAlbumWithTheName(String albumName) {
        albumsPage.createAlbum(albumName);
    }

    @And("they create new album with unique name")
    public void theyCreateNewAlbumWithUniqueName() {
        albumsPage.createAlbumWithUniqueName();
    }

    @Then("they verify no duplicate album with the name {string} was created")
    public void verifyNoDuplicateAlbumCreated(String albumName) {
        albumsPage.assertDuplicateAlbumNotCreated(albumName);
    }

    @And("they verify no album with the name {string} was created")
    public void theyVerifyNoAlbumWithTheNameWasCreated(String albumName) {
        albumsPage.assertAlbumIsNotDisplayed(albumName);
    }

    @And("they assert delete icon for the album {string} is not displayed")
    public void theyAssertDeleteIconForTheAlbumIsNotDisplayed(String albumName) {
        albumsPage.assertBucketIconIsDisplayed(albumName, false);
    }

    @And("they assert delete icon for unique album is not displayed")
    public void theyAssertDeleteIconForUniqueAlbumIsNotDisplayed() {
        albumsPage.assertBucketIconIsDisplayed(false);
    }

    @And("they assert delete icon for the album {string} is displayed")
    public void theyAssertDeleteIconForTheAlbumIsDisplayed(String albumName) {
        albumsPage.assertBucketIconIsDisplayed(albumName, true);
    }

    @And("they assert delete icon for unique album is displayed")
    public void theyAssertDeleteIconForUniqueAlbumIsDisplayed() {
        albumsPage.assertBucketIconIsDisplayed(true);
    }

    @Then("they do not see the album name {string} on Album Page")
    public void theyDoNotSeeTheAlbumNameOnAlbumPage(String albumName) {
        albumsPage.assertAlbumIsNotDisplayed(albumName);
    }

    @Then("they do not see the album with unique name on Album Page")
    public void theyDoNotSeeTheAlbumNameOnAlbumPage() {
        albumsPage.assertAlbumIsNotDisplayed();
    }

    @And("they see an error message under album name input {string}")
    public void theySeeErrorMessageUnderAlbumNameInput(String errorMessage) {
        albumsPage.assertErrorMessageUnderAlbumNameInputIsDisplayed(errorMessage);
    }

    @And("they open unique album from Album Page")
    public void theyOpenUniqueAlbumFromAlbumPage() {
        albumsPage.clickOpenUniqueAlbum();
    }

    @When("they upload a photo to the unique album")
    public void theyUploadAPhotoToTheUniqueAlbum() {
        albumsPage.uploadPhotoToTheUniqueAlbum();
    }

    @Then("they see the uploaded photo in the album")
    public void theySeeTheUploadedPhotoInTheAlbum() {
        albumsPage.assertPhotoIsDisplayed();
    }

    @And("they open page Albums")
    public void openPageAlbums() {
        albumsPage.openAlbumsPage();
    }
}