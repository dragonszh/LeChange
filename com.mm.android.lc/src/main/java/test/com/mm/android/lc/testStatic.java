package test.com.mm.android.lc;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.apache.commons.io.*;

import elementStore.loginPageByProperty;
import publicOperation.checkUpdate;
import publicOperation.takeScreenShot;
import test.DataFromCsv;



public class testStatic {
	 private AndroidDriver driver;

	@BeforeTest(enabled = false)
    public void setUp() throws MalformedURLException{
    	//设置apk路径
//	    	File classpathRoot = new File(System.getProperty("user.dir"));
//	    	File appDir = new File(classpathRoot, "apps");
//	    	File app = new File(appDir,"LeChange.apk");
    	
    	//设置必要的参数
    	DesiredCapabilities capabilities = new DesiredCapabilities();
    	capabilities.setCapability("deviceName", "Android");
    	capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "");
    	capabilities.setCapability(MobileCapabilityType.VERSION, "4.3");
    	capabilities.setCapability(MobileCapabilityType.PLATFORM, MobilePlatform.ANDROID);
    	//不启动版本匹配重新安装app
//	    	capabilities.setCapability("app",app.getAbsoluteFile());
    	capabilities.setCapability("autoLaunch", true);//默认为true
    	capabilities.setCapability("appPackage","com.mm.android.lc");
     	capabilities.setCapability("appActivity",".ui.SplashActivity");
//	     	capabilities.setCapability("appWaitActivity",".ui.LoginActivity");    	
    	capabilities.setCapability("unicodeKeyboard", true);
    	capabilities.setCapability("resetKeyboard", true); 	
    	//创建AndroidDriver对象
    	driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		//隐性等待
		//隐性等待是指当要查找元素，而这个元素没有马上出现时，告诉WebDriver查询元素的一定时间。
		//默认值是0,但是设置之后，这个时间将在WebDriver对象实例整个生命周期都起作用。
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
	
	@AfterTest(enabled = false)
	public void teardown(){
		driver.quit();
	}
	
	@DataProvider(name = "csvData")
	public Object[][] csvData() throws IOException{
		File classPath = new File(System.getProperty("user.dir"));
		File csvPath = new File(classPath,"src\\test\\java\\test\\DataFromCsv.csv");
		return DataFromCsv.readFromCsv(csvPath.toString());
	}

//	@Test(dataProvider = "csvData")
	@Test(enabled = false)
	public void test000() throws MalformedURLException{
		checkUpdate.notUpdate(driver);
	}
	
	@Test(enabled = false)
	public void  test001() throws InterruptedException, IOException{
		checkUpdate.notUpdate(driver);
		loginPageByProperty.userName(driver).click();
		loginPageByProperty.userName(driver).sendKeys("15868482676");
		loginPageByProperty.passWord(driver).click();
		loginPageByProperty.passWord(driver).sendKeys("1234567");
		loginPageByProperty.loginBtn(driver).click();
		Thread.sleep(500);
		takeScreenShot.screenShot(driver, "密码错误");
	}
	
	@Test(groups = {"1","2"})
	public void test0001(){
		Assert.assertTrue(true);
	}
	
	@Test(groups = {"1"})
	public void test0002(){
		Assert.assertTrue(false);
	}
	
	@Test(groups = {"1"},dependsOnMethods = {"test0002"})
	public void test0003(){
		Assert.assertTrue(true);
	}
	
	@Test(groups = {"2"},alwaysRun =  true)
	public void test0004(){
		Assert.assertTrue(true);
	}
	
	@Test(groups = {"2"})
	public void test0005(){
		Assert.assertTrue(true);
	}
	
	@Test
	public boolean test0006(){
		Assert.assertTrue(true);
		return true;
	}
	
}
