package dataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class DBUtility {
	
	public static int insert(String sql, String user, String pw){
		
		Connection con = null;
		Statement stmt = null;
		int numRecords;
		
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//con = DriverManager.getConnection("jdbc:oracle:thin:sys as sysdba/oracle@localhost:1521:orcl");
			con = DriverManager.getConnection("jdbc:oracle:thin:" + user + "/" + pw + "@localhost:1521:orcl");
			stmt = con.createStatement();
			numRecords = stmt.executeUpdate(sql);
			
			return numRecords;

		}catch (SQLException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		
		return 0;	
	}
	
	public static int update(String sql, String user, String pw){
		
		Connection con = null;
		Statement stmt = null;
		int numRecords;
		
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//con = DriverManager.getConnection("jdbc:oracle:thin:sys as sysdba/oracle@localhost:1521:orcl");
			con = DriverManager.getConnection("jdbc:oracle:thin:" + user + "/" + pw + "@localhost:1521:orcl");
			stmt = con.createStatement();
			numRecords = stmt.executeUpdate(sql);
			
			return numRecords;

		}catch (SQLException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		
		return 0;	
	}
	
	public static int delete(String sql, String user, String pw){
		
		Connection con = null;
		Statement stmt = null;
		int numRecords;
		
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//con = DriverManager.getConnection("jdbc:oracle:thin:sys as sysdba/oracle@localhost:1521:orcl");
			con = DriverManager.getConnection("jdbc:oracle:thin:" + user + "/" + pw + "@localhost:1521:orcl");
			stmt = con.createStatement();
			numRecords = stmt.executeUpdate(sql);
			
			return numRecords;

		}catch (SQLException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		
		return 0;	
	}
	

	public static ArrayList<LinkedHashMap<String,String>> select(String sql,String user, String pw){

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		ResultSetMetaData rsmd = null;
		ArrayList<LinkedHashMap<String,String>> list = new ArrayList<LinkedHashMap<String,String>>();
		int numberOfColumns;
		
		LinkedHashMap<String,String> records;
		
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//con = DriverManager.getConnection("jdbc:oracle:thin:sys as sysdba/oracle@localhost:1521:orcl");
			con = DriverManager.getConnection("jdbc:oracle:thin:" + user + "/" + pw + "@localhost:1521:orcl");
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			rsmd = rs.getMetaData();
			numberOfColumns = rsmd.getColumnCount();
			
			while(rs.next()){
				records = new LinkedHashMap<String,String>();
				for (int i = 1; i < numberOfColumns; i++){
					records.put(rsmd.getColumnName(i), rs.getString(i));
				}
				list.add(records);
			}

		}catch (SQLException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}

		return list;
	}
}
