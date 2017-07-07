package com.iberrylogin.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;

public class VerifyLogin {
    public static boolean validate(String name, String pass) {
        //This program validates the user id and password
    	boolean status = false;
    	  try{
    	    	Class.forName("com.mysql.jdbc.Driver").newInstance();
    	    	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/userlogin","root","root");
    	    	PreparedStatement ps=con.prepareStatement("select * from login");
    	    	ResultSet rs=ps.executeQuery();
    	    	while(rs.next()){
    	    		
    	    		if(rs.getString(1).equals(name)&&rs.getString(2).equals(pass)){
    	    			System.out.print(rs.getString(1));
    	    			status=true;
    	    			
    	    		}
    	    		
    	    	}
    	    	
    	        }
    	        catch(Exception e){
    	        	e.printStackTrace();
    	        }
        return status;
    }
}