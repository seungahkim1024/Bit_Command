package service;

import java.util.List;

import domain.OrderDTO;

public interface OrderService {

	public void registOrder(OrderDTO order);
	public List<OrderDTO> bringAllOrderList();
	public List<OrderDTO> retrieveOrderListbySomeone(String searchWord);
	public OrderDTO retrieveOrderSeq(String searchWord);
	public int countOrderList();
	public boolean existsOrder(String searchWord);
	public void modifyOrder(OrderDTO order);
	public void removeOrder(OrderDTO order);
}
