package negocio;

import java.util.ArrayList;

import integracion.Compra;
import integracion.DaoRecurso;
import integracion.FactoriaDAO;
import integracion.RecursoAudioVisual;
import integracion.TipoFactoria;

public class SAGestionRecursos implements ServicioDeAplicacion{
	
	public FactoriaDAO daoFactory;
	public DaoRecurso daoRecursoAudiovisual;

	public SAGestionRecursos() {
		daoFactory = FactoriaDAO.crearFactoria(TipoFactoria.H2DBFactory);
		daoRecursoAudiovisual = daoFactory.getDaoRecurso();
	}
	
	public ArrayList<RecursoAudioVisual> getListaRecursos() {
		return daoRecursoAudiovisual.getRecursosAudiovisuales();
	}
	
	public ArrayList<RecursoAudioVisual> getListaRecursosVenta() {
		return null;
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
