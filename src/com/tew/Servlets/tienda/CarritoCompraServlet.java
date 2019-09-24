package com.tew.Servlets.tienda;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

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
		PrintWriter out = response.getWriter();

		out.println("<HTML>");
		out.println("<HEAD><TITLE>Carrito compra</TITLE></HEAD>");

		out.println("<BODY>");
		out.println("<center>");
		out.println("<h1>�Bienvenido a la tienda!</h1>");
		out.println("<form action=\"/servletsv0_0/CarritoCompra\" method=\"post\")");
		out.println("<br><br><br><select name=idProducto>");
		out.println("<option value=1>Manzana</option>");
		out.println("<option value=2>Pera</option>");
		out.println("<option value=2>Sand�a </option>");
		out.println("<option value=3>Mel�n </option>");
		out.println("<option value=4>Naranja </option>");
		out.println("<option value=5>Mandarina </option>");
		out.println("<option value=6>Fresa </option>");
		out.println("<option value=7>Ciruela </option>");
		out.println("<option value=8>Kiwi </option>");
		out.println("<option value=9>Platano </option>");
		out.println("<option value=10>Coco </option>");
		out.println("</select>");
		out.println("<br><br><input type=\"submit\" value=\"A�adir al carro\">");

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
		out.println("<br><br>");
		request.getSession().setAttribute("carro", carro);
		Set<String> claves = carro.keySet();
		for(String id: claves) {
			out.println(id + ": " + carro.get(id) + "<br>");
		}
		out.println("</center>");
		out.println("</body>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
