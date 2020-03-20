package edu.eci.cvds.sampleprj.dao.mybatis.mappers;

import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.samples.entities.Cliente;

/**
 *
 * 
 */
public interface ClienteMapper {
    
    public Cliente consultarCliente(@Param("idcli") long id); 
    
    /**
     * Registrar un nuevo item rentado asociado al cliente identificado
     * con 'idc' y relacionado con el item identificado con 'idi'
     * @param id
     * @param idit
     * @param fechainicio
     * @param fechafin 
     */
    public void agregarItemRentadoACliente(@Param("idcli") long id, 
    		@Param("idit") int idit, 
    		@Param("fechainicio") Date fechainicio,
    		@Param("fechafin") Date fechafin);

    /**
     * Consultar todos los clientes
     * @return 
     */
    public List<Cliente> consultarClientes();
    
    /**
     * Registrar un nuevo cliente
     * @param doc
     * @param nombre
     * @param telefono
     * @param direccion
     * @param email
     * @param vetado
     */
    public void registrarCliente(@Param("documento") long documento,
    		@Param("nombre") String nombre ,
    		@Param("telefono") String telefono ,
    		@Param("direccion") String direccion ,
    		@Param("email")String email ,
    		@Param("vetado")boolean vetado );
    
}
