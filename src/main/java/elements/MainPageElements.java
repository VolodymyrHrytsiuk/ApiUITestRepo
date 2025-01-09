package elements;
import com.codeborne.selenide.SelenideElement;
import base.BasePage;

public class MainPageElements extends BasePage {
    public static final String MAIN_PAGE_TITLE = "//h1";

    protected SelenideElement getMainPageTitle() {
        return getVisibilityOfElement(MAIN_PAGE_TITLE);
    }

}
