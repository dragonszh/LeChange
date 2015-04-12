package com.mm.android.lc;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import elementStore.loginPageByProperty;
import publicOperation.checkUpdate;
import publicOperation.clearEditText;
import publicOperation.loginIn;
import publicOperation.swipeMethod;
import test.DataFromCsv;


public class LeChangeTest {
    private AndroidDriver driver;
	@BeforeClass
    public static void beforeClass(){
    }
	@BeforeTest
    public void setUp() throws MalformedURLException{
    	//设置apk路径
//    	File classpathRoot = new File(System.getProperty("user.dir"));
//    	File appDir = new File(classpathRoot, "apps");
//    	File app = new File(appDir,"LeChange.apk");
    	
    	//设置必要的参数
    	DesiredCapabilities capabilities = new DesiredCapabilities();
    	capabilities.setCapability("deviceName", "Android");
    	capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "");
    	capabilities.setCapability(MobileCapabilityType.VERSION, "4.3");
    	capabilities.setCapability(MobileCapabilityType.PLATFORM, MobilePlatform.ANDROID);
    	//不启动版本匹配重新安装app
//    	capabilities.setCapability("app",app.getAbsoluteFile());
    	capabilities.setCapability("autoLaunch", true);//默认为true
    	capabilities.setCapability("appPackage","com.mm.android.lc");
     	capabilities.setCapability("appActivity",".ui.SplashActivity");
//     	capabilities.setCapability("appWaitActivity",".ui.LoginActivity");    	
    	capabilities.setCapability("unicodeKeyboard", true);
    	capabilities.setCapability("resetKeyboard", true); 	
    	//创建AndroidDriver对象
    	driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		//隐性等待
		//隐性等待是指当要查找元素，而这个元素没有马上出现时，告诉WebDriver查询元素的一定时间。
		//默认值是0,但是设置之后，这个时间将在WebDriver对象实例整个生命周期都起作用。
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    
	@AfterTest
    public void tearDown(){
    	driver.quit();
    }
    @AfterClass
    public static void afterClass(){
    }
    
    @DataProvider(name = "csvData")
    public Object[][] csvData() throws IOException{
    	File classPath = new File(System.getProperty("user.dir"));
    	File csvPath = new File(classPath,"src\\test\\java\\test\\DataFromCsv.csv");
    	return DataFromCsv.readFromCsv(csvPath.toString());
    }
    
    @Test(dataProvider = "csvData",description = "用户登录",enabled = false)
    public void test000_loginFromCsv(String username,String password,String expecteresult) throws IOException{
    	System.out.println(username+" "+password+" "+expecteresult);
    }
    
    @DataProvider(name = "loginData")
    public Object[][] loginData(){
    	return new Object[][]{
    		{"12345","123456",false},
    		{"15868482676","123456",true},
    	};
    }
    
