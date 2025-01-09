package base;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;

public class BasePage {
    protected SelenideElement getVisibilityOfElement(String locator) {
        return $x(locator).shouldBe(Condition.visible, Duration.ofSeconds(15));
    }

    protected SelenideElement getClickableElement(String locator) {
        return $x(locator).shouldBe(Condition.enabled, Duration.ofSeconds(15));
    }

    protected SelenideElement getPresentElement(String locator) {
        return $x(locator).shouldBe(Condition.exist, Duration.ofSeconds(15));
    }

    protected ElementsCollection getListPresentElements(String locator) {
        return $$x(locator).shouldBe(CollectionCondition.sizeGreaterThan(0), Duration.ofSeconds(15));
    }
}
