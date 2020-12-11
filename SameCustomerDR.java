/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.management.system;

import java.awt.*;
import java.awt.EventQueue;


import java.awt.Font;
import java.awt.Image;
import java.sql.*;	
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
public class SameCustomerDR extends JFrame {
	Connection conn = null;
	PreparedStatement pst = null;
	private JPanel contentPane;
	private JTextField t1,t2,t3,t4,t5,t6,t0;
        JComboBox comboBox;
        JRadioButton r1,r2;
        Choice c1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewCustomer frame = new NewCustomer();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public SameCustomerDR() throws SQLException {
		
                setBounds(530, 200, 850, 550);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
                
                ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/fifth.png"));
                Image i3 = i1.getImage().getScaledInstance(300, 400,Image.SCALE_DEFAULT);
                ImageIcon i2 = new ImageIcon(i3);
                JLabel l1 = new JLabel(i2);
                l1.setBounds(480,10,300,500);
                add(l1);
		
		JLabel lblName = new JLabel("NEW CUSTOMER FORM");
		lblName.setFont(new Font("Yu Mincho", Font.PLAIN, 20));
		lblName.setBounds(118, 11, 260, 53);
		contentPane.add(lblName);
                
            
                JLabel l2 = new JLabel("Adhar Number :");
		l2.setBounds(35, 111, 200, 14);
		contentPane.add(l2);
                
                t1 = new JTextField();
		t1.setBounds(271, 111, 150, 20);
		contentPane.add(t1);
		t1.setColumns(10);
		
		
                
              
		
		JLabel lblName_1 = new JLabel("Allocated room number :");
		lblName_1.setBounds(35, 151, 200, 14);
		contentPane.add(lblName_1);
		
		t2 = new JTextField();
		t2.setBounds(271, 151, 150, 20);
		contentPane.add(t2);
		t2.setColumns(10);
                
               
		

		JButton btnNewButton = new JButton("Add");
                btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                           String path="jdbc:mysql://localhost:3306/hotel_management?zeroDateTimeBehavior=convertToNull";
                           float price=0,total=0;
                           int days=0;
                           String stat = null;
                           try
                           {
                               
                                Class.forName("com.mysql.jdbc.Driver");
                                Connection conn=DriverManager.getConnection(path,"sanskruti","2602");
                                Statement st=conn.createStatement();
                                Statement st1=conn.createStatement();
                                Statement st2=conn.createStatement();
                                ResultSet rs,rs1,rs2,rs3;
                                String query="select availability from rooms where room_no='"+ t2.getText()+"'";
                                rs=st.executeQuery(query);
                                while(rs.next())
                                {
                                   stat=rs.getString("availability");
                                }
                                if(stat.equalsIgnoreCase("yes")){
                                String query1="select price from rooms where room_no='"+ t2.getText()+"'";
                                rs1=st.executeQuery(query1);
                                String query2="select no_of_days from customers where adhar='"+ t1.getText()+"'";
                                rs2=st1.executeQuery(query2);
                                String query3="update rooms set availability ="+"'No'"+" where room_no = "+t2.getText();
                                st2.executeUpdate(query3);
                                while(rs1.next())
                                {
                                   price=rs1.getFloat("price");
                                }
                                while(rs2.next())
                                {
                                   days=rs2.getInt("no_of_days");
                                }
                                total=price*days;
                                String query4="insert into booking values('"+t1.getText()+"','"+t2.getText()+"','"+total+"')";
                                st2.executeUpdate(query4);
                                JOptionPane.showMessageDialog(null, "Inserted");
                                new Reception().setVisible(true);
                                    setVisible(false);
                                }
                                else
                                { 
                                   JOptionPane.showMessageDialog(null, "Room not available");  
                                   new Reception().setVisible(true);
                                   setVisible(false);
                                   
                                }
                           }
                           catch(SQLException ex)
                           {
                                 JOptionPane.showMessageDialog(null, "failed to insert"+ex);
                           } catch (ClassNotFoundException ex) {
                                Logger.getLogger(NewCustomer.class.getName()).log(Level.SEVERE, null, ex);
                           }
                    }
		});
		btnNewButton.setBounds(100, 430, 120, 30);
                btnNewButton.setBackground(Color.BLACK);
                btnNewButton.setForeground(Color.WHITE);
		contentPane.add(btnNewButton);
		
		JButton btnExit = new JButton("Back");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                            new Reception().setVisible(true);
                            setVisible(false);
			}
		}); 
		btnExit.setBounds(260, 430, 120, 30);
                btnExit.setBackground(Color.BLACK);
                btnExit.setForeground(Color.WHITE);
		contentPane.add(btnExit);
                
                getContentPane().setBackground(Color.WHITE);
	}
}