    @Test(dataProvider = "csvData",description = "用户登录")
    public void test000_loginFromDataProvider(String username,String password,String result) throws InterruptedException{
    	//更新模块
    	checkUpdate.notUpdate(driver);
    	//如果登录先注销。
    	if(!driver.findElementsById("com.mm.android.lc:id/my_home_title_left").isEmpty()){
        	Thread.sleep(1800);
    		WebElement menuTopLeft = driver.findElementById("com.mm.android.lc:id/my_home_title_left");
        	System.out.println(driver.currentActivity());
        	menuTopLeft.click();
        	WebElement headImg = driver.findElementById("com.mm.android.lc:id/head_img");
        	headImg.click();
        	Thread.sleep(500);
        	WebElement logOut = driver.findElementById("com.mm.android.lc:id/logout_btn");
        	logOut.click();
    	}
    	//登录模块
		loginIn.loginFromCsv(driver, username, password);
    	System.out.println(driver.currentActivity());
    	Thread.sleep(2000);
//    	WebElement menuTopLeft = driver.findElementById("com.mm.android.lc:id/my_home_title_left");
    	System.out.println(driver.currentActivity());
    	boolean loginResult = (driver.currentActivity().equals(".ui.MainActivity"));
    	System.out.println(loginResult+" "+result);
    	Boolean.parseBoolean(result);
    	//断言，匹配登录结果和预期结果
    	Assert.assertEquals(loginResult, Boolean.parseBoolean(result));
    	
    	driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
    	if(!driver.findElementsById("com.mm.android.lc:id/login_login").isEmpty()){
    		loginPageByProperty.passWord(driver).click();
    		//清空密码框，最大长度16位
    		clearEditText.clearText16(driver);
    	}
    	if(driver.currentActivity().equals(".ui.MainActivity")){
    		WebElement menuTopLeft = driver.findElementById("com.mm.android.lc:id/my_home_title_left");
        	System.out.println(driver.currentActivity());
        	menuTopLeft.click();
        	WebElement headImg = driver.findElementById("com.mm.android.lc:id/head_img");
        	headImg.click();
        	WebElement logOut = driver.findElementById("com.mm.android.lc:id/logout_btn");
        	logOut.click();
        	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    	}
    }
    @Test(enabled = false)
    public void test001_loginOut() throws MalformedURLException, InterruptedException{
    	//更新模块
    	checkUpdate.notUpdate(driver);
    	//登录模块	
    	loginIn.loginDefault(driver);
    	System.out.println(driver.currentActivity());
    	//进行注销
    	WebElement menuTopLeft = driver.findElementById("com.mm.android.lc:id/my_home_title_left");
    	System.out.println(driver.currentActivity());
    	menuTopLeft.click();
    	WebElement headImg = driver.findElementById("com.mm.android.lc:id/head_img");
    	headImg.click();
    	Thread.sleep(500);
    	WebElement logOut = driver.findElementById("com.mm.android.lc:id/logout_btn");
    	logOut.click();
    	//清空用户名框
    	WebElement logUserName = driver.findElementById("com.mm.android.lc:id/login_username");
    	logUserName.click();
    	String contextUserName = logUserName.getText();
    	System.out.println(contextUserName);
    	clearEditText.clearText(driver,contextUserName);
    	System.out.println(logUserName.getText());
    	
    	Assert.assertEquals(logUserName.getText().toString(), "手机号");
    }
    
      
    @Test(enabled = false)
//    @Test(timeOut = 120000,enabled = false)
//    @Test(timeOut = 120000)
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
        // 拖动模块
    	//设置控件超时等待时间1秒,是给下滑操作有更好的找寻速度。
    	driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
    	//判断是否存在“添加设备”的元素
    	while(driver.findElements(By.name("添加设备")).size() ==0){
    		System.out.println(driver.findElements(By.name("添加设备")).size());
    		swipeMethod.swipeUp(driver, homeGrid);
    	}
    	WebElement addDevice = driver.findElement(By.name("添加设备"));
    	addDevice.click();
//    	assertThat("摄像头",hasToString(driver.findElement(By.id("com.mm.android.lc:id/add_camera_text")).getText().toString()));
    }
    
	@Test(enabled = false)
    public void test003_Chat_xPath()throws MalformedURLException, InterruptedException{
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
    	System.out.println(driver.findElement(By.xpath("//android.widget.GridView/*/*/android.widget.ImageView[contains(@resource-id,'sensor_img')]")).getLocation());
    	WebElement chat = driver.findElement(By.xpath("//android.widget.GridView/*/*/android.widget.ImageView[contains(@resource-id,'sensor_img')]"));
    	chat.click();
//    	assertThat("橙聊",hasToString(driver.findElement(By.id("com.mm.android.lc:id/title_center")).getText().toString()));
    	Assert.assertEquals(driver.findElement(By.id("com.mm.android.lc:id/title_center")).getText().toString(), "橙聊");
	}
	

	@Test(enabled = false)
	public void test004_AlarmPIR() throws InterruptedException{
		//检测更新模块，一经提示，点击“暂不更新”
		checkUpdate.notUpdate(driver);
		//登录模块
		loginIn.loginDefault(driver);
		WebElement alarmButton = driver.findElement(By.id("android:id/button1"));
		alarmButton.click();
		WebElement refreshFrame = driver.findElement(By.id("com.mm.android.lc:id/refresh_layout"));
//		//加载报警页面
		Thread.sleep(1500);
		//进行下拉刷新10次的操作，查看程序是否会出异常
		for(int i = 0;i<10;i++){
			swipeMethod.swipeDown(driver, refreshFrame);
		}
//		assertThat("编辑", hasToString(driver.findElement(By.id("com.mm.android.lc:id/edit_more")).getText().toString()));
		Assert.assertEquals(driver.findElement(By.id("com.mm.android.lc:id/edit_more")).getText().toString(), "编辑");

	}
	

	@Test(enabled = false)
	public void test005_loadingAllAlarmMsg() throws InterruptedException{
		//检测更新模块，一经提示，点击“暂不更新”
		checkUpdate.notUpdate(driver);
		//登录模块
		loginIn.loginDefault(driver);
		//点击报警图标，进入报警页面。
		WebElement alarmButton = driver.findElement(By.id("android:id/button1"));
		alarmButton.click();
		//获取报警消息框的控件元素，用来给下拉时，提供对象。
		WebElement refreshFrame = driver.findElement(By.id("com.mm.android.lc:id/refresh_layout"));	
		System.out.println(driver.findElement(By.xpath("//android.widget.ListView/android.widget.LinearLayout[last()]//android.widget.TextView[contains(@resource-id,':id/time')]")).getText().toString());
//		if(driver.findElements(By.name("1感应到人体活动1")).isEmpty()){
			int count = 0;
			String compareText = "";
			while(count !=6 ){			
				String lastTimeText =driver.findElement(By.xpath("//android.widget.ListView/android.widget.LinearLayout[last()]/descendant::android.widget.TextView[contains(@resource-id,':id/time')]")).getText().toString();		
//				String lastTimeText = driver.findElement(By.xpath("//android.widget.TextView[contains(@resource-id,'id/time') and position()=2]")).getText().toString();
				String firstTimeText = driver.findElement(By.xpath("//android.widget.LinearLayout/*/*/*/*/android.widget.TextView[contains(@resource-id,':id/time')][1]")).getText().toString();
				System.out.println("new"+driver.findElements(By.xpath("//android.widget.TextView[contains(@resource-id,'id/time')]")));
				List<WebElement> elementsTime = driver.findElements(By.xpath("//android.widget.TextView[contains(@resource-id,'id/time')]"));
				//使用for each 列举集合中的元素
				for(WebElement s:elementsTime){
					System.out.println(s.getText().toString());
				}
				System.out.println("---------------------------------");
				System.out.println("---------------------------------");
				System.out.println("last: "+lastTimeText);
				System.out.println("first: "+firstTimeText);
				System.out.println("---------------------------------");
				System.out.println("---------------------------------");
				//下拉刷新
				swipeMethod.swipeUp(driver, refreshFrame);
				//等待加载新报警
				Thread.sleep(1800);
				if(compareText.equals(lastTimeText)){
					count ++;
					System.out.println("等于的时候");
					System.out.println("last: "+lastTimeText);
					System.out.println("compareText: "+compareText);
					System.out.println("---------------------------------");
				}else{
					System.out.println("不等的时候");
					System.out.println("last: "+lastTimeText);
					System.out.println("compareText: "+compareText);
					System.out.println("---------------------------------");
					compareText = lastTimeText;
					count = 0;
				}
				Thread.sleep(200);
			}
//		}
//		assertThat("编辑", equalTo(driver.findElement(By.id("com.mm.android.lc:id/edit_more")).getText().toString()));
//		assertThat("编辑", hasToString(driver.findElement(By.id("com.mm.android.lc:id/edit_more")).getText().toString()));
		Assert.assertEquals(driver.findElement(By.id("com.mm.android.lc:id/edit_more")).getText().toString(), "编辑");
	}
	
	@Test(enabled = false)
	public void test006_markUnreadAlarmMsg() throws InterruptedException{
		//检测更新
		checkUpdate.notUpdate(driver);
		//检测是否需要自动登录
		loginIn.loginDefault(driver);
		//获取当前的报警条数,并赋值给中间值compare
		String alarmMsgNum = driver.findElement(By.id("android:id/text1")).getText().toString();
		String compareNum = alarmMsgNum;
		//点击报警图标，进入报警页面。
		WebElement alarmButton = driver.findElement(By.id("android:id/button1"));
		alarmButton.click();
		//获取报警消息框的控件元素，用来给下拉时，提供对象。
		WebElement refreshFrame = driver.findElement(By.id("com.mm.android.lc:id/refresh_layout"));	
		while(driver.findElements(By.id("com.mm.android.lc:id/new_icon")).isEmpty()){
			//下拉刷新
			swipeMethod.swipeUp(driver, refreshFrame);
		}
		WebElement unreadMsg = driver.findElement(By.id("com.mm.android.lc:id/new_icon"));
		unreadMsg.click();
		//判断是否进入了报警录像回放页面
		while(!driver.findElements(By.id("com.mm.android.lc:id/title_left")).isEmpty()){
			WebElement backToMsg = driver.findElement(By.id("com.mm.android.lc:id/title_left"));
			backToMsg.click();
		}
		WebElement backToHome = driver.findElement(By.id("android:id/up"));
		backToHome.click();
		alarmMsgNum = driver.findElement(By.id("android:id/text1")).getText().toString();
//		assertThat(compareNum, not(alarmMsgNum));
		Assert.assertNotEquals(compareNum, alarmMsgNum);
	}
}