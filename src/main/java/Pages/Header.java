package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Header extends BasePage{
    public Header(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//i[@class='fa fa-lock']")
    private WebElement signUpLogInLink;
    public void setSignUpLogInLink(){
        signUpLogInLink.click();
    }
}
