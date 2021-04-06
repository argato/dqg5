package annotations.steps;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class WebSteps {

  private final String BASE_URL = "https://github.com";

  @Step("Открываем главную страницу")
  public void openMainPage() {
    open(BASE_URL);
  }

  @Step("Поиск репозитория {repository}")
  public void searchForRepository(String repository) {
    $("[name=q]").click();
    $("[name=q]").sendKeys(repository);
    $("[name=q]").submit();
  }

  @Step("Переходим в репозиторий")
  public void goToRepository(String repository) {
    $(By.linkText(repository)).click();
  }

  @Step("Переходим на вкладку Issues")
  public void clickOnIssueTab() {
    $$("ul.UnderlineNav-body li").find(text("Issues")).click();
  }

  @Step("Проверяем наличие issue {issueName}")
  public void shouldSeeIssueWithName(String issueName) {
    $("div[aria-label=Issues] [data-hovercard-type=issue]").shouldHave(text(issueName));
  }
}
