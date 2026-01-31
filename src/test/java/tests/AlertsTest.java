package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AlertsPage;

public class AlertsTest extends BaseTest {

    @Test(description = "Работа с Confirm и Prompt алертами DemoQA")
    public void shouldHandleConfirmPromptTest() {
        AlertsPage page = new AlertsPage(driver, wait);
        page.open();

        page.openConfirmAlert();
        page.dismissAlert();
        Assert.assertEquals(page.getConfirmResult(), "You selected Cancel",
                "Confirm alert должен вернуть 'Cancel'");

        page.openPromptAlert();
        page.sendKeysToPrompt("Test Input");
        page.acceptAlert();
        Assert.assertTrue(page.getPromptResult().contains("Test Input"),
                "Prompt должен содержать введенный текст");
    }
}
