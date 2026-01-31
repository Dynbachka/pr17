package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.UploadPage;

import java.io.File;

public class UploadTest extends BaseTest {

    @Test(description = "Загрузка файла")
    public void shouldUploadFileTest() {
        File testFile = new File("src/test/resources/test-file.txt");

        UploadPage page = new UploadPage(driver, wait);
        page.open();
        page.uploadFile(testFile.getAbsolutePath());

        Assert.assertTrue(page.isFileUploaded(),
                "Путь к загруженному файлу должен отобразиться");
        Assert.assertTrue(page.getUploadedPath().contains("test-file.txt"),
                "Имя файла должно быть в пути");
    }
}
