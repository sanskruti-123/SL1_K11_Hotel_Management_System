/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.management.system;

import java.awt.BorderLayout;
import java.awt.*;
import java.awt.EventQueue;


import java.sql.*;	
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.Font;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CheckOut extends JFrame{
	Connection conn = null;
	PreparedStatement pst = null;
	private JPanel contentPane;
	private JTextField t1,t2;
        Choice c1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CheckOut frame = new CheckOut();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void close(){
		this.dispose();
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public CheckOut() throws SQLException {
		//conn = Javaconnect.getDBConnection();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(530, 200, 800, 294);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
                
                ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/sixth.jpg"));
                Image i3 = i1.getImage().getScaledInstance(400, 225,Image.SCALE_DEFAULT);
                ImageIcon i2 = new ImageIcon(i3);
                JLabel l1 = new JLabel(i2);
                l1.setBounds(300,0,500,225);
                add(l1);
		
		JLabel lblCheckOut = new JLabel("Check Out ");
		lblCheckOut.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCheckOut.setBounds(70, 11, 140, 35);
		contentPane.add(lblCheckOut);
		
	

		JLabel lbladhar = new JLabel("adhar:");
		lbladhar.setBounds(20, 85, 86, 20);
		contentPane.add(lbladhar);
		
		t2 = new JTextField();
                t2.setBounds(130, 85, 144, 20);
		contentPane.add(t2);
                
                
                
		JLabel lblRoomNumber = new JLabel("Room Number:");
		lblRoomNumber.setBounds(20, 132, 86, 20);
		contentPane.add(lblRoomNumber);
		
		t1 = new JTextField();
                t1.setBounds(130, 132, 150, 20);
		contentPane.add(t1);
                
                
                JButton btnCheckOut = new JButton("Check Out");
		btnCheckOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                                String path="jdbc:mysql://localhost:3306/hotel_management?zeroDateTimeBehavior=convertToNull";
                                String id = t1.getText();
                                String s1 = t1.getText();
                                String q2 = "update rooms set availability = 'yes' where room_no = "+s1;
                                String q3 = "update rooms set cleaning_status ='dirty' where room_no = "+s1;
                            try
                            {
                               Class.forName("com.mysql.jdbc.Driver");
                               Connection conn=DriverManager.getConnection(path,"sanskruti","2602");
                               Statement st=conn.createStatement();
                               Statement st1=conn.createStatement();
                               ResultSet rs;
                               st.executeUpdate(q2);
                               st1.executeUpdate(q3);
                               JOptionPane.showMessageDialog(null, "Check Out Successful");
                               new Reception().setVisible(true);
                               setVisible(false);
                            }
                            catch(SQLException ex)
                            {
                                 JOptionPane.showMessageDialog(null, "failed to insert"+ex);
                            } catch (ClassNotFoundException ex) {
                                Logger.getLogger(NewCustomer.class.getName()).log(Level.SEVERE, null, ex);
                            }
                               
			}
		});
		btnCheckOut.setBounds(50, 200, 100, 25);
                btnCheckOut.setBackground(Color.BLACK);
                btnCheckOut.setForeground(Color.WHITE);
		contentPane.add(btnCheckOut);
		
		JButton btnExit = new JButton("Back");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Reception().setVisible(true);
                                setVisible(false);
			}
		});
		btnExit.setBounds(160, 200, 100, 25);
                btnExit.setBackground(Color.BLACK);
                btnExit.setForeground(Color.WHITE);
		contentPane.add(btnExit);
                
                
                getContentPane().setBackground(Color.WHITE);
	}

}
