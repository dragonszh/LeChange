package com.mm.android.lc;
/*
 * Junit4
 */
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.server.handler.FindElement;

import publicOperation.checkUpdate;
import publicOperation.clearEditText;
import publicOperation.loginIn;
import publicOperation.swipeMethod;
/*
 * 三种执行顺序，DEFAULT是指，计划方法名的hash值，从小到大执行。NAME_ASCENDIND是按照命名顺序来执行，
 * JVM是按JVM返回的方法名的顺序执行，此种方式下测试方法的执行顺序是不可预测的，即每次运行的顺序可能都不一样
 */


//@FixMethodOrder(MethodSorters.DEFAULT) 
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
//@FixMethodOrder(MethodSorters.JVM) 
public class AppiumTestJunit4{
    private AndroidDriver driver;
	@BeforeClass
    public static void beforeClass(){
    	
    }
    @Before
    public void setUp() throws MalformedURLException{
    	//设置apk路径
    	File classpathRoot = new File(System.getProperty("user.dir"));
    	File appDir = new File(classpathRoot, "apps");
    	File app = new File(appDir,"LeChange.apk");
    	
    	//设置必要的参数
    	DesiredCapabilities capabilities = new DesiredCapabilities();
    	capabilities.setCapability("deviceName", "Android");
    	capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
    	capabilities.setCapability(CapabilityType.VERSION, "4.3");
    	capabilities.setCapability(CapabilityType.PLATFORM, "WINDOWS");
    	capabilities.setCapability("app",app.getAbsoluteFile());
    	capabilities.setCapability("autoLaunch", true);//默认为true
    	capabilities.setCapability("appPackage","com.mm.android.lc");
     	capabilities.setCapability("appActivity",".ui.SplashActivity");
     	capabilities.setCapability("appWaitActivity",".ui.LoginActivity");    	
    	capabilities.setCapability("unicodeKeyboard", true);
    	capabilities.setCapability("resetKeyboard", true); 	
    	//创建AndroidDriver对象
    	driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    
    @After
    public void tearDown(){
    	//System.out.println(driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS));
    	driver.quit();
    }
    @AfterClass
    public static void afterClass(){
    	
    }

    @Test
    public void test001_login() throws MalformedURLException, InterruptedException{
		//隐性等待
		//隐性等待是指当要查找元素，而这个元素没有马上出现时，告诉WebDriver查询元素的一定时间。
		//默认值是0,但是设置之后，这个时间将在WebDriver对象实例整个生命周期都起作用。
    	checkUpdate.notUpdate(driver);
    	//登录模块
    	WebElement logUserName = driver.findElementById("com.mm.android.lc:id/login_username");
    	logUserName.click();
    	logUserName.sendKeys("15858156570");
    	WebElement logPassWord = driver.findElementById("com.mm.android.lc:id/login_password");
    	logPassWord.click();
    	logPassWord.sendKeys("62273159");
    	WebElement logBtn = driver.findElementById("com.mm.android.lc:id/login_login");
    	logBtn.click();
    	//进行注销
    	WebElement menuTopLeft = driver.findElementById("com.mm.android.lc:id/my_home_title_left");
    	menuTopLeft.click();
    	WebElement headImg = driver.findElementById("com.mm.android.lc:id/head_img");
    	headImg.click();
    	WebElement logOut = driver.findElementById("com.mm.android.lc:id/logout_btn");
    	logOut.click();
    	//清空用户名框
    	logUserName.click();
    	String contextUserName = logUserName.getText();
    	System.out.println(contextUserName);
    	clearEditText.clearText(driver,contextUserName);
    	
    }
   
    @Test
    public void test002_addDevice()throws MalformedURLException, InterruptedException{
    	//检查更新
    	checkUpdate.update(driver);
    	//登录模块
    	loginIn.loginDefault(driver);
    	//等待
    	//确认历史登录信息弹出，确保已经进入HOME页
    	WebElement loginHistory = driver.findElement(By.name("上次登录:"));
    	//定义需要拖动的区间的最大控件。
    	WebElement homeGrid = driver.findElementById("com.mm.android.lc:id/my_home_grid");
    	//HOME页出现后，历史登录信息展现2.5秒，所以这里sleep3秒，等待历史登录信息显示消失。
    	Thread.sleep(3000);
        // 拖动
    	//设置控件超时等待时间1秒
    	driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
    	//判断是否存在“添加设备”的元素
    	while(driver.findElements(By.name("添加设备")).size() ==0){
    		System.out.println(driver.findElements(By.name("添加设备")).size());
    		swipeMethod.swipeUp(driver, homeGrid);
    	}
    	WebElement addDevice = driver.findElement(By.name("添加设备"));
    	addDevice.click();
    }
    
	@Ignore
	@Test
//    @Test(timeout=1000)
    public void test003_xPath()throws MalformedURLException, InterruptedException{
    	//检查更新
    	checkUpdate.update(driver);
    	//登录模块
    	loginIn.loginDefault(driver);
    	//等待
    	//确认历史登录信息弹出，确保已经进入HOME页
    	WebElement loginHistory = driver.findElement(By.name("上次登录:"));
    	//定义需要拖动的区间的最大控件。
    	WebElement homeGrid = driver.findElementById("com.mm.android.lc:id/my_home_grid");
    	//HOME页出现后，历史登录信息展现2.5秒，所以这里sleep3秒，等待历史登录信息显示消失。
    	Thread.sleep(3000);
        // 拖动
    	System.out.println(driver.findElements(By.xpath("//android.widget.GridView/*/*/android.widget.ImageView")));
    	System.out.println(driver.findElementsByXPath("//android.widget.GridView/*/*/android.widget.ImageView"));
    	System.out.println(driver.findElements(By.xpath("//android.widget.GridView/*/*/android.widget.ImageView[contains(@resource-id,'sensor_img')]")));
    	System.out.println(driver.findElementsByXPath("//android.widget.GridView/*/*/android.widget.ImageView[contains(@resource-id,'sensor_img')]"));
    	WebElement chat = driver.findElement(By.xpath("//android.widget.GridView/*/*/android.widget.ImageView[contains(@resource-id,'sensor_img')][1]"));
    	chat.click();
    }

    
	  
}