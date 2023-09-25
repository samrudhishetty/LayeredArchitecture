package in.mindcraft.controllers;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import in.mindcraft.dao.AdminDao;
import in.mindcraft.dao.CustomerDao;
import in.mindcraft.pojo.Customer;
import in.mindcraft.pojo.Product;


@Controller
public class CustomerController {
	
	private CustomerDao customerDao=new CustomerDao();
	
	@RequestMapping("/createcustomer")
	public void addCustomer(HttpServletRequest request,HttpServletResponse reponse) throws SQLException, ClassNotFoundException
	{
		int customerId = Integer.parseInt(request.getParameter("customerId"));
		String customerName=request.getParameter("customerName");
		double walletBalance=Double.parseDouble(request.getParameter("walletBalance"));
		
		
		Customer customer=new Customer(customerId,customerName,walletBalance);
		
		customerDao.addCustomer(customer);
	}
	@RequestMapping("/view")
	public ModelAndView display() throws ClassNotFoundException, SQLException{
		ModelAndView mv=new ModelAndView();

			List<Customer> list = customerDao.getCustomers();
			System.out.println(list);
			mv.setViewName("view.jsp");
			mv.addObject("list",list);
			
			return mv;
		
		}
	

}
