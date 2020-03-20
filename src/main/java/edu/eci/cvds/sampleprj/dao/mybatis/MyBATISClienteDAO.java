package edu.eci.cvds.sampleprj.dao.mybatis;

import java.util.Date;
import java.util.List;

import com.google.inject.Inject;

import edu.eci.cvds.sampleprj.dao.ClienteDAO;
import edu.eci.cvds.sampleprj.dao.PersistenceException;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.ClienteMapper;
import edu.eci.cvds.samples.entities.Cliente;


public class MyBATISClienteDAO implements ClienteDAO{

		  @Inject
		  private ClienteMapper ClienteMapper;    

		  @Override
		  public void agregarItemRentadoACliente(long id,int idit,Date fechainicio,Date fechafin) throws PersistenceException{
		  try{
			  ClienteMapper.agregarItemRentadoACliente(id, idit, fechainicio, fechafin);
		  }
		  catch(org.apache.ibatis.exceptions.PersistenceException e){
		      throw new PersistenceException("Error al registrar el cliente "+ id , e);
		  }        
		  }

		  @Override
		  public Cliente consultarCliente(long id) throws PersistenceException {
		  try{
		      return ClienteMapper.consultarCliente(id);
		  }
		  catch(org.apache.ibatis.exceptions.PersistenceException e){
		      throw new PersistenceException("Error al consultar el Cliente "+ id , e);
		  }
		  }
		  
		  @Override
		  public List<Cliente> consultarClientes() throws PersistenceException {
		  try{
		      return ClienteMapper.consultarClientes();
		  }
		  catch(org.apache.ibatis.exceptions.PersistenceException e){
		      throw new PersistenceException("Error al consultar el Clientes " , e);
		  }
		  }
		  
		  @Override
		  public void registrarCliente(long docu, String nombre, String telefono, String direccion, String email, boolean vetado) throws PersistenceException {
		  try{
		       ClienteMapper.registrarCliente(docu, nombre, telefono, direccion, email, vetado);
		  }
		  catch(org.apache.ibatis.exceptions.PersistenceException e){
		      throw new PersistenceException("Error al consultar el Clientes " , e);
		  }
		  }
		  
}
