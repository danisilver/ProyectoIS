package presentacion;

import negocio.ConsultarRecursosModel;

public class ConsultarRecursosController implements Controller {

	private ConsultarRecursosView view;
	private ConsultarRecursosModel model;

	public ConsultarRecursosController(ConsultarRecursosView view, ConsultarRecursosModel model) {
		this.view = view;
		this.model = model;
		
		setupHandlers();
	}
	
	private void setupHandlers() {
		view.btnDetallesPressed.addObserver(new Observer() {
			@Override public void update() {
				if(view.isDetallesEnabled()) {
					view.ocultarDetalles();
				} else {
					view.mostrarDetalles();
				}
			}
		});
		view.btnAveriaPressed.addObserver(new Observer() {
			@Override public void update() {
				view.mostrarAsistenteAveria();
			}
		});
		view.btnMontajePressed.addObserver(new Observer() {
			@Override public void update() {
				view.mostraAsistenteMontaje();
			}
		});
		view.btnRetirarPressed.addObserver(new Observer() {
			@Override public void update() {
				model.remove(view.getSelectedItemIndex());
			}
		});
		model.onItemRemoved.addObserver(new Observer() {
			@Override public void update() {
				view.updateView();
			}
		});
	}

	@Override
	public void run() {

	}

}
