package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectDatabase {

	public static void main(String[] args) {

		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila","root","root"); 

			//here sakila is database name, root is username and password  
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from actor where first_name=\"JOHNNY\" and last_name=\"LOLLOBRIGIDA\";");  

			while(rs.next())  
				System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+" "+rs.getString(4));  
			con.close(); 

		}
		catch(Exception e)
		{
			System.out.println(e);
			
		}  
	}  

}


