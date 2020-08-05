package com.bca.minor;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class OrderStatus extends JFrame {

	 /**
		 * 
		 */
		private static final long serialVersionUID = 1L;
	    private javax.swing.JPanel jPanel2;
	    private javax.swing.JScrollPane jScrollPane1;
	    private javax.swing.JTable jTable_Users;
	    
	    /**
	     * @param args the command line arguments
	     */

	    
	    public static void main(String args[]) {
	        try {
	            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
	                if ("Nimbus".equals(info.getName())) {
	                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
	                    break;
	                }
	            }
	        } catch (ClassNotFoundException ex) {
	            java.util.logging.Logger.getLogger(JTable_Search.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (InstantiationException ex) {
	            java.util.logging.Logger.getLogger(JTable_Search.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (IllegalAccessException ex) {
	            java.util.logging.Logger.getLogger(JTable_Search.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
	            java.util.logging.Logger.getLogger(JTable_Search.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        }
	        //</editor-fold>

	        /* Create and display the form */
	        java.awt.EventQueue.invokeLater(new Runnable() {
	            public void run() {
	                new OrderStatus("").setVisible(true);
	            }
	        });
	    }

	    /**
	     * Creates new form JTable_Search
	     */
	     public OrderStatus(String name)  {
	        initComponents();
	        
	        // call findUsers function
	        findUsers(name);
	        
	    }

	    
	    // function to connect to mysql database
	    public Connection getConnection()
	    {
	        Connection con = null;
	        
	        try{
	            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/scm","root","");
	        }catch(Exception ex){
	            System.out.println(ex.getMessage());
	        }
	        
	        return con;
	    }
	    
	 // function to return users arraylist with particular data 
	    public ArrayList<user> ListUsers(String name)
	    {
	        ArrayList<user> usersList = new ArrayList<user>();
	        
	        PreparedStatement  st;
	        ResultSet rs;
	        
	        try{
	            Connection con = getConnection();
	            st = (PreparedStatement) con
	                    .prepareStatement("SELECT * FROM `orderlist` where User_Name=?");
	             st.setString(1, name);
			     rs = st.executeQuery();
	            
	            user user;
	            
	            while(rs.next())
	            {
	                user = new user(
	                                 rs.getInt("ID"),
	                                 rs.getString("User_Name"),
	                                 rs.getString("Orders"),
	                                 rs.getString("OrderStatus")
	                                );
	                usersList.add(user);
	            }
	            
	        }catch(Exception ex){
	            System.out.println(ex.getMessage());
	        }
	        
	        return usersList;
	    }
	    
	    // function to display data in jtable
	    public void findUsers(String name)
	    {
	        ArrayList<user> users = ListUsers(name);
	        DefaultTableModel model = new DefaultTableModel();
	        model.setColumnIdentifiers(new Object[]{"ID","USER-name","ORDERS","Order-STATUS"});
	        Object[] row = new Object[4];
	        
	        for(int i = 0; i < users.size(); i++)
	        {
	            row[0] = users.get(i).getid();
	            row[1] = users.get(i).getUname();
	            row[2] = users.get(i).getOrder();
	            row[3] = users.get(i).getOrderStatus();
	            model.addRow(row);
	        }
	       jTable_Users.setModel(model);
	       
	    }
	    
	    
	    @SuppressWarnings("unchecked")
	    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
	    private void initComponents() {

	        jPanel2 = new javax.swing.JPanel();
	        jScrollPane1 = new javax.swing.JScrollPane();
	        jTable_Users = new javax.swing.JTable();

	        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

	        jTable_Users.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
	        jTable_Users.setModel(new javax.swing.table.DefaultTableModel(
	            new Object [][] {
	                {null, null, null, null},
	                {null, null, null, null},
	                {null, null, null, null},
	                {null, null, null, null}
	            },
	            new String [] {
	                "Title 1", "Title 2", "Title 3", "Title 4"
	            }
	        ));
	        jScrollPane1.setViewportView(jTable_Users);

	        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
	        jPanel2Layout.setHorizontalGroup(
	        	jPanel2Layout.createParallelGroup(Alignment.LEADING)
	        		.addGroup(jPanel2Layout.createSequentialGroup()
	        			.addGap(37)
	        			.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 502, GroupLayout.PREFERRED_SIZE)
	        			.addContainerGap(32, Short.MAX_VALUE))
	        );
	        jPanel2Layout.setVerticalGroup(
	        	jPanel2Layout.createParallelGroup(Alignment.LEADING)
	        		.addGroup(jPanel2Layout.createSequentialGroup()
	        			.addGap(45)
	        			.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 434, GroupLayout.PREFERRED_SIZE)
	        			.addContainerGap(41, Short.MAX_VALUE))
	        );
	        jPanel2.setLayout(jPanel2Layout);

	        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
	        getContentPane().setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	        );

	        pack();
	    }// </editor-fold>  

	                       
}
