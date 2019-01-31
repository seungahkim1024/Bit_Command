package enums;
// employeeId, manager, name, birthDate, photo, notes
public enum EmployeeSQL {
	REGISTER;
	
	@Override
	public String toString() {
		String query="";
		switch (this) {
		case REGISTER:
			query = "INSERT INTO EMPLOYEES(EMPLOYEE_ID, MANAGER, "
					+ "NAME, BIRTH_DATE, PHOTO, NOTES) VALUES(" //-> DB의 컬럼명과 똑같이 입력!
					+ " EMP_SEQ.NEXTVAL, ?, ?, ?, ?, ?)";
			break;

		default:
			break;
		}
		return query;
	}
}
