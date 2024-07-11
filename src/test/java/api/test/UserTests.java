package api.test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.EndPoints;
import api.payload.User;
import io.qameta.allure.testng.AllureTestNg;
import io.restassured.response.Response;

public class UserTests 
{
	Faker faker;
	User userpayload;
	public static Logger log;

    
    
	@BeforeClass
	public void setupData()
	{
		log= LogManager.getLogger(UserTests.class);
		log.info("Setting up data");
		faker=new Faker();
		userpayload=new User();
		userpayload.setId(faker.idNumber().hashCode());
		
		userpayload.setId(faker.idNumber().hashCode());
		userpayload.setUsername(faker.name().username());
		userpayload.setFirstName(faker.name().firstName());
		userpayload.setLastName(faker.name().lastName());
		userpayload.setEmail(faker.internet().safeEmailAddress());
		userpayload.setPassword(faker.internet().password(5, 10));
		userpayload.setPhone(faker.phoneNumber().cellPhone());
		
	}
	
	@Test(priority = 1)
	public void testPostUser()
	{
		log= LogManager.getLogger(UserTests.class);
		log.info("******* Creating User ******");
	   Response response=EndPoints.createUser(userpayload);
	   response.then().log().all();
	   
	   AssertJUnit.assertEquals(response.getStatusCode(), 200);
	   
	   log.info("******** User is Created ********");
	}
	
	@Test(priority = 2)
	public void testGetUserByName()
	{
		log= LogManager.getLogger(UserTests.class);
		
		log.info("******** Reading user Info *********");
	Response response=EndPoints.readUser(this.userpayload.getUsername());
	response.then().log().all();
	AssertJUnit.assertEquals(response.getStatusCode(), 200);
	
	log.info("******** user Info is displayed *********");
	}
	
	@Test(priority = 3)
	public void testUpdateUserByName()
	{
		log= LogManager.getLogger(UserTests.class);
		log.info("******** Updating user *********");
		//update data using payload
		userpayload.setFirstName(faker.name().firstName());
		userpayload.setLastName(faker.name().lastName());
		userpayload.setEmail(faker.internet().safeEmailAddress());
		
		
		Response response=EndPoints.updateUser(this.userpayload.getUsername(),userpayload);
		   response.then().log().body();
		   
		   AssertJUnit.assertEquals(response.getStatusCode(), 200);
		   
		   log.info("******** User is updated *********");
		   
	// checking data after update	
		   
		   Response responseAfterupdate=EndPoints.readUser(this.userpayload.getUsername());
			response.then().log().all();
			AssertJUnit.assertEquals(responseAfterupdate.getStatusCode(), 200);
		
	}
	
	
	@Test(priority = 4)
	public void testDeleteUserByName()
	{
		log= LogManager.getLogger(UserTests.class);
		log.info("********* Deleting User ********");
	Response response=EndPoints.deleteUser(this.userpayload.getUsername());
	AssertJUnit.assertEquals(response.getStatusCode(), 200);
	}
	
	
	
	
	
	
	

}
