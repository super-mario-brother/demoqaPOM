package demoqaPages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DemoqaHome {
    protected WebDriver driver;

    //private By elementsBy = By.xpath("//h5[contains(text(),'Elements')]");
    @FindBy(xpath="//h5[contains(text(),'Elements')]")
    WebElement elementsLink;
    //private By formsBy = By.cssSelector("div.card.mt-4.top-card:nth-child(2) div:nth-child(1) h5");
    @FindBy(css="div.card.mt-4.top-card:nth-child(2) div:nth-child(1) h5")
    WebElement formsLink;
    //private By alertsFramesWindowsBy = By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[3]/h5[1]");
    @FindBy(xpath = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[3]/h5[1]")
    WebElement alertsFramesWindowsLink;
    //private By widgetsBy = By.cssSelector("div.card.mt-4.top-card:nth-child(4)");
    @FindBy(css = "div.card.mt-4.top-card:nth-child(4)")
    WebElement widgetsLink;
    //private By interactionsBy = By.cssSelector("div.category-cards div.card.mt-4.top-card:nth-child(5) div:nth-child(1) > div.card-body");
    @FindBy(css = "div.category-cards div.card.mt-4.top-card:nth-child(5) div:nth-child(1) > div.card-body")
    WebElement interactionsLink;
    //private By bookStoreAppBy = By.cssSelector("div.body-height:nth-child(2) div.home-content div.home-body div.category-cards div.card.mt-4.top-card:nth-child(6) div:nth-child(1) div.avatar.mx-auto.white svg:nth-child(1) > path:nth-child(1)");
    @FindBy(css = "div.card.mt-4.top-card:nth-child(6)")
    WebElement bookStoreAppLink;
    

    public DemoqaHome(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void scrollBy(int px){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,"+px+");");
    }
    
    //from selenium docs, why return?
    public ElementsPage goToElementsPage(){
        elementsLink.click();
        return new ElementsPage(driver);
    }
    public FormsPage goToFormsPage(){
        formsLink.click();
        return new FormsPage(driver);
    }
    //simpler way works as well
    public void goToWidgetsPage(){
        widgetsLink.click();
    }
    public void goToAlertsFramesWindowsPage(){
        alertsFramesWindowsLink.click();
    }
    public void goToInteractionsPage(){
        interactionsLink.click();
    }
    public BookStoreAppPage goTBookStoreAppPage(){
        bookStoreAppLink.click();
        return new BookStoreAppPage(driver);
    }

}
