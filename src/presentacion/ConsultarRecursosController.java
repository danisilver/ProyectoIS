package presentacion;

import negocio.ConsultarRecursosModel;

public class ConsultarRecursosController implements Controller {

	private ConsultarRecursosView view;
	private ConsultarRecursosModel model;

	public ConsultarRecursosController(ConsultarRecursosView view, ConsultarRecursosModel model) {
		this.view = view;
		this.model = model;
	}
	
	@Override
	public void run() {

	}

}
