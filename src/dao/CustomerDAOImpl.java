package dao;

import java.util.List;

import domain.CustomerDTO;

public class CustomerDAOImpl implements CustomerDAO{
	
	private static CustomerDAOImpl instance = new CustomerDAOImpl();
	private CustomerDAOImpl(){}
	public static CustomerDAOImpl getInstance() {
		return instance;
	}
	CustomerDAOImpl customer;

	@Override
	public void insertCustomer() {
		
	}

	@Override
	public List<CustomerDTO> selectCustomerList() {
		
		return customer.selectCustomerList();
	}

	@Override
	public List<CustomerDTO> selectCustomers(String searchWord) {
		
		return customer.selectCustomers(searchWord);
	}

	@Override
	public CustomerDTO selectCustomer(String searchWord) {
		
		return customer.selectCustomer(searchWord);
	}

	@Override
	public int countCustomer() {
		
		return countCustomer();
	}

	@Override
	public boolean existsCustomer() {
		
		return customer.existsCustomer();
	}

	@Override
	public void updateCustomer() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCustomer() {
		// TODO Auto-generated method stub
		
	}

}
