package dao;

import java.util.List;

import domain.SupplierDTO;

public interface SupplierDAO {

	public void insertSupplier(SupplierDTO supp);
	public List<SupplierDTO> selectSupplierList();
	public List<SupplierDTO> selectSuppliers(String searchWord);
	public SupplierDTO selectSupplier(String searchWord);
	public int countSuppliers();
	public boolean existsSupplier(String searchWord);
	public void updateSupplier(SupplierDTO supp);
	public void deleteSupplier(SupplierDTO supp);
	
}
