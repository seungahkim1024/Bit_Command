package service;

import java.util.List;

import dao.ProductDAOImpl;
import domain.ProductDTO;
import proxy.Proxy;

public class ProductServiceImpl implements ProductService{

	private static ProductServiceImpl instance = new ProductServiceImpl();
	private ProductServiceImpl(){dao=ProductDAOImpl.getInstance();} 
	public static ProductServiceImpl getInstance() {
		return instance;
	}
	ProductDAOImpl dao;
	
	
	@Override
	public void registProduct(ProductDTO pro) {
		dao.insertProduct(pro);
		
	}
	@Override
	public List<ProductDTO> bringAllProductList(Proxy pxy) {
		
		return dao.selectAllProductList(pxy);
	}
	@Override
	public List<ProductDTO> retrieveSomeProducts(Proxy pxy) {
		
		return dao.selectProducts(pxy);
	}
	@Override
	public ProductDTO retrieveProduct(ProductDTO pro) {
		
		return dao.selectProduct(pro);
	}
	@Override
	public int countProduct(Proxy pxy) {
		
		return dao.countProduct(pxy);
	}
	@Override
	public boolean existsProduct(ProductDTO pro) {
		
		return dao.existProduct(pro);
	}
	@Override
	public void modifyProduct(ProductDTO pro) {
		dao.updateProduct(pro);
		
	}
	@Override
	public void removeProduct(ProductDTO pro) {
		dao.deleteProduct(pro);
		
	}
	
	
}
