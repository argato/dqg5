import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AnnotatedStepsTest {
  private final static String REPOSITORY = "eroshenkoam/allure-example";
  private final static String ISSUE_NAME = "Listeners NamedBy";
  private WebSteps steps = new WebSteps();

  @Test
  @DisplayName("Шаги с аннотацией @Step")
  public void issueSearchByName() {
    steps.openMainPage();
    steps.searchForRepository(REPOSITORY);
    steps.goToRepository(REPOSITORY);
    steps.clickOnIssueTab();
    steps.shouldSeeIssueWithName(ISSUE_NAME);
  }
}
