package publicOperation;

import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import elementStore.loginPageByProperty;

public class checkUpdate {
	private checkUpdate(){
		
	}
	public static void notUpdate(AndroidDriver driver){
		//暂不更新
//		if(driver.findElements(By.name("暂不更新")).size() != 0){
		System.out.println("加载static的 notUpdate");
		if(!driver.findElements(By.name("暂不更新")).isEmpty()){
//			WebElement notUpdate = driver.findElement(By.name("暂不更新"));
			loginPageByProperty.updateLater(driver).click();
		}
	}
	
	public static void update(AndroidDriver driver){
		//更新
		if(driver.findElements(By.name("更新")).size() != 0){
			WebElement update = driver.findElement(By.name("更新"));
			update.click();
		}
	}
}