package steps;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import context.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
    private final TestContext context;

    public LoginSteps(TestContext context) {
        this.context = context;
    }

    @Given("I am on the login page")
    public void iAmOnTheLoginPage() {
        context.getLoginPage().open();
    }

    @When("I log in as {string} and password {string}")
    public void iLogIn(String username, String password) {
        context.getLoginPage().login(username, password);
    }

    @Then("I should land on product page")
    public void iShouldLandOnProductPage() {
        assertThat(context.getPage()).hasURL("https://www.saucedemo.com/inventory.html");
    }

    @Then("I should see the error {string}")
    public void iShouldSeeTheError(String message) {
        assertThat(context.getLoginPage().error()).hasText(message);
    }

    @Then("I should stay on the login page")
    public void iShouldStayOnTheLoginPage() {
        assertThat(context.getLoginPage().loginButton()).isVisible();
    }
}