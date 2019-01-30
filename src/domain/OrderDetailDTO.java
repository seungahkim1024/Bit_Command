package domain;

import lombok.Data;

public @Data class OrderDetailDTO {
	private String orderDetailId, orderId, productId, quantity;

	
}
