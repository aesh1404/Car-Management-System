
package Car;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.time.DayOfWeek;
import java.time.temporal.TemporalAdjusters;
import java.util.Random;

public class AddnewcarBrand implements ActionListener
{
    JLabel l1,l2,l3,l4,l5;
    JTextField tf1,tf2,tf3;
    JButton b1,b2;
    JFrame f;

    AddnewcarBrand ()
    {
        f=new JFrame("Add new Brand");
        f.setBackground(Color.WHITE);
        f.setLayout(null);
        
        l1=new JLabel();
        l1.setBounds(0, 0, 580, 350);
        l1.setLayout(null);
        
        ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("Car\\Icons\\UserHomePage.jpg"));
        Image i1=img.getImage().getScaledInstance(580, 350, Image.SCALE_SMOOTH);
        ImageIcon img1=new ImageIcon(i1);
        l1.setIcon(img1);
        
        
        l2=new JLabel("Add new car Brand");
        l2.setBounds(150, 22, 500, 50);
        l2.setFont(new Font("Arial",Font.BOLD,30)); 
        l2.setForeground(Color.ORANGE);
        l1.add(l2);
        f.add(l1);
        
        l3=new JLabel("Brand Name");
        l3.setBounds(120, 90, 150, 30);
        l3.setFont(new Font("Arial",Font.BOLD,20));
        l3.setForeground(Color.WHITE);
        l1.add(l3);
        
        tf1=new JTextField();
        tf1.setBounds(320, 90, 150, 30);
        tf1.setFont(new Font("Arial",Font.BOLD,15));
        l1.add(tf1);
        
        l4=new JLabel("Car Model");
        l4.setBounds(120, 135, 150, 30);
        l4.setFont(new Font("Arial",Font.BOLD,20));
        l4.setForeground(Color.WHITE);
        l1.add(l4);
        
        tf2=new JTextField();
        tf2.setBounds(320, 135, 150, 30);
        tf2.setFont(new Font("Arial",Font.BOLD,15));
        l1.add(tf2);
        
        l5=new JLabel("Year");
        l5.setBounds(120, 185, 150, 30);
        l5.setFont(new Font("Arial",Font.BOLD,20));
        l5.setForeground(Color.WHITE);
        l1.add(l5);
        
        tf3=new JTextField();
        tf3.setBounds(320, 185, 150, 30);
        tf3.setFont(new Font("Arial",Font.BOLD,15));
        l1.add(tf3);
        
        b1=new JButton("Add");
        b2=new JButton("Back");
        
        b1.setBounds(120, 235, 150, 40);
        b2.setBounds(320, 235, 120, 40);
        
        b1.setBackground(Color.BLACK);
        b2.setBackground(Color.BLACK);
        
        b1.setForeground(Color.WHITE);
        b2.setForeground(Color.WHITE);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        
        l1.add(b1);
        l1.add(b2);
        
        f.setVisible(true);
        f.setSize(580, 360);
        f.setLocation(300, 360);
        f.setResizable(false);
           
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==b1)
        {
            try 
            {
                ConnectionClass obj=new ConnectionClass();
                String brandname=tf1.getText();
                String carmodel=tf2.getText();
                String year=tf3.getText();
                Random r=new Random();
                String brand_id=""+Math.abs(r.nextInt()% 100000);
                
                if(brandname.isEmpty() || carmodel.isEmpty() || year.isEmpty())
                {
                    JOptionPane.showMessageDialog(null,"please fill all the details");
                }
                else
                {
                    String q="insert into carBrand values('"+brand_id+"','"+brandname+"','"+carmodel+"','"+year+"')";
                    obj.stmt.executeUpdate(q);
                    JOptionPane.showMessageDialog(null,"Details successfully inserted");
                    f.setVisible(false);
                    
                    
                }
                 
                
                
            } catch (Exception ex) 
            {
                ex.printStackTrace();
            }
            
        }
        if(e.getSource()==b2)
        {
            f.setVisible(false);
            
        }
        
    }
    
    public static void main(String[] args) 
    {
        new AddnewcarBrand();
        
    }
   
    
    
}
