package Car;

import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class ViewUserCar extends JFrame {
    String columns[] = {"Car No", "Brand Name", "Brand Model", "Car Name", "Car Sheet", "Car Engine", "Car Category", "Car Mileage", "Car Mirror", "Car Status"};
    String data[][] = new String[20][10];
    int i = 0, j = 0;
    JTable table;
    Font font;
    
    ViewUserCar() {
        super("New Car Information");
        setSize(1000, 400);
        setLocation(180, 160);
        
        font = new Font("MS UI Gothic", Font.BOLD, 15);
        
        try {
            ConnectionClass obj = new ConnectionClass();
            String query = "SELECT * FROM add_car";
            ResultSet resultSet = obj.stmt.executeQuery(query);
            
            while (resultSet.next()) {
                data[i][j++] = resultSet.getString("carno");
                data[i][j++] = resultSet.getString("Brandname");
                data[i][j++] = resultSet.getString("brandmodel");
                data[i][j++] = resultSet.getString("carname");
                data[i][j++] = resultSet.getString("carsheet");                
                data[i][j++] = resultSet.getString("carengine");
                data[i][j++] = resultSet.getString("carcategory");
                data[i][j++] = resultSet.getString("carmileage");
                data[i][j++] = resultSet.getString("carmirror");                
                data[i][j++] = resultSet.getString("carstatus");
                i++;
                j = 0;                   
            }
            
            table = new JTable(data, columns);
            table.setFont(font);
            table.setBackground(Color.BLACK);
            table.setForeground(Color.WHITE);
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);
    }
    
    public static void main(String[] args) {
        new ViewUserCar().setVisible(true);
    }
}
