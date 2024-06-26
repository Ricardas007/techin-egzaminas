package lt.techin.egzaminas.calkuliatorius.test;

import jdk.jfr.Description;
import lt.techin.egzaminas.calkuliatorius.CalculatorLogin;
import lt.techin.egzaminas.calkuliatorius.CalculatorRegister;
import lt.techin.egzaminas.calkuliatorius.CalculatorSearch;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.CsvFileSource;



public class CalcuatorSearchTest extends BaseTest{

    CalculatorRegister register;
    CalculatorLogin login;
    CalculatorSearch search;

    @Description("Logged user enter data on page to make some calculator inputs")
    @ParameterizedTest(name = "Test {index} => name {0}, password {1}")
    @CsvFileSource(files = "src/main/resources/newInputData.csv", numLinesToSkip = 1)
    public void userLoginToPageAndPerformSearchOnPreviousTasks(ArgumentsAccessor arguments) throws InterruptedException {

        String name = arguments.getString(0);
        String password = arguments.getString(1);

        register = new CalculatorRegister(driver);
        login = new CalculatorLogin(driver);
        login.enterUserNameField(name);
        login.enterUserPassworField(password);
        login.pressPrisijungtiButton();
        search = new CalculatorSearch(driver);
        search.navigateToSavedTasks();
        search.findProjects();

        Thread.sleep(3000);

    }
}