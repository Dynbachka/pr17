package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ButtonsPage extends BasePage {
    private final By doubleClickBtn = By.id("doubleClickBtn");
    private final By rightClickBtn = By.id("rightClickBtn");
    private final By dynamicBtn = By.xpath("//button[text()='Click Me']");
    private final By doubleClickMessage = By.id("doubleClickMessage");
    private final By rightClickMessage = By.id("rightClickMessage");
    private final By dynamicClickMessage = By.id("dynamicClickMessage");

    public ButtonsPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void open() {
        driver.get("https://demoqa.com/buttons");
    }

    public void doubleClick() {
        WebElement btn = el(doubleClickBtn);
        new Actions(driver).doubleClick(btn).perform();
    }

    public void rightClick() {
        WebElement btn = el(rightClickBtn);
        new Actions(driver).contextClick(btn).perform();
    }

    public void dynamicClick() {
        wait.until(org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable(dynamicBtn));
        click(dynamicBtn);
    }

    public boolean hasDoubleClickMessage() {
        return el(doubleClickMessage).isDisplayed();
    }

    public boolean hasRightClickMessage() {
        return el(rightClickMessage).isDisplayed();
    }

    public boolean hasDynamicClickMessage() {
        return el(dynamicClickMessage).isDisplayed();
    }
}
