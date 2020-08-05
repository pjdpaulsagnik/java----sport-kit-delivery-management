package com.bca.minor;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class OrderItem extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public OrderItem(String name) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 666, 391);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Boards for surfing, skateboarding, wakeboarding and snowboarding", "Skates for sports like roller skating and ice skating", "Skis for skiing and water skiing", "Football boots", "Cricket spikes", "Golf shoes", "Track spikes", "Prosthetics like the Cheetah Flex-Foot running blade", "Running shoes", "Walking shoes", "Flat pedal shoes and clipless shoes for mountain biking", "Football helmet", "Jock strap", "Mouthguards", "Shin pads", "Ski suits", "Elbow pads", "Shoulder pads", "Bicycle helmet", "Sports gloves"}));
		comboBox.setBounds(142, 59, 354, 37);
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("Place New Order");
		btnNewButton.setBounds(227, 140, 165, 37);
		btnNewButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                
            	String value = comboBox.getSelectedItem().toString();
            	String msg = "Not Yet Dispatched";
                
            	int a = JOptionPane.showConfirmDialog(btnNewButton, "Are you sure?");
                // JOptionPane.setRootFrame(null);
                if (a == JOptionPane.YES_OPTION) {
                  	try {
                		Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/scm",
                				"root", "");

                		String query ="INSERT INTO orderlist(User_Name,Orders,OrderStatus) values ('" + name + "','" + value + "','" + msg + "')";
                                      
                		Statement sta = connection.createStatement();
                        int x = sta.executeUpdate(query);                		
                   
                		JOptionPane.showMessageDialog(btnNewButton, "Your Order has been Placed");
                		dispose();
                		applicationpanel obj = new applicationpanel();
                        obj.setVisible(true);
                        } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                    }
                }
                else if (a == JOptionPane.NO_OPTION) {
                	dispose();
                }
                else if (a == JOptionPane.CANCEL_OPTION) {
                	dispose();
                	CustomerLogin obj = new CustomerLogin();
                	obj.setTitle("Home");
                	obj.setVisible(true);              	
                }
            }
        });
		contentPane.add(btnNewButton);
		
		JButton btnOrderStatus = new JButton("ORDER STATUS");	     
		btnOrderStatus.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnOrderStatus.setBounds(204, 273, 214, 68);
		btnOrderStatus.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
            	dispose();
            	OrderStatus obj = new OrderStatus(name);
            	obj.setTitle("Order Status");
            	obj.setVisible(true);            	
            	
            }
		});
           
		contentPane.add(btnOrderStatus);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\acer\\eclipse-workspace\\SCM_minor\\src\\com\\bca\\minor\\orderitem.jpg"));
		label.setBounds(0, 0, 650, 352);
		contentPane.add(label);
		
	}
}
