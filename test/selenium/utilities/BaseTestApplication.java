package selenium.utilities;

import static play.test.Helpers.fakeApplication;
import globals.Global;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import play.GlobalSettings;
import play.test.FakeApplication;
import play.test.TestServer;

public class BaseTestApplication {

    private static TestServer testServer;

    public static FakeApplication app;
    protected static final String DEFAULT_URL = "http://localhost:9000";
    protected static WebDriver driver;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        System.setProperty("webdriver.chrome.driver",
                ".\\chromedriver\\chromedriver.exe");
        GlobalSettings glob = new Global();
        app = fakeApplication(glob);

        testServer = new TestServer(9000, app);
        testServer.start();

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        driver.quit();
        testServer.stop();
    }
}
