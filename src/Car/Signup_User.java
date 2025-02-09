package Car;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.Period;
import java.sql.*;
import java.util.*;

public class Signup_User implements ActionListener {
    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10;
    JTextField t1, t2, t3, t5,t8, t9;
    JTextArea t6;
    JButton b1, b2;
    JPasswordField pf;
    JFrame f;
    JComboBox<String> ch1, ch2, dayBox, monthBox, yearBox; // DOB Selection

    Signup_User() {
        f = new JFrame("Add User Details for SignUP");
        f.setBackground(Color.white);
        f.setLayout(null);

        l1 = new JLabel();
        l1.setBounds(0, 0, 840, 600);
        l1.setLayout(null);

        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("Car/Icons/Signup_user.jpg"));
        Image i1 = img.getImage().getScaledInstance(840, 600, Image.SCALE_SMOOTH);
        ImageIcon img1 = new ImageIcon(i1);
        l1.setIcon(img1);

        l2 = new JLabel("Add User Details for SignUP");
        l2.setBounds(230, 30, 500, 50);
        l2.setFont(new Font("Arial", Font.BOLD, 30));
        l2.setForeground(Color.BLUE);
        l1.add(l2);
        f.add(l1);

        l3 = new JLabel("Name");
        l3.setBounds(50, 150, 150, 30);
        l3.setFont(new Font("Arial", Font.BOLD, 20));
        l3.setForeground(Color.BLUE);
        l1.add(l3);

        t1 = new JTextField();
        t1.setBounds(200, 150, 150, 30);
        l1.add(t1);

        l4 = new JLabel("Username");
        l4.setBounds(450, 150, 200, 30);
        l4.setFont(new Font("Arial", Font.BOLD, 20));
        l4.setForeground(Color.BLUE);
        l1.add(l4);

        t2 = new JTextField();
        t2.setBounds(600, 150, 150, 30);
        l1.add(t2);

        l5 = new JLabel("Password");
        l5.setBounds(50, 200, 100, 30);
        l5.setFont(new Font("Arial", Font.BOLD, 20));
        l5.setForeground(Color.BLUE);
        l1.add(l5);

        pf = new JPasswordField();
        pf.setBounds(200, 200, 150, 30);
        l1.add(pf);

        l6 = new JLabel("E-Mail");
        l6.setBounds(450, 200, 200, 30);
        l6.setFont(new Font("Arial", Font.BOLD, 20));
        l6.setForeground(Color.BLUE);
        l1.add(l6);

        t3 = new JTextField();
        t3.setBounds(600, 200, 150, 30);
        l1.add(t3);

        l7 = new JLabel("Gender");
        l7.setBounds(50, 250, 140, 30);
        l7.setFont(new Font("Arial", Font.BOLD, 20));
        l7.setForeground(Color.BLUE);
        l1.add(l7);

        ch1 = new JComboBox<>(new String[]{"Male", "Female", "Other"});
        ch1.setBounds(200, 250, 150, 30);
        l1.add(ch1);

        l8 = new JLabel("Phone");
        l8.setBounds(450, 250, 100, 30);
        l8.setFont(new Font("Arial", Font.BOLD, 20));
        l8.setForeground(Color.BLUE);
        l1.add(l8);

        t5 = new JTextField();
        t5.setBounds(600, 250, 150, 30);
        l1.add(t5);

        l9 = new JLabel("Driving Licence");
        l9.setBounds(50, 300, 160, 30);
        l9.setFont(new Font("Arial", Font.BOLD, 20));
        l9.setForeground(Color.BLUE);
        l1.add(l9); 

        ch2 = new JComboBox<>(new String[]{"Yes", "No"});
        ch2.setBounds(200, 300, 150, 30);
        l1.add(ch2);
        
        // Address Label
        JLabel l11 = new JLabel("Address");
        l11.setBounds(50, 400, 100, 30);
        l11.setFont(new Font("Arial", Font.BOLD, 20));
        l11.setForeground(Color.BLUE);
        l1.add(l11);

        // Address TextArea
        t6 = new JTextArea();
t6.setBounds(200, 400, 550, 60);
t6.setLineWrap(true);
t6.setWrapStyleWord(true);
l1.add(t6);


        //  **Custom DOB Picker (Dropdowns for Day, Month, Year)**
        l10 = new JLabel("DOB");
        l10.setBounds(450, 300, 200, 30);
        l10.setFont(new Font("Arial", Font.BOLD, 20));
        l10.setForeground(Color.BLUE);
        l1.add(l10);

        // Day Dropdown (1-31)
        dayBox = new JComboBox<>();
        for (int i = 1; i <= 31; i++) {
            dayBox.addItem(String.valueOf(i));
        }
        dayBox.setBounds(600, 300, 50, 30);
        l1.add(dayBox);

