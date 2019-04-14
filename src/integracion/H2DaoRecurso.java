package integracion;

import java.sql.SQLException;
import java.util.ArrayList;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;

public class H2DaoRecurso implements DaoRecurso {

	private ConnectionSource connectionSource;
	private Dao<RecursoAudioVisual, String> daoRecurso;

	public H2DaoRecurso(ConnectionSource connectionSource) {
		this.connectionSource = connectionSource;
		try {
			daoRecurso = DaoManager.createDao(this.connectionSource, RecursoAudioVisual.class); 
		} catch (SQLException e) { e.printStackTrace(); }
		
	}
	
	@Override
	public RecursoAudioVisual getRecursoById(int idRecurso) {
		RecursoAudioVisual recurso = null;
		try {
			recurso = daoRecurso.queryForId(String.valueOf(idRecurso));
			
		} catch (SQLException e) { e.printStackTrace(); }
		return recurso;
	}

	@Override
	public void create(RecursoAudioVisual recurso) {
		try {
			daoRecurso.create(recurso);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<RecursoAudioVisual> getRecursosAudiovisuales() {
		ArrayList<RecursoAudioVisual> arr = new ArrayList<>();
		for(RecursoAudioVisual recurso : daoRecurso) {
			arr.add(recurso);
		}
		return arr;
	}

}
