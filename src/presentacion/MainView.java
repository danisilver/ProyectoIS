package presentacion;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import negocio.MainModel;

public class MainView extends JFrame implements View {
	
	private static final long serialVersionUID = 1L;
	
	JTextField tfTitle;
	JButton btnCambiar;
	
	public Event btnCambiarPressed = new Event();
	public Event btnConsultarPressed = new Event();
	public Event btnComprarPressed = new Event();
	public Event btnVolverPressed = new Event();
	
	
	private MainModel model;
	private JButton btnComprar;
	private JButton btnConsultar;
	private JButton btnAsignar;
	private JButton btnSolicitar;
	private JButton btnAveria;

	private JPanel mainPanel;

	private JButton btnVolverPrincipal;
	
	public MainView(MainModel mainModel){
		this.model = mainModel;
		
		setupMainPanelComponents();
		
		/* configuracion general de ventana */
		setTitle("pagina principal del subsistema");
		setPreferredSize(new Dimension(700,400));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		
		/* configuracion de vista para no congestionar el constructor */
		setup();
		
		setVisible(true);
	}
	
	void setupMainPanelComponents(){
		JPanel mainViewOperationsPanel = new JPanel();
		mainViewOperationsPanel.setLayout(new BoxLayout(mainViewOperationsPanel, BoxLayout.X_AXIS));
		mainViewOperationsPanel.setBorder(BorderFactory.createTitledBorder("Operaciones de vista"));
		
		btnComprar = new JButton("comprar recurso");
		btnConsultar = new JButton("consultar recurso");
		btnAsignar = new JButton("asignar a proyecto");
		btnSolicitar = new JButton("solicitar recurso");
		btnAveria = new JButton("nueva averia");
		btnVolverPrincipal = new JButton("volver");
		personalizarBotonesOperaciones();
		
		mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		
		mainViewOperationsPanel.add(btnComprar); 
		mainViewOperationsPanel.add(btnConsultar);
		mainViewOperationsPanel.add(btnAsignar); 
		mainViewOperationsPanel.add(btnSolicitar); 
		mainViewOperationsPanel.add(btnAveria);
		
		/* panel de customizacion y interno */
		JPanel customizationPanel = new JPanel();
		customizationPanel.setBorder(BorderFactory.createTitledBorder("Operaciones de personalizacion"));
		btnCambiar = new JButton("cambiar titulo");
		tfTitle = new JTextField(10);
		customizationPanel.add(btnCambiar);
		customizationPanel.add(tfTitle);
		
		mainViewOperationsPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));
		mainPanel.add(mainViewOperationsPanel);
		mainPanel.add(customizationPanel);
		
		mainPanel.setBorder(BorderFactory.createTitledBorder("SUBSISTEMA DE GESTION DE REC AUDIOVISUALES"));
		
		add(mainPanel);
	}

	private void personalizarBotonesOperaciones() {
		/* expandir automaticamente horizontalmente */
		btnComprar.setMaximumSize(new Dimension(Integer.MAX_VALUE, 100));
		btnConsultar.setMaximumSize(new Dimension(Integer.MAX_VALUE, 100));
		btnAsignar.setMaximumSize(new Dimension(Integer.MAX_VALUE, 100));
		btnSolicitar.setMaximumSize(new Dimension(Integer.MAX_VALUE, 100));
		btnAveria.setMaximumSize(new Dimension(Integer.MAX_VALUE, 100));
		/* para que salgan centrados en el eje x hay que ponerles un alto minimo */
		btnComprar.setMinimumSize(new Dimension(0, 100));
		btnConsultar.setMinimumSize(new Dimension(0, 100));
		btnAsignar.setMinimumSize(new Dimension(0, 100));
		btnSolicitar.setMinimumSize(new Dimension(0, 100));
		btnAveria.setMinimumSize(new Dimension(0, 100));
		/* para que se repartan igual espacio horizontal */
		btnComprar.setPreferredSize(new Dimension(10,100));
		btnConsultar.setPreferredSize(new Dimension(10,100));
		btnAsignar.setPreferredSize(new Dimension(10,100));
		btnSolicitar.setPreferredSize(new Dimension(10,100));
		btnAveria.setPreferredSize(new Dimension(10,100));
	}

	private void setup() {
		//adaptador de ActionListener a Event
		btnCambiar.addActionListener(e -> btnCambiarPressed.notifyAllObservers());		
		btnConsultar.addActionListener(e -> btnConsultarPressed.notifyAllObservers());
		btnComprar.addActionListener(e -> btnComprarPressed.notifyAllObservers());
		btnVolverPrincipal.addActionListener(e -> btnVolverPressed.notifyAllObservers());
	}

	@Override
	public void updateView() {
		setTitle(model.getTitle());		
	}

	public String getTextTitle() {
		return tfTitle.getText();		
	}
	
	public void mostrarUI() {
		getContentPane().removeAll();
		add(mainPanel);
		revalidate();
		repaint();
	}
	
	public void ocultarUI() {
		getContentPane().removeAll();
		revalidate();
		repaint();
	}

	public void showView(View view) {
		getContentPane().removeAll();
		add((JComponent)view);
		JPanel tmpPanel = new JPanel();
		tmpPanel.setLayout(new BoxLayout(tmpPanel, BoxLayout.Y_AXIS));
		tmpPanel.add(btnVolverPrincipal);
		btnVolverPrincipal.setAlignmentX(1.0f);
		add(tmpPanel, BorderLayout.SOUTH);
		revalidate();
		repaint();
	}
	
}

/*
 * para expandir el boton en boxlayout
 * btnComprar.setMaximumSize(getContentPane().getMaximumSize());
 */

/* para evitar que el jtextfield se expanda cuando se expande la ventana */
/* tfTitle.setMaximumSize(tfTitle.getPreferredSize()); */

/*
 * para poner borde
 * titulo.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
 */


/* para ajustar los paneles principales */
/*
 * mainViewOperationsPanel.setPreferredSize(new Dimension(100,80));
 * customizationPanel.setPreferredSize(new Dimension(100, 20));
 */

/* texto de creditos */
/*
 * JPanel vbox = new JPanel(); vbox.add(btnCambiar); vbox.add(tfTitle);
 * customizationPanel.add(vbox); JLabel jltexto = new JLabel();//cuadro de
 * creditos jltexto.setHorizontalAlignment(JLabel.CENTER);
 * jltexto.setAlignmentX(0.5f); jltexto.
 * setText("<html><center>version 1.0<br>github.com/danisilver/proyectoIS<br>mariodga@ucm.es</center></html>"
 * ); customizationPanel.add(jltexto);
 */