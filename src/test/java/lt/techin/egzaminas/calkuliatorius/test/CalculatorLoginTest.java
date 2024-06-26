package lt.techin.egzaminas.calkuliatorius.test;

import jdk.jfr.Description;
import lt.techin.egzaminas.calkuliatorius.CalculatorLogin;
import lt.techin.egzaminas.calkuliatorius.CalculatorRegister;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.CsvFileSource;


public class CalculatorLoginTest extends BaseTest {

    CalculatorRegister register;
    CalculatorLogin login;

    @Tag("Positive")
    @Description("User enters name and password and successfully logs in to page")
    @ParameterizedTest(name = "Test {index} => name {0}, password {1}")
    @CsvFileSource(files = "src/main/resources/loginData.csv", numLinesToSkip = 1)
    public void userLoginToPage(ArgumentsAccessor arguments){

        String name = arguments.getString(0);
        String password = arguments.getString(1);

        register = new CalculatorRegister(driver);
        login = new CalculatorLogin(driver);
        login.enterUserNameField(name);
        login.enterUserPassworField(password);
        login.pressPrisijungtiButton();
        login.getLogoutButtonText();
        String logoutText = login.getLogoutButtonText();
        Assertions.assertEquals(name, logoutText,"Entered name should match with logged in user name.");
    }
    @Tag("Negatvive")
    @Description("User leaves name field empty enters password should not login to page, and error message should appear")
    @ParameterizedTest(name = "Test {index} => name {0}, password {1}")
    @CsvFileSource(files = "src/main/resources/loginData.csv", numLinesToSkip = 1)
    public void userLoginToPageNotEnteringUserName(ArgumentsAccessor arguments) { //istrinti

        String password = arguments.getString(1);

        register = new CalculatorRegister(driver);
        login = new CalculatorLogin(driver);
        login.enterUserPassworField(password);
        login.pressPrisijungtiButton();
        boolean isErrorTextPresent = login.isErrorTextPresentOnLoginPage();
        Assertions.assertTrue(isErrorTextPresent, "When user enters/leaves incorrect or empty field, error message is present");
    }
}
