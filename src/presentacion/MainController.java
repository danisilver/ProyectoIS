package presentacion;

import negocio.MainModel;

public class MainController implements Controller{
	
	private MainView view;
	private MainModel model;

	public MainController(MainView mainView, MainModel mainModel) {
		view = mainView;
		model = mainModel;
		setup();
	}
	
	void setup() {
		view.btnCambiarPressed.addObserver(new Observer() {
			@Override public void update() {
				updateTitleText(view.getTextTitle());
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