        // Month Dropdown (Jan-Dec)
        monthBox = new JComboBox<>(new String[]{
                "Jan", "Feb", "Mar", "Apr", "May", "Jun",
                "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"});
        monthBox.setBounds(660, 300, 60, 30);
        l1.add(monthBox);

        // Year Dropdown (1900 - Current Year)
        yearBox = new JComboBox<>();
        int currentYear = LocalDate.now().getYear();
        for (int i = currentYear; i >= 1900; i--) {
            yearBox.addItem(String.valueOf(i));
        }
        yearBox.setBounds(730, 300, 70, 30);
        l1.add(yearBox);

        l10 = new JLabel("Age");
        l10.setBounds(50, 350, 100, 30);
        l10.setFont(new Font("Arial", Font.BOLD, 20));
        l10.setForeground(Color.BLUE);
        l1.add(l10);

        t9 = new JTextField();
        t9.setBounds(200, 350, 150, 30);
        t9.setEditable(false); // Age should be auto-calculated
        l1.add(t9);

        //  **Automatically Calculate Age When DOB is Selected**
        ActionListener dobListener = e -> calculateAge();
        dayBox.addActionListener(dobListener);
        monthBox.addActionListener(dobListener);
        yearBox.addActionListener(dobListener);

        b1 = new JButton("Submit");
        b2 = new JButton("Back");

        b1.setBounds(250, 500, 150, 40);
        b2.setBounds(450, 500, 150, 40);
        b1.setBackground(Color.RED);
        b2.setBackground(Color.BLACK);

        b1.setForeground(Color.WHITE);
        b2.setForeground(Color.RED);

        b1.addActionListener(this);
        b2.addActionListener(this);

        l1.add(b1);
        l1.add(b2);

        f.setVisible(true);
        f.setSize(840, 600);
        f.setLocation(300, 100);
    }

    public void actionPerformed(ActionEvent e) {
    if (e.getSource() == b1) {
        String name = t1.getText();
        String username = t2.getText();
        String password = new String(pf.getPassword());
        String email = t3.getText().trim();
         String phone = t5.getText().trim();
        String gender = (String) ch1.getSelectedItem();
        String age = t9.getText();
         String DOB = dayBox.getSelectedItem() + "-" + monthBox.getSelectedItem() + "-" + yearBox.getSelectedItem();     
        String drivingLicense = (String) ch2.getSelectedItem();
        String address = t6.getText().trim();

      // Ensure DOB is selected
        if (dayBox.getSelectedItem() == null || monthBox.getSelectedItem() == null || yearBox.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(null, "Please select your birthdate!");
            return;
        }

        // Ensure the user is at least 18 years old
        if (age.isEmpty() || Integer.parseInt(age) < 18) {
            JOptionPane.showMessageDialog(null, "You must be at least 18 years old to sign up.");
            return;
        }

        String DO = dayBox.getSelectedItem() + "-" + monthBox.getSelectedItem() + "-" + yearBox.getSelectedItem();

        Random r = new Random();
        String user_id = "" + Math.abs(r.nextInt() % 100000);

        // Email Validation
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
        if (!email.matches(emailRegex)) {
            JOptionPane.showMessageDialog(null, "Invalid Email Format! Please enter a valid email.");
            return;
        }

        // Phone Validation
        if (!phone.matches("\\d{10}")) {
            JOptionPane.showMessageDialog(null, "Invalid Phone Number! Enter exactly 10 digits.");
            return;
        }
        
        try {
            ConnectionClass obj = new ConnectionClass();
            String q = "INSERT INTO user VALUES('" + user_id + "','" + name + "','" + username + "','" + password + "','" + email + "','" + phone + "','" + gender + "','" + age + "','" + DOB + "','" + drivingLicense + "','" + address + "')";
            obj.stmt.executeUpdate(q);
            JOptionPane.showMessageDialog(null, "Details successfully inserted.");
            f.setVisible(false);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    } else if (e.getSource() == b2) {
        new Login();
        f.setVisible(false);
    }
}


    //  **Method to Calculate Age from DOB Selection**
    public void calculateAge() {
        try {
            int day = Integer.parseInt((String) dayBox.getSelectedItem());
            int month = monthBox.getSelectedIndex() + 1; // Convert Jan=0 to Jan=1
            int year = Integer.parseInt((String) yearBox.getSelectedItem());

            LocalDate dob = LocalDate.of(year, month, day);
            LocalDate today = LocalDate.now();
            int age = Period.between(dob, today).getYears();

            t9.setText(String.valueOf(age)); // Auto-fill age
        } catch (Exception e) {
            t9.setText("");
        }
        
    }

    public static void main(String[] args) {
        new Signup_User();
    }
}
//successfully done by shreya 2/9/2025 
