package lt.techin.egzaminas.calkuliatorius;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class CalculatorCreateNewInput extends BasePage {

    @FindBy(css = "#sk1")
    WebElement inputCalculatorFirstNumber;

    @FindBy(css = "[name='sk2']")
    WebElement inputCalculatorSecondNumber;

    @FindBy(css = "[name='zenklas']")
    WebElement dropDownMeniu;

    @FindBy(css = "[type='submit']")
    WebElement pressSkaicuotiButton;

    @FindBy (css = "h4")
    WebElement isResultPresent;

    @FindBy (xpath = "/html//span[@id='sk1.errors']")
    WebElement calculatorInputErrorText;


    public CalculatorCreateNewInput(WebDriver driver) {
        super(driver);
    }

    public void enterFirstNumber(int number1) {
        inputCalculatorFirstNumber.clear();
        inputCalculatorFirstNumber.sendKeys(String.valueOf(number1));
    }

    public void enterSecondNumber(int number2) {
        inputCalculatorSecondNumber.clear();
        inputCalculatorSecondNumber.sendKeys(String.valueOf(number2));
    }

    public void performCountAction(String action) {
        Select se = new Select(dropDownMeniu);
        se.selectByVisibleText(action);
        wait.until(ExpectedConditions.visibilityOf(dropDownMeniu));
    }

    public void pressSkaicuotiButton() {
        pressSkaicuotiButton.click();
    }

    public void pressDropDown() {
        dropDownMeniu.click();
    }

    public boolean getResult() {
        return isResultPresent.isDisplayed();
    }
    public String gerErrorTextFromCalculatorInput() {
        return calculatorInputErrorText.getText();
    }

}