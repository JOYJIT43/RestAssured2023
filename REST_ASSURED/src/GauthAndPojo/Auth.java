package GauthAndPojo;

import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import DePojo.Response;

public class Auth {
	
	public static void main(String[] args)
	{
		
		//The code should be extracted manually by entering the uname and password or using selenium on the rahul shetty sign in with google page 
		//and all the details will be provided by the api contract
		// https://accounts.google.com/o/oauth2/v2/auth?scope=https://www.googleapis.com/auth/userinfo.email&auth_url=https://accounts.google.com/o/oauth2/v2/auth&client_id=692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com&response_type=code&redirect_uri=https://rahulshettyacademy.com/getCourse.php
		// by hitting the above URL we will get the below code from google authorization server
		String url = "https://rahulshettyacademy.com/getCourse.php?code=4%2F0AX4XfWheDrIAim0GIouQLDga1094pNtKvHevFSSuUTCbLiT1x9nbi0OGqtPRoVIkfd1ngw&scope=email+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email+openid&authuser=0&prompt=none";
		
		//extracting only the value of code query param
		String code=url.split("&")[0].split("code=")[1];
		
		//Extracting the AT USING THE CODE FILTERED AND EXTRACTED FROM THE REDIRECT URI OF THE AUTH PAGE
		//AND THIS CODE CONSISTS OF MANY SPECIAL CHARACTERS WHICH REST ASSURED MAY START ENCODING MAKE THE URLENCODINGENABLgES AS FALSE
		//Gettng the Acess Token from Google Resource Server
		String s= given().urlEncodingEnabled(false).queryParams("code",code).
				queryParams("client_id","692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
		.queryParams("client_secret","erZOWM9g3UtwNRj340YYaK_W").
		queryParams("grant_type", "authorization_code").
		queryParams("redirect_uri","https://rahulshettyacademy.com/getCourse.php")
		.when().post("https://www.googleapis.com/oauth2/v4/token").asString();
		
		JsonPath js = new JsonPath(s);
		
		String AT=js.getString("access_token");
		
		
		
		//Hitting the final request aFTER collecting the access token 
		
		Response r=given().queryParam("access_token",AT).expect().defaultParser(Parser.JSON).
		when().get("https://rahulshettyacademy.com/getCourse.php").as(Response.class);
		
		System.out.println(r.getInstructor());
		System.out.println(r.getCourses().getApi().get(0).getCourseTitle());
		
	}
}

/*
 * Code download
********************UPDATED CODE AS PER GOOGLE UPDATE *****************************









package demo;

import static io.restassured.RestAssured.given;



import java.util.ArrayList;

import java.util.Arrays;

import java.util.List;



import org.openqa.selenium.By;

import org.openqa.selenium.Keys;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;



import io.restassured.parsing.Parser;

import io.restassured.path.json.JsonPath;

import io.restassured.response.Response;

import io.restassured.response.ResponseBody;

import pojo.Api;

import pojo.GetCourse;





public class test1 {



public static void main(String[] args) throws InterruptedException {

// TODO Auto-generated method stub

String url ="https://rahulshettyacademy.com/getCourse.php?state=verifyfjdss&code=4%2FvAHBQUZU6o4WJ719NrGBzSELBFVBI9XbxvOtYpmYpeV47bFVExkaxWaF_XR14PHtTZf7ILSEeamywJKwo_BYs9M&scope=email+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email+openid&authuser=0&session_state=0c32992f0d47e93d273922018ade42d1072b9d1f..a35c&prompt=none#";



String partialcode=url.split("code=")[1];

String code=partialcode.split("&scope")[0];

System.out.println(code);

String response =

                given() 

                .urlEncodingEnabled(false)

                       .queryParams("code",code)

               

                   .queryParams("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")

                        .queryParams("client_secret", "erZOWM9g3UtwNRj340YYaK_W")

                        .queryParams("grant_type", "authorization_code")

                        .queryParams("state", "verifyfjdss")

                        .queryParams("session_state", "ff4a89d1f7011eb34eef8cf02ce4353316d9744b..7eb8")

                     // .queryParam("scope", "email+openid+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email")

                       

                        .queryParams("redirect_uri", "https://rahulshettyacademy.com/getCourse.php")

                        .when().log().all()

                        .post("https://www.googleapis.com/oauth2/v4/token").asString();

// System.out.println(response);

JsonPath jsonPath = new JsonPath(response);

    String accessToken = jsonPath.getString("access_token");

    System.out.println(accessToken);

String r2=    given().contentType("application/json").

queryParams("access_token", accessToken).expect().defaultParser(Parser.JSON)

.when()

           .get("https://rahulshettyacademy.com/getCourse.php")

.asString();

System.out.println(r2);



}



}


 * 
 * */
