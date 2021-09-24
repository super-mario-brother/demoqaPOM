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
    InteractionsPage objInteractionsPage;
    BookStoreAppPage objBookStoreAppPage;

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
        objInteractionsPage = new InteractionsPage(driver);
        objBookStoreAppPage = new BookStoreAppPage(driver);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(baseURL);
    }

    @Test
    public void elementsLinkTest(){
        objDemoqaHome.scrollBy(300);
        objDemoqaHome.goToElementsPage();
        MatcherAssert.assertThat(objElementsPage.getMainHeaderText(), equalTo("Elements"));
        System.out.println(objElementsPage.getMainHeaderText());
    }
    @Test
    public void formsLinktest(){
        objDemoqaHome.scrollBy(300);
        objDemoqaHome.goToFormsPage();
        MatcherAssert.assertThat(objFormsPage.getMainHeaderText(), equalTo("Forms"));
        System.out.println(objFormsPage.getMainHeaderText());
    }
    @Test
    public void widgetsLinkTest(){
        objDemoqaHome.scrollBy(300);
        objDemoqaHome.goToWidgetsPage();
        MatcherAssert.assertThat(objWidgetsPage.getMainHeaderText(), equalTo("Widgets"));
        System.out.println(objWidgetsPage.getMainHeaderText());
    }
    @Test
    public void alertsFramesWindowsLinkTest(){
        objDemoqaHome.scrollBy(300);
        objDemoqaHome.goToAlertsFramesWindowsPage();
        MatcherAssert.assertThat(objAlertsFramesWindowsPage.getMainHeaderText(), equalTo("Alerts, Frame & Windows"));
        System.out.println(objAlertsFramesWindowsPage.getMainHeaderText());
    }
    @Test
    public void interactionsLinkTest(){
        objDemoqaHome.scrollBy(300);
        objDemoqaHome.goToInteractionsPage();
        MatcherAssert.assertThat(objInteractionsPage.getMainHeaderText(), equalTo("Interactions"));
        System.out.println(objInteractionsPage.getMainHeaderText());
    }
    @Test
    public void bookStoreAppLinkTest(){
        objDemoqaHome.scrollBy(300);
        objDemoqaHome.goTBookStoreAppPage();
        MatcherAssert.assertThat(objBookStoreAppPage.getMainHeaderText(), equalTo("Book Store"));
        System.out.println(objBookStoreAppPage.getMainHeaderText());
    }

    @After
    public void tearDown() throws Exception{
        Thread.sleep(3000);
        driver.close();


    }
}
