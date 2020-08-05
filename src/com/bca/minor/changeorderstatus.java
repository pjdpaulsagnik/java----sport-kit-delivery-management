package com.bca.minor;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class changeorderstatus extends JFrame {

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
	public changeorderstatus(String ID) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 680, 383);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Bahnschrift", Font.PLAIN, 25));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"     Not Yet Dispatched", "    Ordered and Approved", "    Under Manufacture", "    Shipped ", "    Out for Delivery", "    Delivered"}));
		comboBox.setBounds(178, 44, 300, 55);
		contentPane.add(comboBox);
		
		JButton btnUpdateStatusofproduct = new JButton("Update Status");
		btnUpdateStatusofproduct.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnUpdateStatusofproduct.setBounds(253, 253, 148, 50);
		btnUpdateStatusofproduct.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                
            	String value = comboBox.getSelectedItem().toString();
            	
                
            	int a = JOptionPane.showConfirmDialog(btnUpdateStatusofproduct, "Are you sure?");
                // JOptionPane.setRootFrame(null);
                if (a == JOptionPane.YES_OPTION) {
                  	try {
                		Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/scm",
                				"root", "");

                		PreparedStatement st = (PreparedStatement) connection
                                .prepareStatement("UPDATE orderlist SET OrderStatus=? where ID=? ");
                                      
                		
                		st.setString(1, value);
                        st.setString(2, ID);                		
                        st.executeUpdate();
                        
                		JOptionPane.showMessageDialog(btnUpdateStatusofproduct, "Order Status Updated");
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
                	UserLogin obj = new UserLogin();
                	obj.setTitle("Home");
                	obj.setVisible(true);              	
                }
            }
        });
		contentPane.add(btnUpdateStatusofproduct);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\acer\\eclipse-workspace\\SCM_minor\\src\\com\\bca\\minor\\changeorderstatus.jpg"));
		label.setBounds(0, 0, 664, 344);
		contentPane.add(label);
	}
}
