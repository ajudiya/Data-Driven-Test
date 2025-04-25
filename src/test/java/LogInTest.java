import Pages.Header;
import Pages.SignUpLogInPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class LogInTest extends BaseTest{
    private Header header;
    private SignUpLogInPage signUpLogInPage;
    @BeforeMethod
    public void inIt(){
        header = new Header(driver);
        signUpLogInPage = new SignUpLogInPage(driver);
    }
    @Test(dataProvider = "AutomationExerciseCredentials.xlsx")
    public void loginTest(String email,String pwd){
        System.out.println("User and password are: "+email+" | "+pwd);
        header.setSignUpLogInLink();
        signUpLogInPage.clearLoginEmailField();
        signUpLogInPage.setLoginEmailField(email);
        signUpLogInPage.clearLoginPasswordField();
        signUpLogInPage.setLoginPasswordField(pwd);
        signUpLogInPage.setLoginButton();
    }
    @DataProvider(name = "AutomationExerciseCredentials.xlsx")
    public String[][] getData() throws IOException {
        String path = "/home/ganesha/Selenium/DDT/dataFiles/AutomationExerciseCredentials.xlsx";
        XLUtility xlUtility = new XLUtility(path);
        int totalRows = xlUtility.getRowCount("Sheet1");
        int totalCols = xlUtility.getCellCount("Sheet1", 1);
        String loginData[][] = new String[totalRows][totalCols];

        for (int i = 1; i <= totalRows; i++) {
            for (int j = 0; j < totalCols; j++) {
                loginData[i - 1][j] = xlUtility.getCellData("Sheet1", i, j);
            }
        }
        return loginData;
    }
}
