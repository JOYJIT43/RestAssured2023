package gorest;

import static org.hamcrest.Matchers.*;
import org.testng.Assert;


import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;


public class CUD {

	static int id;
	public static void main(String[] args) {
		

		 RestAssured.baseURI="https://gorest.co.in/public-api/";
		 
		 
		  String res=given().log().all().header("Authorization",Gorest_Payload.AT).body(Gorest_Payload.post())
	     .header("Content-Type","application/json")
	     .when().post("users")
	     .then().log().all().assertThat().statusCode(200).header("Server", "nginx")
	     .header("Cache-Control","max-age=0, private, must-revalidate").extract().response().asString();  
		  JsonPath js = new JsonPath(res);
	      id = js.getInt("data.id");
	      System.out.println("After posting the id generated "+ id);
	      String status=js.getString("data.status");
	      System.out.println("status after post "+status);
	      
	      
      	 	
	
    //-----------------------------------PUT---------------------------------------------------------
	
	      String response=given().log().all().header("Authorization",Gorest_Payload.AT).body(Gorest_Payload.put())
		  .header("Content-Type","application/json")
		  .when().put("users/"+id)
		  .then().log().all().assertThat().statusCode(200).header("Server", "nginx")
		  .header("Cache-Control","max-age=0, private, must-revalidate").extract().response().asString();  
	      js=new JsonPath(response);
	      status=js.getString("data.status");
	      System.out.println("status after put "+status);
	      Assert.assertEquals(status,"Active" );
	     
	      
	 //--------------------------------delete---------------------------------------------------------------
	      given().log().all().header("Authorization",Gorest_Payload.AT)
		  .when().delete("users/"+id)
		  .then().log().all().assertThat().statusCode(200).header("Server", "nginx").body("code", equalTo(204));
	

	//---------------------------------------again GET/id---------------------------------------------
	 given().log().all().header("Authorization",Gorest_Payload.AT)
    .header("Content-Type","application/json")
    .when().get("users/"+id)
    .then().log().all().assertThat().statusCode(200).header("Server", "nginx").body("data.message",equalTo("Resource not found"))
    .header("Cache-Control","max-age=0, private, must-revalidate");
}
}

