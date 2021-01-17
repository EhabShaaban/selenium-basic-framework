package fileupload;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.FileUploadPage;

import static org.testng.Assert.assertEquals;

public class FIleUploadTests extends BaseTests {
    @Test
    public void testFileUpload(){
        FileUploadPage uploadPage = homePage.clickFileUpload();
        uploadPage.uploadFile("/home/ehab/Development/AutomationUFramework/resources/chromedriver");
        assertEquals(uploadPage.getUploadedFiles(), "chromedriver", "File is not uploaded correctly");
    }
}
