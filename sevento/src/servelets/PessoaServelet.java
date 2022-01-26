package servelets;


import java.io.IOException;  
import java.io.PrintWriter;

import javax.servlet.ServletException;  
//import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
  

import sevento.Usuario;
  
//import model.Pessoa;  
  
//@WebServlet("/EnviarDados")  
public class PessoaServelet extends HttpServlet {  
   private static final long serialVersionUID = 1L;  
         
    public PessoaServelet() {  
        super();  
    }  
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet NovoUsuarioServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet NovoUsuarioServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {            
            out.close();
        }
    }
  
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
   }  
  
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
      try{  
           
        Usuario user = new Usuario();
           
        
            user.setNome(request.getParameter("usernamesignup"));
            user.setEmail( request.getParameter("emailsignup"));
            user.setSenha(request.getParameter("passwordsignup"));  
            
            user.adiciona(user);
              
            request.setAttribute("msg", "Gravado com sucesso!");  
            request.getRequestDispatcher("index.html").forward(request, response);  
     
           
      }catch (Exception e) {  
         request.setAttribute("msg", "Erro: " + e.getMessage());  
         request.getRequestDispatcher("index.html").forward(request, response);  
      }  
     
}  

}