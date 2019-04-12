package presentacion;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import negocio.ComprarRecursosModel;

public class ComprarRecursosView extends JPanel implements View {

	private ComprarRecursosModel model;

	public ComprarRecursosView(ComprarRecursosModel model) {
		this.model = model;
		
		setBorder(BorderFactory.createTitledBorder("COMPRAR RECURSOS"));
		
	}
	
	@Override
	public void updateView() {

	}

}
