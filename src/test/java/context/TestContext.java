package context;
import com.microsoft.playwright.Page;
import pages.LoginPage;

public class TestContext {
    private Page page;
    private LoginPage loginPage;

    public void setPage(Page page) {
        this.page = page;
        this.loginPage = new LoginPage(page);
    }

    public Page getPage() {
        return page;
    }

    public LoginPage getLoginPage() {
        return loginPage;
    }
}