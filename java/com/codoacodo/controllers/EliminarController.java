package com.codoacodo.controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;

import com.codoacodo.connection.Conexion;
import com.codoacodo.dao.OradorDAO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

@WebServlet("/api/EliminarController")
public class EliminarController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        int dialogButton = JOptionPane.OK_CANCEL_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog(null, "Desea eliminar el Orador?", "Elminar", dialogButton);
        if (dialogResult == JOptionPane.OK_OPTION) {

            String id = req.getParameter("id");

            OradorDAO dao = new OradorDAO();

            dao.eliminarOrador(Integer.valueOf(id));
        }

        resp.sendRedirect(req.getContextPath() + "/api/ListadoController");

    }
}
