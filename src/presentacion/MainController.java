package presentacion;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import integracion.Averia;
import integracion.RecursoAudioVisual;
import negocio.ComprarRecursosModel;
import negocio.ConsultarAveriasModel;
import negocio.ConsultarRecursosModel;
import negocio.MainModel;
import negocio.RegistrarAveriaModel;
import negocio.SAGestionRecursos;

public class MainController implements Controller {

	private MainView view;
	private MainModel model;
	private ConsultarRecursosModel consultarRecursosModel;
	private ConsultarRecursosView consultarRecursosView;
	private ConsultarRecursosController consultarRecursosController;
	private ComprarRecursosModel comprarRecursosModel;
	private ComprarRecursosView comprarRecursosView;
	private ComprarRecursosController comprarRecursosController;
	private SAGestionRecursos servicioSGRA;
	private RegistrarAveriaView registrarAveriaView;
	private RegistrarAveriaModel registrarAveriaModel;
	private registrarAveriaController registrarAveriaController;
	private ConsultarAveriasModel consultarAveriasModel;
	private ConsultarAveriasView consultarAveriasView;
	private ConsultarAveriasController consultarAveriasController;

	public MainController(MainView mainView, MainModel mainModel) {
		view = mainView;
		model = mainModel;

		servicioSGRA = new SAGestionRecursos();

		/* vista consultarRecursos */
		consultarRecursosModel = new ConsultarRecursosModel(servicioSGRA.getListaRecursos());
		consultarRecursosView = new ConsultarRecursosView(consultarRecursosModel);
		consultarRecursosController = new ConsultarRecursosController(consultarRecursosView, consultarRecursosModel);
		consultarRecursosController.run();

		/* vista comprar recursos */
		comprarRecursosModel = new ComprarRecursosModel(servicioSGRA.getListaRecursosVenta());
		comprarRecursosView = new ComprarRecursosView(comprarRecursosModel);
		comprarRecursosController = new ComprarRecursosController(comprarRecursosView, comprarRecursosModel);
		comprarRecursosController.run();

		/* vista registrar averia */
		registrarAveriaModel = new RegistrarAveriaModel();
		registrarAveriaView = new RegistrarAveriaView(registrarAveriaModel);
		registrarAveriaController = new registrarAveriaController(registrarAveriaView, registrarAveriaModel);
		registrarAveriaController.run();
		
		/* vista averias */
		consultarAveriasModel = new ConsultarAveriasModel(servicioSGRA.getListaAverias());
		consultarAveriasView = new ConsultarAveriasView(consultarAveriasModel);
		consultarAveriasController = new ConsultarAveriasController(consultarRecursosView, consultarAveriasModel);
		consultarAveriasController.run();
		
		view.addWindowListener(new WindowAdapter() {
			@Override public void windowClosed(WindowEvent e) {
				for(RecursoAudioVisual recurso : comprarRecursosModel.getListaRecursos()) {
					servicioSGRA.actualizarRecurso(recurso);
				}
				for(RecursoAudioVisual recurso : consultarRecursosModel.getListaRecursos()) {
					if(recurso.getId() == null) {
						servicioSGRA.comprarRecurso(recurso.getId());
					}
				}
				for (Averia averia : consultarAveriasModel.getArrAverias()) {
					if(averia.getIdAveria() == null) {
						servicioSGRA.informarAveria(averia);
					}
				}
				super.windowClosed(e);
				
			}
		});
		
		setupHandlers();
	}

	void setupHandlers() {
		view.btnVolverPressed.addObserver(() -> view.mostrarUI());
		view.btnConsultarPressed.addObserver(() -> view.showView(consultarRecursosView));
		view.btnComprarPressed.addObserver(() -> view.showView(comprarRecursosView));
		view.btnVolverPressed.addObserver(() -> model.setTitulo("Pagina principal del subsistema"));
		view.btnConsultarPressed.addObserver(() -> model.setTitulo("pagina de consulta de recursos audiovisuales"));
		view.btnComprarPressed.addObserver(() -> model.setTitulo("pagina de compra de recursos audiovisuales"));
		view.btnAveriasPressed.addObserver(() -> view.showView(consultarAveriasView));
		view.btnAveriasPressed.addObserver(() -> model.setTitulo("pagina de consulta de averias"));
		
		comprarRecursosView.btnComprarPressed.addObserver(() -> comprarRecurso());
		consultarRecursosView.btnAveriaPressed.addObserver(() -> consultarRecursos());
		registrarAveriaView.btnRegistarPressed.addObserver(() -> crearAveria());
		view.btnCambiarPressed.addObserver(() -> model.setTitulo(view.getTextTitle()));
		model.changeTitleEvent.addObserver(() -> view.updateView());
	}

	private void crearAveria() {
		registrarAveriaController.updateModel();
		if (registrarAveriaModel.isValid()) 
			consultarAveriasModel.addAveria(registrarAveriaModel.toAveria());
		else
			registrarAveriaController.mostrarMensajeError();
	}

	private void consultarRecursos() {
		int index = consultarRecursosView.getSelectedItemIndex();
		RecursoAudioVisual recurso = consultarRecursosModel.getListaRecursos().get(index);
		registrarAveriaModel.setIdRecurso(recurso.getId());
		view.showView(registrarAveriaView);
	}

	private void comprarRecurso() {
		int index = comprarRecursosView.getSelectedItemIndex();
		RecursoAudioVisual recurso = comprarRecursosModel.getListaRecursos().get(index);
		if (recurso.getUnidades() > 0) {
			servicioSGRA.comprarRecurso(recurso.getId());
			recurso.setUnidades(recurso.getUnidades() - 1);
			comprarRecursosView.updateView();
			comprarRecursosView.mostrarMensajeCompra();
			consultarRecursosModel.addRecurso(recurso);
		} else {
			comprarRecursosView.mostrarMensajeAgotado();
		}
	}

	@Override
	public void run() {
		view.mostrarUI();
	}

}
