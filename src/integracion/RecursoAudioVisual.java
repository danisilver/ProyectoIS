package integracion;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable
public class RecursoAudioVisual {
	
	@DatabaseField(id = true)
	Integer id;
	
	@DatabaseField
	String nombre;
	
	@DatabaseField
	String descripcion;
}
