import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

//program to accept amount and pid from user and update price as price-amt
public class UpdateData {
	public static void main (String[] args)throws IOException {
		
		InputStreamReader isr=new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(isr);
		System.out.println("enter product id");
		int id= Integer.parseInt(br.readLine());
		System.out.println("enter price");
		float amt= Float.parseFloat(br.readLine());
		
		String sql="update product set price= price-"+amt+"where pid="+id;
		Connection con;
		Statement st;
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/practice","root","root");
			st=con.createStatement();
			int ret=st.executeUpdate(sql);
			
			if(ret>0)
			{
				System.out.println("record updated successfully!!!");
			}
			else
			{
				System.out.println("record not found");
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
