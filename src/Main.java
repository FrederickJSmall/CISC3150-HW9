/*
 * Frederick Small 
 * CISC 3150
 *  
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.microsoft.sqlserver.jdbc.SQLServerConnection;

public class Main {
    public static void main(String[] args) throws SQLException
    {
    	Connection connection = null;
    	Statement statement = null;
    	ResultSet resultset = null;
    	String url = "jdbc:sqlserver://SQLServer2014;user=sa;password=Homework9;";
    	//String url = "jdbc:sqlserver://localhost;user=sa;password=Homework9;
    	
    	try {
			//connection = DriverManager.getConnection(url,"THE_USER", "THE_PASSWORD");
			connection = DriverManager.getConnection(url);
			System.out.println("Connection Established");
			statement = connection.createStatement();
			resultset = statement.executeQuery("Select * from HW9.dbo.Customer");
			System.out.println("Data Extracted");
	        while (resultset.next()) {
	            String firstName = resultset.getString("FirstName");
	            String lastName = resultset.getString("LastName");
	            Integer dob = resultset.getInt("DOB");
	            
	            System.out.printf("Customer %s,%s was born on %d\n",  lastName, firstName, dob  );
	        }
    	}
    	finally
    	{
    		statement.close();
    		connection.close();   
    	}
    	 
    }
}
