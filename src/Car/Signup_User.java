package Car;


import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.Period;
import java.sql.*;
import java.util.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class Signup_User extends javax.swing.JFrame implements ActionListener {
    JLabel titleLabel, nameLbl, usernameLbl, passwordLbl, emailLbl, genderLbl, phoneLbl, licenseLbl, dobLbl, ageLbl, addressLbl,stateLbl, cityLbl, countryLbl,passwordStrengthLabel,otpLbl;
    JTextField nameField, usernameField, emailField, phoneField, ageField,countryField,addressField;
    JPasswordField passwordField;
    JButton submitBtn, backBtn;
    JComboBox<String> genderBox, licenseBox, dayBox, monthBox, yearBox,stateBox, cityBox;
    JCheckBox agreementCheckBox;
    JFrame frame;
    
    JButton sendOTPButton = new JButton("Send OTP");
    JTextField otpField = new JTextField();
    JButton verifyOTPButton = new JButton("Verify OTP");
     
    
    //public static final String ACCOUNT_SID = "AC3f121b77d52516b7bb0902babb5ac8e6";
    //public static final String AUTH_TOKEN = "5385569682d95ea65cf3d73acef0b4aa";
    //public static final String TWILIO_PHONE_NUMBER = "+917046332302";
    
    public Signup_User() 
    {
        frame = new JFrame("User SignUp");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(20, 20, 800, 700);
        panel.setBackground(new Color(34, 34, 34)); // Dark background
        frame.add(panel);

        titleLabel = new JLabel("User SignUp");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(new Color(135, 206, 250));
        titleLabel.setBounds(280, 10, 300, 40);
        panel.add(titleLabel);

        // Name
        nameLbl = createLabel("Name", 50, 70);
        nameField = createTextField(200, 70, 150);
        panel.add(nameLbl);
        panel.add(nameField);

        // Username
        usernameLbl = createLabel("Username", 400, 70);
        usernameField = createTextField(550, 70, 150);
        panel.add(usernameLbl);
        panel.add(usernameField);

        // Password
        passwordLbl = createLabel("Password", 50, 120);
        passwordField = new JPasswordField();
        passwordField.setBounds(200, 120, 150, 30);
        panel.add(passwordLbl);
        panel.add(passwordField);
        passwordField.setToolTipText("Min 8 chars, 1 uppercase, 1 lowercase, 1 digit, 1 special char");
        passwordStrengthLabel = new JLabel("Password Strength: ");
        passwordStrengthLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        passwordStrengthLabel.setForeground(Color.DARK_GRAY);


        passwordStrengthLabel.setBounds(passwordField.getX(), passwordField.getY() + 30, 250, 20);
        panel.add(passwordStrengthLabel);

        passwordField.getDocument().addDocumentListener(new DocumentListener() 
        {
            public void changedUpdate(DocumentEvent e) 
            {
                updatePasswordStrength();
            }
            public void removeUpdate(DocumentEvent e) {
            
                updatePasswordStrength();
            }
            public void insertUpdate(DocumentEvent e) {
                updatePasswordStrength();
            }
        });

        
        // Email
        emailLbl = createLabel("E-Mail", 400, 120);
        emailField = createTextField(550, 120, 150);
        panel.add(emailLbl);
        panel.add(emailField);

        // Gender
        genderLbl = createLabel("Gender", 50, 170);
        genderBox = new JComboBox<>(new String[]{"Male", "Female"});
        genderBox.setBounds(200, 170, 150, 30);
        panel.add(genderLbl);
        panel.add(genderBox);

        // Phone
        phoneLbl = createLabel("Phone", 400, 170);
        phoneField = createTextField(550, 170, 150);
        panel.add(phoneLbl);
        panel.add(phoneField);
        
        sendOTPButton.setBounds(400, 200, 100, 30); 
        otpLbl = createLabel("Enter OTP:", 460, 230);
        otpField.setBounds(550, 230, 80, 30);
        verifyOTPButton.setBounds(640, 230, 100, 30);
        panel.add(sendOTPButton);
        panel.add(otpLbl);
        panel.add(otpField);
        panel.add(verifyOTPButton);
        
        sendOTPButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                JOptionPane.showMessageDialog(null, "This feature is under processing....");
            }
        });
        
        verifyOTPButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                JOptionPane.showMessageDialog(null, "This feature is under processing....");
            }
        });

        // Driving License
        licenseLbl = createLabel("Driving License", 50, 220);
        licenseBox = new JComboBox<>(new String[]{"Yes", "No"});
        licenseBox.setBounds(200, 220, 150, 30);
        panel.add(licenseLbl);
        panel.add(licenseBox);

        // DOB Selection
        dobLbl = createLabel("DOB", 50, 270);
        panel.add(dobLbl);
        dayBox = createComboBox(1, 31, 200, 270, 50);
        monthBox = new JComboBox<>(new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"});
        monthBox.setBounds(260, 270, 80, 30);
        yearBox = createComboBox(1950, LocalDate.now().getYear(), 350, 270, 80);
        panel.add(dayBox);
        panel.add(monthBox);
        panel.add(yearBox);
        
        // Age Field
        ageLbl = createLabel("Age", 450, 270);
        panel.add(ageLbl);
        ageField = createTextField(500, 270, 80);
        ageField.setEditable(false);
        panel.add(ageField);

        // Auto-calculate age
        ActionListener dobListener = e -> 
        {
            updateDays();
            calculateAge();
        };
        dayBox.addActionListener(dobListener);
        monthBox.addActionListener(dobListener);
        yearBox.addActionListener(dobListener);

        updateDays(); // Initialize days correctly
        
        // Address Field (Full row)
        addressLbl = createLabel("Address", 50, 320);
        panel.add(addressLbl);
        addressField = new JTextField();
        addressField.setBounds(200, 320, 500, 30);
        panel.add(addressField);

        // State & City Row
        stateLbl = createLabel("State", 50, 370);
        panel.add(stateLbl);
        stateBox = new JComboBox<>(new String[]{"Select State", "Maharashtra", "Delhi", "Karnataka", "Tamil Nadu","Gujarat"});
        stateBox.setBounds(200, 370, 150, 30);
        stateBox.addActionListener(e -> updateCities());
        panel.add(stateBox);

        cityLbl = createLabel("City", 400, 370);
        panel.add(cityLbl);
        cityBox = new JComboBox<>(new String[]{"Select City"});
        cityBox.setBounds(550, 370, 150, 30);
        panel.add(cityBox);

        // Country Field
        countryLbl = createLabel("Country", 50, 420);
        panel.add(countryLbl);
        countryField = new JTextField("India");
        countryField.setBounds(200, 420, 150, 30);
        countryField.setEditable(false);
        panel.add(countryField);

        // Agreement Checkbox
        agreementCheckBox = new JCheckBox("I declare that the information provided is true");
        agreementCheckBox.setBounds(50, 470, 500, 30);
        agreementCheckBox.setBackground(new Color(34, 34, 34));
        agreementCheckBox.setForeground(new Color(135, 206, 250));
        panel.add(agreementCheckBox);

        // Submit & Back Buttons
        submitBtn = new JButton("Submit");
        submitBtn.setBounds(200, 510, 150, 40);
        submitBtn.setBackground(new Color(70, 130, 180));
        submitBtn.setForeground(Color.WHITE);
        submitBtn.setFont(new Font("Arial", Font.BOLD, 16));
        submitBtn.setFocusPainted(false);
        panel.add(submitBtn);

        backBtn = new JButton("Back");
        backBtn.setBounds(400, 510, 150, 40);
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
        label.setForeground(Color.WHITE);
        label.setBounds(x, y, 150, 30);
        return label;
    }

    private JTextField createTextField(int x, int y, int width) {
        JTextField textField = new JTextField();
        textField.setBounds(x, y, width, 30);
        return textField;
    }

    private JComboBox<String> createComboBox(int start, int end, int x, int y, int width) {
        String[] items = new String[end - start + 1];
        for (int i = 0; i <= (end - start); i++) {
            items[i] = String.valueOf(start + i);
        }
        JComboBox<String> comboBox = new JComboBox<>(items);
        comboBox.setBounds(x, y, width, 30);
        return comboBox;
    }

    private JComboBox<String> createComboBox(String[] items, int x, int y, int width) {
        JComboBox<String> comboBox = new JComboBox<>(items);
        comboBox.setBounds(x, y, width, 30);
        return comboBox;
    }

     public void updateDays() 
     {
        if (yearBox.getSelectedItem() == null || monthBox.getSelectedItem() == null) return;

        int year = Integer.parseInt((String) yearBox.getSelectedItem());
        int month = monthBox.getSelectedIndex() + 1;

        int daysInMonth = switch (month) {
            case 4, 6, 9, 11 -> 30;
            case 2 -> (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) ? 29 : 28;
            default -> 31;
        };
        // Save the current selection before updating
        String selectedDay = (String) dayBox.getSelectedItem();

        dayBox.removeAllItems();
        for (int i = 1; i <= daysInMonth; i++) {
            dayBox.addItem(String.valueOf(i));
        }

        // Restore previous selection if it's valid
        if (selectedDay != null && Integer.parseInt(selectedDay) <= daysInMonth) {
            dayBox.setSelectedItem(selectedDay);
        } else {
            dayBox.setSelectedIndex(0); // Default to first day if previous selection is invalid
        }
    }

     // Method to Calculate Age from DOB Selection**
    public void calculateAge() 
    {
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
    private void updateCities() 
    {
        cityBox.removeAllItems();
        String selectedState = (String) stateBox.getSelectedItem();

        Map<String, String[]> stateCities = new HashMap<>();
        stateCities.put("Maharashtra", new String[]{"Mumbai", "Pune", "Nagpur"});
        stateCities.put("Delhi", new String[]{"New Delhi", "Old Delhi"});
        stateCities.put("Karnataka", new String[]{"Bangalore", "Mysore"});
        stateCities.put("Tamil Nadu", new String[]{"Chennai", "Coimbatore"});
        stateCities.put("Gujarat", new String[]{"Ahmedabad", "Surat", "Vadodara"}); // Added Gujarat cities

        if (stateCities.containsKey(selectedState)) {
            for (String city : stateCities.get(selectedState)) {
                cityBox.addItem(city);
            }
        } else {
            cityBox.addItem("Select City");
        }
    }
    private boolean isValidPassword(String password)
    {
        String passwordRegex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!]).{8,}$";
        return password.matches(passwordRegex);
    }

   private void updatePasswordStrength() {
    String password = new String(passwordField.getPassword());
    String strength = getPasswordStrength(password);

    // Color based on strength
    switch (strength) {
        case "Weak":
            passwordStrengthLabel.setForeground(Color.RED);
            break;
        case "Medium":
            passwordStrengthLabel.setForeground(Color.ORANGE);
            break;
        case "Strong":
            passwordStrengthLabel.setForeground(new Color(0, 128, 0)); // Dark green
            break;
        default:
            passwordStrengthLabel.setForeground(Color.GRAY);
    }

    passwordStrengthLabel.setText("Password Strength: " + strength);
}

