package presentacion;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

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
	private JTable tablaRecursos;
	private JScrollPane scrollpaneRecursos;
	private ConsultarRecursosModel consultarRecursosModel;
	private JScrollPane scrollPaneDescripcion;
	private JTextArea taDescripcion;
	private boolean detallesEnabled;

	public ConsultarRecursosView(ConsultarRecursosModel consultarRecursosModel) {
		
		this.consultarRecursosModel = consultarRecursosModel;
		
		btnDetalles = new JButton("detalles");
		btnAveria = new JButton("averia");
		btnMontaje = new JButton("montaje");
		btnRetirar = new JButton("retirar");
		
		setLayout(new BorderLayout());
		
		setBorder(BorderFactory.createTitledBorder("CONSULTAR TUS RECURSOS"));
		
		tablaRecursos = new JTable(consultarRecursosModel);
		scrollpaneRecursos = new JScrollPane(tablaRecursos);
		tablaRecursos.setFillsViewportHeight(true);
		
		taDescripcion = new JTextArea();
		taDescripcion.setWrapStyleWord(true);
		taDescripcion.setEditable(false);
		taDescripcion.setFont(getFont());
		taDescripcion.setLineWrap(true);
		taDescripcion.setBackground(getBackground());
		scrollPaneDescripcion = new JScrollPane(taDescripcion);
		scrollPaneDescripcion.setBorder(BorderFactory.createTitledBorder("descripcion"));
		scrollPaneDescripcion.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPaneDescripcion.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		add(scrollpaneRecursos,BorderLayout.CENTER);
		
		JPanel panelBotones = new JPanel();
		panelBotones.setLayout(new BoxLayout(panelBotones, BoxLayout.X_AXIS));
		panelBotones.add(btnDetalles);
		panelBotones.add(btnAveria);
		panelBotones.add(btnMontaje);
		panelBotones.add(btnRetirar);
		personalizarBotonesOperaciones();
		
		add(panelBotones, BorderLayout.SOUTH);
		
		btnDetalles.addActionListener(e -> btnDetallesPressed.notifyAllObservers());
		btnAveria.addActionListener(e -> btnAveriaPressed.notifyAllObservers());
		btnMontaje.addActionListener(e -> btnMontajePressed.notifyAllObservers());
		btnRetirar.addActionListener(e -> btnRetirarPressed.notifyAllObservers());
	}
	
	@Override
	public void updateView() {
		
	}
	
	private void personalizarBotonesOperaciones() {
		/* expandir automaticamente horizontalmente */
		btnDetalles.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
		btnAveria.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
		btnMontaje.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
		btnRetirar.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
		btnAveria.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
		/* para que salgan centrados en el eje x hay que ponerles un alto minimo */
		btnDetalles.setMinimumSize(new Dimension(0, 20));
		btnAveria.setMinimumSize(new Dimension(0, 20));
		btnMontaje.setMinimumSize(new Dimension(0, 20));
		btnRetirar.setMinimumSize(new Dimension(0, 20));
		btnAveria.setMinimumSize(new Dimension(0, 20));
		/* para que se repartan igual espacio horizontal */
		btnDetalles.setPreferredSize(new Dimension(10,40));
		btnAveria.setPreferredSize(new Dimension(10,40));
		btnMontaje.setPreferredSize(new Dimension(10,40));
		btnRetirar.setPreferredSize(new Dimension(10,40));
		btnAveria.setPreferredSize(new Dimension(10,40));
	}

	public void mostrarDetalles() {
		if(tablaRecursos.getSelectedRow() < 0) return;
		setDetallesEnabled(true);
		remove(scrollpaneRecursos);
		add(scrollPaneDescripcion);
		taDescripcion.setText("");
		taDescripcion.setText(consultarRecursosModel.getListaRecursos().get(getSelectedItemIndex()).getDescripcion());
		btnDetalles.setText("ocultar detalles");
		revalidate();
		repaint();
	}
	
	public void ocultarDetalles() {
		setDetallesEnabled(false);
		remove(scrollPaneDescripcion);
		add(scrollpaneRecursos);
		btnDetalles.setText("detalles");
		revalidate();
		repaint();
	}

	public boolean isDetallesEnabled() {
		return detallesEnabled;
	}

	public void setDetallesEnabled(boolean detallesEnabled) {
		this.detallesEnabled = detallesEnabled;
	}

	public void mostrarAsistenteAveria() {
		// TODO Auto-generated method stub
	}

	public void mostraAsistenteMontaje() {
		// TODO Auto-generated method stub
	}

	public int getSelectedItemIndex() {
		return tablaRecursos.getSelectedRow();
	}
	
}

/*
 * con jlist listaRecursos = new
 * JList<RecursoAudioVisual>(consultarRecursosModel);
 * listaRecursos.setVisibleRowCount(100);
 * listaRecursos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
 * listaRecursos.setLayoutOrientation(JList.VERTICAL);
 * listaRecursos.setCellRenderer(new CellRecurso()); listaRecursosPane = new
 * JScrollPane(listaRecursos);
 */