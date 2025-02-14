package Car;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Login implements ActionListener {

    JLabel l1, l2, l3, l4, l5;
    JTextField t1;
    JButton b1, b2;
    JPasswordField pf;
    JFrame f;
    Choice ch1;
        public static String loggedInUser = null;  //  Store the logged-in user

    
    public Login() {
        // Create Frame
        f = new JFrame("Login Page");
        f.setLayout(null);

        // Background Image
        l1 = new JLabel();
        l1.setBounds(0, 0, 580, 350);
        l1.setLayout(null);
        
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("Car/Icons/Login_Page.jpeg"));
        Image i1 = img.getImage().getScaledInstance(580, 350, Image.SCALE_SMOOTH);
        l1.setIcon(new ImageIcon(i1));

        // Title
        l2 = new JLabel("Login Account");
        l2.setBounds(190, 22, 500, 50);
        l2.setFont(new Font("Arial", Font.BOLD, 30));
        l2.setForeground(Color.GREEN);
        l1.add(l2);
        f.add(l1);

        // Username Label & Text Field
        l3 = new JLabel("Username");
        l3.setBounds(120, 135, 150, 30);
        l3.setFont(new Font("Arial", Font.BOLD, 20));
        l3.setForeground(Color.WHITE);
        l1.add(l3);

        t1 = new JTextField();
        t1.setBounds(320, 135, 150, 30);
        t1.setFont(new Font("Arial", Font.BOLD, 15));
        l1.add(t1);

        // Password Label & Field
        l4 = new JLabel("Password");
        l4.setBounds(120, 185, 150, 30);
        l4.setFont(new Font("Arial", Font.BOLD, 20));
        l4.setForeground(Color.WHITE);
        l1.add(l4);

        pf = new JPasswordField();
        pf.setBounds(320, 185, 150, 30);
        pf.setFont(new Font("Arial", Font.BOLD, 15));
        l1.add(pf);

        // Account Type (Admin/User)
        l5 = new JLabel("Login Account");
        l5.setBounds(120, 90, 150, 30);
        l5.setFont(new Font("Arial", Font.BOLD, 15));
        l5.setForeground(Color.WHITE);
        l1.add(l5);

        ch1 = new Choice();
        ch1.add("Admin");
        ch1.add("User");
        ch1.setBounds(320, 90, 150, 30);
        ch1.setFont(new Font("Arial", Font.BOLD, 15));
        l1.add(ch1);

        // Buttons
        b1 = new JButton("Login");
        b2 = new JButton("User Signup");

        b1.setBounds(120, 235, 150, 40);
        b2.setBounds(320, 235, 150, 40);
        b1.setBackground(Color.BLACK);
        b2.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b2.setForeground(Color.RED);

        b1.addActionListener(this);
        b2.addActionListener(this);

        l1.add(b1);
        l1.add(b2);

        // Show Frame
        f.setVisible(true);
        f.setSize(580, 360);
        f.setLocation(300, 100);
        f.setResizable(false);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            String account = ch1.getSelectedItem();
            String username = t1.getText();
            String password = new String(pf.getPassword());

            if (username.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(f, "Please enter both username and password", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            try {
                ConnectionClass obj = new ConnectionClass();
                String q = "SELECT * FROM " + (account.equals("Admin") ? "admin" : "user") + " WHERE username=? AND password=?";
                PreparedStatement pstmt = obj.con.prepareStatement(q);
                pstmt.setString(1, username);
                pstmt.setString(2, password);
                ResultSet rs = pstmt.executeQuery();

                if (rs.next()) 
                {
                        loggedInUser = username;  // Save the logged-in user's name

                    f.dispose(); // Close Login Page
                    if (account.equals("Admin"))
                    {
                        new AdminHomePage().setVisible(true);
                    } 
                    else
                    {
                        new UserHomePage(username).setVisible(true);
                    }
                } 
                else 
                {
                    JOptionPane.showMessageDialog(f, "Invalid Username or Password", "Login Failed", JOptionPane.ERROR_MESSAGE);
                }
            }
            catch (Exception ex) 
            {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(f, "Database Error", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        if (e.getSource() == b2) {
            f.dispose(); // Close Login Page
            new Signup_User();
            f.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
// change by shreya 14/2/25  
