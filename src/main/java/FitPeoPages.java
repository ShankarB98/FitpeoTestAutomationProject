import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FitPeoPages {
    WebDriver driver;
    ActionUtils actionUtils;

    public FitPeoPages(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        actionUtils = new ActionUtils(driver);
    }


    @FindBy(xpath = "//div[text()='Revenue Calculator']")
    private WebElement RevenueCAl_link;

    @FindBy(xpath = "//span[text()='Patients should be between 0 to 2000']")
    private WebElement zeroto2000;

    @FindBy(xpath = "//input[@type='range']")
    private WebElement sliderPointer;

    @FindBy(xpath = "//input[@type='number']")
    private WebElement sliderInputField;

    @FindBy(xpath = "//p[text()='Total Individual Patient/Month']/..//p[2]")
    private WebElement sliderPointerAmount;

    @FindBy(xpath = "//p[text()='CPT-99091']/..//input")
    private WebElement CPT99091Checkbox;

    @FindBy(xpath = "//p[text()='CPT-99453']/..//input")
    private WebElement CPT99453Checkbox;

    @FindBy(xpath = "//p[text()='CPT-99454']/..//input")
    private WebElement CPT99454Checkbox;

    @FindBy(xpath = "//p[text()='CPT-99474']/..//input")
    private WebElement CPT99474Checkbox;

    @FindBy(xpath = "//p[text()='Total Recurring Reimbursement for all Patients Per Month:']//p")
    private WebElement TRRFAPPM_Amount;

    public Actions actions;

    public void clickOnRevenueCalPage() {
        actionUtils.doClick(RevenueCAl_link);
    }

    public void scrollToZeroTo20000() {
        actionUtils.doScrollToElement(zeroto2000);
    }

    public void adjustSliderPointerTo820() {
        actionUtils.doDragAndDropBy(sliderPointer, 94, 0);
    }

    public void VerifyTheSliderPointValue(String ExpectedAmount) {
        String actualAmount = sliderPointerAmount.getText();
        actionUtils.doVerifyText(actualAmount, ExpectedAmount);
    }

    public void sendValueInSliderField(String data) {
        actionUtils.doSendKeys(sliderInputField, data);
    }

    public void clickOnCPT99091Checkbox() {
        actions=new Actions(driver);
        actions.moveToElement(CPT99091Checkbox).click(CPT99091Checkbox).perform();

    }

    public void clickOnCPT99453Checkbox() {
        actions=new Actions(driver);
        actions.moveToElement(CPT99453Checkbox).click(CPT99453Checkbox).perform();
    }

    public void clickOnCPT99454Checkbox() {
        actions=new Actions(driver);
        actions.moveToElement(CPT99454Checkbox).click(CPT99454Checkbox).perform();
    }

    public void clickOnCPT99474Checkbox() {
        actions=new Actions(driver);
        actions.moveToElement(CPT99474Checkbox).click(CPT99474Checkbox).perform();
    }

    public void verifyTotalAmount(String data) {
        String actualAmount = TRRFAPPM_Amount.getText();
        actionUtils.doVerifyText(actualAmount, data);
    }

}
