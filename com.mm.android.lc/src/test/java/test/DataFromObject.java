package test;

import org.junit.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


//方式二：
public class DataFromObject {
	
	//被测对象
    public Boolean validate(Integer primeNumber) {
        for (int i = 2; i < (primeNumber / 2); i++) {
            if (primeNumber % i == 0) {
                return false;
             }
        }
        return true;
    }

	@DataProvider(name ="data")
	public  Object[][] getData(){
		return new Object[][]{
			{2,true},
			{6,false},
			{19,true},
	        {22,false},
	        {23,true}
		};
	}
	
	@Test(dataProvider = "data")
	public void test(int a,boolean b){
		System.out.println(a+"  "+b);
		Assert.assertEquals(b,validate(a));
	}
}
