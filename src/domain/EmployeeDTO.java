package domain;

import lombok.Data;

public @Data class EmployeeDTO {
	private String employeeId, manager, name, birthDate, photo, notes;

}
