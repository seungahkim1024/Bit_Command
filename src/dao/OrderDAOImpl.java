package dao;

import java.util.List;

import domain.OrderDTO;

public class OrderDAOImpl implements OrderDAO{

	private static OrderDAOImpl instance = new OrderDAOImpl();
	private OrderDAOImpl(){} 
	public static OrderDAOImpl getInstance() {
		return instance;
	}
	OrderDAOImpl order;
	
	@Override
	public void insertOrder(OrderDTO order) {
		
	}

	@Override
	public List<OrderDTO> selectAllOrderList() {
		
		return order.selectAllOrderList();
	}

	@Override
	public List<OrderDTO> selectOrderListbySomeone(String searchWord) {
		
		return order.selectOrderListbySomeone(searchWord);
	}

	@Override
	public OrderDTO selectOrderSeq(String searchWord) {
		
		return order.selectOrderSeq(searchWord);
	}

	@Override
	public int countOrderList() {
		
		return order.countOrderList();
	}

	@Override
	public boolean existsOrder(String searchWord) {
		
		return order.existsOrder(searchWord);
	}

	@Override
	public void updateOrder(OrderDTO order) {
		
	}

	@Override
	public void deleteOrder(OrderDTO order) {
		
	}

}