private String getPasswordStrength(String password) {
    int score = 0;


    if (password.length() >= 8) score++;
    if (password.matches(".*[a-z].*")) score++;  // Contains at least one lowercase letter
    if (password.matches(".*[A-Z].*")) score++;  // Contains at least one uppercase letter
    if (password.matches(".*\\d.*")) score++;    // Contains at least one digit
    if (password.matches(".*[!@#$%^&*(),.?\":{}|<>].*")) score++;  // Contains at least one special character

    // Return strength based on score
    if (score <= 2) return "Weak";
    else if (score == 3 || score == 4) return "Medium";
    else return "Strong";
}

    
    
    public void actionPerformed(ActionEvent e) 
    {
    if (e.getSource() == submitBtn) {
        String name = nameField.getText();
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());
        String email = emailField.getText().trim();
        String phone = phoneField.getText().trim();
        String gender = (String) genderBox.getSelectedItem();
        String age = ageField.getText();
        String license = (String) licenseBox.getSelectedItem();
        String address = addressField.getText().trim();
        String state = (String) stateBox.getSelectedItem();
        String city = (String) cityBox.getSelectedItem();
        String country = countryField.getText();
        

        // Username and Name non-empty check
        if (username.isEmpty() || name.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Username and Name cannot be empty.");
            return;
        }

        // Address validation
        if (address.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter your address.");
            return;
        }
        
        // Password Validation
        boolean hasUppercase = password.matches(".*[A-Z].*");
        boolean hasLowercase = password.matches(".*[a-z].*");
        boolean hasDigit     = password.matches(".*\\d.*");
        boolean hasSpecial   = password.matches(".*[!@#$%^&*(),.?\":{}|<>].*");
        boolean hasLength    = password.length() >= 8;

        if (!(hasUppercase && hasLowercase && hasDigit && hasSpecial && hasLength)) {
            JOptionPane.showMessageDialog(null, "Password is Weak. Use at least 8 characters including uppercase, lowercase, number, and special character.");
            return;
        }

        // Ensure DOB is selected
        if (dayBox.getSelectedItem() == null || monthBox.getSelectedItem() == null || yearBox.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(null, "Please select your birthdate!");
            return;
        }

        // Format DOB to YYYY-MM-DD
        String inputDOB = yearBox.getSelectedItem() + "-" + monthBox.getSelectedItem() + "-" + dayBox.getSelectedItem();
        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MMM-d");
        SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDOB;

        try {
            Date date = inputFormat.parse(inputDOB);
            formattedDOB = outputFormat.format(date);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Invalid date format! Please check your date selection.");
            return;
        }

        // Ensure the user is at least 18 years old
        if (age.isEmpty() || Integer.parseInt(age) < 18) {
            JOptionPane.showMessageDialog(null, "You must be at least 18 years old to sign up.");
            return;
        }

        // Driving License Validation
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

        // Agreement Checkbox Validation
        if (!agreementCheckBox.isSelected()) {
            JOptionPane.showMessageDialog(null, "You must agree that all information is true before submitting.");
            return;
        }

        // Database Insert
        try {
            ConnectionClass obj = new ConnectionClass();
            String query = "INSERT INTO user (name, username, password, email, gender, phone, drivinglicense, dob, address, age, state, city, country) " +
                           "VALUES ('" + name + "', '" + username + "', '" + password + "', '" + email + "', '" + gender + "', '" + phone + "', '" + license + "', '" + formattedDOB + "', '" + address + "', '" + age + "', '" + state + "', '" + city + "', '" + country + "')";

            int result = obj.stmt.executeUpdate(query);

            if (result > 0) {
                JOptionPane.showMessageDialog(null, "Details successfully inserted.");
                frame.setVisible(false);
                new Login();
            } else {
                JOptionPane.showMessageDialog(null, "Error inserting details.");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Database error: " + ex.getMessage());
        }
    } else if (e.getSource() == backBtn) {
        new Login();
        frame.setVisible(false);
    }
}


    public static void main(String[] args) {
        new Signup_User();
    }
}
//successfully done by shreya 2/9/2025 
//sucessfully done by Ashish for front end 26/02/2025 Shiv ratri jai mahakal 🙏
//sucessfully done by Ashish If state selected auto select cities 15/03/2025 (Hint:-You need to change in user table like need to add column nothing else.)
//sucessfully done by Ashish password validation also strength of password:weak,medium,strong 13/04/2025

// Account SID:- AC3f121b77d52516b7bb0902babb5ac8e6
// Auth Token:- 5385569682d95ea65cf3d73acef0b4aa
//Under maintainance by Ashish Real SMS OTP from Phone number 13/04/2025

//successfully done add validation of name and username by Ashish 15/04/2025
