package annotations.tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import annotations.steps.WebSteps;

public class AnnotatedStepsTest {
  private final static String REPOSITORY = "eroshenkoam/allure-example";
  private final static String ISSUE_NAME = "Listeners NamedBy";
  private WebSteps steps = new WebSteps();

  @Test
  @Owner("anovikova")
  @DisplayName("Шаги с аннотацией @Step. Displaying names of issues")
  @Feature("Issue tab")
  @Story("List of issues")
  public void issueSearchByName() {
    steps.openMainPage();
    steps.searchForRepository(REPOSITORY);
    steps.goToRepository(REPOSITORY);
    steps.clickOnIssueTab();
    steps.shouldSeeIssueWithName(ISSUE_NAME);
  }
}
