package demoqaPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ElementsPage {
    protected WebDriver driver;

    private By mainHeaderBy = By.className("main-header");

    public ElementsPage(WebDriver driver){
        this.driver = driver;
    }

    public String getMainHeaderText(){
        return driver.findElement(mainHeaderBy).getText();
    }

    public ElementsPage textBox(){
        return new ElementsPage(driver);
    }
}
