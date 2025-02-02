
package Car;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class AddNewCar extends JFrame implements ActionListener
{
     JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7,tf8,tf9,tf10,tf11;
     JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14;
     JButton bt1,bt2;
     Choice ch1,ch2,ch3,ch4,ch5;
     JPanel p1,p2,p3;
     Font f,f1;

    AddNewCar()
    {
        super("Add new car  Details");
        setSize(900, 360);
        setLocation(50, 10);
        
        f=new Font("Arial",Font.BOLD,18);
        f1=new Font("Arial",Font.BOLD,25);
        
        
        l1=new JLabel("Add new car Details");
        l1.setHorizontalAlignment(JLabel.CENTER);
        l1.setForeground(Color.RED);
        l1.setFont(f1);
        
        
        l2=new JLabel("Brand Name");
        l3=new JLabel("Brand Model");
        l4=new JLabel("Car Name");
        l5=new JLabel("Car Seater");
        l6=new JLabel("Car Engine");
        l7=new JLabel("Car Category");
        l8=new JLabel("Car Mileage");
        l9=new JLabel("Car Side Mirror");
        l10=new JLabel("Car No.");
        l11=new JLabel("Rent Per Day(Rs)");
        
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
        
        l2.setFont(f);
        l3.setFont(f);
        l4.setFont(f);
        l5.setFont(f);
        l6.setFont(f);
        l7.setFont(f);
        l8.setFont(f);
        l9.setFont(f);
        l10.setFont(f);
        l11.setFont(f);
        
        tf1=new JTextField();
        tf2=new JTextField();
        tf3=new JTextField();
        tf4=new JTextField();
        tf5=new JTextField();
        
        tf1.setFont(f);
        tf2.setFont(f);
        tf3.setFont(f);
        tf4.setFont(f);
        tf5.setFont(f);
        
       
        
        ch1=new Choice();
        ch2=new Choice();
        ch3=new Choice();
        ch4=new Choice();
        ch5=new Choice();
        
        ch1.setFont(f);
        ch2.setFont(f);
        ch3.setFont(f);
        ch4.setFont(f);
        ch5.setFont(f);
        
        try 
        {
            ConnectionClass obj=new ConnectionClass();
            String query="select brandname from carBrand";
            java.sql.ResultSet rest=obj.stmt.executeQuery(query);

            while(rest.next())
            {
                ch1.add(rest.getString("brandname"));
            }
            rest.close();
            
                    
            
        } catch (Exception ex) 
        {
            ex.printStackTrace();
            
        }
        ch3.add("Five Seater");
        ch3.add("Seven Seater");
        
        ch4.add("Petrol");
        ch4.add("Electric");
        
        ch5.add("Yes");
        ch5.add("No");
        
        bt1=new JButton("Add Car");
        bt2=new JButton("Back");
        
        bt1.setBackground(Color.RED);
        bt2.setBackground(Color.BLACK);
        
        bt1.setForeground(Color.WHITE);
        bt2.setForeground(Color.WHITE);
        
        bt1.addActionListener(this);
        bt2.addActionListener(this);
        
        
        
        bt1.setFont(f);
        bt2.setFont(f);
        
        ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("Car\\Icons\\UserHomePage.jpg"));
        Image i1=img.getImage().getScaledInstance(450, 360, Image.SCALE_SMOOTH);
        ImageIcon img1=new ImageIcon(i1); 
        l12=new JLabel(img1);
        
        p1=new JPanel();
        p1.setLayout(new GridLayout(1, 1, 10, 10));
        p1.add(l1);
        
        p2=new JPanel();
        p2.setLayout(new GridLayout(11, 2, 10, 10));
        p2.add(l2);
        p2.add(ch1);
        p2.add(l3);
        p2.add(ch2);
        p2.add(l4);
        p2.add(tf1);
        p2.add(l5);
        p2.add(ch3);
        p2.add(l6);
        p2.add(tf2);
        p2.add(l7);
        p2.add(ch4);
        p2.add(l8);
        p2.add(tf3);
        p2.add(l9);
        p2.add(ch5);
        p2.add(l10);
        p2.add(tf4);
        p2.add(l11);
        p2.add(tf5);
        p2.add(bt1);
        p2.add(bt2);
        
        p3=new JPanel();
        p3.setLayout(new GridLayout(1, 1, 10, 10));
        p3.add(l12);
        
        p3.setBackground(new Color(48,62,82));
        p2.setBackground(new Color(48,62,82));
        p3.setBackground(new Color(48,62,82));
        
        setLayout(new BorderLayout(0, 0));
        add(p1,"North");
        add(p2,"Center");
        add(p3,"West");
        
        
        
        ch1.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent arg0)
            {
                ch2.removeAll();
                try 
                {
                    ConnectionClass obj=new ConnectionClass();
                    String brandname=ch1.getSelectedItem();
                    String q1="select * from carBrand where brandname ='"+brandname+"'";
                    java.sql.ResultSet rest1=obj.stmt.executeQuery(q1);
                    
                    
                    while(rest1.next())
                    {
                       ch2.add(rest1.getString("carmodel"));
                        
                        
                        
                        
                    }
                    
                } catch (Exception ess) 
                {
                    ess.printStackTrace();
                    
                }
 
            }
        }
        
        );

        
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==bt1)
        {
            String brandname=ch1.getSelectedItem();
            String brandmodel=ch2.getSelectedItem();
            String carname=tf1.getText();
            String carsheet=ch3.getSelectedItem();
            String carengine=tf2.getText();
            String carcategory=ch4.getSelectedItem();
            String carmileage=tf3.getText();
            String carmirror=ch5.getSelectedItem();
            String carno=tf4.getText();
            int rent=Integer.parseInt(tf5.getText());
            String carstatus="Available";
            
            try 
            {
                ConnectionClass obj=new ConnectionClass();
                String q="Insert into Add_car values('"+carno+"','"+brandname+"','"+brandmodel+"','"+carname+"','"+carsheet+"','"+carengine+"','"+carcategory+"','"+carmileage+"','"+carmirror+"','"+rent+"','"+carstatus+"')";
                int aa=obj.stmt.executeUpdate(q);
                if(aa==1)
                {
                    JOptionPane.showMessageDialog(null,"Car details successfully added !");
                    this.setVisible(false);
                    
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Please,fill all details carefully");
                    
                }
                    
            } 
            catch (Exception exx) 
            {
                exx.printStackTrace();
                
            }
            
        }
        if(e.getSource()==bt2)
        {
            this.setVisible(false);
        }
        
    }
    public static void main(String[] args) 
    {
        new AddNewCar().setVisible(true);
        
        
    }
            
    
    
    
   
    
    
}

