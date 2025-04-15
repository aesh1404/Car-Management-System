package Car;

import java.sql.*;

public class ConnectionClass 
{
    
    public Connection con;
    public Statement stmt;

    public ConnectionClass()
    {
        try 
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cms","root","@esh1404");
            stmt=con.createStatement();
            
        }
        catch (Exception ex) 
        {
            ex.printStackTrace();
        }
    }
    public static void main(String[] args)
    {
        new ConnectionClass();
        
        new AboutUs();
    }
   
 }

//successfully done add about us as main page by Ashish 15/04/2025 (Hint:- You need to set project's property also.) 
