package servelets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sevento.LoginControle;

public class LoginServelet extends HttpServlet {
private static final long serialVersionUID = 1L;

 public  LoginServelet() {
  super();
 }
 
protected void doGet(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
 processRequest(request, response);
 }
protected void doPost(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
 processRequest(request, response);
 }

protected void processRequest(HttpServletRequest request, HttpServletResponse
response) throws ServletException, IOException {

 RequestDispatcher view;
 String login = request.getParameter("username");
 String senha = request.getParameter("password");

 LoginControle lc = new LoginControle();
 int retorno = lc.ValidarLogin(login, senha);

 if (retorno == 1) {
 request.setAttribute("msg", "Seja bem vindo "+login);
 view = request.getRequestDispatcher("cadevento.html");
 }else {
 request.setAttribute("msg", "Login desconhecido!");
 view = request.getRequestDispatcher("login.html");
 }

 view.forward(request, response);
 } 
}
