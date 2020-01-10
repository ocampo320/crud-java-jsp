package com.Conexion;


import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.postgresql.ds.common.BaseDataSource;

//pool de conexion
public class Conexion {
	
	private static BasicDataSource dataSource=null;
	
	private static DataSource getDataSource()
	{
		
	if (dataSource==null) {
		dataSource=new BasicDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");//seteamos el driver de conexion
		dataSource.setUsername("root");
		dataSource.setPassword("");
		dataSource.setUrl("jdbc:mysql://localhost/crud?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC"); 	
		
		dataSource.setInitialSize(20);
		dataSource.setMaxIdle(15);
		dataSource.setMaxTotal(15);
		dataSource.setMaxWaitMillis(5000);
		
	}
		
		return dataSource;
	}
	
	public static Connection getConnection() throws SQLException
	{
		
		return getDataSource().getConnection();
	}
	
}
