package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SliderPage;

public class SliderTest extends BaseTest {

    @Test(description = "Перетаскивание слайдера DemoQA")
    public void shouldDragSliderTest() {
        SliderPage page = new SliderPage(driver, wait);
        page.open();

        int initialValue = page.getSliderValue();
        System.out.println("Начальное значение: " + initialValue);

        page.dragSliderToValue();

        int finalValue = page.getSliderValue();
        System.out.println("Финальное значение: " + finalValue);

        Assert.assertTrue(finalValue > 50,
                "Слайдер переместился с " + initialValue + " до " + finalValue);
    }
}

