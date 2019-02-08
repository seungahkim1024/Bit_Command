package service;

import java.util.List;

import dao.CustomerDAOImpl;
import domain.CustomerDTO;

public class CustomerServiceImpl implements CustomerService{
	
	private static CustomerServiceImpl instance = new CustomerServiceImpl();
	CustomerDAOImpl dao;
	private CustomerServiceImpl (){dao = CustomerDAOImpl.getInstance();}
	public static CustomerServiceImpl getInstance() {
		return instance;
	}
	
	@Override
	public void registCustomer(CustomerDTO cus) {
		System.out.println("customerimpl 진입!!!");
		dao.insertCustomer(cus);
	}

	@Override
	public List<CustomerDTO> bringCustomerList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CustomerDTO> retrieveCustomers(String searchWord) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomerDTO retrieveCustomer(CustomerDTO cus) {
		
		return dao.selectCustomer(cus);
	}

	@Override
	public int countCustomers() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean existsCustomerID(CustomerDTO cus) {
		
		return dao.existsCustomerID(cus);
	}

	@Override
	public void modifyCustomer(CustomerDTO cus) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeCustomer(CustomerDTO cus) {
		// TODO Auto-generated method stub
		
	}

}
