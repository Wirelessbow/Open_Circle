package pages;

import hooks.Setup;
import hooks.Wait;
import org.openqa.selenium.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;
import static tools.CommonTools.getByObject;

public class BasePage {

    protected WebDriver driver;
    protected Wait wait;
    HashMap<String, Object> context;

    public static final String POPUP_MESSAGE_LOCATOR = "xpath=//div[@class='ant-notification-notice-message']";
    public static final String POPUP_MESSAGE_DESCRIPTION_LOCATOR = "xpath=//div[@class='ant-notification-notice-description']/span";
    public static final String CLOSE_POPUP_MESSAGE_LOCATOR = "xpath=//a[@class='ant-notification-notice-close']";

    public static String getPopUpMessageLocator(){
        return POPUP_MESSAGE_LOCATOR;
    }

    public static String getPopUpMessageDescriptionLocator(){
        return POPUP_MESSAGE_DESCRIPTION_LOCATOR;
    }

    public static String getClosePopupMessageLocator(){
        return CLOSE_POPUP_MESSAGE_LOCATOR;
    }

    public BasePage() {
        this.driver = Setup.driver;
        this.wait = new Wait(this.driver);
        context = new HashMap<>();
    }

    public void clickElement(String targetElement) {
        wait.forElementToBeDisplayed(10, getByObject(targetElement), "Element");
        WebElement foundElement = driver.findElement(getByObject(targetElement));
        foundElement.click();
    }

    public void openWebPage(String address) {
        driver.get(address);
    }

    public void sendKeyToElement(String keyParam, String targetElement) {
        wait.forElementToBeDisplayed(10, getByObject(targetElement), "Element");
        WebElement foundElement = driver.findElement(getByObject(targetElement));
        foundElement.sendKeys(keyParam);
    }

    public void assertElementIsDisplayed(String targetElement) {
        wait.forElementToBeDisplayed(10, getByObject(targetElement), "Element");
        WebElement foundElement = driver.findElement(getByObject(targetElement));
        assertTrue(foundElement.isDisplayed());
    }

    public void assertElementIsNotDisplayed(String targetElement) {
        wait.forElementToBeDisplayed(10, getByObject(targetElement), "Element");
        WebElement foundElement = driver.findElement(getByObject(targetElement));
        assertFalse(foundElement.isDisplayed());
    }

    protected String extractMultiLineText(WebElement webElement) {
        String originalText = webElement.getText();
        return originalText.replaceAll("\\s+", " ").trim();
    }

    public void clearField(String element) {
        WebElement foundElement = driver.findElement(getByObject(element));
        foundElement.clear();
    }

    protected void clearFieldAndType(String element, String text, boolean hitEnter) {
        WebElement foundElement = driver.findElement(getByObject(element));
        foundElement.clear();
        foundElement.sendKeys(text);

        if (hitEnter) {
            foundElement.sendKeys(Keys.RETURN);
        }
    }

    protected void selectAndHitEnter(String element) {
        wait.forElementToBeDisplayed(20, getByObject(element), "Item Quantity field");
        WebElement foundElement = driver.findElement(getByObject(element));

        String value = foundElement.getAttribute("value");
        if (value != null) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].select();", foundElement);

            foundElement.sendKeys(Keys.RETURN);
        }
    }

    public void reloadPage() {
        driver.navigate().refresh();
    }

    public void openNewTab() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open();");
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
    }

    public void switchToTheFirstBrowserTab() {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));
    }

    public void closeTabAndOpenNewTab() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open();");
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.switchTo().window(tabs.get(0));
        driver.close();
        driver.switchTo().window(tabs.get(1));
    }

    public void closeWindowAndOpenNewWindow() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open('about:blank', '_blank');");
        ArrayList<String> windows = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windows.get(1));
        driver.switchTo().window(windows.get(0));
        driver.close();
        driver.switchTo().window(windows.get(1));
    }

    public void assertTextPresentedIn(String text, String target) {
        WebElement foundElement = driver.findElement(getByObject(target));
        String elementText = foundElement.getText();

        String message = "Text '" + text + "' 'in " + target + " is not presented. 'Actual text is '" + elementText + "'";
        assertTrue(message, elementText.contains(text));
    }

    public void waitForElementIsVisible(String target) {
        wait.forElementToBeDisplayed(10, getByObject(target), "Element");
        wait.forElementToBeInteractable(10, getByObject(target), "Element");
    }

    public void assertPopUpMessageIsDisplayed(String messageType) {
        wait.forElementToBeDisplayed(10,
                getByObject(getPopUpMessageLocator()), "PopUp Message");
        WebElement firstElement = driver.findElement(getByObject(getPopUpMessageLocator()));
        String element1Text = firstElement.getText();
        assertTrue(element1Text.contains(messageType));
    }

    public void assertPopUpMessageDescriptionIsDisplayed(String messageDescription) {
        wait.forElementToBeDisplayed(10,
                getByObject(getPopUpMessageDescriptionLocator()), "PopUp Message Description");
        WebElement secondElement = driver.findElement(getByObject(getPopUpMessageDescriptionLocator()));
        String element2Text = secondElement.getText();
        assertTrue(element2Text.contains(messageDescription));
    }

    public void closePopUpWindow(){
        WebElement foundElement = driver.findElement(getByObject(getClosePopupMessageLocator()));
        foundElement.click();
        wait.forElementToBeNotDisplayed(10,
                getByObject(getClosePopupMessageLocator()), "PopUp Message Close Button");
    }

    public static String generateUniqueName(String name) {
        String timestamp = String.valueOf(System.currentTimeMillis());
        return name + timestamp;
    }

    public void assertPasswordIsMasked(String element) {
        wait.forElementToBeDisplayed(10, getByObject(element),
                "Password is masked");
        WebElement passwordField = driver.findElement(getByObject(element));
        String typeAttribute = passwordField.getAttribute("type");
        assertEquals("The password field is not masked. Can't find attribute in tag 'type=password' ",
                "password", typeAttribute);
    }

    private WebElement findStripeFrame() {
        List<WebElement> iframes = driver.findElements(getByObject("xpath=//iframe[starts-with(@name, '__privateStripeFrame')]"));
        if (!iframes.isEmpty()) {
            return iframes.get(0);
        }
        throw new NoSuchElementException("No Stripe iframe found");
    }

    public void switchToStripeFrame() {
        driver.switchTo().frame(findStripeFrame());
    }

    public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }

//    Example of iframe automation
//    @When("the user enters credit card info")
//    public void enterCreditCardInfo() {
//        paymentPage.switchToStripeFrame();
//        driver.findElement(By.name("cardnumber")).sendKeys("4242 4242 4242 4242");
//        driver.findElement(By.name("exp-date")).sendKeys("12/34");
//        driver.findElement(By.name("cvc")).sendKeys("123");
//        paymentPage.switchToDefaultContent();
//    }
}