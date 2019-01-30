package dao;

import java.util.List;

import domain.OrderDTO;

public interface OrderDAO {

	public void insertOrder(OrderDTO order);
	public List<OrderDTO> selectAllOrderList();
	public List<OrderDTO> selectOrderListbySomeone(String searchWord);
	public OrderDTO selectOrderSeq(String searchWord);
	public int countOrderList();
	public boolean existsOrder(String searchWord);
	public void updateOrder(OrderDTO order);
	public void deleteOrder(OrderDTO order);
}
