package publicOperation;

import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;

public class takeScreenShot {
	public static void screenShot(AndroidDriver driver,String photoName) throws IOException{
		File screenfileD = driver.getScreenshotAs(OutputType.FILE);
		Date now = new Date(); 
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");//可以方便地修改日期格式
		FileUtils.copyFile(screenfileD, new File("F:\\screenPicTmp\\"+dateFormat.format(now).toString()+"-"+photoName+".png"));
	}
}
