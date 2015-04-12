package publicOperation;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

public class clearEditText {
	private clearEditText(){
		
	}
	
    public static void clearText(AndroidDriver driver,String contextUserName){
    	driver.sendKeyEvent(123);
//    	System.out.println(contextUserName.length());
    	for(int i = 0;i<contextUserName.length();i++){
    		driver.sendKeyEvent(AndroidKeyCode.DEL);
    	}	 
    }
    
    public static void clearText16(AndroidDriver driver){
    	driver.sendKeyEvent(123);
    	for(int i =0 ; i<16;i++){
    		driver.sendKeyEvent(AndroidKeyCode.DEL);
    	}
    }
}
