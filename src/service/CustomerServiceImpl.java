package service;

import java.util.List;
import java.util.Map;

import dao.CustomerDAOImpl;
import domain.CustomerDTO;
import proxy.Proxy;

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
	public List<CustomerDTO> bringCustomerList(Proxy pxy) {
				
		return dao.selectCustomerList(pxy);
	}

	@Override
	public List<CustomerDTO> retrieveCustomers(Proxy pxy) {
		
		return dao.selectCustomers(pxy);
	}

	@Override
	public CustomerDTO retrieveCustomer(CustomerDTO cus) {
		
		return dao.selectCustomer(cus);
	}

	@Override
	public int countCustomers(Proxy pxy) {
		// TODO Auto-generated method stub
		return dao.countCustomer(pxy);
	}

	@Override
	public boolean existsCustomerID(CustomerDTO cus) {
		
		return dao.existsCustomerID(cus);
	}

	@Override
	public void modifyCustomer(CustomerDTO cus) {
		dao.updateCustomer(cus);
		
	}

	@Override
	public void removeCustomer(CustomerDTO cus) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Map<String, Object> retrievePhone(Proxy pxy) {
		
		return dao.selectPhone(pxy);
	}
	@Override
	public void fileUpload(Proxy pxy) {
		
	}
}
