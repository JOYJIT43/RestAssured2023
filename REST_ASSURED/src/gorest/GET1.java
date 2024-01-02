package gorest;
import static org.hamcrest.Matchers.*;


import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

///// https://gorest.co.in/public-api/users/123 

public class GET1 {
		
		public static void main(String[] args) {
			
		     RestAssured.baseURI="https://gorest.co.in/public-api/";
		     
		     
		     
		     String res=given().log().all().header("Authorization",Gorest_Payload.AT)
		     .header("Content-Type","application/json")
		     .when().get("users/81")
		     .then().log().all().assertThat().statusCode(200).header("Server", "nginx").body("data.id",equalTo(81))
		     .header("Cache-Control","max-age=0, private, must-revalidate").extract().response().asString();
		     System.out.println(res);
	}
}