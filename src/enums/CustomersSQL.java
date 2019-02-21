package enums;
// employeeId, manager, name, birthDate, photo, notes
public enum CustomersSQL {
	SIGNUP, SIGNIN, LIST, ROW_COUNT, PHONE, CUS_RETRIEVE, UPDATE, UPDATE_PROFILE_IMG, DELETE_CUST;
	
	@Override
	public String toString() {
		StringBuffer query=new StringBuffer();
		switch (this) {
		case SIGNUP:
			query.append("INSERT INTO CUSTOMERS(CUSTOMER_ID, PASSWORD, CUSTOMER_NAME, SSN, ADDRESS, CITY, POSTAL_CODE, PHOTO) \n"
					+ "VALUES(?, ?, ?, ?, ?, ?, ?,'1020')");
			break;
		case SIGNIN:
			query.append("SELECT * FROM CUSTOMERS "
					+ "WHERE CUSTOMER_ID LIKE ? AND PASSWORD LIKE ?");
			break;
		case LIST:
			query.append("SELECT T2.*\n" + 
                    "FROM(SELECT ROWNUM R2,T.*\n" + 
                    "        FROM (SELECT ROWNUM RNUM ,C.* \n" + 
                    "        FROM CUSTOMERS C  \n" + 
                    "        ORDER BY RNUM DESC) T) T2  \n" + 
                    "WHERE R2 BETWEEN ? AND ? \n");
			break;
		case ROW_COUNT:
			query.append("SELECT COUNT(*) COUNT FROM CUSTOMERS");
			break;
		case PHONE:
			query.append("SELECT CUSTOMER_ID, CUSTOMER_NAME, PHONE FROM CUSTOMERS");
			break;
		case CUS_RETRIEVE:
			query.append("SELECT * \n"
					+ "FROM CUSTOMERS \n"
					+ "WHERE CUSTOMER_ID LIKE ? \n");
			break;
		case UPDATE:
			query.append("UPDATE CUSTOMERS SET PHONE =?,  CITY =?, ADDRESS=?, POSTAL_CODE=?, PASSWORD=? WHERE CUSTOMER_ID = ?");
			break;
		case UPDATE_PROFILE_IMG:
			query.append("UPDATE CUSTOMERS SET PHOTO = ? WHERE CUSTOMER_ID LIKE ?");
			break;
		case DELETE_CUST:
			query.append("DELETE FROM CUSTOMERS WHERE CUSTOMER_ID = ?");
			break;
		default:
			break;
		}
		return query.toString();
	}
}
