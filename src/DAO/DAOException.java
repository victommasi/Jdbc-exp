package DAO;

@SuppressWarnings("serial")
public class DAOException extends RuntimeException {
	
	public DAOException(){}
	
	public DAOException(String message){
		super(message);
	}

}
