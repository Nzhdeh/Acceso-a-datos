import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConexionJDBC {
	
	public void insertarDisco(Disco disco)
	{
        try 
        {
            // abrimos la conexion
            String sourceURL = "jdbc:sqlserver://localhost";
            String usuario = "disco";
            String password = "disco";
            String miSelect = "INSERT INTO Discos (autor, titulo, formato, localizacion)\n" +
                    "VALUES (?,?,?,?)";

            // Crear una conexion con el DriverManager
            Connection connexionBaseDatos = DriverManager.getConnection(sourceURL, usuario, password);
           
            PreparedStatement preparedStatement = connexionBaseDatos.prepareStatement(miSelect);
            preparedStatement.setString(1, disco.getAutor());
            preparedStatement.setString(2, disco.getTitulo());
            preparedStatement.setString(3, disco.getFormato());
            preparedStatement.setString(4, disco.getLocalizacion());
            
            preparedStatement.executeUpdate();

            // Cerrar
            preparedStatement.close();
            connexionBaseDatos.close();

        } catch (SQLException sqle) {
            System.err.println(sqle);
        }

    }

}
