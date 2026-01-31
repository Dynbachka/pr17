package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TextBoxPage;

public class TextBoxTest extends BaseTest {

    @Test(description = "Позитив: Заполнение Text Box валидными данными")
    public void shouldSubmitValidDataTest() {
        TextBoxPage page = new TextBoxPage(driver, wait);
        page.open();
        page.fill("Иванов Иван", "ivan@test.ru", "Москва", "СПб");

        Assert.assertTrue(page.isOutputVisible(),
                "Блок результатов должен появиться после отправки формы");
    }

    @Test(description = "Негатив: Невалидный email в Text Box")
    public void shouldHighlightInvalidEmailTest() {
        TextBoxPage page = new TextBoxPage(driver, wait);
        page.open();
        page.fill("Иванов Иван", "invalid-email", "Москва", "СПб");

        Assert.assertTrue(page.isEmailInvalid(),
                "Поле email должно подсветиться красным при невалидном формате");
    }
}
