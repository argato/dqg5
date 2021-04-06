package lambda;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class LambdaStepsTest {

  private final String BASE_URL = "https://github.com";
  private final static String REPOSITORY = "eroshenkoam/allure-example";
  private final static String ISSUE_NAME = "Listeners NamedBy";

  @Test
  @Owner("anovikova")
  @DisplayName("Лямбда шаги через step. Displaying names of issues")
  @Feature("Issue tab")
  @Story("List of issues")
  public void issueSearchByName() {

    step("Открываем главную страницу", (step) -> {
      step.parameter("url", BASE_URL);
      open(BASE_URL);
    });
    step("Поиск репозитория", (step) -> {
      step.parameter("repository", REPOSITORY);
      $("[name=q]").click();
      $("[name=q]").sendKeys(REPOSITORY);
      $("[name=q]").submit();
    });
    step("Переходим в репозиторий", (step) -> {
      step.parameter("repository", REPOSITORY);
      $(By.linkText(REPOSITORY)).click();
    });
    step("Переходим на вкладку Issues", (step) -> {
      $$("ul.UnderlineNav-body li").find(text("Issues")).click();
    });
    step("Проверяем наличие issue ", (step) -> {
      step.parameter("issue_name", ISSUE_NAME);
      $("div[aria-label=Issues] [data-hovercard-type=issue]").shouldHave(text(ISSUE_NAME));
    });
  }
}
