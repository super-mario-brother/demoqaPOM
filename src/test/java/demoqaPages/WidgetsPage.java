package demoqaPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WidgetsPage {
    protected WebDriver driver;

    @FindBy(className = "main-header")
    WebElement mainHeaderBy;

    public WidgetsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public String getMainHeaderText(){
        return mainHeaderBy.getText();
    }
}
