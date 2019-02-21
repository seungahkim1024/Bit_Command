package domain;

import lombok.Data;

public @Data class ProductDTO {
	private String productId, productName, supplierId, unit, price, categoryId;

}
