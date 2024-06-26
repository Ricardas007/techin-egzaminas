package lt.techin.egzaminas.calkuliatorius;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CalculatorSearch extends BasePage{

    @FindBy(css = ".nav.navbar-left.navbar-nav  a")
    WebElement navigateToTaskPage;

    @FindBy(css = "tr")
    List<WebElement> getFirstProject;

    public CalculatorSearch(WebDriver driver) {
        super(driver);
    }

    public void navigateToSavedTasks() {
        navigateToTaskPage.click();
    }

    public int findProjects() {
        return getFirstProject.size();
    }
}

