package demoqaPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DemoqaHome {
    protected WebDriver driver;

    private By elementsBy = By.xpath("//h5[contains(text(),'Elements')]");
    private By formsBy = By.cssSelector("div.card.mt-4.top-card:nth-child(2) div:nth-child(1) h5");
    private By alertsFramesWindowsBy = By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[3]/h5[1]");
    private By widgetsBy = By.cssSelector("div.card.mt-4.top-card:nth-child(4)");
    private By interactionsBy = By.cssSelector("div.category-cards div.card.mt-4.top-card:nth-child(5) div:nth-child(1) > div.card-body");
    private By bookStoreAppBy = By.cssSelector("div.body-height:nth-child(2) div.home-content div.home-body div.category-cards div.card.mt-4.top-card:nth-child(6) div:nth-child(1) div.avatar.mx-auto.white svg:nth-child(1) > path:nth-child(1)");

    public DemoqaHome(WebDriver driver){
        this.driver = driver;
    }
    public ElementsPage goToElementsPage(){
        driver.findElement(elementsBy).click();
        return new ElementsPage(driver);
    }
}
