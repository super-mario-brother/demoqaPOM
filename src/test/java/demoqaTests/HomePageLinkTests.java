package demoqaTests;

import demoqaPages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.hamcrest.MatcherAssert;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.Matchers.equalTo;

public class HomePageLinkTests {
    private WebDriver driver;

    DemoqaHome objDemoqaHome;
    ElementsPage objElementsPage;
    FormsPage objFormsPage;
    WidgetsPage objWidgetsPage;
    AlertsFramesWindowsPage objAlertsFramesWindowsPage;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        String baseURL = "https://demoqa.com";

        objDemoqaHome = new DemoqaHome(driver);
        objElementsPage = new ElementsPage(driver);
        objFormsPage = new FormsPage(driver);
        objWidgetsPage = new WidgetsPage(driver);
        objAlertsFramesWindowsPage = new AlertsFramesWindowsPage(driver);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(baseURL);
    }

    @Test
    public void elementsLinkTest(){
        objDemoqaHome.goToElementsPage();
        MatcherAssert.assertThat(objElementsPage.getMainHeaderText(), equalTo("Elements"));
        System.out.println(objElementsPage.getMainHeaderText());
    }
    @Test
    public void formsLinktest(){
        objDemoqaHome.goToFormsPage();
        MatcherAssert.assertThat(objFormsPage.getMainHeaderText(), equalTo("Forms"));
        System.out.println(objFormsPage.getMainHeaderText());
    }
    @Test
    public void widgetsLinkTest(){
        objDemoqaHome.goToWidgetsPage();
        MatcherAssert.assertThat(objWidgetsPage.getMainHeaderText(), equalTo("Widgets"));
        System.out.println(objWidgetsPage.getMainHeaderText());
    }
    @Test
    public void alertsFramesWindowsPageTest(){
        objDemoqaHome.goToAlertsFramesWindowsPage();
        MatcherAssert.assertThat(objAlertsFramesWindowsPage.getMainHeaderText(), equalTo("Alerts, Frame & Windows"));
        System.out.println(objAlertsFramesWindowsPage.getMainHeaderText());
    }

    @After
    public void tearDown() throws Exception{
        Thread.sleep(3000);
        driver.close();


    }
}
