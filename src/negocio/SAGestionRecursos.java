package negocio;

import integracion.Compra;
import integracion.DaoRecurso;
import integracion.RecursoAudioVisual;
import integracion.TipoFactoria;
import presentacion.MainController;
import integracion.FactoriaDAO;

public class SAGestionRecursos implements ServicioDeAplicacion{
	
	FactoriaDAO daoFactory = FactoriaDAO.crearFactoria(TipoFactoria.H2DBFactory);
	
	private DaoRecurso daoRecursoAudiovisual = daoFactory.getDaoRecurso();

	public SAGestionRecursos(MainController controlador) {
		
	}
	
	public void comprarRecurso(int idRecurso) {
		//TODO: implementar
		throw new UnsupportedOperationException();
	}
	
	public RecursoAudioVisual consultarRecursoAudiovisual(int idRecurso){
		return daoRecursoAudiovisual.getRecursoById(idRecurso);
	}
	
	public Compra[] consultarCompras() {
		//TODO: implementar
		throw new UnsupportedOperationException();
	}
	
	public void informarAveria(int idRecurso) {
		//TODO: implementar
		throw new UnsupportedOperationException();
	}
	
	public void solicitarMontaje(int idRecurso) {
		//TODO: implementar
		throw new UnsupportedOperationException();
	}
	
	public void asignarRecurso(int idRecurso) {
		//TODO: implementar
		throw new UnsupportedOperationException();
	}
}
