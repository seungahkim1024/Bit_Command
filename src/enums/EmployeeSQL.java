package enums;
// employeeId, manager, name, birthDate, photo, notes
public enum EmployeeSQL {
	REGISTER, ACCESS;
	
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
		default:
			break;
		}
		return query.toString();
	}
}
