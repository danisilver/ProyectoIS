

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;

import negocio.MainModel;

public class Main {
	public static String databaseUrl = "jdbc:h2:file:./database";
	public static ConnectionSource connectionSource;
	
	static {
		try {
			connectionSource = new JdbcConnectionSource(databaseUrl);
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) { e.printStackTrace(); }
	}
	
	public static void main(String[] args){
		
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


