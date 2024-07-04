package api.endpoints;
import static io.restassured.RestAssured.given;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
// Created to perform Create, Read, Update, Delete Requests to the User API

public class EndPoints 
{
	public static Response createUser(User Payload)
	{
	Response response=given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(Payload)
		.when()
		.post(Routes.post_Url);
	return response;
	}
	
	public static Response readUser(String userName)
	{
	Response response=given()
			.pathParam("username", userName)
		.when()
		.get(Routes.get_Url);
	return response;
	}
	
	public static Response updateUser(String userName, User Payload)
	{
	Response response=given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.pathParam("username", userName)
		.body(Payload)
		.when()
		.put(Routes.update_Url);
	return response;
	}
	
	public static Response deleteUser(String userName)
	{
	Response response=given()
			.pathParam("username", userName)
		.when()
		.delete(Routes.delete_Url);
	return response;
	}

}
