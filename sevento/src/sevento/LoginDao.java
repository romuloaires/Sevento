package sevento;

public class LoginDao extends Conexao{

	public int verificaLogin(Usuario lv) {

		 try {
		 this.stmt = this.getConnection().createStatement();
		 this.rs = this.stmt.executeQuery("select us_nome,us_senha from usuario where us_nome ='"+lv.getNome()+"' and us_senha = '"+lv.getSenha()+"'");
		 if (rs.next()) {
		 return 1; //Achou o login!
		 }
		 else
		 return 0; //Não achou o login! Login invalido!
		 } catch (Exception e) {
		 e.printStackTrace();
		 return 0;
		 }
	 }


	
	
}
