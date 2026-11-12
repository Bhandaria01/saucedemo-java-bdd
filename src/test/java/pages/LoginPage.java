package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class LoginPage {
    private final Page page;
    private final Locator username;
    private final Locator password;
    private final Locator loginButton;
    private final Locator error;

    public LoginPage(Page page) {
        this.page = page;
        this.username = page.locator("[data-test='username']");
        this.password = page.locator("[data-test='password']");
        this.loginButton = page.locator("[data-test='login-button']");
        this.error = page.locator("[data-test='error']");
    }

    public void open() {
        page.navigate("https://www.saucedemo.com/");
    }

    public void login(String user, String pass) {
        username.fill(user);
        password.fill(pass);
        loginButton.click();
    }

    public Locator error() {
        return error;
    }

    public Locator loginButton() {
        return loginButton;
    }
}