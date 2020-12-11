/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.management.system;


import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Login extends JFrame {
    
    JLabel l1,l2;
    JTextField t1;
    JPasswordField t2;
    JButton b1,b2;

    Login(){

        super("Login");

        setLayout(null);

        l1 = new JLabel("Username");
        l1.setBounds(40,20,100,30);
        add(l1);
        
        l2 = new JLabel("Password");
        l2.setBounds(40,70,100,30);
        add(l2);
 
        t1=new JTextField();
        t1.setBounds(150,20,150,30);
        add(t1);

        t2=new JPasswordField();
        t2.setBounds(150,70,150,30);
        add(t2);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3 =  new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(350,10,150,150);
        add(l3);


        b1 = new JButton("Login");
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               String path="jdbc:mysql://localhost:3306/hotel_management?zeroDateTimeBehavior=convertToNull";
               try
               {
                   String Password1 = null,Password2=null;
                   String username = t1.getText();
                   String pass = t2.getText();
                   Class.forName("com.mysql.jdbc.Driver");
                   Connection conn=DriverManager.getConnection(path,"sanskruti","2602");
                   Statement st=conn.createStatement();
                   ResultSet rs1,rs2;


                    String query1="select password from admin where username='Admin'";
                    rs1 =st.executeQuery(query1);
                    while(rs1.next())
                    {
                        Password1=rs1.getString("password");
                    }
                    String query2="select password from admin where username='Reception'";
                    rs2 =st.executeQuery(query2);
                    while(rs2.next())
                    {
                        
                        Password2=rs2.getString("password");
                    }
                   
                    if(pass.equals(Password1)&&username.equals("Admin"))
                    {
                       new Dashboard().setVisible(true);
                       setVisible(false);   
                    }
                    else if(pass.equals(Password2)&&username.equals("Reception"))
                    {
                       new ReceptionWA().setVisible(true);
                       setVisible(false); 
                    }
                    else
                       JOptionPane.showMessageDialog(null, "Invalid Credentials");

               }
               catch(SQLException ex)
               {
                     JOptionPane.showMessageDialog(null, "failed to insert"+ex);
               } catch (ClassNotFoundException ex) {
                    Logger.getLogger(NewCustomer.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
        });
        b1.setBounds(40,140,120,30);
        b1.setFont(new Font("serif",Font.BOLD,15));
        
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        add(b1);

        b2=new JButton("Cancel");
         b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               
                new HotelManagementSystem().setVisible(true);
                 setVisible(false);

                
        }
        });
        b2.setBounds(180,140,120,30);
        b2.setFont(new Font("serif",Font.BOLD,15));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        add(b2);

      
        
        
        getContentPane().setBackground(Color.WHITE);

        setVisible(true);
        setSize(600,300);
        setLocation(600,350);

    }


    public static void main(String[] arg){
        new Login();
    }

   
    

    
}
