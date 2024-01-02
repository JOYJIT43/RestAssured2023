package ownchoice;

import org.testng.Assert;
import io.restassured.path.json.JsonPath;

public class CRUD {

	public static void main(String[] args) {
		

		
JsonPath js=new JsonPath(payloadchoice.Payloadchoice());
		
int count=	js.getInt("courses.size()");
System.out.println(count);
int totalAmount= js.getInt("dashboard.purchaseAmount");
System.out.println(totalAmount);


  String titleFirstCourse=js.get("courses[2].title");
  System.out.println(titleFirstCourse);
  
  
  for(int i=0;i<count;i++)
  {
	  String courseTitles=js.get("courses["+i+"].title");
	  System.out.println(js.get("courses["+i+"].price").toString());
	  
	  System.out.println(courseTitles);
	  
  }
  
 System.out.println("Print no of copies sold by RPA Course");
 
 for(int i=0;i<count;i++)
 {
	  String courseTitles=js.get("courses["+i+"].title");
	  if(courseTitles.equalsIgnoreCase("RPA"))
	  {
		  int copies=js.get("courses["+i+"].copies");
		  System.out.println(copies);
		  break;
	  }
	
	  
 }
 		int sum = 0;
 		int count1=	js.getInt("courses.size()");
 		for(int i=0;i<count1;i++)
 		{
 			int price=js.getInt("courses["+i+"].price");
 			int copies=js.getInt("courses["+i+"].copies");
 			int amount = price * copies;
 			System.out.println(amount);
 			sum = sum + amount;
 			
 		}
 		System.out.println(sum);
 		int purchaseAmount =js.getInt("dashboard.purchaseAmount");
 		Assert.assertEquals(sum, purchaseAmount);
 		
 	}
 
}
