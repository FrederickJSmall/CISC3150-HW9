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
    	String updateRescue = "Update HW9.dbo.Heroes Set Rescues = Rescues+1 Where Alias = ?";
		connection = DriverManager.getConnection(url);
		System.out.println("Connection Established");
		
		System.out.println("Accouncing Heroes\n\n");
    	try {
			//connection = DriverManager.getConnection(url);
    		printHeroes(connection);
			//statement = connection.createStatement();
			//resultset = statement.executeQuery("Select * from HW9.dbo.Heroes");
			//System.out.println("Data Extracted");
			//System.out.println("Printing Customers\n\n");
			//while (resultset.next()) {
	        //    String firstName = resultset.getString("FirstName");
	        //    String lastName = resultset.getString("LastName");
	        //    String fullName = lastName + "," + firstName;
	        //    String alias = resultset.getString("Alias");
	        //    Integer dob = resultset.getInt("Rescues");
	        //    
	        //    System.out.printf("Hero:%-20s \t\tSecret identity:%-20s \tHas %d rescues to their name\n", alias, fullName, dob  );
	        //}
			
    		String message = "\t\t%s has a new rescue to their credit\n";
			preparedstatement = connection.prepareStatement(updateRescue);
			
			System.out.println("\n\n\nSome of the heroes are on the move; please watch for additional credits");
			
			preparedstatement.setString(1, "Superman");
			preparedstatement.executeUpdate();
			System.out.printf(message,"Superman");
			
			preparedstatement.setString(1, "Flash");
			preparedstatement.executeUpdate();
			System.out.printf(message,"Flash");
			
			preparedstatement.setString(1, "Superman");
			preparedstatement.executeUpdate();
			System.out.printf(message,"Superman");
			
			preparedstatement.setString(1, "Batman");
			preparedstatement.executeUpdate();
			System.out.printf(message,"Batman");
			
			preparedstatement.setString(1, "Batman");
			preparedstatement.executeUpdate();
			System.out.printf(message,"Batman");
			

			preparedstatement.setString(1, "Wonder Woman");
			preparedstatement.executeUpdate();
			System.out.printf(message,"Wonder Woman");
			
			
			printHeroes(connection);
			
    	}
    	finally
    	{
    		preparedstatement.close();
    		connection.close();   
    	}
    }
	public static void printHeroes(Connection connection) throws SQLException
	{
    	//Connection connection = null;
		System.out.println("");
    	Statement statement = null;
    	ResultSet resultset = null;
    	try
    	{
			statement = connection.createStatement();
			resultset = statement.executeQuery("Select * from HW9.dbo.Heroes");

			while (resultset.next()) {
	            String firstName = resultset.getString("FirstName");
	            String lastName = resultset.getString("LastName");
	            String fullName = lastName + "," + firstName;
	            String alias = resultset.getString("Alias");
	            Integer dob = resultset.getInt("Rescues");
	            
	            System.out.printf("Hero:%-20s \t\tSecret identity:%-20s \tHas %d rescues to their name\n", alias, fullName, dob  );
	        }
    	}
    	finally
    	{
    		resultset.close();
    		statement.close();
    	}
    	
	}    
}
