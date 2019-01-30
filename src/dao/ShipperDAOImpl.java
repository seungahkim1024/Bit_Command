package dao;

import java.util.List;

import domain.ShipperDTO;

public class ShipperDAOImpl implements ShipperDAO{

	private static ShipperDAOImpl instance = new ShipperDAOImpl();
	private ShipperDAOImpl(){}
	public static ShipperDAOImpl getInstance() {
		return instance;
	}
	ShipperDAOImpl ship;
	
	@Override
	public void insertShipper(ShipperDTO ship) {
		
	}

	@Override
	public List<ShipperDTO> selectShipperList() {
		
		return ship.selectShipperList();
	}

	@Override
	public List<ShipperDTO> selectShippers(String searchWord) {
		
		return ship.selectShippers(searchWord);
	}

	@Override
	public ShipperDTO selectShipper(String searchWord) {
		
		return ship.selectShipper(searchWord);
	}

	@Override
	public int countShippers() {
		
		return ship.countShippers();
	}

	@Override
	public boolean existShipper(String searchWord) {
		
		return ship.existShipper(searchWord);
	}

	@Override
	public void updateShipper(ShipperDTO ship) {
		
		
	}

	@Override
	public void deleteShipper(ShipperDTO ship) {
		
		
	}
}