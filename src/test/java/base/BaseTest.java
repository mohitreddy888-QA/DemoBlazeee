package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

import static DemoBlaze.utilities.TestUtil.prop;

public class BaseTest {

    protected static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    protected static ThreadLocal<WebDriverWait> wait = new ThreadLocal<>();

    @BeforeClass
    public void setup() {

        driver.set(new ChromeDriver());

        getDriver().manage().window().maximize();
        getDriver().get(prop.getProperty("url"));

        wait.set(new WebDriverWait(getDriver(), Duration.ofSeconds(10)));
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static WebDriverWait getWait() {
        return wait.get();
    }

    @AfterClass
    public void teardown() {
        if (getDriver() != null) {
            getDriver().quit();
            driver.remove();
            wait.remove();
        }
    }
}