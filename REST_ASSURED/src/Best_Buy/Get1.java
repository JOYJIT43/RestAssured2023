package Best_Buy;


import static org.hamcrest.Matchers.*;
import org.testng.Assert;


import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import scala.Int;

import static io.restassured.RestAssured.*;

public class Get1 {

	static int id = 9132294;
	public static void main(String[] args) {
		

        RestAssured.baseURI="http://localhost:3030";
		
		String answer2 = given().log().all().header("Content-Type","application/json")
		.when().get("/products/"+id).
		then().log().all().assertThat().statusCode(200).body("name",equalTo("Yamaha - P32D Pianica - Brown/White")).extract().response().asString();
		JsonPath js = new JsonPath(answer2);
		int resid = js.getInt("id");
		//checking whether the response limit is equal to the requested limit or not
		Assert.assertEquals(resid, id);
		String model = js.get("model");
		double Price = js.getDouble("price");
		String Brand= js.get("name");
		System.out.println("The "+Brand+" "+model+" is priced "+Price+" dollars");
		System.out.println("And the categories include");
		for(int i=0;i<js.getInt("categories.size()");i++)
		{
			String names= js.getString("categories["+i+"].name");
			System.out.println(names);
		}
		
		
	}

}
