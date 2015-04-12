package elementStore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;

public class loginPageByProperty {
	
	//更新页面获取更新键
	public static WebElement updateNow(AndroidDriver driver){
		WebElement updateNow = driver.findElement(By.id("更新"));
		return updateNow;
	}
	//更新页面获取暂不更新键
	public static WebElement updateLater(AndroidDriver driver){
		
		WebElement updateLater = driver.findElement(By.name("暂不更新"));
		System.out.println("-------final static ----------");
		System.out.println(updateLater);
		System.out.println("-------------------------------");
//		updateLater.click();
		return updateLater;
	}
	//强制更新时，获取退出键。
	public static WebElement updateExit(AndroidDriver driver){
		WebElement updateExit = driver.findElement(By.name("退出"));
		return updateExit;
	}
	//登录页面获取用户名输入框
	public static WebElement userName(AndroidDriver driver){
		WebElement username = driver.findElement(By.id("com.mm.android.lc:id/login_username"));
		return username;
	}
	//登录页面获取密码输入框
	public static WebElement passWord(AndroidDriver driver){
		WebElement password = driver.findElement(By.id("com.mm.android.lc:id/login_password"));
		return password;
	}
	//登录页面获取登录键
	public static WebElement loginBtn(AndroidDriver driver){
		WebElement loginbtn = driver.findElement(By.id("com.mm.android.lc:id/login_login"));
		return loginbtn;
	}
	//登录页面获取忘记密码键
	public static WebElement forgetBtn(AndroidDriver driver){
		WebElement forgetbtn = driver.findElement(By.id("com.mm.android.lc:id/login_forget"));
		return forgetbtn;
	}
	//登录页面获取注册键
	public static WebElement registerBtn(AndroidDriver driver){
		WebElement registerbtn = driver.findElement(By.id("com.mm.android.lc:id/login_register"));
		return registerbtn;
	}
	//登录页面获取“微信登录”键
	public static WebElement webChatBtn(AndroidDriver driver){
		WebElement webChatbtn = driver.findElement(By.name("微信登录"));
		return webChatbtn;
	}
}
