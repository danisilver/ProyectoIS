package integracion;

import java.sql.SQLException;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;

public class H2FactoriaDAO extends FactoriaDAO{
	
	String databaseUrl = "jdbc:h2:mem:database";
	ConnectionSource connectionSource;
	
	public H2FactoriaDAO() {
		try {
			connectionSource = new JdbcConnectionSource(databaseUrl);
		} catch (SQLException e) {
			System.err.println("cannot create H2FactoriaDAO");
			e.printStackTrace();
		}
	}

	@Override
	public DaoRecurso getDaoRecurso() {
		return new H2DaoRecurso(connectionSource);
	}

	@Override
	public DaoCompra getDaoCompra() {
		return null;
	}

	@Override
	public DaoAveria getDaoAveria() {
		return null;
	}

	@Override
	public DaoMontaje getDaoMontaje() {
		return null;
	}
	
}
