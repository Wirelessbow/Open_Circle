package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import tools.ApiHelper;
import tools.PropertiesLoader;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

import static tools.CommonTools.getFromContext;
import static tools.CommonTools.sleep;

public class TearDown {
    private final WebDriver driver;

    public TearDown() {
        this.driver = Setup.driver;
    }

    @After(order = 1)
    public void afterScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            sleep(2000);
            saveScreenshotsForScenario(scenario);
        }
        this.driver.quit();
    }

    @After(value = "@DeleteCircleAndUser", order = 2)
    public void deleteCircleAfterScenario(Scenario scenario) {
        ApiHelper api = new ApiHelper();

        try {
            api.deleteCircle();

            String userId = api.getUserIdByEmail(PropertiesLoader.getProperties("newCircleEmail"));
            if (userId != null) {
                api.deleteUserById(userId);
                System.out.println("User deleted.");
            } else {
                System.err.println("User not found.");
            }
        } catch (Exception e) {
            System.err.println("Cleanup failed: " + e.getMessage());
        }
    }

    @After(value = "@DeleteUser", order = 2)
    public void deleteUserAfterScenario(Scenario scenario) {
        ApiHelper api = new ApiHelper();

        try {
            String userId = api.getUserIdByEmail(PropertiesLoader.getProperties("newCircleEmail"));
            if (userId != null) {
                api.deleteUserById(userId);
                System.out.println("User deleted.");
            } else {
                System.err.println("User not found.");
            }
        } catch (Exception e) {
            System.err.println("Cleanup failed: " + e.getMessage());
        }
    }

    @After(value = "@changePassword", order = 3)
    public void changeUserPassword() {
        Boolean passwordWasChanged = (Boolean) getFromContext("passwordWasChanged");
        if (passwordWasChanged != null && passwordWasChanged) {
            try {
                ApiHelper api = new ApiHelper();
                api.changeUserPassword();
            } catch (Exception e) {
                System.err.println("Failed to revert password: " + e.getMessage());
            }
        }
    }

    private void saveScreenshotsForScenario(final Scenario scenario) {
        try {
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "screenShot");

            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            String timestamp = new SimpleDateFormat("yyyyMMdd-HHmmss").format(new Date());
            String filePath = "./screenshots/" + scenario.getName().replaceAll("[^a-zA-Z0-9]", "_") + "_" + timestamp + ".png";

            File directory = new File("./screenshots");
            if (!directory.exists()) {
                directory.mkdirs();
            }

            FileUtils.copyFile(screenshotFile, new File(filePath));
            System.out.println("Screenshot saved at: " + filePath);
        } catch (IOException e) {
            System.out.println("Failed to save screenshot: " + e.getMessage());
        }
    }
}