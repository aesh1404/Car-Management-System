  package Car;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class UserHomePage extends JFrame implements ActionListener
{
    JLabel l1;
    Font f,f1;

    UserHomePage() 
    {
        
        //super("Car booking page for User");
        this.setTitle("User Car Booking Home Page");
        setSize(1280,780);
        
        ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("Car\\Icons\\UserHomePage.jpg"));
        Image i1=img.getImage().getScaledInstance(1500,1100, Image.SCALE_SMOOTH);
        ImageIcon img1=new ImageIcon(i1);
        l1=new JLabel(img1);
        
        //First create MenuBar
        JMenuBar mb=new JMenuBar();
        
        //Second Create Menu in Menubar And Third create Items and adds in menu.
        JMenu m1=new JMenu("User Profile");
        JMenuItem mi1=new JMenuItem("Update & View My Details");
        
        m1.add(mi1);
       
        JMenu m2=new JMenu("Booking History");
        JMenuItem mi3=new JMenuItem("Add New Booking");
        JMenuItem mi4=new JMenuItem("View Booking History");
        
        m2.add(mi3);
        m2.add(mi4);
        
        JMenu m3=new JMenu("Car Brand");
        JMenuItem mi6=new JMenuItem("View Brand");
        
        m3.add(mi6);
        
        JMenu m4=new JMenu("Vehicle");
        JMenuItem mi8=new JMenuItem("View Car");
      
        m4.add(mi8);
        
        JMenu m6=new JMenu("Bill");
        JMenuItem mi10=new JMenuItem("Check Bill");
     
        m6.add(mi10);
        
        JMenu m7=new JMenu("Logout");
        JMenuItem mi11=new JMenuItem("Exit");
        
        m7.add(mi11);
        // Forth  Menu adds in MenuBar
        mb.add(m1);
        mb.add(m2);
        mb.add(m3);
        mb.add(m4);
        mb.add(m6);
        mb.add(m7);
        
        // For attractive CSS
        mb.setBackground(new java.awt.Color(4,1,54));
        m1.setForeground(Color.WHITE);
        m2.setForeground(Color.WHITE);
        m3.setForeground(Color.WHITE);
        m4.setForeground(Color.WHITE);
        m6.setForeground(Color.WHITE);
        m7.setForeground(Color.RED);
        
       mi1.setBackground(Color.BLACK);
       mi3.setBackground(Color.BLACK);
       mi4.setBackground(Color.BLACK);
       mi6.setBackground(Color.BLACK);
       mi8.setBackground(Color.BLACK);
       mi10.setBackground(Color.BLACK);
       mi11.setBackground(Color.BLACK);
       
       mi1.setForeground(Color.ORANGE);
       mi3.setForeground(Color.ORANGE);
       mi4.setForeground(Color.ORANGE);
       mi6.setForeground(Color.ORANGE);
       mi8.setForeground(Color.ORANGE);
       mi10.setForeground(Color.ORANGE);
       mi11.setForeground(Color.RED);
       
       //For Menu Items Font
       f=new Font("Licida Fax",Font.BOLD,20);
       f1=new Font("MS GI Gothic",Font.BOLD,18);
       
       m1.setFont(f);
       m2.setFont(f);
       m3.setFont(f);
       m4.setFont(f);
       m6.setFont(f);
       m7.setFont(f);
       
       mi1.setFont(f1);
       mi3.setFont(f1);
       mi4.setFont(f1);
       mi6.setFont(f1);
       mi8.setFont(f1);
       mi10.setFont(f1);
       mi11.setFont(f1);
       
       //Add Action on click Menu Items 
       mi1.addActionListener(this);
       mi3.addActionListener(this);
       mi4.addActionListener(this);
       mi6.addActionListener(this);
       mi8.addActionListener(this);
       mi10.addActionListener(this);
       mi11.addActionListener(this);
       
       
        //Fifth Whole Menubar add in Frame.
        setJMenuBar(mb);
        
        
        add(l1);
    }
     public void actionPerformed(ActionEvent e)
    {
        String comnd=e.getActionCommand();
        if(comnd.equals("Update & View My Details"))
        {
            new UpdateUserDetails().setVisible(true);
        }
        else if(comnd.equals("Add New Booking"))
        {
            new AddNewBooking().setVisible(true);
        }
        else if(comnd.equals("View Booking History"))
        {
            new ViewBookingHistory().setVisible(true);
        }
        else if(comnd.equals("View Brand"))
        {
            new ViewBrand().setVisible(true);
        }
        else if(comnd.equals("View Car"))
        {
            new ViewCar().setVisible(true);
        }
        else if(comnd.equals("Check Bill"))
        {
            new CheckBill().setVisible(true);
        }
        else if(comnd.equals("Exit"))
        {
            System.exit(0);
        }
    }
     public static void main(String[] args) 
     {
        new UserHomePage().setVisible(true);
     }
}
