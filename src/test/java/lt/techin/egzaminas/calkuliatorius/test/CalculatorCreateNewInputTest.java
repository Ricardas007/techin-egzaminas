package lt.techin.egzaminas.calkuliatorius.test;

import jdk.jfr.Description;
import lt.techin.egzaminas.calkuliatorius.CalculatorCreateNewInput;
import lt.techin.egzaminas.calkuliatorius.CalculatorLogin;
import lt.techin.egzaminas.calkuliatorius.CalculatorRegister;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.CsvFileSource;


public class CalculatorCreateNewInputTest extends BaseTest{

    CalculatorRegister register;
    CalculatorLogin login;
    CalculatorCreateNewInput input;


    @Tag("Positive")
    @Description("Logged user enter data on page to make some calculator inputs")
    @ParameterizedTest(name = "Test {index} => name {0}, password {1}")
    @CsvFileSource(files = "src/main/resources/newInputData.csv", numLinesToSkip = 1)
    public void userLoginToPageAndPerformMultiplication(ArgumentsAccessor arguments) {

        String name = arguments.getString(0);
        String password = arguments.getString(1);

        register = new CalculatorRegister(driver);
        login = new CalculatorLogin(driver);
        login.enterUserNameField(name);
        login.enterUserPassworField(password);
        login.pressPrisijungtiButton();
        int number1 = arguments.getByte(2);
        int number2 = arguments.getByte(3);
        String action = arguments.getString(4);
        input = new CalculatorCreateNewInput(driver);
        input.enterFirstNumber(number1);
        input.enterSecondNumber(number2);
        input.pressDropDown();
        input.performCountAction(action);
        input.pressSkaicuotiButton();
        boolean result = input.getResult();
        Assertions.assertTrue(result, "When user performs calculation result should appear");
        }


    @Tag("Negative")
    @Description("Logged user enter data with negative digits to get error or error text")
    @ParameterizedTest(name = "Test {index} => name {0}, password {1}")
    @CsvFileSource(files = "src/main/resources/negativeInputData.csv", numLinesToSkip = 1)
    public void userLoginToPageAndPerformsMultiplicationWithNegativeDigit(ArgumentsAccessor arguments) {

        String name = arguments.getString(0);
        String password = arguments.getString(1);

        register = new CalculatorRegister(driver);
        login = new CalculatorLogin(driver);
        login.enterUserNameField(name);
        login.enterUserPassworField(password);
        login.pressPrisijungtiButton();
        int number1 = arguments.getByte(2);
        int number2 = arguments.getByte(3);
        String action = arguments.getString(4);
        String expectedResult = arguments.getString(5);
        input = new CalculatorCreateNewInput(driver);
        input.enterFirstNumber(number1);
        input.enterSecondNumber(number2);
        input.pressDropDown();
        input.performCountAction(action);
        input.pressSkaicuotiButton();
        String text = input.gerErrorTextFromCalculatorInput();
        Assertions.assertEquals(expectedResult, text ,"When user enters negative number error mesage is appers:'Validacijos klaida: skaičius negali būti neigiamas'");
    }
}
