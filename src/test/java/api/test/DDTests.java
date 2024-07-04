package api.test;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.EndPoints;
import api.payload.User;
import api.utilities.DP;
import io.restassured.response.Response;

public class DDTests 
{
	@Test(priority = 1, dataProvider = "Data", dataProviderClass = DP.class)
	public void testpostuser(String userID, String userName, String fname, String lname, String useremail, String pwd, String ph)
	{
		User userpayload=new User();
		
		userpayload.setId(Integer.parseInt(userID));
		userpayload.setUsername(userName);
		userpayload.setFirstName(fname);
		userpayload.setLastName(lname);
		userpayload.setEmail(useremail);
		userpayload.setPassword(pwd);
		userpayload.setPhone(ph);
		
		
	}

}
