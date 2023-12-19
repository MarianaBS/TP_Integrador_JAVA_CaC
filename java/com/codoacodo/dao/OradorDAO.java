package com.codoacodo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Timestamp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.codoacodo.model.Orador;
import com.codoacodo.connection.Conexion;
import java.sql.Date;

public class OradorDAO {

    static Logger logger = LoggerFactory.getLogger(OradorDAO.class);
    private static final String SQL_SELECT = "SELECT * FROM ORADORES ";
    private static final String SQL_INSERT = "INSERT INTO oradores(nombre, apellido, mail, tema) VALUES (?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE oradores SET nombre = ?, apellido = ?, mail = ?, tema = ? WHERE ID_ORADOR = ?";
    private static final String SQL_DELETE = "DELETE FROM oradores WHERE ID_ORADOR = ?";
    private static final String SQL_BUSCAR = "SELECT * FROM PRODUCTO WHERE nombre LIKE '%?%'";
    private static final String SQL_BUSCAR_ID = "SELECT * FROM PRODUCTO WHERE ID_ORADOR=?";

    public List<Orador> listarOradores() {

        Connection conn = Conexion.getConnection();

        List<Orador> list = new ArrayList<>();
        try {
            Statement st = conn.createStatement();

            //resultset
            ResultSet rs = st.executeQuery(SQL_SELECT);

            while (rs.next()) {

                Long idOrador = rs.getLong(1);
                String nombre = rs.getString(2);
                String apellido = rs.getString(3);
                String mail = rs.getString(4);
                String tema = rs.getString(5);
                Timestamp fechaAlta = rs.getTimestamp(6);

                Orador orador = new Orador(idOrador, nombre, apellido, mail, tema, fechaAlta);
                list.add(orador);
            }
            //cierro la conexion
            conn.close();
        } catch (SQLException e) {
            // ERRORES
            e.printStackTrace();
        }
        return list;
    }

    public void agregarOrador(String nombre, String apellido, String mail, String tema) {

        Connection con = Conexion.getConnection();
        PreparedStatement stmt;
        if (con != null) {

            //control de errores
            try {
                
                stmt = con.prepareStatement(SQL_INSERT);
                stmt.setString(2,nombre);
                stmt.setString(3,apellido);
                stmt.setString(4,mail);
                stmt.setString(5,tema);
                stmt.executeUpdate();

                //cierre de conexion
                con.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void actualizarOrador(String id, String nombre, String ape, String mail, String tema) {
        Connection con = Conexion.getConnection();
        if (con != null) {

            try {
                Statement st = con.createStatement();
                st.executeUpdate(SQL_UPDATE);
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public int eliminarOrador(int id) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, id);
            registros = stmt.executeUpdate();
        } catch (SQLException | NullPointerException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                stmt.close();
                conn.close();
            } catch (SQLException | NullPointerException ex) {
                ex.printStackTrace(System.out);
            }
        }

        return registros;
    }

    public List<Orador> buscar(String clave) {

        //Connection
        Connection con = Conexion.getConnection();

        List<Orador> listado = new ArrayList<Orador>();

        //Statement
        try {
            Statement st = con.createStatement();

            //resultset
            ResultSet rs = st.executeQuery(SQL_BUSCAR);

            //VIENE UN SOLO REGISTRO!!!
            while (rs.next()) {//si existe, hay uno solo
                // rs > sacando los datos
                Long id = rs.getLong(1);//tomar la primer columna
                String nombre = rs.getString(2);
                String apellido = rs.getString(3);
                String mail = rs.getString(4);
                String tema = rs.getString(5);
                Timestamp fechaAlta = rs.getTimestamp(6);

                Orador oraFromDb = new Orador(id, nombre, apellido, mail, tema, fechaAlta);

                listado.add(oraFromDb);
            }
        } catch (SQLException e) {
            // ERRORES
            e.printStackTrace();
        }

        return listado;
    }

    public Orador obtenerPorId(Long id) {
        //Connection
        Connection con = Conexion.getConnection();

        Orador oraFromDb = null;

        //Statement
        try {
            Statement st = con.createStatement();

            //resultset
            ResultSet rs = st.executeQuery(SQL_BUSCAR_ID);

            //VIENE UN SOLO REGISTRO!!!
            if (rs.next()) {//si existe, hay uno solo
                // rs > sacando los datos
                Long idOra = rs.getLong(1);
                String nombre = rs.getString(2);
                String apellido = rs.getString(3);
                String mail = rs.getString(4);
                String tema = rs.getString(5);
                Timestamp fecha = rs.getTimestamp(6);

                //campos crear un objeto????
                oraFromDb = new Orador(idOra, nombre, apellido, mail, tema, fecha);
            }
        } catch (SQLException e) {
            // ERRORES
            e.printStackTrace();
        }
        return oraFromDb;
    }

}
