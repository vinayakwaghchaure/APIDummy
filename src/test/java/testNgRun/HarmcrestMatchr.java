package testNgRun;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import org.json.simple.JSONArray;

import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.collections.Objects;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;


public class HarmcrestMatchr {

	/*@Test
	public void assertionTest()
	{
		RestAssured.baseURI="https://reqres.in/";
		given().get("api/users/2").then().assertThat()
		.body("data.first_name",equalTo("Janet"))
		.and()
		.body("support.url",equalTo("https://reqres.in/#support-heading"));
	}


	@Test
	public void assrtRes()
	{
		RestAssured.baseURI="https://reqres.in/";
		given().param("page", 2)
		.when().get("api/users").then().assertThat().statusCode(200);
	}
	 */

	/*@Test
	public void assrtResArry()
	{
		RestAssured.baseURI="https://reqres.in/";
		//Response response = given().when().get("/api/users?page=2");
		//JSONArray JSONResponseBody = new   JSONArray(response.body().asString());
		//Assert.assertEquals(JSONResponseBody.getJsonObject(0).getString("fieldName"), "TextName");

		given().get("/api/users?page=2").then().assertThat()
		.body("data.first_name[0]",equalTo("Michael"))
		.and()
		.body("data.first_name[1]",equalTo("Lindsay"));
	}



	@Test
	public void assertionTest()
	{
		RestAssured.baseURI="https://reqres.in/";
		given().get("/api/users?page=2").then().assertThat()
		//.body("page",equalToIgnoringWhiteSpace("2"))
		.and()
		.body("support.url",equalTo("https://reqres.in/#support-heading"))
		.and()
		.body("support.text", startsWith("To keep"))
		.and()
		.body("support.text", endsWith("appreciated!"))
		.and()
		.body("support.text", containsString("preciat"));
	}
	 */	

	/*@Test
	public void assertionTest11()
	{
		RestAssured.baseURI="https://reqres.in/";
		given().get("/api/users?page=2").then().assertThat()
		//.body("data[0]", hasKey("avatar"))
		.and()
		.body("data.id[0]",equalTo(7))
		.and().body("page",equalTo(2))
		.and()
		.body("total",equalTo(12))
		.and().body("data.first_name[0]",equalTo("Michael"));

		//hasItem(),hasvalue(),
	}*/


	/*@Test
	public void testAssertThat()
	{
		String email,first_name,last_name;
		int id,page,per_page;

		RestAssured.baseURI="https://reqres.in/";
		Response response=	given().get("/api/users?page=2");


		page =JsonPath.from(response.getBody().asString()).get("page");
		Reporter.log("page :"+page);

		System.out.println(page);
		per_page =JsonPath.from(response.getBody().asString()).get("per_page");
		System.out.println(per_page);
		Reporter.log("per_page :"+per_page);


		id =JsonPath.from(response.getBody().asString()).get("data.id[0]");
		System.out.println(id);

		email =JsonPath.from(response.getBody().asString()).get("data.email[0]");
		System.out.println(email);
		Reporter.log("email :"+email);

		first_name =JsonPath.from(response.getBody().asString()).get("data.first_name[0]");
		last_name =JsonPath.from(response.getBody().asString()).get("data.last_name[0]");

		//Assertion

		assertThat((new Object[] {page,per_page,id,email,first_name,last_name}),is(new Object[] {2,6,7,"michael.lawson@reqres.in","Michael","Lawson"}));

	}

	 */
	//ListOf Data

	@Test
	public void testAssertThatList()
	{

		List<String> email,first_name,last_name;
		List<Integer> id;

		RestAssured.baseURI="https://reqres.in/";
		Response response=	given().get("/api/users?page=2");

		id=new ArrayList<Integer>();
		id =JsonPath.from(response.getBody().asString()).get("data.id");

		email=new ArrayList<String>();
		email =JsonPath.from(response.getBody().asString()).get("data.email");
		System.out.println(email);

		first_name=new ArrayList<String>();
		first_name =JsonPath.from(response.getBody().asString()).get("data.first_name");
		System.out.println(first_name);

		last_name=new ArrayList<String>();
		last_name =JsonPath.from(response.getBody().asString()).get("data.last_name");
		System.out.println(last_name);

		//Assertion

		assertThat((new Object[] {id.get(0),email.get(0),first_name.get(0),last_name.get(0),
								  id.get(1),email.get(1),first_name.get(1),last_name.get(1),
								  id.get(2),email.get(2),first_name.get(2),last_name.get(2)}),
				is(new Object[] {7,"michael.lawson@reqres.in","Michael","Lawson",
								 8,"lindsay.ferguson@reqres.in","Lindsay","Ferguson",
								 9,"tobias.funke@reqres.in","Tobias","Funke"}));

	}

}
