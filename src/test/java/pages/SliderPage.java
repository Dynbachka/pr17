package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SliderPage extends BasePage {

    private final By sliderContainer = By.id("sliderContainer");
    private final By sliderInput = By.cssSelector("input[type='range'].range-slider");
    private final By sliderValueInput = By.id("sliderValue");

    public SliderPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void open() {
        driver.get("https://demoqa.com/slider");
    }

    public void dragSliderToValue() {
        wait.until(d -> driver.findElements(sliderContainer).size() > 0);

        WebElement slider = driver.findElement(sliderInput);
        Actions actions = new Actions(driver);
        actions.dragAndDropBy(slider, 50, 0).perform();
    }

    public int getSliderValue() {
        WebElement valueField = driver.findElement(sliderValueInput);
        return Integer.parseInt(valueField.getAttribute("value"));
    }
}
