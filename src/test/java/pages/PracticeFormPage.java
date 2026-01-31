package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PracticeFormPage extends BasePage {

    // ОСНОВНЫЕ ПОЛЯ
    private final By firstName = By.id("firstName");
    private final By lastName = By.id("lastName");
    private final By email = By.id("userEmail");
    private final By genderMaleLabel = By.xpath("//label[@for='gender-radio-1']");
    private final By mobile = By.id("userNumber");

    // ✅ HOBBIES - ЛЕЙБЛЫ (НЕ input!)
    private final By sportsLabel = By.xpath("//label[@for='hobbies-checkbox-1']");
    private final By readingLabel = By.xpath("//label[@for='hobbies-checkbox-2']");

    private final By dateOfBirth = By.id("dateOfBirthInput");
    private final By subjects = By.id("subjectsInput");
    private final By fileUpload = By.id("uploadPicture");
    private final By currentAddress = By.id("currentAddress");
    private final By state = By.id("react-select-3-input");
    private final By city = By.id("react-select-4-input");
    private final By submitBtn = By.id("submit");
    private final By modalHeader = By.className("modal-header");

    public PracticeFormPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void open() {
        driver.get("https://demoqa.com/automation-practice-form");
    }

    public void fillForm() {
        el(firstName).sendKeys("Иван");
        el(lastName).sendKeys("Иванов");
        el(email).sendKeys("ivan@test.com");
        click(genderMaleLabel);
        el(mobile).sendKeys("9123456789");
        el(dateOfBirth).sendKeys("26/01/2000");
        el(subjects).sendKeys("m");
        clickWithJS("//div[contains(text(),'Maths')]");
        click(sportsLabel);
        el(fileUpload).sendKeys(System.getProperty("user.dir") + "/pom.xml");
        el(currentAddress).sendKeys("Москва, ул. Тестовая 1");
        scrollToElement(submitBtn);
        click(submitBtn);
    }

    private void clickWithJS(String xpath) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", driver.findElement(By.xpath(xpath)));
    }

    private void scrollToElement(By locator) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", el(locator));
    }

    public boolean isFormSubmitted() {
        return el(modalHeader).isDisplayed();
    }
}
