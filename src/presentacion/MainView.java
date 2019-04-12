package presentacion;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import negocio.MainModel;

public class MainView extends JFrame implements View {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTextField tfTitle;
	JButton btnCambiar;
	
	Event btnCambiarPressed = new Event();
	
	private MainModel model;
	private JButton btnComprar;
	private JButton btnAsignar;
	private JButton btnSolicitar;
	private JButton btnAveria;
	
	public MainView(MainModel mainModel){
		this.model = mainModel;
		btnCambiar = new JButton("cambiar titulo");
		tfTitle = new JTextField(10);
		{
			/* para evitar que el jtextfield se expanda cuando se expande la ventana */
			tfTitle.setMaximumSize(tfTitle.getPreferredSize());
		}
		btnComprar = new JButton("comprar recurso");
		//btnComprar.setMaximumSize(getContentPane().getMaximumSize());
		btnComprar.setAlignmentY(CENTER_ALIGNMENT);
		btnAsignar = new JButton("asignar a proyecto");
		btnSolicitar = new JButton("solicitar recurso");
		btnAveria = new JButton("nueva averia");
		
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));
		add(btnCambiar);
		add(tfTitle);
		add(btnComprar); 
		add(Box.createHorizontalGlue());
		add(btnAsignar); 
		add(btnSolicitar); 
		add(btnAveria);
		
		/* configuracion general de ventana */
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		
		/* configuracion de vista para no congestionar el constructor */
		setup();
	}

	private void setup() {
		//adaptador de ActionListener a Event
		btnCambiar.addActionListener(e -> btnCambiarPressed.notifyAllObservers());		
	}

	@Override
	public void updateView() {
		setTitle(model.getTitle());		
	}

	public String getTextTitle() {
		return tfTitle.getText();		
	}
	
	public void mostrarUI() {
		setVisible(true);
	}
	
	public void ocultarUI() {
		setVisible(false);
	}
}
