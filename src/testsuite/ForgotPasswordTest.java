package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class ForgotPasswordTest extends BaseTest {

    static String baseUrl = "https://opensource-demo.orangehrmlive.com/";

    @Before
    public void setUp() {

        openBrowser(baseUrl);

    }

    @Test
    public void userShouldNavigateToForgotPasswordPageSuccessfully(){
        // find the link element and click
        driver.findElement(By.xpath("//p[@class = 'oxd-text oxd-text--p orangehrm-login-forgot-header']")).click();

        // find element to verify the redirection from the re-directed page
        String actualText = driver.findElement(By.xpath("//h6[@class = 'oxd-text oxd-text--h6 orangehrm-forgot-password-title']")).getText();

        String expectedText = "Reset Password"; // expected text in the re-directed page

        Assert.assertEquals(expectedText, actualText); // verify expected and actual text
    }


    @After
   public void tearDown() {
        closeBrowser();
    }

}
