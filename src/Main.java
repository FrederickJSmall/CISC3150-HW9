/*
 * Frederick Small 
 * CISC 3150
 *  
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.microsoft.sqlserver.jdbc.SQLServerConnection;

public class Main {
    public static void main(String[] args) throws SQLException
    {
    	Connection connection = null;
    	Statement statement = null;
    	
    	String url = "jdbc:sqlserver://SQLServer2014;user=sa;password=Homework9;";
    	//String url = "jdbc:sqlserver://localhost;user=sa;password=Homework9;
    	
    	try {
			//connection = DriverManager.getConnection(url,"THE_USER", "THE_PASSWORD");
			connection = DriverManager.getConnection(url);
			System.out.println("Connection Established");
			Statement sta = connection.createStatement();
			sta.executeQuery("Select * from HW9.dbo.Customer");
			System.out.println("Data Extracted");			
    	}
    	finally
    	{
    		statement.close();
    		connection.close();   
    	}
    	 
    }
}
