
package negocio;

public class TransferCliente {
	
	int id;
	String nombre;
	int salario;

	
	public TransferCliente()	{	}
	
	public void setId(int idP)	{
		id= idP;
	}
	
	public void setNombre(String nombreP)	{
		nombre= nombreP;
	}
	
	public void setSalario(int s)	{
		salario= s;
	}
	
	public int getId()	{
		return id;
	}
	
	public String getNombre()	{
		return nombre;
	}
	
	public float getSalario()	{
		return salario;
	}
}
