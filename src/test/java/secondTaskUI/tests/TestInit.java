package secondTaskUI.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Screenshots;
import com.codeborne.selenide.WebDriverRunner;
import listeners.Listener;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import utils.SuiteConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

import static com.codeborne.selenide.Selenide.open;

@Listeners(Listener.class)
public class TestInit {

    private String browser;
    private String headless;

    @BeforeSuite
    public void setParam() throws IOException {
        SuiteConfiguration conf = new SuiteConfiguration();
        browser = conf.getProperty("browser");
        headless = conf.getProperty("headless");
    }

    @BeforeMethod
    public void setup() {
        Configuration.headless = Boolean.parseBoolean(headless);
        Configuration.browser = "chrome";
        if (Boolean.parseBoolean(headless)) {
            Configuration.browserCapabilities.setCapability("chromeOptions", new ChromeOptions().addArguments("--user-agent=Mozilla/5.0 ..."));
        }
        open("http://example.com");
    }

    @AfterMethod
    public void closeBrowser(ITestResult result) {
        if (result.getStatus() == ITestResult.SKIP || result.getStatus() == ITestResult.FAILURE) {
            addScreenshotAttachment(result.getMethod().getMethodName());
        }
        WebDriverRunner.getWebDriver().quit();
    }

    public byte[] addScreenshotAttachment(String methodName) {
        try {
            File screenshot = Screenshots.takeScreenShotAsFile();

            System.out.println("Taking screenshot for method: " + methodName);

            return FileUtils.readFileToByteArray(Objects.requireNonNull(screenshot));
        } catch (IOException e) {
            e.printStackTrace();
            return new byte[0];
        }
    }
}
