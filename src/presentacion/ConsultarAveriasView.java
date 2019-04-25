package presentacion;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import negocio.ConsultarAveriasModel;

public class ConsultarAveriasView extends JPanel implements View {

	private ConsultarAveriasModel model;
	private JTable jtAverias;

	public ConsultarAveriasView(ConsultarAveriasModel model) {
		this.model = model;
		setBorder(BorderFactory.createTitledBorder("CONSULTAR AVERIAS"));
		setLayout(new BorderLayout());
		
		jtAverias = new JTable(model);
		jtAverias.setFillsViewportHeight(true);
		add(new JScrollPane(jtAverias));
	}
	
	@Override
	public void updateView() {

	}

}
