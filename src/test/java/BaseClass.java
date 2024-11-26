import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.time.Duration;

public class BaseClass {
    WebDriver driver;

    @BeforeTest
    public void browserSetUp() {

        SingleToneDriver.getINSTANCE().setDriver("chrome");
        driver = SingleToneDriver.getINSTANCE().getDriver();
        driver.get("https://fitpeo.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().deleteAllCookies();
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
