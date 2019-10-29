import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PruebaConexionBBDD 
{
	public static void main(String[] args) 
	{
		
		int numFilas;
		Connection connexionBaseDatos=null;
		ResultSet dato=null;
		Statement sentencia=null;//un statment para cada senrtecia
		
		String sourceURL ="jdbc:sqlserver://localhost";
		String usuario = "pepito";
		String password = "qq";
		String miSelect = "SELECT Nombre,Altura FROM Personas";
		
		try {
			 // Carga la clase del driver
		    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		      
			connexionBaseDatos =	DriverManager.getConnection(sourceURL,usuario, password);
			
			sentencia =  connexionBaseDatos.createStatement();
			dato = sentencia.executeQuery(miSelect);
			
//			String miOrden = "UPDATE Regalos SET denominacion='Coche Bombero' WHERE ID=1";
//			numFilas = sentencia.executeUpdate (miOrden);
			
			// Mostrar los datos del ResultSet
		    System.out.println("Nombre -> Altura");
		    System.out.println("------------------------------------------");
		    
		    while (dato.next())
		    {
		    	System.out.println(dato.getString("Nombre")+ " -> " + 
		    			dato.getInt("Altura"));
		    }
		}
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			// Cerrar conexion
		    try 
		    {
				connexionBaseDatos.close();
			} catch (SQLException e) 
		    {
				e.printStackTrace();
			}
		}
		
		
		
	}
}
