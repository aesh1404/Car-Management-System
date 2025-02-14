package Car;

import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class ViewUserBrand extends JFrame {
    String columns[] = {"Brand/Model Id", "Brand Name", "Model Name", "Year"};
    String data[][] = new String[20][4];
    int i = 0, j = 0;
    JTable table;
    Font font;
    
    ViewUserBrand() {
        super("Brand Information");
        setSize(1000, 400);
        setLocation(180, 160);
        
        font = new Font("MS UI Gothic", Font.BOLD, 15);
        
        try {
            ConnectionClass obj = new ConnectionClass();
            String query = "SELECT * FROM CarBrand";
            ResultSet resultSet = obj.stmt.executeQuery(query);
            
            while (resultSet.next()) {
                data[i][j++] = resultSet.getString("brand_id");
                data[i][j++] = resultSet.getString("brandname");
                data[i][j++] = resultSet.getString("carmodel");
                data[i][j++] = resultSet.getString("year");
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
        new ViewUserBrand().setVisible(true);
    }
}
//Successfully Done by Darshan 13/02/2025
