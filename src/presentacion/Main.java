package presentacion;

import javax.swing.SwingUtilities;
/*import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;*/

import negocio.MainModel;

public class Main {

	public static void main(String[] args) /* throws Exception */{
		
		//UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		
		MainModel mainModel = new MainModel();
		MainView mainView = new MainView(mainModel);
		Controlador controlador = new Controlador(mainView, mainModel);
		
		SwingUtilities.invokeLater(new Runnable() {
			@Override public void run() {
				controlador.run();
			}
		});
		
	}
}


