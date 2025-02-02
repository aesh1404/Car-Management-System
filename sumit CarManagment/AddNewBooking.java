// Shreya 2nd page

package CarManagment;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Random;
import java.util.Date;

public class AddNewBooking extends JFrame implements ActionListener{

        Font f,f1;
        Choice ch1,ch2,ch3,ch4,ch5;
        JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l13;
        JButton b1,b2;
        JTextField t1,t2,t3,t4,t5,t6;
        JPanel p1,p2,p3;
     AddNewBooking()
    {
         super("Add new car Booking");
        setSize(950, 650);
        setLocation(130,40);
        setResizable(false);
        setBackground(Color.WHITE);
        
        f=new Font("Arial", Font.BOLD, 25);
        f1=new Font("Arial", Font.BOLD, 18);
        
        
        ch1=new Choice();
        ch2=new Choice();
        ch3=new Choice();
        ch4=new Choice();
        ch5=new Choice();
        
        try {
            //get the username from user table
              ConnectionClass obj=new ConnectionClass();
              String q="Select username from user";  //query
              ResultSet rest=obj.stm.executeQuery(q); //pass the q query
              while(rest.next())
              {
              
                  ch1.add(rest.getString("username"));
              }
              rest.close();
                
        } catch (Exception ex) 
        {
            ex.printStackTrace();
        }
        try {
            //get the brand name from add_car table (ViewCar) 
              ConnectionClass obj1=new ConnectionClass();
              String q="Select brand_name from add_car";  //query
              ResultSet rest=obj1.stm.executeQuery(q); //pass the q query
              while(rest.next())
              {
              
                  ch2.add(rest.getString("brand_name")); //add the brand name
              }
              rest.close();
                
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        ch5.add("1");
        ch5.add("2");
        ch5.add("3");
        ch5.add("4");
        ch5.add("5");
        
        l1=new JLabel("Add New Car Booking");
        l1.setForeground(Color.orange);
        l1.setHorizontalAlignment(JLabel.CENTER);
        l1.setFont(f);
        
        
        l2=new JLabel("Customer UserName");
        l3=new JLabel("Customer Name");
        l4=new JLabel("Customer Phone");
        l5=new JLabel("Brand Name");
        l6=new JLabel("Brand Model");
        l7=new JLabel("Car No");
        l8=new JLabel("Car Engine");
        l9=new JLabel("Car Cartegory");
        l10=new JLabel("Car Price Pey Day");
        l11=new JLabel("How Many Days?");
        
        
        t1=new JTextField();
        t2=new JTextField();
        t3=new JTextField();
        t4=new JTextField();
        t5=new JTextField();
        t6=new JTextField();
        
        t1.setEditable(false);
        t2.setEditable(false);
        t3.setEditable(false);
        t4.setEditable(false);
        t5.setEditable(false);
        t6.setEditable(false);
        
        b1=new JButton ("Add Car");
        b2=new JButton("Back");
        
        b1.setBackground(Color.YELLOW);
        b2.setBackground(Color.BLACK);
        b1.setForeground(Color.BLACK);
        b1.setForeground(Color.red);
        
        b1.addActionListener(this);//if not enable addbike,back button so you write this code
        b2.addActionListener(this);
        
        l2.setFont(f1);
        l3.setFont(f1);
        l4.setFont(f1);
        l5.setFont(f1);
        l6.setFont(f1);
        l7.setFont(f1);
        l8.setFont(f1);
        l9.setFont(f1);
        l10.setFont(f1);
        l11.setFont(f1);
        ch1.setFont(f1);
        ch2.setFont(f1);
        ch3.setFont(f1);
        ch4.setFont(f1);
        ch5.setFont(f1);
        
        t1.setFont(f1);
        t2.setFont(f1);
        t3.setFont(f1);
        t4.setFont(f1);
        t5.setFont(f1);
        t6.setFont(f1);
        
        b1.setFont(f1);
        b2.setFont(f1);
        
        l2.setForeground(Color.WHITE);
        l3.setForeground(Color.WHITE);
        l4.setForeground(Color.WHITE);
        l5.setForeground(Color.WHITE);
        l6.setForeground(Color.WHITE);
        l7.setForeground(Color.WHITE);
        l8.setForeground(Color.WHITE);
        l9.setForeground(Color.WHITE);
        l10.setForeground(Color.WHITE);
        l11.setForeground(Color.WHITE);
        
         ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("CarManagment/Icons/Image7.jpg"));//create the object
        Image i1=img.getImage().getScaledInstance(550,420, Image.SCALE_SMOOTH);//give hight,width
        ImageIcon img1=new ImageIcon(i1);
        l13=new JLabel(img1);
    
        p1=new JPanel();// panel1 add Title
        p1.setLayout(new GridLayout(1,1,10,10));
        p1.add(l1);
        
        p2=new JPanel();// panel2 add Image
        p2.setLayout(new GridLayout(1,1,10,10));
        p2.add(l13);
        
        p3=new JPanel();// panel3 add all data
        p3.setLayout(new GridLayout(10,2,9,9));
        p3.add(l2);
        p3.add(ch1);
        p3.add(l3);
        p3.add(t1);
        p3.add(l4);
        p3.add(ch2);
        p3.add(l6);
        p3.add(ch3);
        p3.add(l7);
        p3.add(ch4);
        p3.add(l8);
        p3.add(t3);
        p3.add(l9);
        p3.add(t4);
        p3.add(l10);
        p3.add(t5);
        p3.add(l11);
        p3.add(t6);
        p3.add(b1);
        p3.add(b2);
       
        p1.setBackground(new  Color(39,41,46));//background color
        p2.setBackground(new  Color(39,41,46));
         p3.setBackground(new  Color(39,41,46));
        
        
        setLayout(new BorderLayout(0,0));
        add(p1,"North");
        add(p2,"West");
        add(p3,"Center");
        
        
        
        ch1.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent arg0)//class object 
            {
                ch3.removeAll();
                try {
                    ConnectionClass obj=new ConnectionClass();//create database connection
                     String carno=ch4.getSelectedItem();
                      String bmodel=ch3.getSelectedItem();
                       String bname=ch2.getSelectedItem();
                     String q1="select * from add_car where brand_name='"+bname+"' and brand_name='"+bmodel+"'and car_status='Available'";
                     ResultSet rest1=obj.stm.executeQuery(q1);
                     
                     while (rest1.next()) {
                       t3.setText(rest1.getString("car_name"));
                       t4.setText(rest1.getString("car_engine"));
                       t5.setText(rest1.getString("car_category"));
                       t6.setText(rest1.getString("car_rent"));
                       
                       
                                              
                    }                                     
                }     
             catch (Exception exx) {
                 
                 exx.printStackTrace();
                }                       
            }        
        });        
    }
    
    public void actionPerformed(ActionEvent e){
        
        if(e.getSource()==b1)
        {
        String username=ch1.getSelectedItem();
        String name=t1.getText();
         String phone=t2.getText();
         String brandname=ch2.getSelectedItem();
         String brandmodel= ch3.getSelectedItem();
         String carno=ch4.getSelectedItem();
         String car_engine=t5.getText();
         String car_category=t6.getText();
         int days_cout=Integer.parseInt(ch5.getSelectedItem());
         int car_price=days_cout*(Integer.parseInt(t6.getText()));
         String booking_status="Booked";
            Random r=new Random();
            String bookind_id=""+Math.abs(r.nextInt()%100000);
            Date dtf=new Date();
            
            try
            {
                ConnectionClass obj3=new ConnectionClass();
                String q="insert into car_booking values('"+bookind_id+"','"+username+"','"+name+"','"+phone+"','"+brandname+"','"+brandmodel+"','"+carno+"',"+car_engine+"','"+car_category+"','"+car_price+"','"+days_cout+"','"+dtf+"','"+booking_status+"')";
                int aa=obj3.stm.executeUpdate(q);
            
                if (aa==1)
                {
                    JOptionPane.showMessageDialog(null,"Car Successfully Booked");
                    String q1="update add_car set car _status='Booked' where carno='"+carno+"'";//car status change 
                    obj3.stm.executeUpdate(q1);
                    this.setVisible(false);
                }
                else
                {
                     JOptionPane.showMessageDialog( null, "Please!, Fill all details carefully");
                }
            }
            catch(Exception exx)
            {
                exx.printStackTrace();
            }
        }
        if(e.getSource()==b2)
        {
            this.setVisible(false);
        }
    }    
    public static void main(String[] args) 
    {
       new AddNewBooking().setVisible(true);
    }
    
}
