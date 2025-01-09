package pages;

import elements.MainPageElements;
import io.qameta.allure.Step;

public class MainPage extends MainPageElements {
    @Step("Get page title")
    public String getPageTitle() {
        return getMainPageTitle().getText();
    }
}
