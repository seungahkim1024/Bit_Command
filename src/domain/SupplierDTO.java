package domain;

import lombok.Data;

public @Data class SupplierDTO {
	private String supplierId, supplierName, contactName, address, city, postalCode, country, phone;

}
