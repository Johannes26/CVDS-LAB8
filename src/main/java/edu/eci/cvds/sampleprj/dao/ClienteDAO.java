package edu.eci.cvds.sampleprj.dao;

import java.util.Date;
import java.util.List;

import edu.eci.cvds.samples.entities.Cliente;


public interface ClienteDAO {
	
	   public void agregarItemRentadoACliente(long id,int idit,Date fechainicio,Date fechafin) throws PersistenceException;

	   public Cliente consultarCliente(long id) throws PersistenceException;
	   
	   public List<Cliente> consultarClientes() throws PersistenceException;
	   
	   public void registrarCliente(long docu, String nombre, String telefono, String direccion, String email, boolean vetado) throws PersistenceException;
  
}
