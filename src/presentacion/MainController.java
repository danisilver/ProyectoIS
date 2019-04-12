package presentacion;

import negocio.ComprarRecursosModel;
import negocio.ConsultarRecursosModel;
import negocio.MainModel;

public class MainController implements Controller{
	
	private MainView view;
	private MainModel model;
	private ConsultarRecursosModel consultarRecursosModel;
	private ConsultarRecursosView consultarRecursosView;
	private ConsultarRecursosController consultarRecursosController;
	private ComprarRecursosModel comprarRecursosModel;
	private ComprarRecursosView comprarRecursosView;
	private ComprarRecursosController comprarRecursosController;

	public MainController(MainView mainView, MainModel mainModel) {
		view = mainView;
		model = mainModel;
		
		/* vista consultarRecursos */
		consultarRecursosModel = new ConsultarRecursosModel();
		consultarRecursosView = new ConsultarRecursosView(consultarRecursosModel);
		consultarRecursosController = new ConsultarRecursosController(consultarRecursosView, consultarRecursosModel);
		consultarRecursosController.run();
		
		/* vista comprar recursos */
		comprarRecursosModel = new ComprarRecursosModel();
		comprarRecursosView = new ComprarRecursosView(comprarRecursosModel);
		comprarRecursosController = new ComprarRecursosController(comprarRecursosView, comprarRecursosModel);
		comprarRecursosController.run();
		
		setup();
	}
	
	void setup() {
		view.btnCambiarPressed.addObserver(new Observer() {
			@Override public void update() {
				updateTitleText(view.getTextTitle());
			}
		});
		view.btnConsultarPressed.addObserver(new Observer() {
			@Override public void update() {
				view.showView(consultarRecursosView);
				updateTitleText("pagina de consulta de recursos audiovisuales");
			}
		});
		view.btnComprarPressed.addObserver(new Observer() {
			@Override public void update() {
				view.showView(comprarRecursosView);
				updateTitleText("pagina de compra de recursos audiovisuales");
			}
		});
		view.btnVolverPressed.addObserver(new Observer() {
			@Override public void update() {
				updateTitleText("Pagina principal del subsistema");
				view.mostrarUI();
			}
		});
		model.changeTitleEvent.addObserver(new Observer() {
			@Override public void update() {
				view.updateView();
			}
		});
	}
	
	void updateTitleText(String title){
		model.setTitulo(title);
	}

	@Override
	public void run() {
		view.mostrarUI();
	}
	
}
