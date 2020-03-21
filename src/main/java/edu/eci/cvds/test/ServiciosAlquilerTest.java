package edu.eci.cvds.test;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.google.inject.Inject;
import edu.eci.cvds.sampleprj.dao.PersistenceException;
import edu.eci.cvds.samples.entities.Cliente;
import edu.eci.cvds.samples.entities.Item;
import edu.eci.cvds.samples.entities.ItemRentado;
import edu.eci.cvds.samples.entities.TipoItem;
import edu.eci.cvds.samples.services.ExcepcionServiciosAlquiler;
import edu.eci.cvds.samples.services.ServiciosAlquiler;
import edu.eci.cvds.samples.services.ServiciosAlquilerFactory;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

public class ServiciosAlquilerTest {

    @Inject
    private SqlSession sqlSession;

    ServiciosAlquiler serviciosAlquiler;

    public ServiciosAlquilerTest() {
        serviciosAlquiler = ServiciosAlquilerFactory.getInstance().getServiciosAlquilerTesting();
    }

    @Before
    public void setUp() {
    }
    
    @Test
    public void deberiaRegistrarNuevosClientes(){
        try{
            Cliente cliente = new Cliente("johann", 2158145 ,"345534553", "Calle 4 no 36- 55 ", "johannbogota99@gmail.com");
            serviciosAlquiler.registrarCliente(cliente);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void deberiaConsultarClientes(){
        try{
        	Cliente cliente = new Cliente("johann", 2158145 ,"345534553", "Calle 4 no 36- 55 ", "johannbogota99@gmail.com");
            serviciosAlquiler.registrarCliente(cliente);
            Cliente consulta = serviciosAlquiler.consultarCliente((int)cliente.getDocumento());
            Assert.assertTrue(cliente.getDocumento() == consulta.getDocumento());
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void deberiaRegistrarAlquilerCliente(){
        try{
        	Cliente cliente = new Cliente("johann", 2158145 ,"345534553", "Calle 4 no 36- 55 ", "johannbogota99@gmail.com");
            TipoItem itti = new TipoItem(1,"accion");
            java.util.Date d = new java.util.Date();  
            java.sql.Date date2 = new java.sql.Date(d.getTime());
            Item it = new Item(itti, 1, "Item1", "Primer Item", date2, 20000, "", "Masculino");
            serviciosAlquiler.registrarAlquilerCliente(date2, cliente.getDocumento(), it, 8);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }


    @Test
    public void emptyDB() {
        for(int i = 0; i < 100; i += 10) {
            boolean r = false;
            try {
                Cliente cliente = serviciosAlquiler.consultarCliente(i);
            } catch(ExcepcionServiciosAlquiler e) {
                r = true;
            } catch(IndexOutOfBoundsException e) {
                r = true;
            }
            // Validate no Client was found;
            Assert.assertTrue(r);
        };
    }
}