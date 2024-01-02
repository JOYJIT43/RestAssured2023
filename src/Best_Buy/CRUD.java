package Best_Buy;

import static org.hamcrest.Matchers.*;
import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

public class CRUD {

	static String MakeInIndia="TATA MOT0RS";
	public static void main(String[] args) {
		
		//--------------------------------------POST-------------------------------------------------
		        RestAssured.baseURI="http://localhost:3030";
		
		        String res= given().log().all().header("Content-Type","application/json").body(Payload.post())
				.when().post("/products").
				then().log().all().assertThat().statusCode(201).statusLine("HTTP/1.1 201 Created").body("type", equalTo("PREMIUM HATCHBACK")).extract().response().asString();
		        JsonPath js = new JsonPath(res);
		        int myid = js.getInt("id");
		        System.out.print(myid);
		   
		     
		//---------------------------------------GET-------------------------------------------------------------
		        
		        given().log().all().header("Content-Type","application/json")
		        .when().get("/products/"+myid).
		        then().log().all().assertThat().statusCode(200);

		//---------------------------------------PUT----------------------------------------------------------------
		        
		        given().log().all().header("Content-Type","application/json").body(Payload.put())
		        .when().put("/products/"+myid).
		        then().log().all().assertThat().statusCode(200);
//		        String type = js.getString("type");
//		        Assert.assertEquals(type,"Compact SUV");
		        
		        
		//------------------------------------------GET-------------------------------------------------------
		        
	
		        given().log().all().header("Content-Type","application/json")
		        .when().get("/products/"+myid).
		        then().log().all().assertThat().statusCode(200).body("name",equalTo("TATA NEXON"));
		        String maker = js.getString("manufacturer");
		        String type = js.getString("type");
//		        Assert.assertEquals(MakeInIndia,maker);
//		        Assert.assertEquals(type,"Compact SUV");
		//--------------------------------------DELETE--------------------------------------------------------------
		        
		           given().log().all().header("Content-Type","application/json")
				  .when().delete("products/"+myid)
				  .then().log().all().assertThat().statusCode(200);
		           
		//------------------------------------DELETE AGAIN------------------------------------------------------
	
		               given().log().all().header("Content-Type","application/json")
					  .when().delete("products/"+myid)
					  .then().log().all().assertThat().statusCode(404).body("message", equalTo("No record found for id '"+myid+"'"));
	}

}

