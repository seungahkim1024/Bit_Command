package service;

import java.util.List;

import domain.SupplierDTO;

public class SupplierServiceImpl implements SupplierService{

	private static SupplierServiceImpl instance = new SupplierServiceImpl();
	private SupplierServiceImpl(){}
	public static SupplierServiceImpl getInstance() {
		return instance;
	}
	
	@Override
	public void registSupplier(SupplierDTO supp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<SupplierDTO> bringSupplierList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SupplierDTO> retrieveSuppliers(String searchWord) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SupplierDTO retrieveSupplier(String searchWord) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countSuppliers() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean existsSupplier(String searchWord) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void modifySupplier(SupplierDTO supp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeSupplier(SupplierDTO supp) {
		// TODO Auto-generated method stub
		
	}
}
