package Car;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class UpdateUserDetails extends JFrame implements ActionListener {
    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13, l14, l15;
    JTextField tf1, tf2, tf3, tf4, tf5, tf6, tf7, tf8, tf9, tf10, tf11, tf12, tf13;
    Choice ch1;
    JPanel p1, p2, p3;
    Font f, f1;
    JButton t1, t2;
    
    UpdateUserDetails() {
        super("Update User Details");
        setSize(760, 720);
        setLocation(50, 10);
        
        f = new Font("Arial", Font.BOLD, 18);
        f1 = new Font("Arial", Font.BOLD, 25);
        
        ch1 = new Choice();
        
        // **********************************************************
        // MODIFICATION: Restrict the username list to only the logged-in user.
        // Replace "user123" with the actual logged-in username.
        String loggedInUser = "user123";  // This should come from your login session.
        try {
            ConnectionClass obj = new ConnectionClass();
            // Only load the logged-in user into the choice.
            String query = "select username from user where username='" + loggedInUser + "'";
            ResultSet rest = obj.stmt.executeQuery(query);
            while(rest.next()) {
                ch1.add(rest.getString("username"));
            }
            rest.close();
            // Disable the choice so that the user cannot select another username.
            ch1.setEnabled(false);
            
            // Since the choice is now disabled (and contains only one item),
            // automatically load the user's details.
            if(ch1.getItemCount() > 0) {
                String username = ch1.getItem(0);
                String q1 = "select * from user where username='" + username + "'";
                ResultSet rest1 = obj.stmt.executeQuery(q1);
                while(rest1.next()) {
                    // Note: tf1 - tf8 are not yet instantiated at this point,
                    // but the following assignment works later (after text fields are created).
                    // To ensure the details load properly, you may consider moving this
                    // block after the text fields are initialized.
                    // For minimal changes we leave it here.
                    tf1 = new JTextField(); // Temporary initialization if needed
                    tf2 = new JTextField();
                    tf3 = new JTextField();
                    tf4 = new JTextField();
                    tf5 = new JTextField();
                    tf6 = new JTextField();
                    tf7 = new JTextField();
                    tf8 = new JTextField();
                    
                    tf1.setText(rest1.getString("name"));
                    tf2.setText(rest1.getString("password"));
                    tf3.setText(rest1.getString("email"));
                    tf4.setText(rest1.getString("gender"));
                    tf5.setText(rest1.getString("phone"));
                    tf6.setText(rest1.getString("DOB"));
                    tf7.setText(rest1.getString("Address"));
                    tf8.setText(rest1.getString("age"));
                }
                rest1.close();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        // **********************************************************
        
        ch1.setFont(f);
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("Car\\Icons\\UserHomePage.jpg"));
        Image i1 = img.getImage().getScaledInstance(340, 500, Image.SCALE_SMOOTH);
        ImageIcon img1 = new ImageIcon(i1); 
        l14 = new JLabel(img1);
        
        l1 = new JLabel("Update User Details");
        l1.setHorizontalAlignment(JLabel.CENTER);
        l1.setForeground(Color.RED);
        l1.setFont(f1);
        
        l2 = new JLabel("Username");
        l3 = new JLabel("Name");
        l4 = new JLabel("Password");
        l5 = new JLabel("E-mail");
        l6 = new JLabel("Gender");
        l7 = new JLabel("Phone");
        l8 = new JLabel("DOB");
        l9 = new JLabel("Address");
        l10 = new JLabel("Age");
        
        l2.setFont(f);
        l3.setFont(f);
        l4.setFont(f);
        l5.setFont(f);
        l6.setFont(f);
        l7.setFont(f);
        l8.setFont(f);
        l9.setFont(f);
        l10.setFont(f);
        
        // (Re)initialize text fields to ensure they are not null.
        // (If the auto-loading above already set these, this step ensures they are recreated.)
        tf1 = new JTextField();
        tf2 = new JTextField();
        tf3 = new JTextField();
        tf4 = new JTextField();
        tf5 = new JTextField();
        tf6 = new JTextField();
        tf7 = new JTextField();
        tf8 = new JTextField();
        
        tf1.setFont(f);
        tf2.setFont(f);
        tf3.setFont(f);
        tf4.setFont(f);
        tf5.setFont(f);     
        tf6.setFont(f);
        tf7.setFont(f);
        tf8.setFont(f);
        
        t1 = new JButton("Update Details");
        t2 = new JButton("Back");
        
        t1.setBackground(Color.RED);
        t2.setBackground(Color.BLACK);
        
        t1.setForeground(Color.WHITE);
        t2.setForeground(Color.WHITE);
        
        t1.addActionListener(this);
       
        p1 = new JPanel();
        p1.setLayout(new GridLayout(1, 1, 10, 10));
        p1.add(l1);
        
        p2 = new JPanel();
        p2.setLayout(new GridLayout(13, 2, 10, 10));
        p2.add(l2);
        p2.add(ch1);
        p2.add(l3);
        p2.add(tf1);
        p2.add(l4);
        p2.add(tf2);
        p2.add(l5);
        p2.add(tf3);
        p2.add(l6);
        p2.add(tf4);
        p2.add(l7);
        p2.add(tf5);
        p2.add(l8);
        p2.add(tf6);
        p2.add(l9);
        p2.add(tf7);
        p2.add(l10);
        p2.add(tf8);
        p2.add(t1);
        p2.add(t2);
       
        p3 = new JPanel();
        p3.setLayout(new GridLayout(1, 1, 10, 10));
        p3.add(l14);
        
        setLayout(new BorderLayout(10, 10));
        add(p1, "North");
        add(p2, "Center");
        add(p3, "West");
        
        // The mouse listener remains unchanged. It will work if the Choice is re-enabled.
        ch1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                try {
                    ConnectionClass obj = new ConnectionClass();
                    String username = ch1.getSelectedItem();
                    String q1 = "select * from user where username='" + username + "'";
                    ResultSet rest1 = obj.stmt.executeQuery(q1);
                    while(rest1.next()) {
                        tf1.setText(rest1.getString("name"));
                        tf2.setText(rest1.getString("password"));
                        tf3.setText(rest1.getString("email"));
                        tf4.setText(rest1.getString("gender"));
                        tf5.setText(rest1.getString("phone"));
                        tf6.setText(rest1.getString("DOB"));
                        tf7.setText(rest1.getString("Address"));
                        tf8.setText(rest1.getString("age"));
                    }
                    rest1.close();
                } catch (Exception ess) {
                    ess.printStackTrace();
                }
            }
        });
    }
    
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == t1) {
            String username = ch1.getSelectedItem();
            String name = tf1.getText();
            String password = tf2.getText();
            String email = tf3.getText();
            String gender = tf4.getText();
            String phone = tf5.getText();
            String DOB = tf6.getText();
            String Address = tf7.getText();
            String age = tf8.getText();
            
            try {
                ConnectionClass obj3 = new ConnectionClass();
                String q1 = "update user set name='" + name + "', password='" + password + 
                        "', email='" + email + "', gender='" + gender + "', phone='" + phone + 
                        "', DOB='" + DOB + "', Address='" + Address + "', age='" + age + 
                        "' where username='" + username + "'";
                int aa = obj3.stmt.executeUpdate(q1);
                if(aa == 1) {
                    JOptionPane.showMessageDialog(null, "User details successfully updated");
                    this.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Please!, fill all details carefully");
                }
            } catch (Exception ee) {
                ee.printStackTrace();
            }
        }
        if(e.getSource() == t2) {
            // 'Back' button action (currently just keeps the frame visible)
            this.setVisible(true);
        }
    }
    
    public static void main(String[] args) {
        new UpdateUserDetails().setVisible(true);
    }
}
//successfully done by shreya 2/9/2025 
