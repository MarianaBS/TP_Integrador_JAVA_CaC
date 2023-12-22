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
import javax.swing.JOptionPane;


public class OradorDAO {

    static Logger logger = LoggerFactory.getLogger(OradorDAO.class);
    private static final String SQL_SELECT = "SELECT * FROM ORADORES ";
    private static final String SQL_DELETE = "DELETE FROM oradores WHERE ID_ORADOR = ?";

    public List<Orador> listarOradores() {

        Connection conn = Conexion.getConnection();

        List<Orador> list = new ArrayList<>();
        try {
            Statement st = conn.createStatement();

            //resultset
            ResultSet rs = st.executeQuery(SQL_SELECT);

            while (rs.next()) {

                int idOrador = rs.getInt(1);
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
            String sql = "INSERT INTO oradores (nombre, apellido,mail,tema) ";
            sql += " VALUES('" + nombre + "','" + apellido + "','" + mail + "','" + tema + "')";
            //control de errores
            try {

                Statement st = con.createStatement();
                st.execute(sql);

                //cierre de conexion
                con.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void actualizarOrador(int id, String nombre, String apellido, String mail, String tema) {
        Connection con = Conexion.getConnection();
        if (con != null) {
            String sqlEdit = "UPDATE oradores SET ";
            sqlEdit += " nombre='" + nombre + "', apellido='" + apellido + "', mail='" + mail + "', tema='" + tema + "' WHERE id_orador =" + id ;
            try {
                Statement st = con.createStatement();
                st.executeUpdate(sqlEdit);
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

        String sql = "SELECT * FROM oradores WHERE nombre LIKE '%" + clave + "%' ";
        //Connection
        Connection con = Conexion.getConnection();

        List<Orador> listado = new ArrayList<Orador>();

        //Statement
        try {
            Statement st = con.createStatement();

            //resultset
            ResultSet rs = st.executeQuery(sql);

            //VIENE UN SOLO REGISTRO!!!
            while (rs.next()) {//si existe, hay uno solo
                // rs > sacando los datos
                int id = rs.getInt(1);//tomar la primer columna
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

    public Orador obtenerPorId(int idOra) {
        String sql = "SELECT * FROM oradores WHERE ID_ORADOR = " + idOra;
        //Connection
        Connection con = Conexion.getConnection();

        Orador oraFromDb = null;

        //Statement
        try {
            Statement st = con.createStatement();

            //resultset
            ResultSet rs = st.executeQuery(sql);

            //VIENE UN SOLO REGISTRO!!!
            if (rs.next()) {//si existe, hay uno solo
                // rs > sacando los datos
                int id = rs.getInt(1);
                String nombre = rs.getString(2);
                String apellido = rs.getString(3);
                String mail = rs.getString(4);
                String tema = rs.getString(5);
                Timestamp fecha = rs.getTimestamp(6);
         
                oraFromDb = new Orador(id, nombre, apellido, mail, tema, fecha);
            }
        } catch (SQLException e) {
            // ERRORES
            e.printStackTrace();
        }
        return oraFromDb;
    }

}
