package dao;

import java.util.List;

import domain.ShipperDTO;

public interface ShipperDAO {

	public void insertShipper(ShipperDTO ship);
	public List<ShipperDTO> selectShipperList();
	public List<ShipperDTO> selectShippers(String searchWord);
	public ShipperDTO selectShipper(String searchWord);
	public int countShippers();
	public boolean existShipper(String searchWord);
	public void updateShipper(ShipperDTO ship);
	public void deleteShipper(ShipperDTO ship);
	
}
