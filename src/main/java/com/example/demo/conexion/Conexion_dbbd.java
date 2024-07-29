package com.example.demo.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
    		String selectSql = "Select * from prueba_web;";
    		Statement statement = conn.createStatement();
   	     	ResultSet resultSet = statement.executeQuery(selectSql);
    	    while (resultSet.next()) {
    	        String name = resultSet.getString("Nombre");
    	        System.out.println(", Name: " + name);
    	    }
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e);
		}
    	
    }
    
    public void patata() {
    	
    	String selectSql = "Select * from prueba_web;";
    	try (Statement statement = conn.createStatement();
    	     ResultSet resultSet = statement.executeQuery(selectSql)) {
    	    while (resultSet.next()) {
    	        int id = resultSet.getInt("id");
    	        String name = resultSet.getString("name");
    	        String email = resultSet.getString("email");
    	        System.out.println("ID: " + id + ", Name: " + name + ", Email: " + email);
    	    }
    	} catch (SQLException e) {
    	    e.printStackTrace();
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

       /** String jdbcUrl = "jdbc:mariadb://localhost:3307/";
        String username = "root";
        String password = "mariadbpalotes1234";
        
        public Conexion_dbbd() {

	        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {
	            System.out.println("Conexión exitosa!");
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	      
        }*/
}
