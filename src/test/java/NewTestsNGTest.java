
import java.util.concurrent.TimeUnit;
import org.testng.Reporter;
import org.testng.annotations.*;
import tests4.mavenproject44.BaseTest;
import tests4.mavenproject44.pages.*;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import tests4.mavenproject44.utils.logging.EventHandler;


public class NewTestsNGTest {
    private LogginPage logPage;
    private CreateProductPage crPrPage;
    private MainAdminPage admPage;
    private ProductPage prPage;
    private ShopPage shPage;
    private EventFiringWebDriver driver;


    @DataProvider(name = "loginPasword")
    public Object[][] dataProviderMethod() {
        return new Object[][]{{"webinar.test@gmail.com", "Xcg7299bnSmMuRLp9ITw"}};
    }

    @Test(dataProvider = "loginPasword")
    public void createNewProductTest(String log, String pass) {
        logPage = new LogginPage(driver);
        admPage = new MainAdminPage(driver);
        crPrPage=new CreateProductPage (driver);
        logPage.loginAsAdmin(log, pass);
        admPage.goCreateProduct();
        crPrPage.createProduct();
    }

    @Test(dependsOnMethods={"createNewProductTest"})
    public void CheckProductTest(){
        shPage = new ShopPage(driver);
        prPage = new ProductPage(driver);
        shPage.findProduct();
        prPage.checkProduct();
    }

    @BeforeMethod
    @Parameters({"browser", "url"})
    public void setUp(String br, String urlPage) {
        driver = new EventFiringWebDriver(BaseTest.getDriver(br));
        driver.register(new EventHandler());
        Reporter.setEscapeHtml(false);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(urlPage);
    }


    @AfterMethod
    public void tearDown() {
        if (driver != null) driver.quit();
    }




}


