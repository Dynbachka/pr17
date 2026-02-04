package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UploadPage extends BasePage {
    private final By uploadInput = By.id("uploadFile");
    private final By uploadedFilePath = By.id("uploadedFilePath");

    public UploadPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void open() {
        driver.get("https://demoqa.com/upload-download");
    }

    public void uploadFile(String filePath) {
        driver.findElement(uploadInput).sendKeys(filePath);
    }

    public boolean isFileUploaded() {
        return el(uploadedFilePath).isDisplayed();
    }

    public String getUploadedPath() {
        return el(uploadedFilePath).getText();
    }
}
