package test;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DataFromXML {
 
//数据导入方式一：
	@Test
	@Parameters("username")
	public void inputUsername(String username) {
			System.out.println("Input Username: " + username);
			Assert.assertEquals("root", username);
	}

	@Test
	@Parameters("password")  
	public void inputPassword(String password) {
		System.out.println("Input Password: " + password);
		Assert.assertEquals("pwd2", password);
	}

}
