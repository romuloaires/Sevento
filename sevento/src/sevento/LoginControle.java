
package sevento;
public class LoginControle {

	public int ValidarLogin(String login, String senha) {
		 Usuario lv = new Usuario();
		 lv.setNome(login);
		 lv.setSenha(senha);
		 //Instanciando 
		 LoginDao ld = new LoginDao();
		 int retorno = ld.verificaLogin(lv);
		 return retorno; 

	}
	
}  