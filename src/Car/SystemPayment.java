package Car;

import Car.ConnectionClass;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class SystemPayment implements ActionListener
{
    JLabel l1,l2,l3,l4,l5,l6,l7;
    JTextField t1,t2,t3,t4;
    JButton b1,b2;
    JPasswordField pf2;
    JFrame f;
            
    SystemPayment()
    {
        //JFrame Object and it's methods
        f=new JFrame("Payment System");
        f.setBackground(Color.BLACK);
        f.setLayout(null);
        
        //Jlabel Object
        l1=new JLabel();
        l1.setBounds(0,0,840,600);
        l1.setLayout(null);
        
        ImageIcon img=new ImageIcon(ClassLoader.getSystemResource(""));
        Image i1=img.getImage().getScaledInstance(840, 600, Image.SCALE_SMOOTH);
        ImageIcon img1=new ImageIcon(i1);
        l1.setIcon(img1);
        
        l2=new JLabel("Mode Of Payment:-");
        l2.setBounds(70,30,600,50);
        l2.setFont(new Font("Arial",Font.BOLD,30));
        l2.setForeground(Color.BLACK);
        
        l1.add(l2);
        f.add(l1);
        
        l3=new JLabel("Card No.:-");
        l3.setBounds(50,150,150,30);
        l3.setFont(new Font("Arial",Font.BOLD,20));
        l3.setForeground(Color.BLACK);
        
        l1.add(l3);
        
        t1=new JTextField();
        t1.setBounds(200,150,150,30);
        l1.add(t1);
        
        l4=new JLabel("/");
        l4.setBounds(360,150,200,30);
        l4.setFont(new Font("Arial",Font.BOLD,30));
        l4.setForeground(Color.BLACK);
        l1.add(l4);
        
        pf2=new JPasswordField();
        pf2.setBounds(380,150,50,30);
        l1.add(pf2);
       
        l5=new JLabel("Car Brand");
        l5.setBounds(50,250,140,30);
        l5.setFont(new Font("Arial",Font.BOLD,20));
        l5.setForeground(Color.BLACK);
        l1.add(l5);
        
        t2=new JTextField();
        t2.setBounds(200,250,150,30);
        l1.add(t2);
        
       
        
        l6=new JLabel("Car Name");
        l6.setBounds(50,300,160,30);
        l6.setFont(new Font("Arial",Font.BOLD,20));
        l6.setForeground(Color.BLACK);
        l1.add(l6);
        
        t3=new JTextField();
        t3.setBounds(200,300,150,30);
        l1.add(t3);
        
        l7=new JLabel("Amount");
        l7.setBounds(50,350,100,30);
        l7.setFont(new Font("Arial",Font.BOLD,20));
        l7.setForeground(Color.BLACK);
        l1.add(l7);
        
        t4=new JTextField();
        t4.setBounds(200,350,150,30);
        l1.add(t4);
      
        b1=new JButton("Submit");
        b2=new JButton("Back");
        
        b1.setBounds(250,500,150,40);
        b2.setBounds(450,500,150,40);
        b1.setBackground(Color.RED);
        b2.setBackground(Color.BLACK);
        
        b1.setForeground(Color.WHITE);
        b2.setForeground(Color.RED);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        
        l1.add(b1);
        l1.add(b2);
              
        //For Visible Frame
        f.setVisible(true);
        f.setSize(840,600);
        f.setLocation(300,100);
        
    }
    
    public void actionPerformed(ActionEvent e)
    {
     /*   if(e.getSource()==b1)
        {
            String cardno=t1.getText();
            String cvv=pf2.getText();
            String carbrand=t2.getText();
            String carname=t3.getText();
            String amount=t4.getText();
           
            Random r=new Random();
            String pay_id=""+Math.abs(r.nextInt() % 100000);
         
                try 
                {
                    ConnectionClass obj=new ConnectionClass();
                    String q="insert into user values('"+pay_id+"','"+cardno+"','"+cvv+"','"+carbrand+"','"+carname+"','"+amount+"','"+phone+"','"+DOB+"','"+drivingLicense+"','"+Address+"','"+age+"')";
                    obj.stmt.executeUpdate(q);
                    JOptionPane.showMessageDialog(null,"Payment Successfully Done.");
                    f.setVisible(false);
                } 
                catch(Exception ex) 
                {
                    ex.printStackTrace();
                }
            
            }
        }
        if(e.getSource()==b2)
        {
            new AddNewBooking();
            f.setVisible(false);
        }*/
    }
   
    
     public static void main(String[] args) 
    {
        new SystemPayment();
    }
}
