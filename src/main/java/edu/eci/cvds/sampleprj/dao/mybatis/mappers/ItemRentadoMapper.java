package edu.eci.cvds.sampleprj.dao.mybatis.mappers;

import edu.eci.cvds.samples.entities.ItemRentado;
import edu.eci.cvds.samples.entities.TipoItem;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface ItemRentadoMapper {

    public List<ItemRentado> getItemsRentados();

    public ItemRentado load(@Param("idr")int id);

    public void addItemRentado(int cliid, int itemid, Date fechaini, Date fechafin);
}
