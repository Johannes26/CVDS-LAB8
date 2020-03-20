package edu.eci.cvds.samples.services;

import edu.eci.cvds.sampleprj.dao.PersistenceException;

public class ExcepcionServiciosAlquiler extends Exception {
	
	public ExcepcionServiciosAlquiler (String msg) {
		super(msg);
	}

	public ExcepcionServiciosAlquiler(String string, PersistenceException ex) {
		super(string+ex.getMessage());
	}

}
