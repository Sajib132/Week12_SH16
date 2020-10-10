package sh;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Question1 {
	private static String driverName = "org.apache.hive.jdbc.HiveDriver";
	   private static Connection con = null;
	   private static Statement stmt = null;

	
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
	      // Register driver and create driver instance
		   
	      Class.forName(driverName);
	      // get connection
	      
	       con = DriverManager.getConnection("jdbc:hive2://localhost:10000/sh", "", "");
	       stmt = con.createStatement();
	       
	       stmt.execute("use sh");
	      
	       
	    // create table employee
	       stmt.execute("CREATE TABLE IF NOT EXISTS"
	  	         +" olympic (AthleteName String, Age int, Country String, Year int, Closing_Date String,"
	  	         +" Sport String, Gold_Medals int, Silver_Medals int, Bronze_Medals int, Total_Medals int)"
	  	         +" COMMENT 'Olympic Data'"
	  	         +" ROW FORMAT DELIMITED"
	  	         +" FIELDS TERMINATED BY ','"
	  	         +" LINES TERMINATED BY '\n'"
	  	         +" STORED AS TEXTFILE"); 
	  	      System.out.println("Table Olympic created");
	 
	  	      
	      
	      con.close();
	}

}

