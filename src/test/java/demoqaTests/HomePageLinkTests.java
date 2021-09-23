package demoqaTests;

import demoqaPages.DemoqaHome;
import demoqaPages.ElementsPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.hamcrest.MatcherAssert;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.Matchers.equalTo;

public class HomePageLinkTests {
    private WebDriver driver;
    private String baseURL;

    DemoqaHome objDemoqaHome;
    ElementsPage objElementsPage;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        baseURL = "https://demoqa.com";

        objDemoqaHome = new DemoqaHome(driver);
        objElementsPage = new ElementsPage(driver);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(baseURL);
    }

    @Test
    public void elementsLinkTest(){
        objDemoqaHome.goToElementsPage();
        MatcherAssert.assertThat(objElementsPage.getMainHeaderText(), equalTo("Elements"));
    }

    @After
    public void tearDown() throws Exception{
        Thread.sleep(7000);
        driver.close();


    }
}
