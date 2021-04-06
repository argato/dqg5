package selenide;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class SelenideTest {

  private final String BASE_URL = "https://github.com";
  private final static String REPOSITORY = "eroshenkoam/allure-example";
  private final static String ISSUE_NAME = "Listeners NamedBy";

  @Test
  @Owner("anovikova")
  @DisplayName("Чистый Selenide. Displaying names of issues")
  @Feature("Issue tab")
  @Story("List of issues")
  public void issueSearchByName() {

    SelenideLogger.addListener("allure", new AllureSelenide());
    open(BASE_URL);
    $("[name=q]").click();
    $("[name=q]").sendKeys(REPOSITORY);
    $("[name=q]").submit();
    $(By.linkText(REPOSITORY)).click();
    $$("ul.UnderlineNav-body li").find(text("Issues")).click();
    $("div[aria-label=Issues] [data-hovercard-type=issue]").shouldHave(text(ISSUE_NAME));
  }
}
