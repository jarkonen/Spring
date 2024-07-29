package com.example.demo.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion_dbbd {
	
	public Connection conn;

    private String host = "localhost";
    private String port = "3306";
    private String user = "root";
    private String password = "1234";
    private String database = "losmosqueperros";

    
    public Conexion_dbbd() {

    	try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
    		String url = "jdbc:mysql://" + this.host + ":" + this.port + "/" + this.database;
    		conn = DriverManager.getConnection(url, this.user, this.password);
    		System.out.println("Conexion exitosa");
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e);
		}
    	
    }
    
    public void acabarConexion() {
    	
    	try {
			this.conn.close();
			System.out.println("Conexion con la BBDD acabada");
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
}
