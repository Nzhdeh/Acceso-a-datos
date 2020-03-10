package clases;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.Utilidad;

public class PersistenciaSeguro 
{
	//Insertará el Seguro en la base de datos.
	public void insertSeguro(Seguro seguro) 
	{
		//Variables inserción en base de datos
		Conexion objConexion = new Conexion();
		CallableStatement cstmt = null;
        ResultSet rs = null;
        Connection connection = null ;
        int results = 0;
        boolean exito = false;
		
		Utilidad u=new Utilidad();
		int filasAfectadas = 0;


		try
		{
			connection = objConexion.getConnection();
            cstmt = connection.prepareCall(
                    "{call insertarSeguro(?,?,?,?,?,?)}"
                    );
            cstmt.setString(1, seguro.getNif());
            cstmt.setString(2, seguro.getNombre());
            cstmt.setString(3, seguro.getApe1());
            cstmt.setString(4, seguro.getApe2());
            cstmt.setInt(5, seguro.getEdad());
            cstmt.setInt(6, seguro.getNumHijos());

	        filasAfectadas = cstmt.executeUpdate();
//				if(preparedStatement.executeUpdate() == 1)
//				{
//					exito = true;
//				}else{
//					System.out.println("Error al intentar insertar el partido");
//				}

		}catch (Exception e)
		{
			e.printStackTrace();
		}finally 
		{
			//Cierra conexión y prepareStatement
			try 
			{
				cstmt.close();
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
			objConexion.closeConnection(connection);
		}
	}
	
	
	// Obtendrá el Seguro cuya clave primaria es idSeguro.
	public Seguro getSeguro(int idSeguro)
	{
		Conexion conexionJDBC = new Conexion();
		Connection connection = conexionJDBC.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Seguro seguro = null;

		String miSelect = "select * from Seguros where idSeguro= ?";
		try {
			//Preparo el statement
			preparedStatement = connection.prepareStatement(miSelect);
			preparedStatement.setInt(1,idSeguro);
			//Ejecuto
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) 
			{
				seguro = new Seguro();
				
				seguro.setIdSeguro(resultSet.getInt("idSeguro"));
				seguro.setNif(resultSet.getString("nif"));
				seguro.setNombre(resultSet.getString("nombre"));
				seguro.setApe1(resultSet.getString("ape1"));
				seguro.setApe2(resultSet.getString("ape2"));
				seguro.setIdSeguro(resultSet.getInt("edad"));
				seguro.setIdSeguro(resultSet.getInt("numHijos"));
			}
			preparedStatement.close();
			conexionJDBC.closeConnection(connection);
		}catch (SQLException e){
			e.getStackTrace();
		}
		return seguro;
	}
	
	//Actualizará en la base de datos el Seguro.
	public void updateSeguro(Seguro seguro)
	{
		
	}
	
	// Borrará de la base de datos el seguro cuya clave primaria sea idSeguro
	public void deleteSeguro(int idSeguro)
	{
		Conexion conexionJDBC = new Conexion();
		Connection connection = conexionJDBC.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Seguro seguro = null;

		try {
	        String sql = "delete * from Seguros where idSeguro= ?";
	        preparedStatement.setInt(1, idSeguro);
	        conexionJDBC.getConnection();
	        Statement st = objConec.conex.createStatement();
	        preparedStatement.executeUpdate();
	        
	        objConec.conex.close();
	        st.close();
	    } catch (Exception e) {
	        JOptionPane.showMessageDialog(null, "Error al eliminar" + e.getMessage());
	    }
	}
}
