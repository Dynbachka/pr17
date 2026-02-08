package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PracticeFormPage;

public class PracticeFormTest extends BaseTest {

    @Test(description = "Полная форма регистрации DemoQA")
    public void shouldFillPracticeFormTest() {
        PracticeFormPage page = new PracticeFormPage(driver, wait);
        page.open();
        page.fillForm();
        Assert.assertTrue(page.isFormSubmitted(),
                "Модальное окно подтверждения должно появиться");
    }
}
