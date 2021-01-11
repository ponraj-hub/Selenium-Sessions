package seleniumPrograms;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftHardAssertion {

	SoftAssert SoftAssert=new SoftAssert();
	@Test
	public void Assertion() {
		System.out.println("open browser");
		//Hard assertion(its terminated)
		Assert.assertEquals(true, false,"enter into the url");
		System.out.println("enter url");
		//Soft assertion(run till end)
		SoftAssert.assertEquals(true, false,"enter username and password");
		System.out.println("enter username");
		System.out.println("enter password");
		System.out.println("click login");
		SoftAssert.assertEquals(true, false,"not going to home page");
		System.out.println("click homepage");
		SoftAssert.assertAll();
	}

}
