package service;

import java.util.List;

import dao.EmployeeDAOImpl;
import domain.EmployeeDTO;

public class EmployeeServiceImpl implements EmployeeService {
	
	private static EmployeeServiceImpl instance = new EmployeeServiceImpl();
	private EmployeeServiceImpl(){dao = EmployeeDAOImpl.getInstance();}
	public static EmployeeServiceImpl getInstance() {
	return instance;
	}
	
	EmployeeDAOImpl dao;
	
	@Override
	public void registEmployee(EmployeeDTO emp) {
		System.out.println("employeeimpl 진입!!!");
		dao.insertEmployee(emp);
	}


	@Override
	public List<EmployeeDTO> bringEmployeesList() {
		
		return dao.selectEmployeesList();
	}

	@Override
	public List<EmployeeDTO> retrieveEmployees(String searchWord) {
		
		return dao.selectEmployees(searchWord);
	}

	@Override
	public EmployeeDTO retrieveEmployee(String searchWord) {
		
		return dao.selectEmployee(searchWord);
	}

	@Override
	public int countEmployees() {
		// TODO Auto-generated method stub
		return dao.countEmployees();
	}

	@Override
	public boolean existsEmployee(EmployeeDTO emp) {
	
		return dao.existsEmployee(emp);
	}

	@Override
	public void modifyEmployee(EmployeeDTO emp) {
		
		
	}

	@Override
	public void removeEmployee(EmployeeDTO emp) {
		
		
	}

}
