package demoqaPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ElementsPage {
    protected WebDriver driver;

    //private By mainHeaderBy = By.className("main-header");
    @FindBy(className = "main-header")
    WebElement mainHeaderBy;

    public ElementsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public String getMainHeaderText(){
        return mainHeaderBy.getText();
    }

    public ElementsPage textBox(){
        return new ElementsPage(driver);
    }
}
