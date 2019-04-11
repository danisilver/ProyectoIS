package integracion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import integracion.DAOClientes;
import negocio.TransferCliente;

public class DAOClientesImp implements DAOClientes {
	
	
	public TransferCliente buscaCliente(float idCliente)
	{
		TransferCliente tE= null;
		Connection con= null;
		Statement stmt= null;
		
		
		
		tE= new TransferCliente();
		//Relleno los datos desde la BBDD BLA BLA BLA
		tE.setId(1234);
		tE.setNombre("Paco");
		tE.setSalario(35000);
		
		return tE;

		/*try { 
        	
    		Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection("jdbc:mysql://localhost/practicaUNLP?user=unlp&password=unlp");
           	String query= "SELECT * FROM  Cliente WHERE  idCliente='"+ idCliente+"'";
       
        	stmt= con.createStatement();
        	ResultSet rs= stmt.executeQuery(query);
              	 	
        	if (rs.next()){
        		tE= new TransferCliente();
        		tE.setId(rs.getInt("idCliente"));
        		tE.setNombre(rs.getString("nombre"));
        		tE.setHoras(rs.getInt("horas"));
        		}
                      
        	if (stmt != null) stmt.close();
        	if (con != null) con.close();
               	
        	} catch (Exception ex) {
        								System.out.println("SQLException: " + ex.getMessage()); 
        								return null;
        								} 
        
		*/
           
	}
}
