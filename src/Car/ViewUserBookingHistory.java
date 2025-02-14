package Car;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class ViewUserBookingHistory extends JFrame {
    String columns[] = {"Booking No", "Customer Username", "Brand Name", "Brand Model", "Car No", "Car Name", "Car Category", "Car Mileage", "Car Rent", "Total Days", "Booking Date", "Status"};
    String data[][];
    JTable t;
    Font f;

    ViewUserBookingHistory() {
        super("View Booking History");

        // Get the logged-in username
        String username = Login.loggedInUser;

        // If no user is logged in, show an error and close the window
        if (username == null) {
            JOptionPane.showMessageDialog(null, "Please log in first!");
            this.dispose();
            return;
        }

        setSize(1100, 400);
        setLocation(180, 160);
        f = new Font("MS UI Gothic", Font.BOLD, 15);
 
        try {
            ConnectionClass obj = new ConnectionClass();
            
            // Count number of rows for the logged-in user
            String countQuery = "SELECT COUNT(*) FROM car_booking WHERE customer_username=?";
            PreparedStatement countStmt = obj.con.prepareStatement(countQuery);
            countStmt.setString(1, username);
            ResultSet countResult = countStmt.executeQuery();
            countResult.next();
            int rowCount = countResult.getInt(1);

            if (rowCount == 0) {
                JOptionPane.showMessageDialog(null, "No booking history found!");
                this.dispose();
                return;
            }

            // Initialize the table array
            data = new String[rowCount][12];

            // Fetch bookings for the logged-in user
            String q = "SELECT * FROM car_booking WHERE customer_username=?";
            PreparedStatement pstmt = obj.con.prepareStatement(q);
            pstmt.setString(1, username);
            ResultSet rest = pstmt.executeQuery();
            
            int i = 0;
            while (rest.next()) {
                data[i][0] = rest.getString("booking_id");
                data[i][1] = rest.getString("customer_username");
                data[i][2] = rest.getString("brand_name");
                data[i][3] = rest.getString("brand_model");
                data[i][4] = rest.getString("car_no");
                data[i][5] = rest.getString("car_name");
                data[i][6] = rest.getString("car_category");
                data[i][7] = rest.getString("car_mielage");
                data[i][8] = rest.getString("car_rent");
                data[i][9] = rest.getString("total_days");
                data[i][10] = rest.getString("booking_date");
                data[i][11] = rest.getString("booking_status");
                i++;
                
            }

            t = new JTable(data, columns);
            t.setFont(f);   
            t.setBackground(Color.BLACK);
            t.setForeground(Color.WHITE);

            JScrollPane scrollPane = new JScrollPane(t);
            add(scrollPane);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new ViewUserBookingHistory().setVisible(true);
    }
}
// new page create for Only user can see own BookingHistory by shreya 14/2/25 