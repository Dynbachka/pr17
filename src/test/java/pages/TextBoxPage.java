package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TextBoxPage extends BasePage {
    private final By userName = By.id("userName");
    private final By userEmail = By.id("userEmail");
    private final By currentAddress = By.id("currentAddress");
    private final By permanentAddress = By.id("permanentAddress");
    private final By submit = By.id("submit");
    private final By output = By.id("output");

    public TextBoxPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void open() {
        driver.get("https://demoqa.com/text-box");
    }

    public void fill(String name, String email, String currAddr, String permAddr) {
        sendKeys(userName, name);
        sendKeys(userEmail, email);
        sendKeys(currentAddress, currAddr);
        sendKeys(permanentAddress, permAddr);
        click(submit);
    }

    public boolean isOutputVisible() {
        return el(output).isDisplayed();
    }

    public boolean isEmailInvalid() {
        WebElement emailField = driver.findElement(userEmail);
        return emailField.getAttribute("class").contains("error");
    }
}
