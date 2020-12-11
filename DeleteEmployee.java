/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.management.system;

import java.awt.BorderLayout;
import java.awt.*;
import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;

import java.awt.Font;
import java.awt.Image;
import java.sql.*;	
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
public class DeleteEmployee extends JFrame {
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

	public DeleteEmployee() throws SQLException {
		
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
		
		JLabel lblName = new JLabel("Delete Employee");
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
		
		
                
              
		
		
                
               JButton btnNewButton = new JButton("Delete");
                btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                           String path="jdbc:mysql://localhost:3306/hotel_management?zeroDateTimeBehavior=convertToNull";
                           float price=0,total=0;
                           int days=0;
                           try
                           {
                               
                                Class.forName("com.mysql.jdbc.Driver");
                                Connection conn=DriverManager.getConnection(path,"sanskruti","2602");
                                Statement st=conn.createStatement();
                                Statement st1=conn.createStatement();
                                Statement st2=conn.createStatement();
                                ResultSet rs1,rs2,rs3;
                                String query1="delete from employee where adhar='"+ t1.getText()+"'";
                                st.executeUpdate(query1);
                               
                                
                               
                                JOptionPane.showMessageDialog(null, "Success deleted");
                           }
                           catch(SQLException ex)
                           {
                                 JOptionPane.showMessageDialog(null, "failed to delete"+ex);
                           } catch (ClassNotFoundException ex) {
                                Logger.getLogger(NewCustomer.class.getName()).log(Level.SEVERE, null, ex);
                           }
                    }
		});
		/*btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                            conn c = new conn();
                            String radio = null;
                            
                            if(r1.isSelected()){ 
                                radio = "Male";
                            }
                            else if(r2.isSelected()){ 
                                radio = "Female";
                            }
                            
                            String s6 = c1.getSelectedItem();
                          
                            try{
	    			
                                String s1 = (String)comboBox.getSelectedItem(); 
	    			String s2 =  t1.getText();
	    			String s3 =  t2.getText();
                                String s4 =  radio;
	    			String s5 =  t3.getText();
	    			String s7 =  t5.getText();
                                String s8 =  t6.getText();
                                
                                String q1 = "insert into customer values('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+s6+"','"+s7+"','"+s8+"')";
                                String q2 = "update room set availability = 'Occupied' where room_number = "+s6;
                                c.s.executeUpdate(q1);
                                c.s.executeUpdate(q2);
	    			
	    			
	    			JOptionPane.showMessageDialog(null, "Data Inserted Successfully");
                                new Reception().setVisible(true);
                                setVisible(false);
	    		}
		    		catch(NumberFormatException s){
		    			JOptionPane.showMessageDialog(null, "Please enter a valid Number");
			}
			}
		});*/
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
