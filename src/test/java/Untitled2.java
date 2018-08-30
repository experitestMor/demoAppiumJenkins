//package <set your test package>;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.By;
import org.testng.annotations.*;
import java.net.URL;
import java.net.MalformedURLException;
import java.util.logging.Level;

public class Untitled2 {
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "Jenkins iOS";
    private String accessKey = "eyJ4cC51IjoxMzY1NDgsInhwLnAiOjIsInhwLm0iOiJNQSIsImFsZyI6IkhTMjU2In0.eyJleHAiOjE4NDczNTk3OTIsImlzcyI6ImNvbS5leHBlcml0ZXN0In0.VqFw1Fbd_W0kPMvrHCNgQSZCnKhRrNkk14la1HrAPso";
    protected IOSDriver<IOSElement> driver = null;

    DesiredCapabilities dc = new DesiredCapabilities();

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability("testName", testName);
        dc.setCapability("accessKey", accessKey);
//        dc.setCapability(MobileCapabilityType.UDID, "0cacc0ade2a6869bb3578d52c58b9d7693b832bd");
        dc.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "com.experitest.ExperiBank");
        driver = new IOSDriver<>(new URL("https://sales.experitest.com:443/wd/hub"), dc);
        driver.setLogLevel(Level.INFO);
    }

    @Test
    public void testUntitled() {
        driver.findElement(By.xpath("//*[@placeholder='Username']")).sendKeys("company");
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@placeholder='Password']")));
        driver.findElement(By.xpath("//*[@placeholder='Password']")).sendKeys("company");
        driver.findElement(By.xpath("//*[@text='loginButton']")).click();
        driver.findElement(By.xpath("//*[@class='UIAView' and ./*[@class='UIAView' and ./*[@text='Your balance is: ']]]")).click();
        driver.findElement(By.xpath("//*[@text='makePaymentButton']")).click();
        driver.findElement(By.xpath("//*[@text='sendPaymentButton']")).click();
        driver.findElement(By.xpath("//*[@text='cancelButton']")).click();
        driver.findElement(By.xpath("//*[@text='Mortgage Request']")).click();
        driver.findElement(By.xpath("//*[@text='nextButton']")).click();
        driver.findElement(By.xpath("//*[@text='5']")).click();
        driver.findElement(By.xpath("//*[@text='backButton']")).click();
        driver.findElement(By.xpath("//*[@text='scrollView']")).click();
        driver.findElement(By.xpath("//*[@text='cancelButton']")).click();
        driver.findElement(By.xpath("//*[@text='logoutButton']")).click();
        driver.executeScript("seetest:client.deviceAction(\"Home\")");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}