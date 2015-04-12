package com.mm.android.lc;

import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import publicOperation.checkUpdate;
import publicOperation.loginIn;

public class CalculatorTest {

	private AndroidDriver driver;



		public interface SmokeTests{
			
		}
		
		public interface SlowTests{
			
		}
		
		
		@BeforeClass
		public static void setUpBeforeClass() throws Exception {
			System.out.println("BeforeClass");
		}

		@AfterClass
		public static void tearDownAfterClass() throws Exception {
			System.out.println("AfterClass");
		}

		@Before
		public void setUp() throws Exception {
			System.out.println("Before");
		}

		@After
		public void tearDown() throws Exception {
			System.out.println("After");
		}

		public CalculatorTest(){
			System.out.println("无参构造函数");
		}
		
		@Category(SmokeTests.class)
		@Test
		public void testAdd1() {
			System.out.println("testAdd1");
		}
		
		@Category(SlowTests.class)
		@Test
		public void testAdd2() throws Exception {
			Thread.sleep(1000);
			System.out.println("testAdd2");
//			assertThat(1003.14, is());
		}
		
		@Category(SlowTests.class)
		@Test
		public void testAdd3() throws Exception {
			Thread.sleep(2000);
			System.out.println("testAdd3");
//			assertThat(2003.14, is(new Calculator().add(3.14, 2000)));
		}
		
		@Ignore
		@Test
		public void testMinus() {
			System.out.println("testMinus");
//			assertThat(0.0, is(new Calculator().minus(3.14, 3.14)));
		}
		
		@Test(timeout=1000)
		public void testMultiply() throws Exception {
			Thread.sleep(2000);
			System.out.println("testMultiply");
//			assertThat(3.14, is(new Calculator().multiply(3.14, 1.0)));
		}
		
		@Test(expected=ArithmeticException.class)
		public void testDivision() {
			System.out.println("testMultiply expected=ArithmeticException.class");
//			new Calculator().division(3.14, 0.0);
		}
		
		@Ignore
		@Test
//	    @Test(timeout=1000)
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
//	    			(By.xpath("//GridView/*/*/ImageView"));
	    }
		
	}