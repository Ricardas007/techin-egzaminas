package lt.techin.egzaminas.calkuliatorius.test;

import jdk.jfr.Description;
import lt.techin.egzaminas.calkuliatorius.CalculatorLogin;
import lt.techin.egzaminas.calkuliatorius.CalculatorRegister;
import lt.techin.egzaminas.calkuliatorius.utils.Utils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.CsvFileSource;

public class CalculatoriRegisterTest extends BaseTest{

    CalculatorRegister register;
    CalculatorLogin login;


    @Tag("Positive")
    @Description("User pass all relevant data to name, password and confirm password fields and successfully register to page")
    @Test
    void userRegistrationOnPage() {

        String userName = Utils.generateFistName();
        String userPassword = Utils.generatePassword();
        String userConfirmPassword = userPassword;
        register = new CalculatorRegister(driver);
        register.navigateToRegisterPage();
        register.enterUserNameField(userName);
        register.enterUserPassworField(userPassword);
        register.enterConfirmPassworField(userConfirmPassword);
        register.pressSukurtiButton();
        login = new CalculatorLogin(driver);
        login.getLogoutButtonText();
        String logoutText = login.getLogoutButtonText();
        Assertions.assertEquals(userName, logoutText,"When user sign in user name should be the same as logged name");
    }

    @Tag("Negative")
    @Description("Negative test when user left name field empty")
    @ParameterizedTest(name = "Test {index} =>password {0}, confirmPassword {1}")
    @CsvFileSource(files = "src/main/resources/registerData.csv", numLinesToSkip = 1)
    void userRegistrationEmptyRegisterNameField(ArgumentsAccessor arguments) {

        String password = arguments.getString(0);
        String confirmPassword = arguments.getString(1);

        register = new CalculatorRegister(driver);
        register.navigateToRegisterPage();
        register.enterUserPassworField(password);
        register.enterConfirmPassworField(confirmPassword);
        register.pressSukurtiButton();
        boolean isErrorTextPresent = register.isErrorTextPresent();
        Assertions.assertTrue(isErrorTextPresent, "When user name field is empty error message should appear");
    }

}
