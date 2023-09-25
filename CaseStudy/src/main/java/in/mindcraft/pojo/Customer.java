package in.mindcraft.pojo;

import java.util.List;

public class Customer {
    private int customerId;
    private String customerName;
    private double walletBalance;
    
    public Customer() {
    	
    }

    public Customer(int customerId, String customerName, double walletBalance) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.walletBalance = walletBalance;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public double getWalletBalance() {
        return walletBalance;
    }

    public void setWalletBalance(double walletBalance) {
        this.walletBalance = walletBalance;
    }


	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", walletBalance="
				+ walletBalance + "]";
	}
	private List<CartItem> cart;

    public List<CartItem> getCart() {
        return cart;
    }

    public void setCart(List<CartItem> cart) {
        this.cart = cart;
    }
    
    
}


