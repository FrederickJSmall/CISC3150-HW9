/*
 * Frederick Small 
 * CISC 3150
 *  
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
    	PreparedStatement preparedstatement = null;
    	
    	String url = "jdbc:sqlserver://SQLServer2014;user=sa;password=Homework9;";
    	//String updateDOB = ""
    	
    	try {
			connection = DriverManager.getConnection(url);
			System.out.println("Connection Established");
			statement = connection.createStatement();
			resultset = statement.executeQuery("Select * from HW9.dbo.Heroes");
			System.out.println("Data Extracted");
			System.out.println("Printing Customers\n\n");
			while (resultset.next()) {
	            String firstName = resultset.getString("FirstName");
	            String lastName = resultset.getString("LastName");
	            String fullName = lastName + "," + firstName;
	            String alias = resultset.getString("Alias");
	            Integer dob = resultset.getInt("Rescues");
	            
	            System.out.printf("Hero:%-20s \t\tSecret identity:%-20s \tHas %d rescues to their name\n", alias, fullName, dob  );
	        }
			
			
			//updateSales = connection.prepareStatement(updateString);
			
			
			
    	}
    	finally
    	{
    		statement.close();
    		connection.close();   
    	}
    	 
    }
}
