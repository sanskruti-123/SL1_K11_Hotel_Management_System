
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
import java.math.BigInteger;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NewCustomer extends JFrame {
	Connection conn = null;
	PreparedStatement pst = null;
	private JPanel contentPane;
	private JTextField t1,t2,t3,t4,t5,t6;
        JComboBox comboBox,comboBox1;
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

	public NewCustomer() throws SQLException {
		
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
                
                /*JLabel lblId = new JLabel("Rooms Required :");
		lblId.setBounds(35, 76, 200, 14);
		contentPane.add(lblId);*/
                
                
                JLabel l2 = new JLabel("Aadhar Number :");
		l2.setBounds(35, 111, 200, 14);
		contentPane.add(l2);
                
                t1 = new JTextField();//adhar
		t1.setBounds(271, 111, 150, 20);
		contentPane.add(t1);
		t1.setColumns(10);
		
		JLabel lblName_1 = new JLabel("Name :");
		lblName_1.setBounds(35, 151, 200, 14);
		contentPane.add(lblName_1);
		
		t2 = new JTextField();
		t2.setBounds(271, 151, 150, 20);//name
		contentPane.add(t2);
		t2.setColumns(10);

                
		JLabel lblGender = new JLabel("Gender :");
		lblGender.setBounds(35, 191, 200, 14);
		contentPane.add(lblGender);
                
                r1 = new JRadioButton("Male");//gender
                r1.setFont(new Font("Raleway", Font.BOLD, 14));
                r1.setBackground(Color.WHITE);
                r1.setBounds(271, 191, 80, 12);
                add(r1);
                
                r2 = new JRadioButton("Female");
                r2.setFont(new Font("Raleway", Font.BOLD, 14));
                r2.setBackground(Color.WHITE);
                r2.setBounds(350, 191, 100, 12);
		add(r2);
                
		JLabel lblCountry = new JLabel("Country :");
		lblCountry.setBounds(35, 231, 200, 14);
		contentPane.add(lblCountry);
		
                
		t3 = new JTextField(); //country
		t3.setBounds(271, 231, 150, 20);
		contentPane.add(t3);
		t3.setColumns(10);
                
                JLabel lbldays = new JLabel("Days :");
                 lbldays.setBounds(35, 280, 200, 14);
		contentPane.add( lbldays);
              
                
             	t4 = new JTextField(); //days
		t4.setBounds(271, 280, 150, 20);
		contentPane.add(t4);
		t4.setColumns(10);
                
              
		
		JLabel lblCheckInStatus = new JLabel("Deposite :");
		lblCheckInStatus.setBounds(35, 316, 200, 14);
		contentPane.add(lblCheckInStatus);
                
                
		
		t5 = new JTextField();//deposite
		t5.setBounds(271, 316, 150, 20);
		contentPane.add(t5);
		t5.setColumns(10);
		
		JLabel lblDeposite = new JLabel("Rooms Required :");
		lblDeposite.setBounds(35, 359, 200, 14);
		contentPane.add(lblDeposite);
		
		t6 = new JTextField();//deposite
		t6.setBounds(271,359, 150, 20);
		contentPane.add(t6);
		t6.setColumns(10);
		
		
		/*comboBox = new JComboBox(new String[] {"1", "2", "3", "4"});
		comboBox.setBounds(271,359, 150, 20);
		contentPane.add(comboBox);*/
                

		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                           String path="jdbc:mysql://localhost:3306/hotel_management?zeroDateTimeBehavior=convertToNull";
                           try
                           {
                               Calendar calendar = Calendar.getInstance();
                               java.sql.Date ourJavaDateObject = new java.sql.Date(calendar.getTime().getTime());
                               String radio=null;
                               Class.forName("com.mysql.jdbc.Driver");
                               Connection conn=DriverManager.getConnection(path,"sanskruti","2602");
                               Statement st=conn.createStatement();
                               ResultSet rs;
                                 if(r1.isSelected()){ 
                                radio = "Male";
                            }
                            else if(r2.isSelected()){ 
                                radio = "Female";
                            }
                            //String asastring = (String) comboBox.getSelectedItem();
                            
                            String query2="insert into customers(adhar,name,gender,country,checkin,no_of_days,deposite,no_of_rooms) values('"+t1.getText()+"','"+t2.getText()+"','"+radio+"','"+t3.getText()+"','"+ourJavaDateObject+"','"+t4.getText()+"','"+t5.getText()+"','"+ t6.getText()+"')";
                            st.executeUpdate(query2);
                            JOptionPane.showMessageDialog(null, "Inserted");
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