package edu.ucjc.damdaw.lengmarcas.appweb.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet1 extends HttpServlet {

	@Override
	public void init() throws ServletException {
		System.out.println("Llamando metodo init");
		super.init();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doGet");
		
		String param1 = req.getParameter("parametro1");
		String param2 = req.getParameter("parametro2");
		
		System.out.println(param1);
		System.out.println(param2);
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		resp.getWriter().append("<H1>RESPONDIENDO  "+ param1 + "/" + param2 + "</H1>");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doPost");
	}
	
}
