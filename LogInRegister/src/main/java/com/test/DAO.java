package com.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DAO {
	
	Student std=null;
	public Student login(String user, String password)
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","1234");
			PreparedStatement ps = con.prepareStatement("select *from logindb where userid=? and pass=?");
			ps.setString(1, user);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				
				
				std=new Student(rs.getString(1), rs.getString(2), rs.getString(3));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return std;
	}
	
	public int register(Student st)
	{
		
		int k=0;
		try
		{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","1234");
		PreparedStatement ps = con.prepareStatement("insert into logindb values(?,?,?)");
		
		ps.setString(1, st.getName());
		ps.setString(2, st.getMail());
		ps.setString(3, st.getPass());
		
		k = ps.executeUpdate();
		
		}
		catch(Exception e)
		{
			
		}
		return k;
		
	}
	
}
