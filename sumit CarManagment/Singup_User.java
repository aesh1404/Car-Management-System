package CarManagment;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
public class Singup_User implements ActionListener 
{
    JLabel l1,l2,l3,l4,l5,l6,l7,l8;
    JTextField tf1,tf2,tf3,tf4,tf5;
    JButton b1,b2; 
    JPasswordField pf;
    JFrame f;
    
   Singup_User()
    {
        f=new JFrame("ADD User Details For Signup");
        f.setBackground(Color.WHITE);
        f.setLayout(null);
        
        l1=new JLabel();
        l1.setBounds(0, 0, 840, 600);
        l1.setLayout(null);
        
        ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("CarManagment/Icons/Image3.jpg"));
        Image i1=img.getImage().getScaledInstance(840,600, Image.SCALE_SMOOTH);
        ImageIcon img1=new ImageIcon(i1);
        l1.setIcon(img1);
        
        l2=new JLabel("ADD User Details For Signup");
        l2.setBounds(230, 30, 500, 50);
        l2.setFont(new Font("Arial",Font.BOLD,30));
        l2.setForeground(Color.BLACK);
        l1.add(l2);
        f.add(l1);
                
                
        l3=new JLabel("Name");
        l3.setBounds(50,150,150, 30);
        l3.setFont(new Font("Arial",Font.BOLD,20));
        l3.setForeground(Color.WHITE); 
        l1.add(l3);
        
        tf1=new JTextField();
        tf1.setBounds(200, 150,150, 30);
        l1.add(tf1);
                
        l4=new JLabel("Username");
        l4.setBounds(450,150,200, 30);
        l4.setFont(new Font("Arial",Font.BOLD,20));
        l4.setForeground(Color.WHITE); 
        l1.add(l4);
        
        tf2=new JTextField();
        tf2.setBounds(600, 150,150, 30);
        l1.add(tf2);
        
        l5=new JLabel("Password");
        l5.setBounds(50,200,100, 30);
        l5.setFont(new Font("Arial",Font.BOLD,20));
        l5.setForeground(Color.WHITE); 
        l1.add(l5);
        
        pf=new JPasswordField();
        pf.setBounds(200, 200,150, 30);
        l1.add(pf);
                
        l6=new JLabel("Phone"); 
        l6.setBounds(450,200,200, 30);
        l6.setFont(new Font("Arial",Font.BOLD,20));
        l6.setForeground(Color.WHITE); 
        l1.add(l6);
        
        tf3=new JTextField();
        tf3.setBounds(600, 200,150, 30);
        l1.add(tf3);
        
        l7=new JLabel("AGE");
        l7.setBounds(450,250,100, 30);
        l7.setFont(new Font("Arial",Font.BOLD,20));
        l7.setForeground(Color.WHITE); 
        l1.add(l7);
        
        tf4=new JTextField();
        tf4.setBounds(600, 250,160, 30);
        l1.add(tf4);
              
        l8=new JLabel("Driving License");
        l8.setBounds(50,250,140, 30);
        l8.setFont(new Font("Arial",Font.BOLD,20));
        l8.setForeground(Color.WHITE); 
        l1.add(l8);
        
        tf5=new JTextField();
        tf5.setBounds(200, 250,150, 30);
        l1.add(tf5);
      
        
        b1=new JButton("Submit");
        b2=new JButton("Back");
        
        
        
        b1.setBounds(250, 500, 150, 40);
        b2.setBounds(450, 500, 150, 40);
        
        b1.setBackground(Color.BLACK);
        b2.setBackground(Color.RED);
        
        b1.setForeground(Color.WHITE);
        b2.setForeground(Color.WHITE);
        
        l1.add(b1);
        l1.add(b2);
        
       f.setVisible(true);
       f.setSize(840,600);
       f.setLocation(300, 100);
    }
    public void actionPerformed(ActionEvent e)
    {
           
    }
    public static void main(String[] args) {
        
        new Singup_User();
    }
}
