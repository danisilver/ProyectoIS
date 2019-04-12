package presentacion;

import javax.swing.SwingUtilities;
/*import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;*/

import negocio.MainModel;
import negocio.SAGestionRecursos;

public class Main {

	public static void main(String[] args) /* throws Exception */{
		
		//UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		
		//SAGestionRecursos servicioDeAplicacion = new SAGestionRecursos(null);
		
		MainModel mainModel = new MainModel();
		MainView mainView = new MainView(mainModel);
		MainController controlador = new MainController(mainView, mainModel);
		
		SwingUtilities.invokeLater(new Runnable() {
			@Override public void run() {
				controlador.run();
			}
		});
		
	}
}


