package integracion;

import java.util.List;

import com.j256.ormlite.dao.Dao;

public interface DaoCompra extends Dao<Compra,Integer>{
	
	public List<Compra> getCompras();
	
}
