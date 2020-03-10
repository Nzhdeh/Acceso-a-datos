package clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion 
{
	private String sourceURL = "jdbc:sqlserver://localhost";
	//private String sourceURL = "jdbc:sqlserver://DESKTOP-68D7LR4//SQLEXPRESS";
    //private String sourceURL = "jdbc:sqlserver://192.168.0.166";
    private String usuario = "seguro";
    private String password = "seguro";

    /*
     * Signatura: public Connection getConnection()
     * Comentario: Devuelve una conexion con la BBDD
     * Precondiciones:
     * Entradas:
     * Salidas: Objeto Connection
     * Entrada/Salida:
     * Postcondiciones: Devuelve un objeto conexion, que es una conexion con la BBDD abierta.
     * */
    public Connection getConnection()
    {
        Connection conexionBD = null;
        try
        {
            conexionBD = DriverManager.getConnection(sourceURL, usuario, password);
            
        }catch (SQLException e){
            e.getStackTrace();
        }
        return conexionBD;
    }

    /*
     * Signatura: public boolean closeConnection(Connection conexion)
     * Comentario: Cierra la conexion recibida como parametro de entrada
     * Precondiciones:
     * Entradas:
     * Salidas: boolean que indica si la conexion se cerro correctamente
     * Entrada/Salida: Connection conexion
     * Postcondiciones: Asociado al nombre devuelve un boolean que sera true si la conexion recibida se cerro correctamente y false si no.
     *                  La conexion quedara cerrada.
     * */
    public boolean closeConnection(Connection conexion)
    {
        boolean exito = false;
        try
        {
            conexion.close();
            if(conexion.isClosed())
            {
                exito = true;
            }
        }catch (SQLException e){
            e.getStackTrace();
        }
        return exito;
    }
}
