import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class AddValues {
	public static void main(String[] args)throws IOException {
		
		InputStreamReader isr=new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(isr);
		System.out.println("Enter product id");
		int pid=Integer.parseInt(br.readLine());
		System.out.println("Enter product company");
		String comp=(br.readLine());
		System.out.println("Enter product name");
		String name= (br.readLine());
		System.out.println("Enter product price");
		int pri=Integer.parseInt(br.readLine());
		
		//String sql="insert into product values("+pid+",'"+comp+",'"+name+",'"+pri+")";
		String sql2="insert into product values("+pid+",'"+comp+"','"+name+"',"+pri+")";
		
		Connection con;
		Statement st;
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/practice","root","root");
			st=con.createStatement();
			int ret=st.executeUpdate(sql2);
			
			if(ret>0)
			{
				System.out.println("record added successfully!!!");
			}
			else
			{
				System.out.println("cannot add record");
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
