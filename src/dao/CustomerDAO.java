package dao;

import java.util.List;

import domain.CustomerDTO;

public interface CustomerDAO {

	public void insertCustomer(CustomerDTO cus);
	public List<CustomerDTO> selectCustomerList();
	public List<CustomerDTO> selectCustomers(String searchWord);
	public CustomerDTO selectCustomer(CustomerDTO cus);
	public int countCustomer();
	public boolean existsCustomerID(CustomerDTO cus);
	public void updateCustomer();
	public void deleteCustomer();
}
