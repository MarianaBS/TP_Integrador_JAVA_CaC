package com.codoacodo.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codoacodo.dao.OradorDAO;
import com.codoacodo.model.Orador;

@WebServlet("/api/EditarController")
public class EditarController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String id = req.getParameter("id");
		
		//Crear ProductoDAO
		OradorDAO dao = new OradorDAO();
		
		//invocar el metodo obtenerPorId(id)
                Orador oraFromDb = dao.obtenerPorId(Long.parseLong(id));
		
		//guardar en el request el producto
		req.setAttribute("orador", oraFromDb);
		
		//ir a la siguiente pagina
		getServletContext().getRequestDispatcher("/editar.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String nombre = req.getParameter("nombre");
		String apellido = req.getParameter("apellido");
		String mail = req.getParameter("mail");
		String tema = req.getParameter("tema");
		String id = req.getParameter("id");
		
		//Crear ProductoDAO
		OradorDAO dao = new OradorDAO();
				
                dao.actualizarOrador(id, nombre, apellido, mail, tema);

		//ir a la siguiente pagina
		resp.sendRedirect(req.getContextPath()+"/api/ListadoController");
	}
}
