package lt.techin.egzaminas.calkuliatorius;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CalculatorLogin extends BasePage {

    @FindBy(css = "input[name='username']")
    WebElement inputLoginName;

    @FindBy(css = "input[name='password']")
    WebElement inputLoginPassword;

    @FindBy (css = ".btn-primary")
    WebElement prisijungtiButton;

    @FindBy (css = ".nav.navbar-nav.navbar-right > a")
    WebElement logoutButton;

    @FindBy (css = "div > span:nth-of-type(2)")
    WebElement errorTextMessage;

    public CalculatorLogin(WebDriver driver) {
        super(driver);
    }

    public void enterUserNameField(String name) {
        inputLoginName.sendKeys(name);
    }

    public void enterPassworField(String password) {
        inputLoginPassword.sendKeys(password);
    }

    public void pressPrisijungtiButton() {
        prisijungtiButton.click();
    }

    public String getLogoutButtonText() {
        String logoutText = logoutButton.getText();
        return logoutText.split(", ")[1];
    }

    public boolean isErrorTextPresentOnLoginPage() {
        return errorTextMessage.isDisplayed();
    }
}
