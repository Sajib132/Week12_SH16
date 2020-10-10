package sh;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Question2 {
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
	      
	       
		   // Load data into olympic table
		     stmt.execute("LOAD DATA LOCAL INPATH '/home/cloudera/olympic.csv' INTO TABLE olympic");
		     System.out.println("Load Data into Olympic table successful");
		      
	   
	      
	      con.close();
	}

}
