
import net.bytebuddy.implementation.bytecode.Throw;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class SeleniumTest extends BaseClass {
    WebDriver driver;
    FitPeoPages fitPeoPages;

    @Test
    void FitPeoTest() throws InterruptedException {
        try {
            driver = SingleToneDriver.getINSTANCE().getDriver();
            fitPeoPages = new FitPeoPages(driver);

            fitPeoPages.clickOnRevenueCalPage();
            fitPeoPages.scrollToZeroTo20000();
            fitPeoPages.adjustSliderPointerTo820();
            fitPeoPages.scrollToZeroTo20000();
            fitPeoPages.VerifyTheSliderPointValue("823");
            fitPeoPages.sendValueInSliderField("560");
            fitPeoPages.VerifyTheSliderPointValue("560");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            fitPeoPages.clickOnCPT99091Checkbox();
            fitPeoPages.clickOnCPT99453Checkbox();
            fitPeoPages.clickOnCPT99454Checkbox();
            fitPeoPages.clickOnCPT99474Checkbox();
            fitPeoPages.verifyTotalAmount("111105");
        }
        catch (Exception e){
            throw new RuntimeException("UnKnown Error occurred",e);
        }

    }
}
