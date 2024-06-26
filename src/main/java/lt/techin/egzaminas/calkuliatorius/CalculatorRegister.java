package lt.techin.egzaminas.calkuliatorius;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CalculatorRegister extends BasePage {

    @FindBy(xpath = "//a[@href='/registruoti']")
    WebElement sukurtiNaujaPaskiraButton;

    @FindBy (css = "input#username")
    WebElement inputUserName;

    @FindBy (css = "input#password")
    WebElement inputUserPassword;

    @FindBy (css = "input#passwordConfirm")
    WebElement inputPasswordConfirm;

    @FindBy (css = ".btn-primary")
    WebElement sukurtiButton;

    @FindBy (css = "#username\\.errors")
    WebElement userNameErrorText;

    @FindBy (css = ".nav.navbar-nav.navbar-right > a")
    WebElement userNameLogoutButton;

    public CalculatorRegister(WebDriver driver) {
        super(driver);
    }

    public void navigateToRegisterPage() {
        sukurtiNaujaPaskiraButton.click();
    }

    public void enterUserNameField(String userName) {
        inputUserName.sendKeys(userName);
    }

    public void enterUserPassworField(String userPassword) {
        inputUserPassword.sendKeys(userPassword);
    }

    public void enterConfirmPassworField(String userConfirmPassword) {
        inputPasswordConfirm.sendKeys(userConfirmPassword);
    }

    public void pressSukurtiButton() {
        sukurtiButton.click();
    }

    public boolean isErrorTextPresent() {
        return userNameErrorText.isDisplayed();
    }

    public String getUserLoginName() {
        return userNameLogoutButton.getText();
    }

    public void clickOnUserLoginButton() {
        userNameLogoutButton.click();
    }
}

