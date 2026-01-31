package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ButtonsPage;

public class ButtonsTest extends BaseTest {

    @Test(description = "Различные типы кликов: двойной, правый, динамический")
    public void shouldPerformAllClicksTest() {
        ButtonsPage page = new ButtonsPage(driver, wait);
        page.open();

        page.doubleClick();
        Assert.assertTrue(page.hasDoubleClickMessage(), "Должно появиться сообщение о двойном клике");

        page.rightClick();
        Assert.assertTrue(page.hasRightClickMessage(), "Должно появиться сообщение о правом клике");

        page.dynamicClick();
        Assert.assertTrue(page.hasDynamicClickMessage(), "Должно появиться сообщение о динамическом клике");
    }
}
