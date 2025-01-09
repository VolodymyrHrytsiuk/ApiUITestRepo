package secondTaskUI.tests;

import jdk.jfr.Description;
import org.testng.annotations.Test;
import pages.MainPage;

import static com.codeborne.selenide.Selenide.title;
import static org.testng.Assert.assertEquals;

public class UITest extends TestInit {
    String expectedTitle = "Example Domain";

    @Test
    @Description("Verify page title")
    public void testPageTitle() {
        MainPage mainPage = new MainPage();

        assertEquals(mainPage.getPageTitle(), expectedTitle, String.format("Title should be '%s'", expectedTitle));
        assertEquals(title(), expectedTitle, String.format("Title should be '%s'", expectedTitle));
    }
}
