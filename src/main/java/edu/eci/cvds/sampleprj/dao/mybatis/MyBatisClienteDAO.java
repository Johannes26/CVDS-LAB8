package edu.eci.cvds.sampleprj.dao.mybatis;

import java.util.Date;

import com.google.inject.Inject;

import edu.eci.cvds.sampleprj.dao.ClienteDAO;
import edu.eci.cvds.sampleprj.dao.PersistenceException;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.ClienteMapper;
import edu.eci.cvds.samples.entities.Cliente;


public class MyBatisClienteDAO implements ClienteDAO{

		  @Inject
		  private ClienteMapper ClienteMapper;    

		  @Override
		  public void save(int id,int idit,Date fechainicio,Date fechafin) throws PersistenceException{
		  try{
			  ClienteMapper.agregarItemRentadoACliente(id, idit, fechainicio, fechafin);
		  }
		  catch(org.apache.ibatis.exceptions.PersistenceException e){
		      throw new PersistenceException("Error al registrar el cliente "+ id , e);
		  }        
		  }

		  @Override
		  public Cliente load(int id) throws PersistenceException {
		  try{
		      return ClienteMapper.consultarCliente(id);
		  }
		  catch(org.apache.ibatis.exceptions.PersistenceException e){
		      throw new PersistenceException("Error al consultar el Cliente "+ id , e);
		  }

		  }
}
