package com.Dao;

import java.awt.List;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.Conexion.Conexion;
import com.modelo.Usuario;

public class UsuarioDao extends Conexion{
	
	private Connection connection;
	private PreparedStatement statement;
	private boolean estadoOperacion;
	
	
	public boolean guardar(Usuario usuario) throws SQLException {
		
		String sqlString=null;
		estadoOperacion=false;
		connection=obtenerConexion();
		
		
		
		try {
			connection.setAutoCommit(false);//inicia transacion
			
			sqlString="INSERT INTO usuario(id_usuario, nombre, apellido, direccion)VALUES (?, ?, ?, ?)";
			statement=connection.prepareStatement(sqlString);
			statement.setString(1,null );
			statement.setString(2,usuario.getNombre());
			statement.setString(3, usuario.getApellido());
			statement.setString(4, usuario.getDireccion());
			
			estadoOperacion=statement.executeUpdate()>0;
			
			connection.commit();
			statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			connection.rollback();
			
			e.printStackTrace();
			
		}
		
		return estadoOperacion;
	}
	
	public boolean editar(Usuario usuario) throws SQLException {

		String sqlString;
		estadoOperacion=true;
		connection=obtenerConexion();
		try {
			connection.setAutoCommit(false);
			sqlString="update usuario set  nombre=? , apellido=? ,direccion=? where id_usuario=?";
			
			statement=connection.prepareStatement(sqlString);
			
			statement.setString(1, usuario.getNombre());
			statement.setString(2, usuario.getApellido());
			statement.setString(3, usuario.getDireccion());
			
			statement.setInt(4, usuario.getId());
			
			estadoOperacion=statement.executeUpdate()>0;
			connection.commit();
			statement.close();
			connection.close();
			
		} catch (SQLException e) {
			connection.rollback();
			// TODO: handle exception
		}
		
		return estadoOperacion;
	}
	
	public boolean eliminar(int idUsuario) throws SQLException {
		
		String sqlString;
		estadoOperacion=true;
		connection=obtenerConexion();
		try {
			connection.setAutoCommit(false);
			sqlString="delete from  usuario  where id_usuario=?";
			statement=connection.prepareStatement(sqlString);
			 statement.setInt(1, idUsuario);

			estadoOperacion=statement.executeUpdate()>0;
			connection.commit();
			statement.close();
			connection.close();
			
		} catch (SQLException e) {
			connection.rollback();
			// TODO: handle exception
		}
		
		return estadoOperacion;
		
	}
	
	
	
public ArrayList<Usuario> consultar() throws SQLException {
		
String sqlString=null;
boolean estadoOperacion=false;
ArrayList<Usuario> listaUsuarios=new ArrayList<Usuario>();
connection=obtenerConexion();

try {
	sqlString="SELECT *from usuario";
	statement=connection.prepareStatement(sqlString);	
	ResultSet rSet=statement.executeQuery(sqlString);
	while(rSet.next())
	{
		Usuario usurUsuario=new Usuario();
		usurUsuario.setId(rSet.getInt(1));
		usurUsuario.setNombre(rSet.getString(2));
		usurUsuario.setApellido(rSet.getString(3));
		usurUsuario.setDireccion(rSet.getString(4));
		listaUsuarios.add(usurUsuario);
		
	}
} catch (Exception e) {
	// TODO: handle exception
}

		return listaUsuarios;
	}
	
	public Usuario consultaId(int idUsuario) throws SQLException
	{
		String sql=null;
		Usuario usurUsuario = null;
		estadoOperacion=false;
		ResultSet rSet=null;
		 usurUsuario=new Usuario();
		connection=obtenerConexion();
		try {
			
			
			sql="SELECT *from usuario WHERE id_usuario=?";
			statement=connection.prepareStatement(sql);
			statement.setInt(1,idUsuario );
			 rSet=statement.executeQuery();
			
			while(rSet.next())
			{
				
				usurUsuario.setId(rSet.getInt(1));
				usurUsuario.setNombre(rSet.getString(2));
				usurUsuario.setApellido(rSet.getString(3));
				usurUsuario.setDireccion(rSet.getString(4));
				
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return usurUsuario;
		
	}
	
	private Connection obtenerConexion() throws SQLException
	{
		return Conexion.getConnection();
		
	}
	

}
