package service;

import java.util.List;

import domain.OrderDTO;

public class OrderServiceImpl implements OrderService{

	private static OrderServiceImpl instance = new OrderServiceImpl();
	private OrderServiceImpl(){} 
	public static OrderServiceImpl getInstance() {
		return instance;
	}
	
	@Override
	public void registOrder(OrderDTO order) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<OrderDTO> bringAllOrderList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderDTO> retrieveOrderListbySomeone(String searchWord) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderDTO retrieveOrderSeq(String searchWord) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countOrderList() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean existsOrder(String searchWord) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void modifyOrder(OrderDTO order) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeOrder(OrderDTO order) {
		// TODO Auto-generated method stub
		
	}

}
