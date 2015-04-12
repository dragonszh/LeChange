package publicOperation;

import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.WebElement;

public class swipeMethod {
	swipeMethod(){
		
	}
	static int LocX = 0;
	static int LocY = 0;
	static int Width = 0;
	static int Height = 0;
	static int StartX = 0;
	static int StartY = 0;
	static int EndX = 0;
	static int EndY = 0;
	public static void swipeLeft(AndroidDriver driver,WebElement element){
		LocX = element.getLocation().getX();
		LocY = element.getLocation().getY();
		Width = element.getSize().width;
		Height = element.getSize().width;
		StartX = (int) (LocX+Width*0.5);
		StartY = LocY+Height/2;
		EndX = LocX;
		EndY = LocY+Height/2;
		driver.swipe(StartX, StartY, EndX, EndY, 200);
	}
	public static void swipeRight(AndroidDriver driver,WebElement element){
		LocX = element.getLocation().getX();
		LocY = element.getLocation().getY();
		Width = element.getSize().width;
		Height = element.getSize().width;
		StartX = LocX; 
		StartY = LocY+Height/2;
		EndX = (int)(LocX+Width*0.5);
		EndY = LocY+Height/2;
		driver.swipe(StartX, StartY, EndX, EndY, 200);
	}
	public static void swipeUp(AndroidDriver driver,WebElement element){
		LocX = element.getLocation().getX();
		LocY = element.getLocation().getY();
		Width = element.getSize().width;
		Height = element.getSize().width;
		StartX = (LocX+Width/2);
		StartY = (int) (LocY+Height*0.5);
		EndX = (LocX+Width/2);
		EndY = LocY;
		driver.swipe(StartX, StartY, EndX, EndY, 200);
	}
	public static void swipeDown(AndroidDriver driver,WebElement element){
		LocX = element.getLocation().getX();
		LocY = element.getLocation().getY();
		Width = element.getSize().width;
		Height = element.getSize().width;
		StartX = (LocX+Width/2);
		StartY = LocY;
		EndX = (LocX+Width/2);
		EndY = (int) (LocY+Height*0.5);
		driver.swipe(StartX, StartY, EndX, EndY, 200);
	}
}
