package demoqaTests;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.hamcrest.MatcherAssert;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.hamcrest.Matchers.equalTo;
import demoqaPages.AlertsFramesWindowsPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertsFramesWindowsTests {
    private WebDriver driver;

    AlertsFramesWindowsPage objAlertsFramesWindowsPage;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        String baseURL = "https://demoqa.com/browser-windows";

        objAlertsFramesWindowsPage = new AlertsFramesWindowsPage(driver);
        
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(baseURL);
    }
    @Test
    public void switchWindowsTest() throws Exception {
        String parent = objAlertsFramesWindowsPage.getParentWindow();
        objAlertsFramesWindowsPage.openNewWindow();
        Set<String> windows = objAlertsFramesWindowsPage.getHandles();
        objAlertsFramesWindowsPage.switchToChild(parent, windows);
        String actual = objAlertsFramesWindowsPage.getSampleHeadingText();
        MatcherAssert.assertThat(actual, equalTo("This is a sample page"));
        System.out.println(actual);
        objAlertsFramesWindowsPage.switchToParent(parent);
        MatcherAssert.assertThat(objAlertsFramesWindowsPage.getMainHeaderText(), equalTo("Browser Windows"));
        System.out.println(objAlertsFramesWindowsPage.getMainHeaderText());
    }

    @After
    public void tearDown() throws Exception{
        Thread.sleep(3000);
        driver.close();


    }

    
}