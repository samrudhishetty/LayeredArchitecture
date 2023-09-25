package in.mindcraft.controllers;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import in.mindcraft.dao.CustomerDao;
import in.mindcraft.pojo.Customer;

@Controller
public class LoginController {
    
    private final CustomerDao customerDao = new CustomerDao(); // Instantiate CustomerDao
    
    @RequestMapping("/login")
    public String showLoginPage() {
        return "customerlogin"; // Return the name of the login JSP page
    }
    
    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public String authenticateUser(String id, String name, String role, HttpSession session, Model model) throws ClassNotFoundException, SQLException {
        if ("customer".equals(role) && isCustomerCredentialsValid(id, name)) {
            session.setAttribute("user", "customer");
            session.setAttribute("customerId", id);

            // Fetch and set the customer's cart from the database (if applicable)
            Customer customer = customerDao.getCustomerById(Integer.parseInt(id));
            session.setAttribute("cart", customer.getCart());

            return "customer_home"; // Redirect to customer's home page
        } else {
            model.addAttribute("error", "Invalid credentials");
            return "customerlogin"; // Return to login page with error message
        }
    }
    
    private boolean isCustomerCredentialsValid(String id, String name) throws ClassNotFoundException, SQLException {
        int customerId = Integer.parseInt(id);
        return customerDao.authenticateCustomer(customerId, name);
    }
}
