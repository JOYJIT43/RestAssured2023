package gorest;

import static org.hamcrest.Matchers.*;


import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

public class GET {

	public static void main(String[] args) {
	
	     RestAssured.baseURI="https://gorest.co.in/public-api/";	     
	     
	     
	      given().log().all().header("Authorization",Gorest_Payload.AT)
	     .header("Content-Type","application/json")
	     .when().get("users")
	     .then().log().all().assertThat().statusCode(200).header("Server", "nginx").body("meta.pagination.pages",equalTo(84))
	     .header("Cache-Control","max-age=0, private, must-revalidate").extract().response().asString();
	     
	     //----------------------output------------------------
/*SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
Request method:	GET
Request URI:	https://gorest.co.in/public-api/users/123
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
Date: Thu, 13 May 2021 16:51:30 GMT
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
ETag: W/"e02dbaa5f93ea2bc791ae00fc79095f6"
Cache-Control: max-age=0, private, must-revalidate
X-Request-Id: 2d7dcabf-f272-4f85-8e88-47069ba4895d
X-Runtime: 0.020621
Strict-Transport-Security: max-age=31536000; includeSubDomains
Vary: Origin
X-Frame-Options: sameorigin
Expect-CT: enforce; max-age=3600
Content-Encoding: gzip

{
    "code": 200,
    "meta": null,
    "data": {
        "id": 123,
        "name": "Achintya Bharadwaj",
        "email": "achintya_bharadwaj@flatley.com",
        "gender": "Male",
        "status": "Active",
        "created_at": "2021-05-13T03:50:05.949+05:30",
        "updated_at": "2021-05-13T03:50:05.949+05:30"
    }
}
	     
	     
*/
}
}