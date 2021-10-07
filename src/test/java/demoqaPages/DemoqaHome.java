package demoqaPages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DemoqaHome {
    protected WebDriver driver;

    //private By elementsBy = By.xpath("//h5[contains(text(),'Elements')]");
    @FindBy(xpath="/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]")
    WebElement elementsLink;
    //private By formsBy = By.cssSelector("div.card.mt-4.top-card:nth-child(2) div:nth-child(1) h5");
    @FindBy(css = "div.card.mt-4.top-card:nth-child(2)")
    WebElement formsLink;
    //private By alertsFramesWindowsBy = By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[3]/h5[1]");
    @FindBy(xpath = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[3]")
    WebElement alertsFramesWindowsLink;
    //private By widgetsBy = By.cssSelector("div.card.mt-4.top-card:nth-child(4)");
    @FindBy(css = "div.card.mt-4.top-card:nth-child(4)")
    WebElement widgetsLink;
    //private By interactionsBy = By.cssSelector("div.category-cards div.card.mt-4.top-card:nth-child(5) div:nth-child(1) > div.card-body");
    @FindBy(css = "div.card.mt-4.top-card:nth-child(5)")
    WebElement interactionsLink;
    //private By bookStoreAppBy = By.cssSelector("div.body-height:nth-child(2) div.home-content div.home-body div.category-cards div.card.mt-4.top-card:nth-child(6) div:nth-child(1) div.avatar.mx-auto.white svg:nth-child(1) > path:nth-child(1)");
    @FindBy(css = "div.card.mt-4.top-card:nth-child(6)")
    WebElement bookStoreAppLink;
    @FindBy(id = "close-fixedban")
    WebElement closeAdLink;
    

    //constructor
    public DemoqaHome(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    //getters
    public WebElement getElementsLink(){
        return elementsLink;
    }
    public WebElement getFormsLink(){
        return formsLink;
    }
    public WebElement getAlertsFramesWindowsLink(){
        return alertsFramesWindowsLink;
    }
    public WebElement getWidgetsLink(){
        return widgetsLink;
    }
    public WebElement getInteractionsLink(){
        return interactionsLink;
    }
    public WebElement getBookstoreAppLink(){
        return bookStoreAppLink;
    }
    
    public void moveTo(WebElement link) throws Exception{
        WebElement hover = link;
        Actions object = new Actions(driver); //must inrteract with driver
        object.moveToElement(hover).build().perform();
        Thread.sleep(1000);
    }
    public void scrollIntoView(WebElement linkCard) throws Exception{
        WebElement element = linkCard;
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(1000);
    }
    public void closeAd() throws Exception{
        closeAdLink.click();
        Thread.sleep(1000);
    }

    public void scrollBy(int px){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,"+px+");");
    }
    public void scrollToBottom() throws Exception{
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Thread.sleep(2000);
    }
    //from selenium docs, why return?
    public ElementsPage goToElementsPage() throws Exception{
        elementsLink.click();
        return new ElementsPage(driver);
    }
    public FormsPage goToFormsPage() throws Exception{
        formsLink.click();
        return new FormsPage(driver);
    }
    //simpler way works as well
    public void goToWidgetsPage() throws Exception{
        widgetsLink.click();
    }
    public void goToAlertsFramesWindowsPage() throws Exception{
        alertsFramesWindowsLink.click();
    }
    public void goToInteractionsPage()throws Exception{
        interactionsLink.click();
    }
    public BookStoreAppPage goTBookStoreAppPage() throws Exception{
        bookStoreAppLink.click();
        return new BookStoreAppPage(driver);
    }

}
