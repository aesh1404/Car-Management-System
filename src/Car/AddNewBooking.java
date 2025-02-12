    // S 2nd page

    package Car;

    import java.awt.*;
    import javax.swing.*;
    import java.awt.event.*;
    import java.sql.*;
    import java.util.Random;
    import java.util.Date;
    import java.time.LocalDate;
    import java.time.format.DateTimeFormatter;
    
    public class AddNewBooking extends JFrame implements ActionListener{

            Font f,f1;
            Choice ch1,ch2,ch3,ch4,ch5;
            JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15,l16;
            JButton b1,b2;
            JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9;
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
                  ResultSet rest=obj.stmt.executeQuery(q); //pass the q query
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
                  String q="Select brandname from add_car";  //query
                  ResultSet rest=obj1.stmt.executeQuery(q); //pass the q query
                  while(rest.next())
                  {

                      ch2.add(rest.getString("brandname")); //add the brand name
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
            l8=new JLabel("Car Name");
            l9=new JLabel("Car seater");
            l10=new JLabel("Car Engine");
            l11=new JLabel("Car Cartegory");
            l12=new JLabel("Car Mileage");
            l14=new JLabel("Car Side Mirror");
            l15=new JLabel("Car Price Pey Day");
            l16=new JLabel("How Many Days?");


            t1=new JTextField();
            t2=new JTextField();
            t3=new JTextField();
            t4=new JTextField();
            t5=new JTextField();
            t6=new JTextField();
            t7=new JTextField();
            t8=new JTextField();
            t9=new JTextField();

            t1.setEditable(false);
            t2.setEditable(false);
            t3.setEditable(false);
            t4.setEditable(false);
            t5.setEditable(false);
            t6.setEditable(false);
            t7.setEditable(false);
            t8.setEditable(false);
            t9.setEditable(false);

            b1=new JButton ("Add Car");
            b2=new JButton("Back");

            b1.setBackground(Color.YELLOW);
            b2.setBackground(Color.BLACK);
            b1.setForeground(Color.BLACK);
            b2.setForeground(Color.red);

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
            l12.setFont(f1);
            l14.setFont(f1);
            l15.setFont(f1);
            l16.setFont(f1);

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
            t7.setFont(f1);
            t8.setFont(f1);
            t9.setFont(f1);

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
            l12.setForeground(Color.WHITE);
            l14.setForeground(Color.WHITE);
            l15.setForeground(Color.WHITE);
            l16.setForeground(Color.WHITE);

             ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("Car\\Icons\\UserHomePage.jpg"));//create the object
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
            p3.setLayout(new GridLayout(15,2,10,10));
            p3.add(l2);
            p3.add(ch1);
            p3.add(l3);
            p3.add(t1);
            p3.add(l4);
            p3.add(t2);
            p3.add(l5);
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
            p3.add(l12);
            p3.add(t7);
            p3.add(l14);
            p3.add(t8);
            p3.add(l15);
            p3.add(t9);
            p3.add(l16);
            p3.add(ch5);
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

                    try {
                        ConnectionClass obj=new ConnectionClass();//create database connection
                         String cuser=ch1.getSelectedItem();
                         String q1="select name, phone from user where username='"+cuser+"'";
                         ResultSet rest1=obj.stmt.executeQuery(q1);

                         while (rest1.next()) {
                           t1.setText(rest1.getString("name"));
                           t2.setText(rest1.getString("phone"));

                        }                                     
                    }

                 catch (Exception exx) {

                     exx.printStackTrace();
                    }                       
                }        
            });        
             ch2.addMouseListener(new MouseAdapter()
            {
                @Override
                public void mouseClicked(MouseEvent arg0)//class object 
                {
                   ch3.removeAll();
                    try 
                    {
                        ConnectionClass obj=new ConnectionClass();//create database connection
                         String bname=ch2.getSelectedItem();
                         String q1="select brandmodel from add_car where brandname='"+bname+"'";
                         ResultSet rest1=obj.stmt.executeQuery(q1);

                         while (rest1.next()) {
                           ch3.add(rest1.getString("brandmodel"));


                        }                                     
                    }
                    catch (Exception exx) {

                     exx.printStackTrace();
                    } 
                }
            }); 
             ch3.addMouseListener(new MouseAdapter()
            {
                @Override
                public void mouseClicked(MouseEvent arg0)//class object 
                {
                   ch4.removeAll();
                    try 
                    {
                        ConnectionClass obj=new ConnectionClass();//create database connection
                         String bmodel=ch3.getSelectedItem();
                         String q1="select carno from add_car where brandmodel='"+bmodel+"'and carstatus='available'";
                         ResultSet rest1=obj.stmt.executeQuery(q1);

                         while (rest1.next()) {
                           ch4.add(rest1.getString("carno"));


                        }                                     
                    }
                    catch (Exception exx) {

                     exx.printStackTrace();
                    } 
                }
            }); 
             ch4.addMouseListener(new MouseAdapter()
            {
                @Override
                public void mouseClicked(MouseEvent arg0)//class object 
                {

                    try 
                    {
                        ConnectionClass obj=new ConnectionClass();//create database connection
                        String bname=ch2.getSelectedItem();            
                         String bmodel=ch3.getSelectedItem();                   
                        String carno=ch4.getSelectedItem();

                         String q1="select * from add_car where brandname='"+bname+"'and brandmodel='"+bmodel+"' and carno='"+carno+"'";
                         ResultSet rest1=obj.stmt.executeQuery(q1);

                         while (rest1.next()) {
                           t3.setText(rest1.getString("carname"));
                           t4.setText(rest1.getString("carsheet"));
                           t5.setText(rest1.getString("carengine"));
                           t6.setText(rest1.getString("carcategory"));
                           t7.setText(rest1.getString("carmileage"));
                           t8.setText(rest1.getString("carmirror"));
                           t9.setText(rest1.getString("rent"));

                        }                                     
                    }
                    catch (Exception exx) {

                     exx.printStackTrace();
                    } 
                }
            }); 
             
        }
         public void updateCarStatus() 
         {
            try 
            {
                ConnectionClass obj = new ConnectionClass();
                String q = "UPDATE add_car SET carstatus='Available' WHERE carno IN (SELECT car_no FROM car_booking WHERE return_date <= NOW())";
                obj.stmt.executeUpdate(q);
            } 
            catch (Exception ex) 
            {
                ex.printStackTrace();
            }
        }

         

        public void actionPerformed(ActionEvent e){

            if(e.getSource()==b1)

            {
             String username=ch1.getSelectedItem();
             String name=t1.getText();
             String phone=t2.getText();
             String brandname=ch2.getSelectedItem();
             String brandmodel=ch3.getSelectedItem();
             String carno=ch4.getSelectedItem();
             String carname=t3.getText();
             String carsheet=t4.getText();         
             String carengine=t5.getText();
             String carcategory=t6.getText();
             String carmileage=t7.getText();
             String carmirror=t8.getText();
             int dayscount=Integer.parseInt(ch5.getSelectedItem());
             int carprice=dayscount*(Integer.parseInt(t9.getText()));
             String booking_status="Booked";
                Random r=new Random();
                String booking_id=""+Math.abs(r.nextInt()%100000);
               
                // Get today's date
                LocalDate bookingDate = LocalDate.now(); 
                // Calculate return date
                LocalDate returnDate = bookingDate.plusDays(dayscount);

                // Format dates for MySQL (yyyy-MM-dd)
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                String formattedBookingDate = bookingDate.format(formatter);
                String formattedReturnDate = returnDate.format(formatter);
                try
                {
                    ConnectionClass obj3=new ConnectionClass();
                    
                    String q = "INSERT INTO car_booking (booking_id, customer_username, customer_name, customer_phone, brand_name, brand_model, car_no, car_name, car_sheet, car_engine, car_category, car_mielage, car_mirror, car_rent, total_days, booking_date, booking_status, return_date) VALUES ('"
                + booking_id + "', '" + username + "', '" + name + "', '" + phone + "', '" + brandname + "', '" + brandmodel + "', '" + carno + "', '" + carname + "', '" + carsheet + "', '" + carengine + "', '" + carcategory + "', '" + carmileage + "', '" + carmirror + "', " + carprice + ", " + dayscount + ", '" + formattedBookingDate + "', '" + booking_status + "', '" + formattedReturnDate + "')";
                    int aa=obj3.stmt.executeUpdate(q);

                    if (aa==1)
                    {
                        JOptionPane.showMessageDialog(null,"Car Successfully Booked");
                        String q1="update add_car set carstatus='Booked' where carno='"+carno+"'";//car status change 
                        obj3.stmt.executeUpdate(q1);
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
           AddNewBooking booking = new AddNewBooking();
           booking.updateCarStatus(); // Update car status on startup
           booking.setVisible(true);
        }
        // changed by ashish on 12-02-2025
    }
