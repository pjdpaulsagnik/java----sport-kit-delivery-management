package com.bca.minor;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.SystemColor;
import javax.swing.JTextField;


public class UserHome extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JLabel label;
    private JTextField textField;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UserHome frame = new UserHome();
                    frame.setTitle("Home");
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public UserHome() {
    	
    	JButton button = new JButton("");
    	getContentPane().add(button, BorderLayout.CENTER);

    }

    /**
     * Create the frame.
     */
    public UserHome(String userSes) {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(150, 90, 1014, 597);
        setResizable(true);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        JButton btnNewButton = new JButton("Logout");
        btnNewButton.setBounds(640, 141, 317, 82);
        btnNewButton.setForeground(new Color(0, 0, 0));
        btnNewButton.setBackground(UIManager.getColor("Button.disabledForeground"));
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 39));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int a = JOptionPane.showConfirmDialog(btnNewButton, "Are you sure?");
                // JOptionPane.setRootFrame(null);
                if (a == JOptionPane.YES_OPTION) {
                    dispose();
                    UserLogin obj = new UserLogin();
                    obj.setTitle("Supplier-Login Portal");
                    obj.setVisible(true);
                }
                else if (a == JOptionPane.NO_OPTION) {
                	dispose();
                	UserHome obj = new UserHome(userSes);
                	obj.setTitle("Home");
                	obj.setVisible(true);
                }
                else if (a == JOptionPane.CANCEL_OPTION) {
                	dispose();
                	UserHome obj = new UserHome(userSes);
                	obj.setTitle("Home");
                	obj.setVisible(true);              	
                }

            }
        });
        contentPane.setLayout(null);
        contentPane.add(btnNewButton);
        JButton button = new JButton("Change-password\r\n");
        button.setBounds(640, 249, 317, 94);
        button.setBackground(UIManager.getColor("Button.disabledForeground"));
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ChangePassword bo = new ChangePassword(userSes);
                bo.setTitle("Change Password");
                bo.setVisible(true);

            }
        });
        button.setFont(new Font("Tahoma", Font.PLAIN, 35));
        contentPane.add(button);
        
        JButton ldButton = new JButton("Load Order List");
        ldButton.setBounds(640, 366, 317, 94);
        ldButton.setForeground(new Color(0, 0, 0));
        ldButton.setBackground(UIManager.getColor("Button.disabledForeground"));
        ldButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                JTable_Search obj= new JTable_Search();
                obj.setTitle("Orders Database");
                obj.setVisible(true);
            }
        });
        ldButton.setFont(new Font("Tahoma", Font.PLAIN, 39));
        contentPane.add(ldButton);
        
        JLabel lblPlaceCustomerId = new JLabel("Place Customer ID  to Change its Order Status");
        lblPlaceCustomerId.setForeground(Color.MAGENTA);
        lblPlaceCustomerId.setFont(new Font("Franklin Gothic Book", Font.BOLD | Font.ITALIC, 22));
        lblPlaceCustomerId.setBounds(27, 80, 447, 82);        
        contentPane.add(lblPlaceCustomerId);

        JButton button_1 = new JButton("Search ID to Change Order Status\r\n");
        button_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        button_1.setBackground(UIManager.getColor("Button.disabledForeground"));
        button_1.setBounds(65, 306, 363, 76);
        button_1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String ID = textField.getText();
                
                try {
                    Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/scm",
                        "root", "");

                    PreparedStatement st = (PreparedStatement) connection
                        .prepareStatement("Select ID from `orderlist` where ID=?");

                    st.setString(1, ID);                    
                    ResultSet rs = st.executeQuery();
                    if (rs.next()) {
                        dispose();
                        changeorderstatus ah = new changeorderstatus(ID);
                        ah.setTitle("Change Status");
                        ah.setVisible(true);
                        
                    } else {
                        JOptionPane.showMessageDialog(btnNewButton, "ID has no active Order");
                    }
                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }
            }
        });
        
        contentPane.add(button_1);
        
        
        textField = new JTextField();
        textField.setBounds(116, 216, 252, 51);
        contentPane.add(textField);
        textField.setColumns(10);
                
        
        label = new JLabel("");
        label.setBounds(0, 0, 1008, 562);
        label.setIcon(new ImageIcon("C:\\Users\\acer\\eclipse-workspace\\SCM_minor\\src\\com\\bca\\minor\\loginimage.jpg"));
        contentPane.add(label);
        
      
      
        
    }
}
