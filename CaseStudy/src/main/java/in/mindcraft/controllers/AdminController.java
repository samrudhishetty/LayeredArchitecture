package in.mindcraft.controllers;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import in.mindcraft.dao.AdminDao;
import in.mindcraft.pojo.Customer;
import in.mindcraft.pojo.Product;


@Controller
public class AdminController {
private AdminDao adminDao=new AdminDao();
	
	@RequestMapping("/insertproduct")
	public void addProduct(HttpServletRequest request,HttpServletResponse reponse) throws SQLException, ClassNotFoundException
	{
		int id=Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("name");
		double cost=Double.parseDouble(request.getParameter("cost"));
		int quantity=Integer.parseInt(request.getParameter("quantity"));
		
		Product product=new Product(id,name,cost,quantity);
		
		adminDao.addProduct(product);
	}
	@RequestMapping("/display")
	public ModelAndView display() throws ClassNotFoundException, SQLException{
		ModelAndView mv=new ModelAndView();

			List<Product> list = adminDao.getProducts();
			System.out.println(list);
			mv.setViewName("display.jsp");
			mv.addObject("list",list);
			
			return mv;
		
		}
	

}
