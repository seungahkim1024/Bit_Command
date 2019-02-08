package enums;
// employeeId, manager, name, birthDate, photo, notes
public enum CustomersSQL {
	SIGNUP, SIGNIN;
	
	@Override
	public String toString() {
		StringBuffer query=new StringBuffer();
		switch (this) {
		case SIGNUP:
			query.append("INSERT INTO CUSTOMERS(CUSTOMER_ID, PASSWORD, CUSTOMER_NAME, SSN, ADDRESS, CITY, POSTAL_CODE) VALUES(?, ?, ?, ?, ?, ?, ?)");
			break;
		case SIGNIN:
			query.append("SELECT CUSTOMER_ID, PASSWORD FROM CUSTOMERS "
					+ "WHERE CUSTOMER_ID LIKE ? AND PASSWORD LIKE ?");
			break;

		default:
			break;
		}
		return query.toString();
	}
}
