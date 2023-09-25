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


public class AdminDao {
	
	private Connection cn;
	private PreparedStatement pst1;
	private PreparedStatement pst2;

	
	
	public void addProduct(Product product) throws SQLException, ClassNotFoundException {
		cn=DBUtils.openConnection();	
		pst1=cn.prepareStatement("insert into product values(?,?,?,?)");
		pst1.setInt(1, product.getId());
		pst1.setString(2, product.getName());
		pst1.setDouble(3, product.getCost());
		pst1.setInt(4, product.getQuantity());		
		pst1.execute();
		//cn.commit();
		DBUtils.closeConnection();
	}
	
	public List<Product> getProducts() throws SQLException, ClassNotFoundException
	{
		cn=DBUtils.openConnection();
		List<Product> list = new ArrayList<Product>();
		pst2=cn.prepareStatement("select * from product");
		ResultSet rs = pst2.executeQuery();
	    while (rs.next()) {
	        list.add(new Product(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getInt(4)));
	    }

	    DBUtils.closeConnection();
	    return list;
		
		
	}
	
}