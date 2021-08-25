import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DBToSeleniumTest {
	
	
	public void display()
	{
		System.out.println("DB connection with selenium webdriver tutorial");
		
	}

	public static void main(String[] args) throws SQLException {
		
		
		//enter url ,username password
		//"jdbc:mysql://"+"localhost"+":"+"3306"+"/cert01","root","root"
		//url-->jdbc:mysql://"+host+":"+port+"/databasename","username","password"
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\driverFiles\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		Connection con=DriverManager.getConnection("jdbc:mysql://"+"localhost"+":"+"3306"+"/cert01","root","root");
		Statement s=con.createStatement();
		ResultSet rs=s.executeQuery("select * from account where AccountNum='34534534534'"); //it will be at base index,but have to move to 1st index to get the result values 
		while(rs.next())  //to move from base index to 1st index
		{
			
			String Fname=rs.getString("FirstName");
			String Lname=rs.getString("LastName");
			driver.get("https://login.salesforce.com/");
			driver.findElement(By.id("username")).sendKeys(Fname+"."+Lname+"@something.com");
			driver.findElement(By.id("password")).sendKeys(Fname);
			
		}
	
	}

}