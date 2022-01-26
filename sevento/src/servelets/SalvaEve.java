package servelets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sevento.Evento;

/**
 * Servlet implementation class SalvaEve
 */
public class SalvaEve extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
	        try{  
	             
	        	Evento user = new Evento();
	             
	        	
	        	
	             user.setTitulo(request.getParameter("titulo"));
	             user.setTipo(request.getParameter("tipo"));
	             user.setLocal(request.getParameter("local"));  
	             user.setDescricao(request.getParameter("descricao"));  
	             
	             user.adiciona(user);
	               
	             request.setAttribute("msg", "Gravado com sucesso!");  
	             request.getRequestDispatcher("validareve.html").forward(request, response);  
	      
	       
	       
	             
	        }catch (Exception e) {  
	           request.setAttribute("msg", "Erro: " + e.getMessage());  
	           request.getRequestDispatcher("index.html").forward(request, response);  
	        }  
	 }

}