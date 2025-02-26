package Car;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.Period;
import java.sql.*;
import java.util.*;

public class Signup_User implements ActionListener {
    JLabel title, nameLbl, usernameLbl, passwordLbl, emailLbl, genderLbl, phoneLbl, licenseLbl, dobLbl, ageLbl, addressLbl;
    JTextField nameField, usernameField, emailField, phoneField, ageField;
    JTextArea addressField;
    JPasswordField passwordField;
    JButton submitBtn, backBtn;
    JComboBox<String> genderBox, licenseBox, dayBox, monthBox, yearBox;
    JCheckBox agreementCheckBox;
    JFrame frame;

    Signup_User() {
        frame = new JFrame("User SignUp");
        frame.setSize(900, 650);
        frame.setLocation(300, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(50, 30, 780, 550);
        panel.setBackground(new Color(30, 30, 30)); // Dark Background
        panel.setBorder(BorderFactory.createLineBorder(new Color(70, 130, 180), 2)); // Stylish Border
        panel.setLayout(null);
        frame.add(panel);

        title = new JLabel("User SignUp");
        title.setFont(new Font("Arial", Font.BOLD, 28));
        title.setForeground(new Color(70, 130, 180));
        title.setBounds(280, 10, 300, 40);
        panel.add(title);

        nameLbl = createLabel("Name", 50, 80);
        nameField = createTextField(200, 80);
        panel.add(nameLbl);
        panel.add(nameField);

        usernameLbl = createLabel("Username", 400, 80);
        usernameField = createTextField(550, 80);
        panel.add(usernameLbl);
        panel.add(usernameField);

        passwordLbl = createLabel("Password", 50, 130);
        passwordField = new JPasswordField();
        passwordField.setBounds(200, 130, 150, 30);
        panel.add(passwordLbl);
        panel.add(passwordField);

        emailLbl = createLabel("E-Mail", 400, 130);
        emailField = createTextField(550, 130);
        panel.add(emailLbl);
        panel.add(emailField);

        genderLbl = createLabel("Gender", 50, 180);
        genderBox = new JComboBox<>(new String[]{"Male", "Female", "Other"});
        genderBox.setBounds(200, 180, 150, 30);
        panel.add(genderLbl);
        panel.add(genderBox);

        phoneLbl = createLabel("Phone", 400, 180);
        phoneField = createTextField(550, 180);
        panel.add(phoneLbl);
        panel.add(phoneField);

        licenseLbl = createLabel("Driving License", 50, 230);
        licenseBox = new JComboBox<>(new String[]{"Yes", "No"});
        licenseBox.setBounds(200, 230, 150, 30);
        panel.add(licenseLbl);
        panel.add(licenseBox);

        dobLbl = createLabel("DOB", 400, 220);
        dayBox = new JComboBox<>();
        for (int i = 1; i <= 31; i++) dayBox.addItem(String.valueOf(i));
        dayBox.setBounds(550, 230, 50, 30);
        panel.add(dayBox);
        panel.add(dobLbl);

        monthBox = new JComboBox<>(new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"});
        monthBox.setBounds(610, 230, 60, 30);
        panel.add(monthBox);

        yearBox = new JComboBox<>();
        int currentYear = LocalDate.now().getYear();
        for (int i = currentYear; i >= 1900; i--) yearBox.addItem(String.valueOf(i));
        yearBox.setBounds(680, 230, 70, 30);
        panel.add(yearBox);

        ageLbl = createLabel("Age", 50, 280);
        ageField = createTextField(200, 280);
        ageField.setEditable(false);
        panel.add(ageLbl);
        panel.add(ageField);
         // **Automatically Calculate Age When DOB is Selected**
        ActionListener dobListener = e -> calculateAge();
        dayBox.addActionListener(dobListener);
        monthBox.addActionListener(dobListener);
        yearBox.addActionListener(dobListener);

        
        addressLbl = createLabel("Address", 50, 330);
        addressField = new JTextArea();
        addressField.setBounds(200, 330, 550, 60);
        addressField.setLineWrap(true);
        addressField.setWrapStyleWord(true);
        panel.add(addressLbl);
        panel.add(addressField);

        agreementCheckBox = new JCheckBox("I declare that all information provided is true");
        agreementCheckBox.setBounds(200, 410, 400, 30);
        panel.add(agreementCheckBox);

        submitBtn = new JButton("Submit");
        submitBtn.setBounds(250, 460, 150, 40);
        submitBtn.setBackground(new Color(70, 130, 180)); // Steel Blue
        submitBtn.setForeground(Color.WHITE);
        submitBtn.setFont(new Font("Arial", Font.BOLD, 16));
        submitBtn.setFocusPainted(false);
        panel.add(submitBtn);

        backBtn = new JButton("Back");
        backBtn.setBounds(450, 460, 150, 40);
        backBtn.setBackground(Color.BLACK);
        backBtn.setForeground(Color.RED);
        backBtn.setFont(new Font("Arial", Font.BOLD, 16));
        backBtn.setFocusPainted(false);
        panel.add(backBtn);
        
        submitBtn.addActionListener(this);
        backBtn.addActionListener(this);

        frame.setVisible(true);
    }

    private JLabel createLabel(String text, int x, int y) {
        JLabel label = new JLabel(text);
        label.setBounds(x, y, 140, 30);
        label.setFont(new Font("Arial", Font.BOLD, 18));
        label.setForeground(new Color(135, 206, 250)); // Light Blue
        return label;
    }

    private JTextField createTextField(int x, int y) {
        JTextField textField = new JTextField();
        textField.setBounds(x, y, 150, 30);
        return textField;
    }


    
    public void actionPerformed(ActionEvent e) {
    if (e.getSource() == submitBtn) {
        String name = nameField.getText();
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());
        String email = emailField.getText().trim();
         String phone = phoneField.getText().trim();
        String gender = (String) genderBox.getSelectedItem();
        String age = ageField.getText();
         String DOB = dayBox.getSelectedItem() + "-" + monthBox.getSelectedItem() + "-" + yearBox.getSelectedItem();     
        String license = (String) licenseBox.getSelectedItem();
        String address = addressField.getText().trim();

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

         //Driving License Validation
        if (!license.equals("Yes")) {
            JOptionPane.showMessageDialog(null, "You must have a Driving License to sign up.");
            return;
        }
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
        if (e.getSource() == submitBtn) {
            if (!agreementCheckBox.isSelected()) {
                JOptionPane.showMessageDialog(null, "You must agree that all information is true before submitting.");
                return;
            }

            JOptionPane.showMessageDialog(null, "Form Submitted Successfully!");
            frame.setVisible(false);
        } else if (e.getSource() == backBtn) {
            new Login();
            frame.setVisible(false);
        }
        try {
            ConnectionClass obj = new ConnectionClass();
            String q = "INSERT INTO user VALUES('" + user_id + "','" + name + "','" + username + "','" + password + "','" + email + "','" + gender + "','" + phone + "','" + license + "','" + DOB + "','" + address + "','" + age + "')";
            obj.stmt.executeUpdate(q);
            JOptionPane.showMessageDialog(null, "Details successfully inserted.");
            frame.setVisible(false);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    } else if (e.getSource() == backBtn) {
        new Login();
        frame.setVisible(false);
    }
}


    // Method to Calculate Age from DOB Selection**
    public void calculateAge() {
        try {
            int day = Integer.parseInt((String) dayBox.getSelectedItem());
            int month = monthBox.getSelectedIndex() + 1; // Convert Jan=0 to Jan=1
            int year = Integer.parseInt((String) yearBox.getSelectedItem());

            LocalDate dob = LocalDate.of(year, month, day);
            LocalDate today = LocalDate.now();
            int age = Period.between(dob, today).getYears();

            ageField.setText(String.valueOf(age)); // Auto-fill age
        } catch (Exception e) {
            ageField.setText("");
        }
        
    }

    public static void main(String[] args) {
        new Signup_User();
    }
}
//successfully done by shreya 2/9/2025 
//sucessfully done by Ashish for front end 26/02/2025 Shiv ratri jai mahakal 🙏
