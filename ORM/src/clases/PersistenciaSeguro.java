package clases;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PersistenciaSeguro 
{
	//Insertará el Seguro en la base de datos.
	public void insertSeguro(Seguro seguro) 
	{
		//Utilidad objUtilidad = new Utilidad();
		//Variables inserción en base de datos
		Conexion objConexion = new Conexion();
		Connection conexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultset;
		int filasAfectadas = 0;
		String sentenciaSql = "INSERT INTO Seguros VALUES(?, ?, ?, ?, ?, ?, ?)";


		try{
			conexion = objConexion.getConnection();
			preparedStatement = conexion.prepareStatement(sentenciaSql);
			if(!conexion.isClosed()){
				preparedStatement.setString(1, seguro.getNif());
	            preparedStatement.setString(2, seguro.getNombre());
	            preparedStatement.setString(3, seguro.getApe1());
	            preparedStatement.setString(4, seguro.getApe2());
	            preparedStatement.setInt(5, seguro.getEdad());
	            preparedStatement.setInt(6, seguro.getNumHijos());
	            preparedStatement.setDate(7, (Date) seguro.getFechaCreacion());

	            filasAfectadas = preparedStatement.executeUpdate();
//				if(preparedStatement.executeUpdate() == 1){
//					exito = true;
//				}else{
//					System.out.println("Error al intentar insertar el partido");
//				}
			}

		}catch (SQLException e){
			e.printStackTrace();
		}finally {
			//Cierra conexión y prepareStatement
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			objConexion.closeConnection(conexion);
		}
	}
	
	
	// Obtendrá el Seguro cuya clave primaria es idSeguro.
	public Seguro getSeguro(int idSeguro)
	{
		return null;
	}
	
	//Actualizará en la base de datos el Seguro.
	public void updateSeguro(Seguro seguro)
	{
		
	}
	
	// Borrará de la base de datos el seguro cuya clave primaria sea idSeguro
	public void deleteSeguro(int idSeguro)
	{
		
	}
}
