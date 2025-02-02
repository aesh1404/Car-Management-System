// Shreya 3th page

package CarManagment;

import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class ViewBookingHistory extends JFrame implements ActionListener
{

    String x[]={"Booking No","Customer Username","Brand Name","Brand Model","Car No","Car Category","Car Rent","Total Days","Booking Date","Status"};
    JButton b1;
    String y[][]=new String[20][12] ;//row and colum
    int i=0,j=0;//next colum and row
    JTable t; //value insert in table
    JLabel l1,l2,l3;
    JTextField t1,t2;
    JPanel p1,p2,p3;
    Font f,f1;

     ViewBookingHistory() 
    {
         super("View Booking History");
        setSize(1100, 400);
        setLocation(180, 160);

        f=new Font("MS UI Gothic", Font.BOLD, 15);
        
        try
        {
            ConnectionClass obj=new ConnectionClass();
            String q="select * from car_booking";
            ResultSet rest=obj.stm.executeQuery(q);
            while(rest.next())
            {
                y[i][j++]=rest.getString("booking_id");
                y[i][j++]=rest.getString("customer_username");
                y[i][j++]=rest.getString("brand_name");
                y[i][j++]=rest.getString("brand_model");
                y[i][j++]=rest.getString("car_no");
                y[i][j++]=rest.getString("car_name");
                y[i][j++]=rest.getString("car_category");
                y[i][j++]=rest.getString("brand_rent");
                y[i][j++]=rest.getString("total_days");
                y[i][j++]=rest.getString("booking_date");
                y[i][j++]=rest.getString("booking_status");
                i++;
                j=0;                   
            }
             t=new JTable(y,x);
            t.setFont(f);
            t.setBackground(Color.BLACK);
            t.setForeground(Color.WHITE);
        } 
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        JScrollPane js=new JScrollPane(t);
        
        f1=new Font("Arial", Font.BOLD,25);
        
        l1=new JLabel("Cancel Status of any Car ?");
        
        l1.setForeground(Color.YELLOW);
        l1.setHorizontalAlignment(JLabel.CENTER);
        l1.setFont(f1);
        
        l2=new JLabel("Type Booking id");
        l2.setFont(f1);
        l2.setForeground(Color.GRAY);
        
        l3=new JLabel("Type Car No");
        l3.setFont(f1);
        l3.setForeground(Color.GRAY);
        
        t1=new JTextField();
        t1.setFont(f);  
        
        t2=new JTextField();
        t2.setFont(f);  
        
        b1=new JButton("Change Status");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.RED);
        b1.setFont(f);
        b1.addActionListener(this);
        
        p1=new JPanel();
        p1.setLayout(new GridLayout(1,1,10,10));
        p1.add(l1);
        
        p2=new JPanel();
        p2.setLayout(new GridLayout(1,5,10,10));
        p2.add(l2);
        p2.add(t1);
        p2.add(l3);
        p2.add(t2);
        p2.add(b1);
        
        p3=new JPanel();
        p3.setLayout(new GridLayout(2,1,10,10));
        p3.add(p1);
        p3.add(p2);

        p1.setBackground(Color.BLACK);
        p2.setBackground(Color.BLACK);
        p3.setBackground(Color.BLACK);
        
        add(p3,"South");
         add(js);    
    }
     public  void actionPerformed(ActionEvent e)
     {
        if(e.getSource()==b1)
        {
             String booking_id=t1.getText();//use for changies in the history(car_booking) table  becuse of primary value
             String car_no=t2.getText();//use for changies in the add_car table  becuse this primary value
             
             if(booking_id.isEmpty() || car_no.isEmpty())
             {
                JOptionPane.showMessageDialog(null, "Please fill the car number of booking id!");
             
             }
             else
             {
                 try
                 {
                     ConnectionClass obj=new ConnectionClass();
                     String q="update car_booking set booking_status='Cancel' where booking_id='"+booking_id+"'";
                       int aa=obj.stm.executeUpdate(q);
                       if(aa==1)
                       {                       
                        JOptionPane.showMessageDialog(null, "Please fill the car number of booking id!");
                        String q1="update add_car set car_status='Available' where car_no='"+car_no+"'";
                       obj.stm.executeUpdate(q1);
                       this.setVisible(false);
                       } 
                       
                 }
                 catch(Exception ex){
                     ex.printStackTrace();
                 }
             
             }
        }
     }
            
    public static void main(String[] args) {
        new ViewBookingHistory().setVisible(true);
    }
 
    

}
