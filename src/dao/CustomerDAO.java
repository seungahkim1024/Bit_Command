package dao;

import java.util.List;
import java.util.Map;

import domain.CustomerDTO;
import proxy.Proxy;

public interface CustomerDAO {

	public void insertCustomer(CustomerDTO cus);
	public List<CustomerDTO> selectCustomerList(Proxy pxy);
	public List<CustomerDTO> selectCustomers(Proxy pxy);
	public CustomerDTO selectCustomer(CustomerDTO cus);
	public int countCustomer(Proxy pxy);
	public boolean existsCustomerID(CustomerDTO cus);
	public void updateCustomer(CustomerDTO cus);
	public void deleteCustomer();
	public Map<String,Object> selectPhone(Proxy pxy);
}
