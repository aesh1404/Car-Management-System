package Car;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class UpdateUserDetails extends JFrame implements ActionListener {
    private JLabel lTitle, lUsername, lName, lPassword, lEmail, lGender, lPhone, lDOB, lAddress, lAge;
    private JTextField tfName, tfPassword, tfEmail, tfGender, tfPhone, tfDOB, tfAddress, tfAge;
    private JLabel lblUsernameValue; // Read-only username label
    private JButton btnUpdate, btnBack;
    private String loggedInUser;

    // ✅ Constructor
    public UpdateUserDetails(String username) {
        this.loggedInUser = username; // Store the username
        
        setTitle("Update User Details");
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initComponents(); // ✅ Initialize UI components
        
        // ✅ Load user data from database
        loadUserData();
    }

    // ✅ Method to initialize UI components
    private void initComponents() {
        Font labelFont = new Font("Arial", Font.BOLD, 14);
        Font titleFont = new Font("Arial", Font.BOLD, 20);
        
        // Title
        lTitle = new JLabel("Update User Details", JLabel.CENTER);
        lTitle.setFont(titleFont);
        lTitle.setForeground(Color.RED);
        
        // Labels
        lUsername = new JLabel("Username:");
        lName = new JLabel("Name:");
        lPassword = new JLabel("Password:");
        lEmail = new JLabel("E-mail:");
        lGender = new JLabel("Gender:");
        lPhone = new JLabel("Phone:");
        lDOB = new JLabel("DOB:");
        lAddress = new JLabel("Address:");
        lAge = new JLabel("Age:");
        
        // Set label fonts
        JLabel[] labels = {lUsername, lName, lPassword, lEmail, lGender, lPhone, lDOB, lAddress, lAge};
        for (JLabel label : labels) {
            label.setFont(labelFont);
        }

        // Fields
        lblUsernameValue = new JLabel(loggedInUser); // Username as label (read-only)
        lblUsernameValue.setFont(labelFont);
        
        tfName = new JTextField(15);
        tfPassword = new JTextField(15);
        tfEmail = new JTextField(15);
        tfGender = new JTextField(15);
        tfPhone = new JTextField(15);
        tfDOB = new JTextField(15);
        tfAddress = new JTextField(15);
        tfAge = new JTextField(15);

        // Buttons
        btnUpdate = new JButton("Update");
        btnUpdate.setBackground(Color.RED);
        btnUpdate.setForeground(Color.WHITE);
        btnUpdate.addActionListener(this);

        btnBack = new JButton("Back");
        btnBack.setBackground(Color.BLACK);
        btnBack.setForeground(Color.WHITE);
        btnBack.addActionListener(this);

        // Panel Layout
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Padding
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(lUsername, gbc);
        gbc.gridx = 1;
        panel.add(lblUsernameValue, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(lName, gbc);
        gbc.gridx = 1;
        panel.add(tfName, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(lPassword, gbc);
        gbc.gridx = 1;
        panel.add(tfPassword, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(lEmail, gbc);
        gbc.gridx = 1;
        panel.add(tfEmail, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(lGender, gbc);
        gbc.gridx = 1;
        panel.add(tfGender, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 5;
        panel.add(lPhone, gbc);
        gbc.gridx = 1;
        panel.add(tfPhone, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 6;
        panel.add(lDOB, gbc);
        gbc.gridx = 1;
        panel.add(tfDOB, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 7;
        panel.add(lAddress, gbc);
        gbc.gridx = 1;
        panel.add(tfAddress, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 8;
        panel.add(lAge, gbc);
        gbc.gridx = 1;
        panel.add(tfAge, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.gridwidth = 2;
        panel.add(btnUpdate, gbc);
        
        gbc.gridy = 10;
        panel.add(btnBack, gbc);
        
        // Add components to frame
        setLayout(new BorderLayout());
        add(lTitle, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);
    }

    // ✅ Method to load user data from database
    private void loadUserData() {
        try {
            ConnectionClass obj = new ConnectionClass();
            String query = "SELECT * FROM user WHERE username='" + loggedInUser + "'";
            ResultSet rest = obj.stmt.executeQuery(query);

            if (rest.next()) {
                tfName.setText(rest.getString("name"));
                tfPassword.setText(rest.getString("password"));
                tfEmail.setText(rest.getString("email"));
                tfGender.setText(rest.getString("gender"));
                tfPhone.setText(rest.getString("phone"));
                tfDOB.setText(rest.getString("DOB"));
                tfAddress.setText(rest.getString("Address"));
                tfAge.setText(rest.getString("age"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // ✅ Action Handling
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnUpdate) {
            updateUserDetails();
        } else if (e.getSource() == btnBack) {
            this.setVisible(false);
        }
    }

    // ✅ Method to update user details
    private void updateUserDetails() {
        String name = tfName.getText();
        String password = tfPassword.getText();
        String email = tfEmail.getText();
        String gender = tfGender.getText();
        String phone = tfPhone.getText();
        String DOB = tfDOB.getText();
        String Address = tfAddress.getText();
        String age = tfAge.getText();

        try {
            ConnectionClass obj3 = new ConnectionClass();
            String q1 = "UPDATE user SET name='" + name + "', password='" + password + "', email='" + email + 
                        "', gender='" + gender + "', phone='" + phone + "', DOB='" + DOB + "', Address='" + Address + 
                        "', age='" + age + "' WHERE username='" + loggedInUser + "'";
            int aa = obj3.stmt.executeUpdate(q1);

            if (aa == 1) {
                JOptionPane.showMessageDialog(null, "User details successfully updated");
                this.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(null, "Please fill all details carefully");
            }
        } catch (Exception ee) {
            ee.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new UpdateUserDetails("testuser").setVisible(true);
    }
}

//successfully done by ashish 14/02/2025
