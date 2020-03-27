package edu.eci.cvds.samples.services.impl;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import edu.eci.cvds.sampleprj.dao.ClienteDAO;
import edu.eci.cvds.sampleprj.dao.ItemDAO;
import edu.eci.cvds.sampleprj.dao.ItemRentadoDAO;
import edu.eci.cvds.sampleprj.dao.PersistenceException;

import edu.eci.cvds.samples.entities.Cliente;
import edu.eci.cvds.samples.entities.Item;
import edu.eci.cvds.samples.entities.ItemRentado;
import edu.eci.cvds.samples.entities.TipoItem;
import edu.eci.cvds.samples.services.ExcepcionServiciosAlquiler;
import edu.eci.cvds.samples.services.ServiciosAlquiler;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;

@Singleton
public class ServiciosAlquilerImpl implements ServiciosAlquiler {

   @Inject
   private ItemDAO itemDAO;
   
   @Inject
   private ClienteDAO clienteDAO;
   
   @Inject
   private ItemRentadoDAO itemRentadoDAO;

   @Override
   public int valorMultaRetrasoxDia(int itemId) {
       throw new UnsupportedOperationException("Not supported yet.");
   }

   @Override
   public Cliente consultarCliente(int docu) throws ExcepcionServiciosAlquiler {
	   try {
		   return clienteDAO.consultarCliente(docu);
	   } catch (PersistenceException ex) {
           throw new ExcepcionServiciosAlquiler("Error al consultar el cliente "+docu,ex);
       }
   }

   
   public List<ItemRentado> consultarItemsCliente(long idcliente) throws ExcepcionServiciosAlquiler {
	   throw new UnsupportedOperationException("Not supported yet.");
   }
   
   
   public List<ItemRentado> consultarItemR() throws ExcepcionServiciosAlquiler {
	   try {
	   return itemRentadoDAO.loadItems();
	   }catch(PersistenceException ex) {
		   throw new UnsupportedOperationException("Not supported yet.");
	   }
   }

   @Override
   public List<Cliente> consultarClientes() throws ExcepcionServiciosAlquiler {
	   try {
		   return clienteDAO.consultarClientes();
	   }catch (PersistenceException ex) {
       throw new UnsupportedOperationException("Not supported yet.");
	   }
   }

   
   @Override
   public Item consultarItem(int id) throws ExcepcionServiciosAlquiler {
       try {
           return itemDAO.consultarItem(id);
       } catch (PersistenceException ex) {
           throw new ExcepcionServiciosAlquiler("Error al consultar el item "+id,ex);
       }
   }

   @Override
   public List<Item> consultarItemsDisponibles() {
       throw new UnsupportedOperationException("Not supported yet.");
   }

   @Override
   public long consultarMultaAlquiler(int iditem, Date fechaDevolucion) throws ExcepcionServiciosAlquiler {
	   try{
           ItemRentado itemren = itemRentadoDAO.load(iditem);
           Item item = itemDAO.consultarItem(iditem);
           long multa = item.getTarifaxDia();
           Date fechafinrenta = itemren.getFechafinrenta();
           int dias=(int) ((fechaDevolucion.getTime()-fechafinrenta.getTime())/86400000);
           return dias * multa;
       } catch (PersistenceException ex) {
    	   throw new ExcepcionServiciosAlquiler("Error al consultar items disponibles",ex);
       }
   }

   @Override
   public TipoItem consultarTipoItem(int id) throws ExcepcionServiciosAlquiler {
       throw new UnsupportedOperationException("Not supported yet.");
   }

   @Override
   public List<TipoItem> consultarTiposItem() throws ExcepcionServiciosAlquiler {
       throw new UnsupportedOperationException("Not supported yet.");
   }

   @Override
   public void registrarAlquilerCliente(Date date, long docu, Item item, int numdias) throws ExcepcionServiciosAlquiler {
	   try {
		   //sumar dias
		   Calendar calendar = Calendar.getInstance();
		   calendar.setTime(date);
		   calendar.add(Calendar.DAY_OF_YEAR, numdias);
		   clienteDAO.agregarItemRentadoACliente(docu,item.getId(),date,calendar.getTime());
	   	} catch (PersistenceException ex) {
	   throw new UnsupportedOperationException("Not supported yet.");
	   }
   }

   @Override
   public void registrarCliente(Cliente c) throws ExcepcionServiciosAlquiler {
	   try {
		   clienteDAO.registrarCliente(c.getDocumento(), c.getNombre(), c.getTelefono(), c.getDireccion(), c.getEmail(), c.isVetado());
	   }catch(PersistenceException ex){
		   throw new ExcepcionServiciosAlquiler("Error al registrar cliente",ex);
	   }
   }

   @Override
   public long consultarCostoAlquiler(int iditem, int numdias) throws ExcepcionServiciosAlquiler {
       throw new UnsupportedOperationException("Not supported yet.");
   }

   @Override
   public void actualizarTarifaItem(int id, long tarifa) throws ExcepcionServiciosAlquiler {
       throw new UnsupportedOperationException("Not supported yet.");
   }
   @Override
   public void registrarItem(Item i) throws ExcepcionServiciosAlquiler {
	   try {
		   itemDAO.save(i);
	   } catch (PersistenceException ex) {
		   throw new ExcepcionServiciosAlquiler("Error al consultar el item "+i.getId(),ex);
	   }
   }

   @Override
   public void vetarCliente(long docu, boolean estado) throws ExcepcionServiciosAlquiler {
       throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   }
}