/*-----------------------------------------------END TO END RESPONSE---------------------------------------------------------------
 * SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
Request method:	POST
Request URI:	http://localhost:3030/products
Proxy:			<none>
Request params:	<none>
Query params:	<none>
Form params:	<none>
Path params:	<none>
Headers:		Accept=*//*
				Content-Type=application/json; charset=UTF-8
Cookies:		<none>
Multiparts:		<none>
Body:
{
    "name": "TATA ALTROZ",
    "type": "PREMIUM HATCHBACK",
    "price": 1650000,
    "upc": "086792895093",
    "shipping": 0,
    "description": "Connectiong Aspirations",
    "manufacturer": "TATA MOT0R",
    "model": "XZ+ LUX",
    "url": "https://cars.tatamotors.com/suv/nexon",
    "image": "https://youtu.be/eNaTGveb1no?list=TLGG8anfLYfiz-YxNTA1MjAyMQ"
}
HTTP/1.1 201 Created
X-Powered-By: Express
Access-Control-Allow-Origin: *
Allow: GET,POST,PUT,PATCH,DELETE
Vary: Accept, Accept-Encoding
Content-Type: application/json; charset=utf-8
Content-Length: 393
ETag: W/"189-raZg6vGu+Xtji/1YSI2cn9XwT60"
Date: Sat, 15 May 2021 10:53:18 GMT
Connection: keep-alive
Keep-Alive: timeout=5

{
    "id": 9999702,
    "name": "TATA ALTROZ",
    "type": "PREMIUM HATCHBACK",
    "price": 1650000,
    "upc": "086792895093",
    "shipping": 0,
    "description": "Connectiong Aspirations",
    "manufacturer": "TATA MOT0R",
    "model": "XZ+ LUX",
    "url": "https://cars.tatamotors.com/suv/nexon",
    "image": "https://youtu.be/eNaTGveb1no?list=TLGG8anfLYfiz-YxNTA1MjAyMQ",
    "updatedAt": "2021-05-15T10:53:18.778Z",
    "createdAt": "2021-05-15T10:53:18.778Z"
}
9999702Request method:	GET
Request URI:	http://localhost:3030/products/9999702
Proxy:			<none>
Request params:	<none>
Query params:	<none>
Form params:	<none>
Path params:	<none>
Headers:		Accept=*//*
				Content-Type=application/json; charset=UTF-8
Cookies:		<none>
Multiparts:		<none>
Body:			<none>
HTTP/1.1 200 OK
X-Powered-By: Express
Access-Control-Allow-Origin: *
Allow: GET,POST,PUT,PATCH,DELETE
Vary: Accept, Accept-Encoding
Content-Type: application/json; charset=utf-8
Content-Length: 409
ETag: W/"199-IRTtfC0tv8qw6mJsD+sjpiuWaMk"
Date: Sat, 15 May 2021 10:53:20 GMT
Connection: keep-alive
Keep-Alive: timeout=5

{
    "id": 9999702,
    "name": "TATA ALTROZ",
    "type": "PREMIUM HATCHBACK",
    "price": 1650000,
    "upc": "086792895093",
    "shipping": 0,
    "description": "Connectiong Aspirations",
    "manufacturer": "TATA MOT0R",
    "model": "XZ+ LUX",
    "url": "https://cars.tatamotors.com/suv/nexon",
    "image": "https://youtu.be/eNaTGveb1no?list=TLGG8anfLYfiz-YxNTA1MjAyMQ",
    "createdAt": "2021-05-15T10:53:18.778Z",
    "updatedAt": "2021-05-15T10:53:18.778Z",
    "categories": [
        
    ]
}
Request method:	PUT
Request URI:	http://localhost:3030/products/9999702
Proxy:			<none>
Request params:	<none>
Query params:	<none>
Form params:	<none>
Path params:	<none>
Headers:		Accept=*//*
				Content-Type=application/json; charset=UTF-8
Cookies:		<none>
Multiparts:		<none>
Body:
{
    "name": "TATA NEXON",
    "type": "Compact SUV",
    "price": 950000,
    "upc": "086792895093",
    "shipping": 0,
    "description": "EV is the future",
    "manufacturer": "TATA MOTORS",
    "model": "XZ+ LUX",
    "url": "https://cars.tatamotors.com/suv/nexon",
    "image": "https://youtu.be/eNaTGveb1no?list=TLGG8anfLYfiz-YxNTA1MjAyMQ"
}
HTTP/1.1 200 OK
X-Powered-By: Express
Access-Control-Allow-Origin: *
Allow: GET,POST,PUT,PATCH,DELETE
Vary: Accept, Accept-Encoding
Content-Type: application/json; charset=utf-8
Content-Length: 379
ETag: W/"17b-EsQZoRcA6h+8IGAN+jMHJWJsPZc"
Date: Sat, 15 May 2021 10:53:20 GMT
Connection: keep-alive
Keep-Alive: timeout=5

{
    "id": 9999702,
    "name": "TATA NEXON",
    "type": "Compact SUV",
    "price": 950000,
    "upc": "086792895093",
    "shipping": 0,
    "description": "EV is the future",
    "manufacturer": "TATA MOTORS",
    "model": "XZ+ LUX",
    "url": "https://cars.tatamotors.com/suv/nexon",
    "image": "https://youtu.be/eNaTGveb1no?list=TLGG8anfLYfiz-YxNTA1MjAyMQ",
    "createdAt": "2021-05-15T10:53:18.778Z",
    "updatedAt": "2021-05-15T10:53:20.275Z"
}
Request method:	GET
Request URI:	http://localhost:3030/products/9999702
Proxy:			<none>
Request params:	<none>
Query params:	<none>
Form params:	<none>
Path params:	<none>
Headers:		Accept=*//*
				Content-Type=application/json; charset=UTF-8
Cookies:		<none>
Multiparts:		<none>
Body:			<none>
HTTP/1.1 200 OK
X-Powered-By: Express
Access-Control-Allow-Origin: *
Allow: GET,POST,PUT,PATCH,DELETE
Vary: Accept, Accept-Encoding
Content-Type: application/json; charset=utf-8
Content-Length: 395
ETag: W/"18b-fppmDu0+qeg5DX5IJMORRMV1DV0"
Date: Sat, 15 May 2021 10:53:20 GMT
Connection: keep-alive
Keep-Alive: timeout=5

{
    "id": 9999702,
    "name": "TATA NEXON",
    "type": "Compact SUV",
    "price": 950000,
    "upc": "086792895093",
    "shipping": 0,
    "description": "EV is the future",
    "manufacturer": "TATA MOTORS",
    "model": "XZ+ LUX",
    "url": "https://cars.tatamotors.com/suv/nexon",
    "image": "https://youtu.be/eNaTGveb1no?list=TLGG8anfLYfiz-YxNTA1MjAyMQ",
    "createdAt": "2021-05-15T10:53:18.778Z",
    "updatedAt": "2021-05-15T10:53:20.275Z",
    "categories": [
        
    ]
}
Request method:	DELETE
Request URI:	http://localhost:3030/products/9999702
Proxy:			<none>
Request params:	<none>
Query params:	<none>
Form params:	<none>
Path params:	<none>
Headers:		Accept=*//*
				Content-Type=application/json; charset=UTF-8
Cookies:		<none>
Multiparts:		<none>
Body:			<none>
HTTP/1.1 200 OK
X-Powered-By: Express
Access-Control-Allow-Origin: *
Allow: GET,POST,PUT,PATCH,DELETE
Vary: Accept, Accept-Encoding
Content-Type: application/json; charset=utf-8
Content-Length: 379
ETag: W/"17b-EsQZoRcA6h+8IGAN+jMHJWJsPZc"
Date: Sat, 15 May 2021 10:53:20 GMT
Connection: keep-alive
Keep-Alive: timeout=5

{
    "id": 9999702,
    "name": "TATA NEXON",
    "type": "Compact SUV",
    "price": 950000,
    "upc": "086792895093",
    "shipping": 0,
    "description": "EV is the future",
    "manufacturer": "TATA MOTORS",
    "model": "XZ+ LUX",
    "url": "https://cars.tatamotors.com/suv/nexon",
    "image": "https://youtu.be/eNaTGveb1no?list=TLGG8anfLYfiz-YxNTA1MjAyMQ",
    "createdAt": "2021-05-15T10:53:18.778Z",
    "updatedAt": "2021-05-15T10:53:20.275Z"
}
Request method:	DELETE
Request URI:	http://localhost:3030/products/9999702
Proxy:			<none>
Request params:	<none>
Query params:	<none>
Form params:	<none>
Path params:	<none>
Headers:		Accept=*//*
				Content-Type=application/json; charset=UTF-8
Cookies:		<none>
Multiparts:		<none>
Body:			<none>
HTTP/1.1 404 Not Found
X-Powered-By: Express
Access-Control-Allow-Origin: *
Allow: GET,POST,PUT,PATCH,DELETE
Content-Type: application/json; charset=utf-8
Content-Length: 111
ETag: W/"6f-15zyNuMzSI00P6omASQABSu3ibI"
Vary: Accept-Encoding
Date: Sat, 15 May 2021 10:53:20 GMT
Connection: keep-alive
Keep-Alive: timeout=5

{
    "name": "NotFound",
    "message": "No record found for id '9999702'",
    "code": 404,
    "className": "not-found",
    "errors": {
        
    }
}
*/ 
