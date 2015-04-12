package publicOperation;

import org.openqa.selenium.WebElement;

import elementStore.loginPageByProperty;
import io.appium.java_client.android.AndroidDriver;

public class loginIn {
	private loginIn(){
		
	}

	public static void loginDefault(AndroidDriver driver){
    	if(driver.findElementsById("com.mm.android.lc:id/my_home_title_left").isEmpty()){
    		WebElement logUserName = driver.findElementById("com.mm.android.lc:id/login_username");
    		logUserName.click();
//        	logUserName.sendKeys("15858156570");
    		String contentlogUserName = logUserName.getText();
    		clearEditText.clearText(driver, contentlogUserName);
    		logUserName.sendKeys("15868482676");
        	WebElement logPassWord = driver.findElementById("com.mm.android.lc:id/login_password");
        	logPassWord.click();
//        	logPassWord.sendKeys("62273159");
        	logPassWord.sendKeys("123456");
        	WebElement logBtn = driver.findElementById("com.mm.android.lc:id/login_login");
        	logBtn.click();
    	}
	}
	
	public static void loginModifyPassWord(AndroidDriver driver){
		if(driver.findElementsById("com.mm.android.lc:id/my_home_title_left").isEmpty()){
	    	WebElement logUserName = driver.findElementById("com.mm.android.lc:id/login_username");
	    	logUserName.click();
	    	logUserName.sendKeys("15858156570");
	    	WebElement logPassWord = driver.findElementById("com.mm.android.lc:id/login_password");
	    	logPassWord.click();
	    	logPassWord.sendKeys("123456");
	    	WebElement logBtn = driver.findElementById("com.mm.android.lc:id/login_login");
	    	logBtn.click();
		}
	}
	
	
	public static void loginFromCsv(AndroidDriver driver,String username,String password){
    	if(driver.findElementsById("com.mm.android.lc:id/my_home_title_left").isEmpty()){
    		loginPageByProperty.userName(driver).click();
    		String contentlogUserName = loginPageByProperty.userName(driver).getText();
    		clearEditText.clearText(driver, contentlogUserName);
    		loginPageByProperty.userName(driver).sendKeys(username);
    		loginPageByProperty.passWord(driver).click();
    		loginPageByProperty.passWord(driver).sendKeys(password);
    		loginPageByProperty.loginBtn(driver).click();
    	}
	}
}
