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
    private String accessKey = "eyJ4cC51IjoxMDAyMTIsInhwLnAiOjIsInhwLm0iOiJNVFV5T1RreE16UTVOekEyTkEiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE4NDUyNzM0OTcsImlzcyI6ImNvbS5leHBlcml0ZXN0In0.M0O2U91aFY8XMYiLGpI7MaWMqcrCJIsm_aCUvjFgjJs";
    protected IOSDriver<IOSElement> driver = null;

    DesiredCapabilities dc = new DesiredCapabilities();

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability("testName", testName);
        dc.setCapability("accessKey", accessKey);
//        dc.setCapability(MobileCapabilityType.UDID, "0cacc0ade2a6869bb3578d52c58b9d7693b832bd");
        dc.setCapability("deviceQuery","@os='ios'");
        dc.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "com.experitest.ExperiBank");
        dc.setCapability(IOSMobileCapabilityType.APP_NAME,"cloud:com.experitest.ExperiBank");
        dc.setCapability("instrumentApp", true);
        driver = new IOSDriver<>(new URL("https://ukdemo.experitest.com:443/wd/hub"), dc);
        System.out.println(driver.getCapabilities().getCapability("reportUrl"));
        driver.setLogLevel(Level.INFO);
    }

    @Test
    public void testUntitled() {
        driver.findElement(By.xpath("//*[@placeholder='Username']")).sendKeys("company");
        driver.findElement(By.xpath("//*[@placeholder='Password']")).click();
        driver.findElement(By.xpath("//*[@placeholder='Password']")).sendKeys("company");
        new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='loginButton']")));
        driver.findElement(By.xpath("//*[@text='loginButton']")).click();
        driver.findElement(By.xpath("//*[@text='logoutButton']")).click();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}