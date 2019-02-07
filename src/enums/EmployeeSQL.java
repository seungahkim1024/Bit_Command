package enums;
// employeeId, manager, name, birthDate, photo, notes
public enum EmployeeSQL {
	REGISTER, ACCESS, SIGNUP, SIGNIN;
	
	@Override
	public String toString() {
		StringBuffer query=new StringBuffer();
		switch (this) {
		case REGISTER:
			query.append("INSERT INTO EMPLOYEES(EMPLOYEE_ID, MANAGER, "
					+ "NAME, BIRTH_DATE, PHOTO, NOTES) VALUES(" //-> DB의 컬럼명과 똑같이 입력!
					+ " EMP_SEQ.NEXTVAL, ?, ?, ?, ?, ?)");
			break;
		case ACCESS:
			query.append("SELECT NAME FROM EMPLOYEES "
					+ "WHERE EMPLOYEE_ID LIKE ? AND NAME LIKE ?");
			break;
		case SIGNUP:
			/*query.append("INSERT INTO CUSTOMERS(CUSTOMER_ID, CUSTOMER_NAME, ADDRESS, CITY, POSTAL_CODE, SSN, PASSWORD) VALUES(?, ?, ?, ?, ?, ?, ?)");*/
			query.append("INSERT INTO CUSTOMERS(CUSTOMER_ID, CUSTOMER_NAME, ADDRESS, CITY, POSTAL_CODE, SSN, PASSWORD) VALUES(?, ?, ?, ?, ?, ?, ?)");
		case SIGNIN:
			query.append("SELECT CUSTOMER_NAME FROM CUSTOMERS"
					+ "WHERE CUSTOMER_ID LIKE ? AND CUSTOMER_NAME LIKE ?");
		default:
			break;
		}
		return query.toString();
	}
}
