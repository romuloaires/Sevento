package servelets;

import java.io.*;  
import java.sql.PreparedStatement;  
  
import java.sql.SQLException;  
  



import javax.servlet.ServletException;
import javax.servlet.http.*;  

import sevento.Conexao;
import sevento.Usuario;
import java.sql.*;
  
public class SalvaCadastro extends HttpServlet {  
  

    
    
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
        try{  
             
        	 Usuario user = new Usuario();
             
             
             user.setNome(request.getParameter("usernamesignup"));
             user.setEmail( request.getParameter("emailsignup"));
             user.setSenha(request.getParameter("passwordsignup"));  
             
             user.adiciona(user);
               
             request.setAttribute("msg", "Gravado com sucesso!");  
             request.getRequestDispatcher("validar.html").forward(request, response);  
      
       
       
             
        }catch (Exception e) {  
           request.setAttribute("msg", "Erro: " + e.getMessage());  
           request.getRequestDispatcher("index.html").forward(request, response);  
        }  
       
  }  
    
    
    
    
    
  
}  