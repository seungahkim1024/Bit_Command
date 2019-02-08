package service;

import java.util.List;

import domain.CustomerDTO;

public interface CustomerService {

	public void registCustomer(CustomerDTO cus);
	public List<CustomerDTO> bringCustomerList();
	public List<CustomerDTO> retrieveCustomers(String searchWord);
	public CustomerDTO retrieveCustomer(CustomerDTO cus);
	public int countCustomers();
	public boolean existsCustomerID(CustomerDTO cus);
	public void modifyCustomer(CustomerDTO cus);
	public void removeCustomer(CustomerDTO cus);
}
