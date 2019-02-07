package dao;

import java.util.List;

import domain.CustomerDTO;

public interface CustomerDAO {

	public void insertCustomer(CustomerDTO cus);
	public List<CustomerDTO> selectCustomerList();
	public List<CustomerDTO> selectCustomers(String searchWord);
	public CustomerDTO selectCustomer(String searchWord);
	public int countCustomer();
	public boolean existsCustomer(CustomerDTO cus);
	public void updateCustomer();
	public void deleteCustomer();
}
