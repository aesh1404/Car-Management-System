package Car;

import java.sql.*;

public class ConnectionClass 
{
    
    Connection con;
    Statement stmt;

    ConnectionClass()
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
    }
}
