package dao;

import java.util.List;

import domain.EmployeeDTO;

public class EmployeeDAOImpl implements EmployeeDAO{
	
	private static EmployeeDAOImpl instance = new EmployeeDAOImpl();
	private EmployeeDAOImpl(){dao = EmployeeDAOImpl.getInstance();}
	public static EmployeeDAOImpl getInstance() {
	return instance;
	}
	EmployeeDAOImpl dao;
	
	@Override
	public void insertEmployee(EmployeeDTO emp) {
		dao.insertEmployee(emp);
	}

	@Override
	public List<EmployeeDTO> selectEmployeesList() {
		
		return dao.selectEmployeesList();
	}

	@Override
	public List<EmployeeDTO> selectEmployees(String searchWord) {
		
		return dao.selectEmployeesList();
	}

	@Override
	public EmployeeDTO selectEmployee(String searchWord) {
		
		return dao.selectEmployee(searchWord);
	}

	@Override
	public int countEmployees() {
		
		return countEmployees();
	}

	@Override
	public boolean existsEmployee(String searchWord) {
		
		return dao.existsEmployee(searchWord);
	}

	@Override
	public void updateEmployee(EmployeeDTO emp) {
		
		
	}

	@Override
	public void deleteEmployee(EmployeeDTO emp) {
		
		
	}

}
