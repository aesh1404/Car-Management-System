package Car;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Random;

public class AddnewcarBrand implements ActionListener {
    JLabel l2, l3, l4, l5;
    JTextField tf1, tf2, tf3;
    JButton b1, b2;
    JFrame f;

    AddnewcarBrand() {
        f = new JFrame("Add New Car Brand");
        f.setLayout(null);

        // Load and scale the background image (car logo)
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("Car/Icons/car_logo.jpg"));
        Image scaledImg = img.getImage().getScaledInstance(700, 500, Image.SCALE_SMOOTH);
        ImageIcon img1 = new ImageIcon(scaledImg);

        JPanel backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(img1.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };

        backgroundPanel.setLayout(null);
        backgroundPanel.setBounds(0, 0, 700, 500);

        // Title Label
        l2 = new JLabel("Add New Car Brand");
        l2.setBounds(150, 20, 500, 50);
        l2.setFont(new Font("Serif", Font.BOLD, 45));
        l2.setForeground(Color.WHITE);
        backgroundPanel.add(l2);

        // Brand Name Label and TextField
        l3 = new JLabel("Brand Name");
        l3.setBounds(120, 120, 150, 30);
        l3.setFont(new Font("Arial", Font.BOLD, 24));
        l3.setForeground(Color.LIGHT_GRAY);
        backgroundPanel.add(l3);

        tf1 = new JTextField();
        tf1.setBounds(320, 120, 250, 35);
        tf1.setFont(new Font("Arial", Font.PLAIN, 18));
        backgroundPanel.add(tf1);

        // Car Model Label and TextField
        l4 = new JLabel("Car Model");
        l4.setBounds(120, 180, 150, 30);
        l4.setFont(new Font("Arial", Font.BOLD, 24));
        l4.setForeground(Color.LIGHT_GRAY);
        backgroundPanel.add(l4);

        tf2 = new JTextField();
        tf2.setBounds(320, 180, 250, 35);
        tf2.setFont(new Font("Arial", Font.PLAIN, 18));
        backgroundPanel.add(tf2);

        // Year Label and TextField
        l5 = new JLabel("Year");
        l5.setBounds(120, 240, 150, 30);
        l5.setFont(new Font("Arial", Font.BOLD, 24));
        l5.setForeground(Color.LIGHT_GRAY);
        backgroundPanel.add(l5);

        tf3 = new JTextField();
        tf3.setBounds(320, 240, 250, 35);
        tf3.setFont(new Font("Arial", Font.PLAIN, 18));
        backgroundPanel.add(tf3);

        // Add and Back Buttons
        b1 = new JButton("Add");
        b2 = new JButton("Back");

        b1.setBounds(200, 320, 150, 50);
        b2.setBounds(400, 320, 150, 50);

        b1.setBackground(new Color(192, 192, 192)); // Metallic Silver
        b2.setBackground(new Color(28, 28, 28));   // Glossy Black

        b1.setForeground(Color.BLACK);
        b2.setForeground(Color.WHITE);

        b1.setFont(new Font("Arial", Font.BOLD, 22));
        b2.setFont(new Font("Arial", Font.BOLD, 22));

        b1.addActionListener(this);
        b2.addActionListener(this);

        backgroundPanel.add(b1);
        backgroundPanel.add(b2);

        f.add(backgroundPanel);

        f.setVisible(true);
        f.setSize(700, 500);
        f.setLocation(300, 200);
        f.setResizable(false);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            try {
                ConnectionClass obj = new ConnectionClass();
                String brandname = tf1.getText();
                String carmodel = tf2.getText();
                String year = tf3.getText();
                Random r = new Random();
                String brand_id = "" + Math.abs(r.nextInt() % 100000);

                if (brandname.isEmpty() || carmodel.isEmpty() || year.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill all the details");
                } else {
                    String q = "INSERT INTO carBrand VALUES('" + brand_id + "', '" + brandname + "', '" + carmodel + "', '" + year + "')";
                    obj.stmt.executeUpdate(q);
                    JOptionPane.showMessageDialog(null, "Details successfully inserted");
                    f.setVisible(false);
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        if (e.getSource() == b2) {
            f.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new AddnewcarBrand();
    }
} 
//successfuly my front end by darshan date:26/02/2025 
//hint:- i send in github car_logo image so you need to save in car icon folder
