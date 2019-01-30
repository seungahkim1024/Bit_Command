package domain;

import lombok.Data;

public @Data class CustomerDTO {
	private String customer_id, contactName, address, city, postalCode, country;

	
}
