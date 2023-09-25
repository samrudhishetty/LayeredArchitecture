package in.mindcraft.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import in.mindcraft.utils.DBUtils;
import in.mindcraft.pojo.Customer;
import in.mindcraft.pojo.Product;

public class CustomerDao {
	private Connection cn;
	private PreparedStatement pst;
	private PreparedStatement pst1;
	private PreparedStatement pst2;
    
    public boolean authenticateCustomer(int customerId, String customerName) throws ClassNotFoundException, SQLException {
        cn = DBUtils.openConnection();
        pst = cn.prepareStatement("SELECT * FROM customer WHERE customerId = ? AND customerName = ?");
        pst.setInt(1, customerId);
        pst.setString(2, customerName);
        
        ResultSet rs = pst.executeQuery();
        boolean isValid = rs.next();
        
        DBUtils.closeConnection();
        return isValid;
    }
	public void addCustomer(Customer customer) throws SQLException, ClassNotFoundException {
		cn=DBUtils.openConnection();	
		pst1=cn.prepareStatement("insert into customer values(?,?,?)");
		pst1.setInt(1, customer.getCustomerId());
		pst1.setString(2, customer.getCustomerName());
		pst1.setDouble(3, customer.getWalletBalance());		
		pst1.execute();
		//cn.commit();
		DBUtils.closeConnection();
	}
	public List<Customer> getCustomers() throws SQLException, ClassNotFoundException
	{
		cn=DBUtils.openConnection();
		List<Customer> list = new ArrayList<Customer>();
		pst2=cn.prepareStatement("select * from customer");
		ResultSet rs = pst2.executeQuery();
	    while (rs.next()) {
	        list.add(new Customer(rs.getInt(1),rs.getString(2),rs.getDouble(3)));
	    }

	    DBUtils.closeConnection();
	    return list;
		
		
	}
    
    // Add more methods for CRUD operations on customers here
    
    // For example, you can add a method to retrieve customer information by ID
    public Customer getCustomerById(int customerId) throws ClassNotFoundException, SQLException {
        cn = DBUtils.openConnection();
        pst = cn.prepareStatement("SELECT * FROM customers WHERE customer_id = ?");
        pst.setInt(1, customerId);
        
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            String customerName = rs.getString("customer_name");
            double walletBalance = rs.getDouble("wallet_balance");
            return new Customer(customerId, customerName, walletBalance);
        }
        
        DBUtils.closeConnection();
        return null;
    }
}
