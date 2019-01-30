package service;

import java.util.List;

import domain.ShipperDTO;

public class ShipperServiceImpl implements ShipperService{

	private static ShipperServiceImpl instance = new ShipperServiceImpl();
	private ShipperServiceImpl(){}
	public static ShipperServiceImpl getInstance() {
		return instance;
	}
	
	@Override
	public void registShipper(ShipperDTO shi) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ShipperDTO> bringShipperList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ShipperDTO> retrieveShippers(String searchWord) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ShipperDTO retrieveShipper(String searchWord) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countShippers() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean existsShipper(String searchWord) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void modifyShipper(ShipperDTO shi) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeShipper(ShipperDTO shi) {
		// TODO Auto-generated method stub
		
	}

}
