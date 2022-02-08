package testNgRun;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.jvnet.staxex.StAxSOAPBody.Payload;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
//import io.restassured.internal.util.IOUtils;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;


public class PostAPI {

	//.body(IOUtils.toByteArray(fileInputStream).toString())

	@Test
	public void Divide() throws IOException{


		FileInputStream fileInputStream =new FileInputStream("D:\\JavaPractice\\APIAutomation1\\resources\\divide.xml");

		RestAssured.baseURI="http://www.dneonline.com";

		Reporter.log("Step 1 baseURI:"+RestAssured.baseURI);
		Reporter.log("Step 2 Resource:  /calculator.asmx");

		Response response= 
				given()
				.header("Content-Type","text/xml")
				.and()
				.body(org.apache.commons.io.IOUtils.toString(fileInputStream,"UTF-8"))
				.when()
				.post("/calculator.asmx")
				.then()
				.statusCode(200)
				.and()
				.log().all().extract().response();


		Reporter.log("response: "+response.toString());
		String body=response.getBody().asString();
		System.out.println("Body: "+body);
		Reporter.log("DivideResults: "+body);

		//	XmlPath xmlpath=new XmlPath(response.toString());
		//	System.out.println("response :"+xmlpath.toString());	

	}



	@Test(priority=1)
	public void AddService() throws IOException{


		FileInputStream fileInputStream =new FileInputStream("D:\\JavaPractice\\APIAutomation1\\resources\\add.xml");

		RestAssured.baseURI="http://www.dneonline.com";

		Reporter.log("Step 1 baseURI:"+RestAssured.baseURI);
		Reporter.log("Step 2 Resource:  /calculator.asmx");

		Response response= 
				given()
				.header("Content-Type","text/xml")
				.and()
				.body(org.apache.commons.io.IOUtils.toString(fileInputStream,"UTF-8"))
				.when()
				.post("/calculator.asmx")
				.then()
				.statusCode(200)
				.and()
				.log().all().extract().response();


		Reporter.log("response: "+response.toString());
		String body=response.getBody().asString();
		System.out.println("Add Response Body: "+body);
		Reporter.log("Add Results: "+body);
		

	}


	@Test(priority=2)
	public void MultiplyService() throws IOException{

		FileInputStream fileInputStream =new FileInputStream("D:\\JavaPractice\\APIAutomation1\\resources\\Multiply.xml");
		RestAssured.baseURI="http://www.dneonline.com";

		Reporter.log("Step 1 baseURI:"+RestAssured.baseURI);
		Reporter.log("Step 2 Resource:  /calculator.asmx");

		Response response= 
				given()
				.header("Content-Type","text/xml")
				.and()
				.body(org.apache.commons.io.IOUtils.toString(fileInputStream,"UTF-8"))
				.when()
				.post("/calculator.asmx")
				.then()
				.statusCode(200)
				.and()
				.log().all().extract().response();


		Reporter.log("response: "+response.toString());
		String body=response.getBody().asString();
		System.out.println("Multiply Response Body: "+body);
		Reporter.log("Multiply Results: "+body);
	}

	@Test(priority=3)
	public void substractService() throws IOException{

		FileInputStream fileInputStream =new FileInputStream("D:\\JavaPractice\\APIAutomation1\\resources\\substract.xml");
		RestAssured.baseURI="http://www.dneonline.com";

		Reporter.log("Step 1 baseURI:"+RestAssured.baseURI);
		Reporter.log("Step 2 Resource:  /calculator.asmx");

		Response response= 
				given()
				.header("Content-Type","text/xml")
				.and()
				.body(org.apache.commons.io.IOUtils.toString(fileInputStream,"UTF-8"))
				.when()
				.post("/calculator.asmx")
				.then()
				.statusCode(200)
				.and()
				.log().all().extract().response();


		Reporter.log("response: "+response.toString());
		String body=response.getBody().asString();
		System.out.println("Substract Response Body: "+body);
		Reporter.log("Substract result: "+body);
	}








	/*@SuppressWarnings("unchecked")
	@Test(priority=1)
	public void jsonMethod()
	{
		//given - all input details
		//when  - submit the API
		//then   -validate the response

		RestAssured.baseURI="https://rahulshettyacademy.com";           

		// /maps/api/place/add/json?key=qaclick123";
		String response=	
				given()
				.queryParam("key","qaclick123").header("Content-Type","application/json")
				.body("")
				.when()
				.post("/maps/api/place/add/json")

				.then().log().all().assertThat().statusCode(200).toString();


		JsonPath js= new JsonPath(response);
		String placeId=js.getString(response);



		RestAssured.baseURI ="https://reqres.in";
		RequestSpecification request = RestAssured.given();

		JSONObject requestParams = new JSONObject();
		requestParams.put("email", "eve.holt@reqres.in"); // Cast
		requestParams.put("password", "pistol");
		request.body(requestParams.toJSONString());
		Response response = request.post("/api/register");

		System.out.println("response :" +response.asString());


		int statusCode = response.getStatusCode();
		System.out.println(statusCode);
		Assert.assertEquals(statusCode,201);

		JsonPath jsonPathEvaluator = response.jsonPath();
		String id = jsonPathEvaluator.get("id");

		Assert.assertEquals(id, "4", "Correct id  received in the Response");


	}*/


}
