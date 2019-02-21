package enums;

public enum ProductSQL {
	PRO_COUNT;
	@Override
	public String toString() {
		StringBuffer query = new StringBuffer();
		switch(this){
		case PRO_COUNT:
			query.append("SELECT COUNT(*) COUNT FROM PRODUCTS");
		break;
		}
		return query.toString();
	}
	
}
