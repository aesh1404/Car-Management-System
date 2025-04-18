// Shreya 4th page

package CarManagment;


import CarManagment.ConnectionClass;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class CheckBill extends JFrame implements ActionListener
{

    JButton b1,b2;
    JLabel l1,l2;
    JTextArea ta;
    Choice ch1,ch2;
    JPanel p1,p2;
    Font f;
    String q;
     CheckBill() {
    
         this.setTitle("Generate Bill Slip");
         setLocation(100, 100);
         setSize(500,500);
         setResizable(false);
        
         f=new Font("Lucida Fax",Font.BOLD,16);
            
         l1=new JLabel("Customer Username");
         l2=new JLabel("Booking Id");

         ch1=new Choice();
         ch2=new Choice();
        
         try {
             ConnectionClass obj=new ConnectionClass();
             q="select distinct customer_username from car_booking";//distinct use for duplicate name
             ResultSet rest=obj.stm.executeQuery(q);
             while (rest.next()) {
                 ch1.add(rest.getString("Customer_username"));
                 
             }
         } catch (Exception ex) {
            ex.printStackTrace();
            }
         
         ch1.setFont(f);
         ch2.setFont(f);
         b1=new JButton("Show");
         b2=new JButton("Print Pdf");
         
         b1.setBackground(Color.BLACK);
         b2.setBackground(Color.BLACK);
         b1.setForeground(Color.white);
         b2.setForeground(Color.white);
         b1.setFont(f);
         b2.setFont(f);
         
         b1.addActionListener(this);
         b2.addActionListener(this);

         ta=new JTextArea();
         JScrollPane sp=new JScrollPane(ta);
         ta.setFont(f);
         ta.setEditable(false);
         
         p1=new JPanel();
         p1.setLayout(new GridLayout(3,2,10,10));
         p1.add(l1);
         p1.add(ch1);
         p1.add(l2);
         p1.add(ch2);
         p1.add(b1);
         p1.add(b2);
         
         setLayout(new BorderLayout());
         add(sp,"Center");
         add(p1,"South");
         
        ch1.addMouseListener(new MouseAdapter()
        {
             @Override
             public void  mouseClicked(MouseEvent arg0)
             {
                 ch2.removeAll();
                 
                 try
                 {
                     ConnectionClass obj=new ConnectionClass();
                     String c_username=ch1.getSelectedItem();
                     String q1="select distinct booking_id from car_booking where customer_username='"+c_username+"'";//fetch the data from databases
                     ResultSet rest1=obj.stm.executeQuery(q1);
                     while(rest1.next())
                     {
                     ch2.add(rest1.getString("booking_id"));
                     }
                 }
                 catch(Exception ex)
                 {
                     ex.printStackTrace();
                 }
                     
             }
        });    
    }
     public void actionPerformed(ActionEvent e){
     
         if(e.getSource()==b1)
          {
              ta.setText("-----------Car Booking Bill-----------");
              try 
                {
                   ConnectionClass obj=new ConnectionClass();
                     String user_name=ch1.getSelectedItem();
                     String booking_id=ch2.getSelectedItem();
                     String q3="select *from car_booking where cunstomer_username='"+user_name+"' add booking_id='"+booking_id+"'";
                     ResultSet rest3=obj.stm.executeQuery(q3);
                     while (rest3.next()) {                      
                            ta.append("\n\n Customer Name:"+rest3.getString("cudtomer_name"));
                            ta.append("\n\n Customer phone:"+rest3.getString("cudtomer_phone"));
                            ta.append("\n---------------------------------------------------\n");
                            ta.append("\n\n car Brand Name:"+rest3.getString("brand_name"));
                            ta.append("\n\n car Brand Model:"+rest3.getString("brand_model"));
                            ta.append("\n\n car Number:"+rest3.getString("car_no"));
                            ta.append("\n\n car Name:"+rest3.getString("car_name"));
                            ta.append("\n---------------------------------------------------\n");

                            
                            ta.append("\n\n Total Days:"+rest3.getString("total_days"));
                            ta.append("\n\n Booking Date:"+rest3.getString("booking_date"));
                            
                            ta.append("\n---------------------------------------------------\n");
                          
                            //car_rent colum convert the float
                            float gross_payment=Float.parseFloat(rest3.getString("car_rent"));
                            double tax=(gross_payment*2.1)/100;
                            ta.append(("\n Gross Payment: "+gross_payment));
                           double total_payment=gross_payment+tax;
                            
                            ta.append(("\n Total payment:"+total_payment));
                            ta.append("\n Tax:"+tax);
                            
                         }
                  }
                   
               catch (Exception ex) {
                  ex.printStackTrace();
              }
             
          }
            if(e.getSource()==b2){
                
                try
                {
                    ta.print();
                }catch(Exception ex)
                {
                    ex.printStackTrace();
                }
            }
     }
     public static void main(String[] args) {
        new CheckBill().setVisible(true);
        }
     
}
