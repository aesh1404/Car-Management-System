
package Car;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class PaymentSystem extends JFrame implements ActionListener
{
     JTextField tf1,tf2,tf3,tf4,tf5;
     JLabel l1,l2,l3,l4,l5,l6,l12;
     JButton bt1,bt2;
     JPanel p1,p2,p3;
     Font f,f1;

    PaymentSystem()
    {
        super("Payment System");
        setSize(900, 360);
        setLocation(50, 10);
        
        f=new Font("Arial",Font.BOLD,18);
        f1=new Font("Arial",Font.BOLD,25);
        
        
        l1=new JLabel("Payment System");
        l1.setHorizontalAlignment(JLabel.CENTER);
        l1.setForeground(Color.RED);
        l1.setFont(f1);
        
        
        l2=new JLabel("Mode Of Payment:-");
        l2.setBounds(10, 11, 12, 15);
        l3=new JLabel("BrandModel");
        l3.setBounds(50, 51, 59, 61);
        l4=new JLabel("Car Name");
        
        l5=new JLabel("Car Seater");
        l6=new JLabel("Car Engine");
        
        l2.setForeground(Color.WHITE);
        l3.setForeground(Color.WHITE);
        l4.setForeground(Color.WHITE);
        l5.setForeground(Color.WHITE);
        l6.setForeground(Color.WHITE);
        
        l2.setFont(f);
        l3.setFont(f);
        l4.setFont(f);
        l5.setFont(f);
        l6.setFont(f);
        
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
        
        
      
        
        try 
        {
            ConnectionClass obj=new ConnectionClass();
            String query="select brandname from carBrand";
            java.sql.ResultSet rest=obj.stmt.executeQuery(query);

            while(rest.next())
            {
            }
            rest.close();
            
                    
            
        } catch (Exception ex) 
        {
            ex.printStackTrace();
            
        }
        
        bt1=new JButton("Pay");
        bt2=new JButton("Cancel");
        
        bt1.setBackground(Color.RED);
        bt2.setBackground(Color.BLACK);
        
        bt1.setForeground(Color.WHITE);
        bt2.setForeground(Color.WHITE);
        
        bt1.addActionListener(this);
        bt2.addActionListener(this);
        
        
        
        bt1.setFont(f);
        bt2.setFont(f);
        
        ImageIcon img=new ImageIcon(ClassLoader.getSystemResource(""));
        Image i1=img.getImage().getScaledInstance(450, 360, Image.SCALE_SMOOTH);
        ImageIcon img1=new ImageIcon(i1); 
        l12=new JLabel(img1);
        
        p1=new JPanel();
        p1.setLayout(new GridLayout(1, 1, 10, 10));
        p1.add(l1);
        
        p2=new JPanel();
        p2.setLayout(new GridLayout(11, 2, 10, 10));
        p2.add(l2);
        p2.add(l3);
        p2.add(l4);
        p2.add(tf1);
        p2.add(l5);
        p2.add(l6);
        p2.add(tf2);
        p2.add(tf3);
        p2.add(tf4);
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
        
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==bt1)
        {
            String carname=tf1.getText();
            String carengine=tf2.getText();
            String carmileage=tf3.getText();
            String carno=tf4.getText();
            int rent=Integer.parseInt(tf5.getText());
            String carstatus="Available";
            
            try 
            {
                ConnectionClass obj=new ConnectionClass();
                String q="Insert into Add_car values('"+carno+"','"+carname+"','"+carengine+"','"+carmileage+"','"+rent+"','"+carstatus+"')";
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
        new PaymentSystem().setVisible(true);
        
        
    }
            //Final done by ashish
}

