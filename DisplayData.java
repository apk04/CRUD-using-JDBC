package demo2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DisplayData {
	public static void main(String[] args) {
		Connection con;        //API
		Statement st;          //API
		ResultSet rs;          //API
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");               //loads driver(mySQL driver), static method 
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/practice","root","root");  //establishes connection b/w java & database, static method
			st=con.createStatement();             //create statement object          
			rs=st.executeQuery("select * from product");       //SQL query
			
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getInt(4));
			}
			rs.close();
			st.close();
			con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}


