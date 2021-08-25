import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestDBConnection {

	public static void main(String[] args) throws SQLException {
		
		
		//enter url ,username password
		//"jdbc:mysql://"+"localhost"+":"+"3306"+"/cert01","root","root"
		//url-->jdbc:mysql://"+host+":"+port+"/databasename","username","password"
		Connection con=DriverManager.getConnection("jdbc:mysql://"+"localhost"+":"+"3306"+"/cert01","root","root");
		Statement s=con.createStatement();
		ResultSet rs=s.executeQuery("select * from account where AccountType='SAV'"); //result will be at base index
		while(rs.next())  //to move from base index to 1st index
		{
			System.out.print(rs.getString("AccountNum")+" ");
			System.out.print(rs.getString("AccountType")+" ");
			System.out.print(rs.getString("FirstName")+" ");
			System.out.print(rs.getString("LastName")+" ");
			System.out.print(rs.getString("AccountStatus")+" ");
			System.out.print(rs.getString("VRFNStatus")+" ");
			System.out.print(rs.getString("Category")+" ");
			System.out.println(" ");
		}
		
		
		
		
		
		

	}

}
