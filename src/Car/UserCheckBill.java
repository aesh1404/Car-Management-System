package Car;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class UserCheckBill extends JFrame implements ActionListener {

    JButton b1, b2;
    JLabel l1, l2;
    JTextArea ta;
    Choice ch2;
    JPanel p1;
    Font f;
    private String loggedInUsername;

    public UserCheckBill(String username) {
        this.loggedInUsername = username;
        setTitle("Generate Bill Slip");
        setLocation(100, 100);
        setSize(500, 500);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        f = new Font("Lucida Fax", Font.BOLD, 16);

        l1 = new JLabel("Logged-in User:");
        l2 = new JLabel("Booking ID:");
        l1.setFont(f);
        l2.setFont(f);

        // Show the logged-in user's username (not editable)
        JTextField t1 = new JTextField(loggedInUsername);
        t1.setEditable(false);
        t1.setFont(f);

        // Choice Box for Booking IDs
        ch2 = new Choice();
        ch2.setFont(f);
        loadBookingIds(); // Load only the logged-in user's booking IDs

        // Buttons
        b1 = new JButton("Show");
        b2 = new JButton("Print PDF");
        setupButton(b1);
        setupButton(b2);

        // Text Area for Bill
        ta = new JTextArea();
        ta.setFont(f);
        ta.setEditable(false);
        JScrollPane sp = new JScrollPane(ta);

        // Panel Layout
        p1 = new JPanel(new GridLayout(3, 2, 10, 10));
        p1.add(l1);
        p1.add(t1);
        p1.add(l2);
        p1.add(ch2);
        p1.add(b1);
        p1.add(b2);

        setLayout(new BorderLayout());
        add(sp, BorderLayout.CENTER);
        add(p1, BorderLayout.SOUTH);

        // Action Listeners
        b1.addActionListener(this);
        b2.addActionListener(this);
    }

    private void setupButton(JButton button) {
        button.setBackground(Color.BLACK);
        button.setForeground(Color.WHITE);
        button.setFont(f);
    }

    private void loadBookingIds() {
    try {
        ConnectionClass obj = new ConnectionClass(); // Use existing connection class
        String query = "SELECT DISTINCT booking_id FROM car_booking WHERE customer_username = '" + loggedInUsername + "'";
        ResultSet rs = obj.stmt.executeQuery(query);

        while (rs.next()) {
            ch2.add(rs.getString("booking_id"));
        }
    } catch (Exception ex) {
        ex.printStackTrace();
    }
}


    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            showBill();
        } else if (e.getSource() == b2) {
            printBill();
        }
    }

    private void showBill() {
        ta.setText("-----------Car Booking Bill-----------");

        String bookingId = ch2.getSelectedItem();
        if (bookingId == null || bookingId.isEmpty()) {
            ta.append("\n\n No bookings found for this user.");
            return;
        }

        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cms", "root", "@esh1404");
             PreparedStatement stmt = con.prepareStatement("SELECT * FROM car_booking WHERE customer_username = ? AND booking_id = ?")) {
            stmt.setString(1, loggedInUsername);
            stmt.setString(2, bookingId);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                ta.append("\n\n Customer Name: " + rs.getString("customer_name"));
                ta.append("\n\n Customer Phone: " + rs.getString("customer_phone"));
                ta.append("\n---------------------------------------------------\n");
                ta.append("\n\n Car Brand Name: " + rs.getString("brand_name"));
                ta.append("\n\n Car Brand Model: " + rs.getString("brand_model"));
                ta.append("\n\n Car Number: " + rs.getString("car_no"));
                ta.append("\n\n Car Name: " + rs.getString("car_name"));
                ta.append("\n---------------------------------------------------\n");
                ta.append("\n\n Total Days: " + rs.getString("total_days"));
                ta.append("\n\n Booking Date: " + rs.getString("booking_date"));
                ta.append("\n\n Return Date: " + rs.getString("return_date"));
                ta.append("\n---------------------------------------------------\n");

                // Calculate Payment with Tax
                float grossPayment = rs.getFloat("car_rent");
                double tax = (grossPayment * 2.1) / 100;
                double totalPayment = grossPayment + tax;

                ta.append("\n Gross Payment: " + grossPayment);
                ta.append("\n Tax: " + tax);
                ta.append("\n Total Payment: " + totalPayment);
            } else {
                ta.append("\n\n No bill found for the selected booking ID.");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void printBill() {
        try {
            ta.print();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new UserCheckBill("testuser").setVisible(true));
    }
}
//Successfully done by ashish In this you need to change database connection password in loadBookingIds & ShowBill function
