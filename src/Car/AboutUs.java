package Car;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class AboutUs {

    JFrame f;
    JLabel l1;
    JButton learnMore;

    public AboutUs() 
    {
        f = new JFrame("About Us - Car Rental System");
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.setSize(900, 500);
        f.setLocationRelativeTo(null);

        // 🌈 Gradient Background Panel
        JPanel gradientPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                int w = getWidth();
                int h = getHeight();
                Color color1 = new Color(240, 248, 255);  // Light Blue
                Color color2 = new Color(224, 255, 255);  // Pale Turquoise
                GradientPaint gp = new GradientPaint(0, 0, color1, w, h, color2);
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, w, h);
            }
        };
        gradientPanel.setLayout(new BorderLayout());
        
        // LEFT SIDE - Text Content
        JPanel leftPanel = new JPanel();
        leftPanel.setBackground(new Color(240, 240, 240));
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        leftPanel.setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 20));

        JLabel heading = new JLabel("About Us");
        heading.setFont(new Font("SansSerif", Font.BOLD, 28));
        heading.setForeground(new Color(0, 128, 192)); 
        heading.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel welcome = new JLabel("Welcome To EasyCar Rentals");
        welcome.setFont(new Font("SansSerif", Font.BOLD, 20));
        welcome.setAlignmentX(Component.LEFT_ALIGNMENT);
        welcome.setBorder(BorderFactory.createEmptyBorder(20, 0, 10, 0));

        JLabel description = new JLabel("<html><p style='width:350px;'>Discover secure and seamless car rentals with EasyCar. From everyday rides to long trips, our fleet and expert support ensure a smart, smooth journey every time.</p></html>");
        description.setFont(new Font("SansSerif", Font.PLAIN, 16));
        description.setAlignmentX(Component.LEFT_ALIGNMENT);

        learnMore = new JButton("LOGIN");
        learnMore.setFont(new Font("SansSerif", Font.BOLD, 14));
        learnMore.setAlignmentX(Component.LEFT_ALIGNMENT);
        learnMore.setBackground(new Color(0, 128, 192)); // Blue button
        learnMore.setForeground(Color.WHITE);
        learnMore.setFocusPainted(false);
        learnMore.setPreferredSize(new Dimension(140, 40));
        learnMore.setMaximumSize(new Dimension(160, 40));

        learnMore.addActionListener(e -> {
            f.dispose();
            new Login();
        });

        leftPanel.add(heading);
        leftPanel.add(welcome);
        leftPanel.add(description);
        leftPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        leftPanel.add(learnMore);

        // RIGHT SIDE - Image
        JPanel rightPanel = new JPanel();
        rightPanel.setBackground(new Color(240, 240, 240));
        rightPanel.setBorder(BorderFactory.createEmptyBorder(40, 20, 40, 40));

        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("Car//Icons//AboutUs.jpg"));
        Image i1 = img.getImage().getScaledInstance(325, 250, Image.SCALE_SMOOTH);
        ImageIcon img1 = new ImageIcon(i1);
        l1 = new JLabel(img1);
        rightPanel.add(l1);

       // Combine both sides
        gradientPanel.add(leftPanel, BorderLayout.WEST);
        gradientPanel.add(rightPanel, BorderLayout.EAST);

        // BOTTOM PANEL - "Do you want login"
        JPanel bottomPanel = new JPanel();
        bottomPanel.setOpaque(false); // transparent to show gradient background
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 10)); // centered, with vertical padding

        JLabel bottomLabel = new JLabel("Do you want login?");
        bottomLabel.setFont(new Font("SansSerif", Font.BOLD, 20));
        bottomLabel.setForeground(new Color(0, 128, 192));

        bottomPanel.add(bottomLabel);

        // Add bottom panel to SOUTH of the gradientPanel
        gradientPanel.add(bottomPanel, BorderLayout.SOUTH);

        // Final setup
        f.setContentPane(gradientPanel);
        f.setVisible(true);
        
        
    }

    public static void main(String[] args) 
    {
        new AboutUs();
    }
}