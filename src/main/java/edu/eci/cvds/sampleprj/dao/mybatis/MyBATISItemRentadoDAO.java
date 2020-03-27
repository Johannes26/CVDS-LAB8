package edu.eci.cvds.sampleprj.dao.mybatis;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import edu.eci.cvds.sampleprj.dao.ItemDAO;
import edu.eci.cvds.sampleprj.dao.ItemRentadoDAO;
import edu.eci.cvds.sampleprj.dao.PersistenceException;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.ClienteMapper;
import edu.eci.cvds.samples.entities.Item;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.ItemRentadoMapper;
import edu.eci.cvds.samples.entities.ItemRentado;
import edu.eci.cvds.samples.entities.TipoItem;
import java.sql.SQLException;
import java.util.List;

public class MyBATISItemRentadoDAO implements ItemRentadoDAO {

    @Inject
    private ItemRentadoMapper itemRentadoMapper;

    @Override
    public ItemRentado load(int id) throws PersistenceException {
    	try {
    		 return itemRentadoMapper.load(id);
    	}catch(org.apache.ibatis.exceptions.PersistenceException e){
    	      throw new PersistenceException("Error al cargar el item "+id,e);
    	  } 
       
    }

    @Override
    public List<ItemRentado> loadItems() throws PersistenceException {
    	try {
    		return itemRentadoMapper.getItemsRentados();
   	}catch(org.apache.ibatis.exceptions.PersistenceException e){
   	      throw new PersistenceException("Error al cargar los items");
   	  } 
    	
    }
}