package Car;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Login implements ActionListener {

    JLabel l2, l3, l4, l5;
    JTextField t1;
    JButton b1, b2;
    JPasswordField pf;
    JFrame f;
    Choice ch1;
    public static String loggedInUser = null;

    public Login() {
        f = new JFrame("Login Page");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(800, 500);
        f.setMinimumSize(new Dimension(600, 400)); // Prevents it from getting too small
        f.setLocationRelativeTo(null);
        f.setLayout(new GridBagLayout());
        f.getContentPane().setBackground(new Color(30, 30, 60));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Title
        l2 = new JLabel("Login Account");
        l2.setFont(new Font("Arial", Font.BOLD, 28));
        l2.setForeground(Color.ORANGE);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        f.add(l2, gbc);

        // Account Type Label
        l5 = new JLabel("Select Account:");
        l5.setForeground(Color.WHITE);
        gbc.gridwidth = 1;
        gbc.gridy++;
        gbc.anchor = GridBagConstraints.LINE_END;
        f.add(l5, gbc);

        // Account Type Choice
        ch1 = new Choice();
        ch1.add("Admin");
        ch1.add("User");
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        f.add(ch1, gbc);

        // Username Label
        gbc.gridx = 0;
        gbc.gridy++;
        l3 = new JLabel("Username:");
        l3.setForeground(Color.WHITE);
        gbc.anchor = GridBagConstraints.LINE_END;
        f.add(l3, gbc);

        // Username Field
        gbc.gridx = 1;
        t1 = new JTextField(15);
        t1.setPreferredSize(new Dimension(200, 30));
        f.add(t1, gbc);

        // Password Label
        gbc.gridx = 0;
        gbc.gridy++;
        l4 = new JLabel("Password:");
        l4.setForeground(Color.WHITE);
        gbc.anchor = GridBagConstraints.LINE_END;
        f.add(l4, gbc);

        // Password Field
        gbc.gridx = 1;
        pf = new JPasswordField(15);
        pf.setPreferredSize(new Dimension(200, 30));
        f.add(pf, gbc);

        // Login Button
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.anchor = GridBagConstraints.LINE_END;
        b1 = new JButton("Login");
        b1.setBackground(new Color(50, 150, 255));
        b1.setForeground(Color.WHITE);
        b1.setPreferredSize(new Dimension(120, 40));
        f.add(b1, gbc);

        // Signup Button
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        b2 = new JButton("User Signup");
        b2.setBackground(new Color(255, 50, 50));
        b2.setForeground(Color.WHITE);
        b2.setPreferredSize(new Dimension(120, 40));
        f.add(b2, gbc);

        b1.addActionListener(this);
        b2.addActionListener(this);

        f.setVisible(true);
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

                if (rs.next()) {
                    loggedInUser = username;
                    f.dispose();
                    if (account.equals("Admin")) {
                        new AdminHomePage().setVisible(true);
                    } else {
                        new UserHomePage(username).setVisible(true);
                    }
                } else {
                    JOptionPane.showMessageDialog(f, "Invalid Username or Password", "Login Failed", JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(f, "Database Error", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        if (e.getSource() == b2) {
            f.dispose();
            new Signup_User();
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
//Changed by shreya 14/2
//sucessfully done by Ashish for front end 26/02/2025 Shiv ratri jai mahakal 🙏
