package presentacion;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import negocio.ConsultarRecursosModel;

public class ConsultarRecursosView extends JPanel implements View {

	public Event btnDetallesPressed = new Event();
	public Event btnAveriaPressed = new Event();
	public Event btnMontajePressed = new Event();
	public Event btnRetirarPressed = new Event();
	
	private static final long serialVersionUID = 1L;
	private JButton btnDetalles;
	private JButton btnAveria;
	private JButton btnMontaje;
	private JButton btnRetirar;
	private JList<String> listaRecursos;
	private JScrollPane listaRecursosPane;
	private ConsultarRecursosModel consultarRecursosModel;

	public ConsultarRecursosView(ConsultarRecursosModel consultarRecursosModel) {
		
		this.consultarRecursosModel = consultarRecursosModel;
		
		btnDetalles = new JButton("detalles");
		btnAveria = new JButton("averia");
		btnMontaje = new JButton("montaje");
		btnRetirar = new JButton("retirar");
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		setBorder(BorderFactory.createTitledBorder("CONSULTAR TUS RECURSOS"));
		String[] objects = new String[] {
				"uno", 
				"dos", 
				"tres", 
				"cuatro",
				"cinco",
				"seis",
				"siete",
				"ocho"
				};
		listaRecursos = new JList<>(objects);
		listaRecursos.setVisibleRowCount(100);
		listaRecursos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listaRecursos.setLayoutOrientation(JList.VERTICAL);
		listaRecursosPane = new JScrollPane(listaRecursos);
		
		add(listaRecursosPane);
		JPanel panelBotones = new JPanel();
		panelBotones.setLayout(new BoxLayout(panelBotones, BoxLayout.X_AXIS));
		panelBotones.add(btnDetalles);
		panelBotones.add(btnAveria);
		panelBotones.add(btnMontaje);
		panelBotones.add(btnRetirar);
		
		add(panelBotones);
	}
	
	@Override
	public void updateView() {
		
	}

}
