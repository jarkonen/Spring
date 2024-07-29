package com.example.demo.conexion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Service;

@Service
public class Crud_clientes {
	
	

	
	public static void introduce_cliente(String nombre, String contraseña) {
		
		Conexion_dbbd x = new Conexion_dbbd();
		String insertSql = "INSERT INTO prueba_web (Nombre, pass) VALUES (?, ?)";
		try (PreparedStatement preparedStatement = x.conn.prepareStatement(insertSql)) {
		    preparedStatement.setString(1, nombre);
		    preparedStatement.setString(2, contraseña);
		    int rowsAffected = preparedStatement.executeUpdate();
		    System.out.println("Rows inserted: " + rowsAffected);
		    x.acabarConexion();
		} catch (SQLException e) {
		    e.printStackTrace();
		}
	
		
	}
	
	public static void leer_clientes() {
		Conexion_dbbd x = new Conexion_dbbd();
		String selectSql = "SELECT * FROM prueba_web";
		try (Statement statement = x.conn.createStatement();
		     ResultSet resultSet = statement.executeQuery(selectSql)) {
		    while (resultSet.next()) {
		        String name = resultSet.getString("Nombre");
		        System.out.println("Name: " + name);
	
		    }
		} catch (SQLException e) {
		    e.printStackTrace();
		}
	    x.acabarConexion();
	}
	
	public static void actualizar_cliente(String nombre, String actualizar) {
		
		Conexion_dbbd x = new Conexion_dbbd();
		String updateSql = "UPDATE prueba_web SET Nombre = ? WHERE Nombre = ?"
				+ "WHERE Nombre = 'patata2';";
		try (PreparedStatement preparedStatement = x.conn.prepareStatement(updateSql)) {
		    preparedStatement.setString(1, actualizar);
		    preparedStatement.setString(2, nombre);
		    int rowsAffected = preparedStatement.executeUpdate();
		    System.out.println("Rows updated: " + rowsAffected);
		} catch (SQLException e) {
		    e.printStackTrace();
		}
	    x.acabarConexion();

		
	}
	
}