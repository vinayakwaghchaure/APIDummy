package testNgRun;

import static io.restassured.RestAssured.given;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ApiDBtest {

	FileInputStream fileInputStream;
	Connection con;


	@BeforeTest
	public void startWith() {
		try{  
			
			Class.forName("com.mysql.jdbc.Driver");  
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila","root","root"); 
			System.out.println("Database Connected");
			//here sakila is database name, root is username and password  
		}
		catch(Exception e)
		{
			System.out.println(e);
		}  
	}


	@Test
	public void divideService() throws IOException
	{
		fileInputStream =new FileInputStream("D:\\JavaPractice\\APIAutomation1\\resources\\divide.xml");
		RestAssured.baseURI="http://www.dneonline.com";
		String resource="/calculator.asmx";
		Reporter.log("Step 1 baseURI:"+RestAssured.baseURI);
		Reporter.log("Step 2 Resource: "+resource);

		Response response= 
				given()
				.header("Content-Type","text/xml")
				.and()
				.body(org.apache.commons.io.IOUtils.toString(fileInputStream,"UTF-8"))
				.when()
				.post(resource)
				.then()
				.statusCode(200)
				.and()
				.log().all().extract().response();

		Reporter.log("response: "+response.toString());
		String body=response.getBody().asString();
		
		System.out.println("Body: "+body);
		Reporter.log("DivideResults: "+body);
		
		try {
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from actor where first_name=\"JOHNNY\" and last_name=\"LOLLOBRIGIDA\";");  
			System.out.println("Database Result:");
			while(rs.next())  
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+"  "+rs.getString(3)+" "+rs.getString(4)); 
			Assert.assertEquals(rs.getString(2).toString(), "JOHNNY"); 
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@AfterTest
	public void tearDown() throws Exception {
		con.close(); 
		System.out.println("Close database connection");
	}


}
