//package <set your test package>;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.android.AndroidKeyCode;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.By;
import org.testng.annotations.*;
import java.net.URL;
import java.net.MalformedURLException;
import java.util.logging.Level;

public class Untitled {
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "Jenkins Android";
    private String accessKey = "eyJ4cC51IjoxMzY1NDgsInhwLnAiOjIsInhwLm0iOiJNQSIsImFsZyI6IkhTMjU2In0.eyJleHAiOjE4NDY1ODg1NTQsImlzcyI6ImNvbS5leHBlcml0ZXN0In0.yJrbvQhXxRMu5CzZOjLw2hUXqyDejrQkO-lC7WROGKw";
    protected AndroidDriver<AndroidElement> driver = null;

    DesiredCapabilities dc = new DesiredCapabilities();

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability("testName", testName);
        dc.setCapability("accessKey", accessKey);
        dc.setCapability("deviceQuery", "@os='android'");
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.experitest.ExperiBank");
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".LoginActivity");
        dc.setCapability("instrumentApp", true);
        driver = new AndroidDriver<>(new URL("https://sales.experitest.com:443/wd/hub"), dc);
        driver.setLogLevel(Level.INFO);
    }

    @Test
    public void testUntitled() {
        driver.findElement(By.xpath("//*[@hint='Username']")).click();
        new WebDriverWait(driver, 60).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@hint='Username']")));
        driver.findElement(By.xpath("//*[@hint='Username']")).click();
        new WebDriverWait(driver, 120).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@hint='Username']")));
        driver.findElement(By.xpath("//*[@hint='Username']")).sendKeys("company");
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@hint='Password']")));
        driver.findElement(By.xpath("//*[@hint='Password']")).sendKeys("company");
        driver.findElement(By.xpath("//*[@text='Login']")).click();
        driver.findElement(By.xpath("//*[@text='Make Payment']")).click();
        driver.findElement(By.xpath("//*[@text='Cancel']")).click();
        driver.findElement(By.xpath("//*[@text='Expense Report']")).click();
        driver.findElement(By.xpath("//*[@text='Back']")).click();
        driver.findElement(By.xpath("//*[@text='Logout']")).click();
        driver.pressKeyCode(AndroidKeyCode.HOME);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}