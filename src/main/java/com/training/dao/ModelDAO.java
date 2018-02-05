package com.training.dao;

import com.training.exception.*;
import java.sql.*;
import java.util.*;
import java.io.*;
public class ModelDAO {
	static Connection connection;

	public static Connection openConnection() {
		String drivername = "";
		String url = "jdbc:mysql://localhost:3306/training";
		String username = "root";
		String password = "root";
		Properties prop = new Properties();		
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("C:\\Users\\Yougall\\workspace\\BookDB1\\src\\main\\resources\\jdbc.properties");
			
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			prop.load(fis);
			url = prop.getProperty("url");
			username = prop.getProperty("username");
			password = prop.getProperty("password");
			drivername = prop.getProperty("driver");
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally{
			try {
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
		connection = null;
		try {
			Class.forName(drivername);
			connection = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}

	public static void closeConnection() {
		try {
			if (connection != null)
				connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
