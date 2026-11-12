package hooks;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;
import context.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
    private final TestContext context;
    private Playwright playwright;
    private Browser browser;

    public Hooks(TestContext context) {
        this.context = context;
    }

    @Before
    public void openBrowser() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions().setHeadless(false));
        context.setPage(browser.newPage());
    }

    @After
    public void closeBrowser(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot = context.getPage().screenshot();
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
        browser.close();
        playwright.close();
    }
}