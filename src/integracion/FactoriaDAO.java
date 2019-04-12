package integracion;

public abstract class FactoriaDAO {
	
	public static FactoriaDAO crearFactoria(TipoFactoria tipo) {
		return null;
	}
	
	public abstract DaoRecurso getDaoRecurso();
	
	public abstract DaoCompra getDaoCompra();
	
	public abstract DaoAveria getDaoAveria();
	
	public abstract DaoMontaje getDaoMontaje();

}
