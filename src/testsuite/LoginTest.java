package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {

    static String baseUrl = "https://opensource-demo.orangehrmlive.com/";

    @Before
    public void setUp() {

        openBrowser(baseUrl);

    }

    @Test
    public void verifyUserShouldLoginSuccessfullyWithValidCredentials() {

        // Find the emailField and type the Email to username field
        WebElement emailField = driver.findElement(By.name("username"));
        emailField.sendKeys("Admin");

        // Find the password field and type the password to password field
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("admin123");

        // find element for submit button and click
        driver.findElement(By.xpath("//button[@type = 'submit']")).click();

        // find element to verify the redirection from the re-directed page
        String actualText = driver.findElement(By.xpath("//h6[@class = 'oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']")).getText();

        String expectedText = "Dashboard"; // expected text in the re-directed page
        Assert.assertEquals(expectedText, actualText); // verify expected and actual text
    }

    @After
    public void tearDown() {
        closeBrowser();
    }

}
