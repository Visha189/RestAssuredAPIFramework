package api.endpoints;
/*
 swagger URI--> https://petstore.swagger.io/user
 
 Create user (post) : https://petstore.swagger.io/v2
 get user (post): https://petstore.swagger.io/v2/user/{username}
 update user (put): https://petstore.swagger.io/v2/user/{username}
 delete user (delete): https://petstore.swagger.io/v2/user/{username}
 
*/
public class Routes 
{
	public static String base_Url="https://petstore.swagger.io/v2";
	
	// User Module
	public static String post_Url=base_Url+"/user";
	
	public static String get_Url=base_Url+"/user/{username}";
	
	public static String update_Url=base_Url+"/user/{username}";
	
	public static String delete_Url=base_Url+"/user/{username}";

}
