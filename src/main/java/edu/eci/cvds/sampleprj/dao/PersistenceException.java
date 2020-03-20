package edu.eci.cvds.sampleprj.dao;

public class PersistenceException extends Exception{
	public PersistenceException(String msg) {
		super(msg);
	}

	public PersistenceException(String string, org.apache.ibatis.exceptions.PersistenceException e) {
		super(string+e.getMessage());
	}
}
