package com.elibrary.connectionUtils;

import java.sql.*;

public class DB {
	
public static Connection getCon(){
	Connection con=null;
	try{
		Class.forName("com.mysql.cj.jdbc.Driver"); 				//"oracle.jdbc.driver.OracleDriver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library_data","root","admin1@");
		
	}catch(Exception e){System.out.println(e);}
	return con;
}
}
