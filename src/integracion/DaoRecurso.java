package integracion;

import java.util.ArrayList;

public interface DaoRecurso {
	
	public RecursoAudioVisual getRecursoById(int idRecurso);

	public void create(RecursoAudioVisual recurso);

	public ArrayList<RecursoAudioVisual> getRecursosAudiovisuales();
	
}
