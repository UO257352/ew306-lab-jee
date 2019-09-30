package com.tew.Servlets.tienda;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CarritoCompraServlet
 */
@WebServlet(name = "CarritoCompraServlet", urlPatterns = { "/CarritoCompra" })
public class CarritoCompraServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CarritoCompraServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		@SuppressWarnings("unchecked")
		HashMap<String, Integer> carro = (HashMap<String, Integer>) request.getSession().getAttribute("carro");
		if(carro==null) {
			carro = new HashMap<String, Integer>();
		}

		String idProducto = request.getParameter("idProducto");
		if(idProducto!=null) {
			if(carro.containsKey(idProducto))
				carro.put(idProducto, carro.get(idProducto)+1);
			else
				carro.put(idProducto, 1);
		}
		request.getSession().setAttribute("carro", carro);


		RequestDispatcher dispatcher = getServletContext().getNamedDispatcher("CarritoCompraVistaServlet");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
