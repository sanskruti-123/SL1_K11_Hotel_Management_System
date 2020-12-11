/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.management.system;


import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AddRoom extends JFrame {

    private JPanel contentPane;
    private JTextField t1,t2,t3,t4;
    private JComboBox comboBox, comboBox_1, comboBox_2, comboBox_3;
    JButton b1,b2;
    Choice c1;

    public static void main(String[] args) {
        new AddRoom().setVisible(true);
    }


    public AddRoom() {
        setBounds(450, 200, 1000, 450);
	contentPane = new JPanel();
	setContentPane(contentPane);
	contentPane.setLayout(null);
        
        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/twelve.jpg"));
                Image i3 = i1.getImage().getScaledInstance(500, 300,Image.SCALE_DEFAULT);
                ImageIcon i2 = new ImageIcon(i3);
                JLabel l15 = new JLabel(i2);
                l15.setBounds(400,30,500,370);
                add(l15);
        
        JLabel l10 = new JLabel("Add Rooms");
        l10.setFont(new Font("Tahoma", Font.BOLD, 18));
	l10.setBounds(194, 10, 120, 22);
	contentPane.add(l10);
        
	
        
	JLabel l1 = new JLabel("Room Number");
	l1.setForeground(new Color(25, 25, 112));
	l1.setFont(new Font("Tahoma", Font.BOLD, 14));
	l1.setBounds(64, 70, 102, 22);
	contentPane.add(l1);
        
        
        t4 = new JTextField();//taking room number
	t4.setBounds(174, 70, 156, 20);
	contentPane.add(t4);
        

	JLabel l2 = new JLabel("Availability");
	l2.setForeground(new Color(25, 25, 112));
	l2.setFont(new Font("Tahoma", Font.BOLD, 14));
	l2.setBounds(64, 110, 102, 22);
	contentPane.add(l2);
        
        comboBox = new JComboBox(new String[] { "yes", "no" });//taking availability
	comboBox.setBounds(176, 110, 154, 20);
	contentPane.add(comboBox);
        String available = (String) comboBox.getSelectedItem();

	JLabel l3 = new JLabel("Cleaning Status");
	l3.setForeground(new Color(25, 25, 112));
	l3.setFont(new Font("Tahoma", Font.BOLD, 14));
	l3.setBounds(64, 150, 102, 22);
	contentPane.add(l3);
        
        comboBox_2 = new JComboBox(new String[] { "clean", "dirty" });//taking cleaning status
	comboBox_2.setBounds(176, 150, 154, 20);
	contentPane.add(comboBox_2);
        String cleaning = (String) comboBox_2.getSelectedItem();
        
	JLabel l4 = new JLabel("Price");
	l4.setForeground(new Color(25, 25, 112));
	l4.setFont(new Font("Tahoma", Font.BOLD, 14));
	l4.setBounds(64, 190, 102, 22);
	contentPane.add(l4);
        
        t2 = new JTextField();//taking price
	t2.setBounds(174, 190, 156, 20);
	contentPane.add(t2);

        JLabel l5 = new JLabel("Bed Type");
	l5.setForeground(new Color(25, 25, 112));
	l5.setFont(new Font("Tahoma", Font.BOLD, 14));
	l5.setBounds(64, 230, 102, 22);
	contentPane.add(l5);


        comboBox_3 = new JComboBox(new String[] { "Single Bed", "Double Bed"});//taking bed type
	comboBox_3.setBounds(176, 230, 154, 20);
	contentPane.add(comboBox_3);
        String type = (String) comboBox_3.getSelectedItem();

	

	

	b1 = new JButton("Add");
        b1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                   String path="jdbc:mysql://localhost:3306/hotel_management?zeroDateTimeBehavior=convertToNull";
                   try
                   {
                      
                       Class.forName("com.mysql.jdbc.Driver");
                       Connection conn=DriverManager.getConnection(path,"sanskruti","2602");
                       Statement st=conn.createStatement();
                       ResultSet rs;
                      
                       String query2="insert into rooms values('"+t4.getText()+"','"+available+"','"+cleaning+"','"+t2.getText()+"','"+type+"')";
                       st.executeUpdate(query2);
                       JOptionPane.showMessageDialog(null, "Inserted");
                       new Reception().setVisible(true);
                       setVisible(false);
                   }
                   catch(SQLException ex)
                   {
                         JOptionPane.showMessageDialog(null, "failed to insert"+ex);
                   } 
                   catch (ClassNotFoundException ex) {
                        Logger.getLogger(NewCustomer.class.getName()).log(Level.SEVERE, null, ex);
                   }
            }
        });
	b1.setBounds(64, 321, 111, 33);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
	contentPane.add(b1);
	
        contentPane.setBackground(Color.WHITE);
    
    }
    
  

} 

