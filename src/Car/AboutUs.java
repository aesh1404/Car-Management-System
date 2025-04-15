package Car;

import java.awt.*;
import javax.swing.*;

public class AboutUs {

    JFrame f;
    JLabel l1;
    JButton loginBtn;

    public AboutUs() {
        f = new JFrame("About Us - Car Rental System");
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        f.setLocationRelativeTo(null);

        // Main background panel (white)
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(Color.WHITE);

        // LEFT SIDE - Text Section
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        leftPanel.setBackground(Color.WHITE);
        leftPanel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 30));

        JLabel heading = new JLabel("About Us");
        heading.setFont(new Font("SansSerif", Font.BOLD, 30));
        heading.setForeground(new Color(30, 144, 255)); // Dodger Blue
        heading.setAlignmentX(Component.LEFT_ALIGNMENT);

         JLabel welcome = new JLabel("Welcome to Rentify Users");
        welcome.setFont(new Font("Segoe UI", Font.BOLD, 24));
        welcome.setAlignmentX(Component.LEFT_ALIGNMENT);
        welcome.setBorder(BorderFactory.createEmptyBorder(20, 0, 15, 0));

        JLabel description = new JLabel("<html><div style='width:500px;'>"
                + "Rentify Rentals offers quick and reliable car rental services. "
        + "Choose from a wide range of cars for daily use, business trips, or vacations. "
        + "Book online and enjoy a smooth ride with 24/7 support."   + "</div></html>");
        description.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        description.setAlignmentX(Component.LEFT_ALIGNMENT);


        loginBtn = new JButton("LOGIN");
        loginBtn.setFont(new Font("SansSerif", Font.BOLD, 14));
        loginBtn.setBackground(new Color(30, 144, 255));
        loginBtn.setForeground(Color.WHITE);
        loginBtn.setFocusPainted(false);
        loginBtn.setAlignmentX(Component.LEFT_ALIGNMENT);
        loginBtn.setPreferredSize(new Dimension(140, 40));
        loginBtn.setMaximumSize(new Dimension(160, 40));
        loginBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));

        loginBtn.addActionListener(e -> {
            f.dispose();
            new Login();
        });

        leftPanel.add(heading);
        leftPanel.add(welcome);
        leftPanel.add(description);
        leftPanel.add(Box.createRigidArea(new Dimension(0, 25)));
        

        // RIGHT SIDE - Image Section
        JPanel rightPanel = new JPanel();
        rightPanel.setBackground(Color.WHITE);
        rightPanel.setBorder(BorderFactory.createEmptyBorder(50, 30, 50, 50));

        try {
            ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("Car/Icons/AboutUs.jpg"));
            Image scaledImg = img.getImage().getScaledInstance(350, 250, Image.SCALE_SMOOTH);
            l1 = new JLabel(new ImageIcon(scaledImg));
            rightPanel.add(l1);
        } catch (Exception e) {
            l1 = new JLabel("Image not found");
            l1.setForeground(Color.RED);
            rightPanel.add(l1);
        }

        
// Footer - "Do you want login?" and LOGIN button aligned right
JPanel bottomPanel = new JPanel(new BorderLayout());
bottomPanel.setBackground(Color.WHITE);
bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 15)); // center with 10px gap

// Left label
JLabel bottomText = new JLabel("Need an account? Click LOGIN to continue.");
bottomText.setFont(new Font("SansSerif", Font.BOLD, 18));
bottomText.setForeground(new Color(0, 128, 192));
bottomPanel.add(bottomText, BorderLayout.WEST);

// Right-aligned button
loginBtn = new JButton("LOGIN");
loginBtn.setFont(new Font("SansSerif", Font.BOLD, 14));
loginBtn.setBackground(new Color(30, 144, 255));
loginBtn.setForeground(Color.WHITE);
loginBtn.setFocusPainted(false);
loginBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
loginBtn.setPreferredSize(new Dimension(100, 35));
loginBtn.addActionListener(e -> {
    f.dispose();
    new Login();
});
bottomPanel.add(loginBtn, BorderLayout.EAST);

        // Add to main panel
        mainPanel.add(leftPanel, BorderLayout.WEST);
        mainPanel.add(rightPanel, BorderLayout.EAST);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);
        

        f.setContentPane(mainPanel);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        new AboutUs();
    }
}
//successfully done About Us by shreya 15/04/2025 
