// Shreya 1st page
package CarManagment;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;




public class ViewCar extends JFrame implements ActionListener
{
    String x[]={"Car No","Brand Name","Brand Model","Car Name","Car Engine","Car Category","Car Status"};
    JButton b1;
    String y[][]=new String[20][10] ;//row and colum
    int i=0,j=0;
    JTable t;
    JLabel l1,l2;
    JTextField t1;
    JPanel p1,p2,p3;
    Font f,f1;

     ViewCar() 
    {
        super("New Car Information");
        setSize(1000, 400);
        setLocation(180, 160);

        f=new Font("  MS UI Gothic", Font.BOLD, 15);
                
        try {
            ConnectionClass obj=new ConnectionClass();
            String q="select * from add_car";
            ResultSet rest=obj.stm.executeQuery(q);
            while(rest.next())
            {
                y[i][j++]=rest.getString("car_no");
                y[i][j++]=rest.getString("Brand_name");
                y[i][j++]=rest.getString("brand_model");
                y[i][j++]=rest.getString("car_name");
                y[i][j++]=rest.getString("car_engine");
                y[i][j++]=rest.getString("car_category");
                y[i][j++]=rest.getString("car_status"); 
                i++;
                j=0;                   
            }
            t=new JTable(y,x);
            t.setFont(f);
            t.setBackground(Color.BLACK);
            t.setForeground(Color.WHITE);
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        JScrollPane sp=new JScrollPane(t);
        
        f1=new Font("Arial", Font.BOLD,25);

        l1=new JLabel("Delete any Car?");
        l1.setHorizontalAlignment(JLabel.CENTER);
        l1.setForeground (Color.YELLOW);
        l1.setFont(f1);

        l2=new JLabel("Type Car No");
        l2.setForeground(Color.GRAY);
        l2.setFont(f1);

        t1=new JTextField();
        t1.setFont(f);

        b1=new JButton("Delete Car");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.RED);
        b1.setFont(f);
        b1.addActionListener(this);
        
        p1=new JPanel();
        p1.setLayout(new GridLayout(1,1,10,10));
        p1.add(l1);
        
        p2=new JPanel();
        p2.setLayout(new GridLayout(1,3,10,10));
        p2.add(l2);
        p2.add(t1);
        p2.add(b1);
        
        p3=new JPanel();
        p3.setLayout(new GridLayout(2,1,10,10));
        p3.add(p1);
        p3.add(p2);
        
        p1.setBackground(Color.BLACK);
        p2.setBackground(Color.BLACK);
        p3.setBackground(Color.BLACK);
         
        add(p3, "South");
        add(sp);
    }
    public void actionPerformed(ActionEvent e)
    {
        String carname=t1.getText();
        if(e.getSource()==b1)
        {
            if(carname.isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Please fill the car number!");
            }
            else
            {
                try
                {
                    ConnectionClass obj=new ConnectionClass();
                    String q="delete from add_car where carno='"+carname+"'";
                    int temp=obj.stm.executeUpdate(q);
                    if (temp==1)
                    {
                        JOptionPane.showMessageDialog(null, "car record is deleted"); 
                        setVisible(true);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"Car record does not match!");
                    }
                }
                catch (Exception exx)
                {
                    exx.printStackTrace();
                }
            }    

        }
    }   
    public static void main(String[] args) 
    {
        new ViewCar().setVisible(true);
    }        
}
