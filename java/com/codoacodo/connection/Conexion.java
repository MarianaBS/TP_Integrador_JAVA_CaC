package com.codoacodo.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {

    public static Connection getConnection() {
        String url = "jdbc:mysql://127.0.0.1:3306/integrador_cac";
        String username = "root";
        String password = "root";

        String driverName = "com.mysql.cj.jdbc.Driver";
        /*
		String url = System.getenv("DATASOURCE_URL");
		String user = System.getenv("DATASOURCE_USERNAME");
		String password = System.getenv("DATASOURCE_PASSWORD");
		String driverName = System.getenv("DATASOURCE_DRIVER");
         */
        //control errores
        Connection con = null;
        try {
            Class.forName(driverName);//carga en memoria el Driver
            con = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();//muestra la excepción y el error
        }
        return con;
    }

    public static void main(String[] args) {
        Connection con = Conexion.getConnection();//f5
        if (con != null) {
            System.out.println("Conexion ok");
        } else {
            System.err.println("Conexion fail");
        }

    }
}
