package negocio;

import integracion.DAOClientes;
import integracion.FactoriaDAO;
import negocio.SAClientes;
import negocio.TransferCliente;

public class SAClientesImp implements SAClientes{
	
	public Float sumar(Float id1, Float id2)
	{
		float suma= -1;
		
		//El SA necesita los datos de los clientes con un determinado id
		//para ello crea un DAO que se va a encargar de buscarlo en la base de datos
		// y devolverlo en un transfer
		DAOClientes daoCliente= FactoriaDAO.getInstancia().nuevoDAOClientes();
		
		TransferCliente tE1= daoCliente.buscaCliente(id1);
	    TransferCliente tE2= daoCliente.buscaCliente(id2);
	    
		if ((tE2 != null)&&(tE1!=null))
				suma= tE1.getSalario() +tE2.getSalario();
				
		return suma;
	}

}
