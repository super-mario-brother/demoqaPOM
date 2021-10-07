package demoqaPages;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class AlertsFramesWindowsPage {
    protected WebDriver driver;

    @FindBy(className = "main-header")
    WebElement mainHeaderBy;
    @FindBy(id = "windowButton")
    WebElement newWindowButton;
    @FindBy(id = "sampleHeading")
    WebElement sampleHeading;

    public AlertsFramesWindowsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    public String getMainHeaderText(){
        return mainHeaderBy.getText();
    }
    public void openNewWindow(){
        newWindowButton.click();
    }
    public String getParentWindow(){
        String parentWindow = driver.getWindowHandle();
        System.out.println(parentWindow);
        return parentWindow;
    }
    public Set<String> getHandles(){
        Set<String> handles = driver.getWindowHandles();
        System.out.println(handles);
        return handles;
    }
    public void switchToChild(String parent, Set<String> children){
        for(String childHandle: children){
            if(!childHandle.equals(parent)){
                driver.switchTo().window(childHandle);
                System.out.println("run child window tests");
                break;
            }
        }
    }
    public void switchToParent(String parent){
        driver.close();
        driver.switchTo().window(parent);
        System.out.println("back to parent");
    }
    public String getSampleHeadingText(){
        return sampleHeading.getText();
    }
    // public void handles() throws Exception{
    //     Set<String> parentWindow = driver.getWindowHandles();
    //     System.out.println(parentWindow);
    //     //newWindow Locator
    //     newWindow.click();
    //     Set<String> handles = driver.getWindowHandles();
    //     for (String childHandle: handles){
    //         System.out.println(handles);
    //         if(!childHandle.equals(parentWindow)){
    //             driver.switchTo().window(childHandle);
    //             WebElement allCourses = driver.findElement(By.cssSelector("linktoallcourses"));
    //             allCourses.click();
    //             WebElement searchBox = driver.findElement(By.cssSelector("searchlocator"));
    //             searchBox.sendKeys("Java?");
    //             driver.close();
    //             break; is it right place?
    //         }
    //     }
    //     driver.switchTo().window(parentWindow);
    // }
}
