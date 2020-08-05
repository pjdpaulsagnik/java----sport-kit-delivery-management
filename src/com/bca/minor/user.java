package com.bca.minor;

public class user {
	
	 
	    private int Id;
	    private String uname;
	    private String orders;
	    private String orderstatus;
	    
	    
	    public user(int ID,String Uname,String Order,String OrderStatus)
	    {
	        this.Id = ID;
	        this.uname = Uname;
	        this.orders = Order;
	        this.orderstatus = OrderStatus;
	    }
	    

	    public int getid()
	    {
	        return Id;
	    }
	    
	    public String getUname()
	    {
	        return uname;
	    }
	    
	    public String getOrder()
	    {
	        return orders;
	    }
	    
	    public String getOrderStatus()
	    {
	        return orderstatus;
	    }

}
