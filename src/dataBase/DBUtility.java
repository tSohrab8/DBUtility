package dataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class DBUtility {
	
	public static int insertRecord(String sql){
		
		Connection con = null;
		Statement stmt = null;
		int numRecords;
		
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//con = DriverManager.getConnection("jdbc:oracle:thin:sys as sysdba/oracle@localhost:1521:orcl");
			con = DriverManager.getConnection("jdbc:oracle:thin:ora1/ora1@localhost:1521:orcl");
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
	
	public static int updateRecord(String sql){
		
		Connection con = null;
		Statement stmt = null;
		int numRecords;
		
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//con = DriverManager.getConnection("jdbc:oracle:thin:sys as sysdba/oracle@localhost:1521:orcl");
			con = DriverManager.getConnection("jdbc:oracle:thin:ora1/ora1@localhost:1521:orcl");
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
	
	public static int deleteRecord(String sql){
		
		Connection con = null;
		Statement stmt = null;
		int numRecords;
		
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//con = DriverManager.getConnection("jdbc:oracle:thin:sys as sysdba/oracle@localhost:1521:orcl");
			con = DriverManager.getConnection("jdbc:oracle:thin:ora1/ora1@localhost:1521:orcl");
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
	

	public static ArrayList<HashMap<String,String>> selectRecord(String sql){

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		ResultSetMetaData rsmd = null;
		ArrayList<HashMap<String,String>> list = new ArrayList<HashMap<String,String>>();
		int numberOfColumns;
		
		HashMap<String,String> records = new HashMap<String,String>();
		
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//con = DriverManager.getConnection("jdbc:oracle:thin:sys as sysdba/oracle@localhost:1521:orcl");
			con = DriverManager.getConnection("jdbc:oracle:thin:ora1/ora1@localhost:1521:orcl");
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			rsmd = rs.getMetaData();
			numberOfColumns = rsmd.getColumnCount();
			
			while(rs.next()){
				records = new HashMap<String,String>();
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
	
	public static void main(String[]args){
		
		ArrayList<HashMap<String,String>> myList;
		
		myList = DBUtility.selectRecord("select * from MCStudents");
		
		System.out.println(myList.get(5).get("STUDENTid"));
		
		//int x = DBUtility.insertRecord("insert into cities(city) values ('landingville')");
		//System.out.println(x);
	}

}
