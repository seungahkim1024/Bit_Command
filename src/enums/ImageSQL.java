package enums;

public enum ImageSQL {
	IMG_ADD, SELECT_ONE_IMG, IMG_LAST_SEQ;
@Override
public String toString() {
	StringBuffer query = new StringBuffer();
		switch(this){
		case IMG_ADD:
			query.append("INSERT INTO IMG(IMG_SEQ, IMG_NAME, IMGEXTENTION, OWNER) \n"
					+ "VALUES (IMG_SEQ.NEXTVAL, ?, ?, ?)");
			break;
		case SELECT_ONE_IMG:
			query.append("SELECT * FROM IMG WHERE IMG_SEQ LIKE ?");
			break;
		case IMG_LAST_SEQ:
			query.append("SELECT * \n" + 
					" FROM IMG \n" + 
					" WHERE IMG_SEQ LIKE ((SELECT MAX(IMG_SEQ) \n" + 
					"                    FROM IMG))");
			break;
		}
	return query.toString();
}
}
