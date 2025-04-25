package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpLogInPage extends BasePage {
    public SignUpLogInPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@data-qa='login-email']")
    private WebElement loginEmailField;
    @FindBy(xpath = "//input[@data-qa='login-password']")
    private WebElement loginPasswordField;
    @FindBy(xpath = "//button[@data-qa='login-button']")
    private WebElement loginButton;

    public void setLoginEmailField(String loginEmail) {
        loginEmailField.sendKeys(loginEmail);
    }
    public void clearLoginEmailField() {
        loginEmailField.clear();
    }
    public void setLoginPasswordField(String loginPassword) {
        loginPasswordField.sendKeys(loginPassword);
    }
    public void clearLoginPasswordField() {
        loginPasswordField.clear();
    }
    public void setLoginButton() {
        loginButton.click();
    }
}
