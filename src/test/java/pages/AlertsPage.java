package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertsPage extends BasePage {
    private final By confirmAlertBtn = By.id("confirmButton");
    private final By promptAlertBtn = By.id("promtButton");
    private final By confirmResult = By.id("confirmResult");
    private final By promptResult = By.id("promptResult");

    public AlertsPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void open() {
        driver.get("https://demoqa.com/alerts");
    }

    public void openConfirmAlert() {
        click(confirmAlertBtn);
    }

    public void openPromptAlert() {
        click(promptAlertBtn);
    }

    public void acceptAlert() {
        wait.until(ExpectedConditions.alertIsPresent()).accept();
    }

    public void dismissAlert() {
        wait.until(ExpectedConditions.alertIsPresent()).dismiss();
    }

    public void sendKeysToPrompt(String text) {
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.sendKeys(text);
    }

    public String getConfirmResult() {
        return el(confirmResult).getText();
    }

    public String getPromptResult() {
        return el(promptResult).getText();
    }
}