/* ----------------------------------------------OUTPUT-----------------------------------------------------------------
SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
Request method:	POST
Request URI:	https://gorest.co.in/public-api/users
Proxy:			<none>
Request params:	<none>
Query params:	<none>
Form params:	<none>
Path params:	<none>
Headers:		Authorization=Bearer f3c0e8abd5b6adba347382dee8767017416c21e25440bfb0c8f6583b68ea4eda
				Accept=*//*
				Content-Type=application/json; charset=UTF-8
Cookies:		<none>
Multiparts:		<none>
Body:
{
    "name": "JOYJIT GHOSH",
    "email": "joyjitghosh9965@gmail.com",
    "gender": "Male",
    "status": "Inactive"
}
HTTP/1.1 200 OK
Server: nginx
Date: Fri, 14 May 2021 09:28:03 GMT
Content-Type: application/json; charset=utf-8
Transfer-Encoding: chunked
Connection: keep-alive
Vary: Accept-Encoding
X-Frame-Options: SAMEORIGIN
X-XSS-Protection: 1; mode=block
X-Content-Type-Options: nosniff
X-Download-Options: noopen
X-Permitted-Cross-Domain-Policies: none
Referrer-Policy: strict-origin-when-cross-origin
Location: https://gorest.co.in/public-api/users/1487
ETag: W/"52ea049f61205c4efacc36178685c914"
Cache-Control: max-age=0, private, must-revalidate
X-Request-Id: 9f3d1239-1c63-4d25-9e44-3a5d3eae8f8e
X-Runtime: 0.027167
Strict-Transport-Security: max-age=31536000; includeSubDomains
Vary: Origin
X-Frame-Options: sameorigin
Expect-CT: enforce; max-age=3600
Content-Encoding: gzip

{
    "code": 201,
    "meta": null,
    "data": {
        "id": 1487,
        "name": "JOYJIT GHOSH",
        "email": "joyjitghosh9965@gmail.com",
        "gender": "Male",
        "status": "Inactive",
        "created_at": "2021-05-14T14:58:03.947+05:30",
        "updated_at": "2021-05-14T14:58:03.947+05:30"
    }
}
After posting the id generated 1487
status after post Inactive
Request method:	PUT
Request URI:	https://gorest.co.in/public-api/users/1487
Proxy:			<none>
Request params:	<none>
Query params:	<none>
Form params:	<none>
Path params:	<none>
Headers:		Authorization=Bearer f3c0e8abd5b6adba347382dee8767017416c21e25440bfb0c8f6583b68ea4eda
				Accept=*//*
				Content-Type=application/json; charset=UTF-8
Cookies:		<none>
Multiparts:		<none>
Body:
{
    "name": "Joyjit Ghosh",
    "email": "joyjitghosh05061999@gmail.com",
    "gender": "Male",
    "status": "Active"
}
HTTP/1.1 200 OK
Server: nginx
Date: Fri, 14 May 2021 09:28:06 GMT
Content-Type: application/json; charset=utf-8
Transfer-Encoding: chunked
Connection: keep-alive
Vary: Accept-Encoding
X-Frame-Options: SAMEORIGIN
X-XSS-Protection: 1; mode=block
X-Content-Type-Options: nosniff
X-Download-Options: noopen
X-Permitted-Cross-Domain-Policies: none
Referrer-Policy: strict-origin-when-cross-origin
ETag: W/"bc1abb652a57a8616dc4923eda63bca8"
Cache-Control: max-age=0, private, must-revalidate
X-Request-Id: 72846472-9472-4857-9427-6bd5b32c5710
X-Runtime: 0.025456
Strict-Transport-Security: max-age=31536000; includeSubDomains
Vary: Origin
X-Frame-Options: sameorigin
Expect-CT: enforce; max-age=3600
Content-Encoding: gzip

{
    "code": 200,
    "meta": null,
    "data": {
        "id": 1487,
        "email": "joyjitghosh05061999@gmail.com",
        "name": "Joyjit Ghosh",
        "gender": "Male",
        "status": "Active",
        "created_at": "2021-05-14T14:58:03.947+05:30",
        "updated_at": "2021-05-14T14:58:06.722+05:30"
    }
}
status after put Active
Request method:	DELETE
Request URI:	https://gorest.co.in/public-api/users/1487
Proxy:			<none>
Request params:	<none>
Query params:	<none>
Form params:	<none>
Path params:	<none>
Headers:		Authorization=Bearer f3c0e8abd5b6adba347382dee8767017416c21e25440bfb0c8f6583b68ea4eda
				Accept=*//*
Cookies:		<none>
Multiparts:		<none>
Body:			<none>
HTTP/1.1 200 OK
Server: nginx
Date: Fri, 14 May 2021 09:28:08 GMT
Content-Type: application/json; charset=utf-8
Transfer-Encoding: chunked
Connection: keep-alive
Vary: Accept-Encoding
X-Frame-Options: SAMEORIGIN
X-XSS-Protection: 1; mode=block
X-Content-Type-Options: nosniff
X-Download-Options: noopen
X-Permitted-Cross-Domain-Policies: none
Referrer-Policy: strict-origin-when-cross-origin
ETag: W/"9132bec7c413b5b015be1efe1c6efe72"
Cache-Control: max-age=0, private, must-revalidate
X-Request-Id: e753bbe8-31fb-4e4d-9fe6-af27699ac7cb
X-Runtime: 0.027586
Strict-Transport-Security: max-age=31536000; includeSubDomains
Vary: Origin
X-Frame-Options: sameorigin
Expect-CT: enforce; max-age=3600
Content-Encoding: gzip

{
    "code": 204,
    "meta": null,
    "data": null
}
Request method:	GET
Request URI:	https://gorest.co.in/public-api/users/1487
Proxy:			<none>
Request params:	<none>
Query params:	<none>
Form params:	<none>
Path params:	<none>
Headers:		Authorization=Bearer f3c0e8abd5b6adba347382dee8767017416c21e25440bfb0c8f6583b68ea4eda
				Accept=*//*
				Content-Type=application/json; charset=UTF-8
Cookies:		<none>
Multiparts:		<none>
Body:			<none>
HTTP/1.1 200 OK
Server: nginx
Date: Fri, 14 May 2021 09:28:09 GMT
Content-Type: application/json; charset=utf-8
Transfer-Encoding: chunked
Connection: keep-alive
Vary: Accept-Encoding
X-Frame-Options: SAMEORIGIN
X-XSS-Protection: 1; mode=block
X-Content-Type-Options: nosniff
X-Download-Options: noopen
X-Permitted-Cross-Domain-Policies: none
Referrer-Policy: strict-origin-when-cross-origin
ETag: W/"b654e1cd0d3be5d471e57be8f71a8543"
Cache-Control: max-age=0, private, must-revalidate
X-Request-Id: 0a1122c6-1968-48a8-bf32-61006af09012
X-Runtime: 0.002181
Strict-Transport-Security: max-age=31536000; includeSubDomains
Vary: Origin
X-Frame-Options: sameorigin
Expect-CT: enforce; max-age=3600
Content-Encoding: gzip

{
    "code": 404,
    "meta": null,
    "data": {
        "message": "Resource not found"
    }
}
*/