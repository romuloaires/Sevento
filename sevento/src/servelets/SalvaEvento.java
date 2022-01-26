package servelets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sevento.Evento;

/**
 * Servlet implementation class SalvaEvento
 */
public class SalvaEvento extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
	        try{  
	             
	        	Evento user = new Evento();
	             
	             user.setTitulo(request.getParameter("name"));
	            // user.setTipo( request.getParameter("job"));
	             user.setLocal(request.getParameter("local"));  
	             user.setDescricao(request.getParameter("descricao"));  
	             user.adiciona(user);
	               
	             request.setAttribute("msg", "Gravado com sucesso!");  
	             request.getRequestDispatcher("index.html").forward(request, response);  
	      
	       
	       
	             
	        }catch (Exception e) {  
	           request.setAttribute("msg", "Erro: " + e.getMessage());  
	           request.getRequestDispatcher("index.html").forward(request, response);  
	        }  
	 }

}