import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SingleToneDriver {
    private WebDriver driver;

    private static SingleToneDriver INSTANCE;

    private SingleToneDriver() {
    }

    public static SingleToneDriver getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new SingleToneDriver();
        }
        return INSTANCE;
    }

    public void setDriver(String browser) {
        switch (browser.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            default:
                throw new IllegalArgumentException("Invalid Browser");
        }

    }

    public WebDriver getDriver() {
        return driver;
    }
}
