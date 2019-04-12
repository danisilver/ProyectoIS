package presentacion;

import negocio.ComprarRecursosModel;

public class ComprarRecursosController implements Controller {

	private ComprarRecursosView comprarRecursosView;
	private ComprarRecursosModel comprarRecursosModel;

	public ComprarRecursosController(ComprarRecursosView comprarRecursosView,
			ComprarRecursosModel comprarRecursosModel) {
				this.comprarRecursosView = comprarRecursosView;
				this.comprarRecursosModel = comprarRecursosModel;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

}
