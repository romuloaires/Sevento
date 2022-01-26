package sevento;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class  Usuario {
    Connection con = null;
    private String nome;
    private String email;
    private String senha;
    
    private Long id;

        public Usuario(){
        	super();
            this.con = new Conexao().getConnection();
        }
    
        public Usuario(String nome, String email, String senha) {  
            super();  
           // this.id = id;  
            this.nome = nome;  
            this.email = email;  
            this.senha = senha;  
         }  

        
        public void adiciona(Usuario contato){
        try {
            PreparedStatement sql = con .prepareStatement("insert into usuario (us_nome,us_email,us_senha)"
                    + "values (?,?,?)");
       
         
        sql.setString(1,contato.getNome());
        sql.setString(2,contato.getEmail());
        sql.setString(3,contato.getSenha());
        
        sql.execute();
        sql.close();
        } catch (SQLException e) {
             throw new RuntimeException(e);
            }
        }
    
        public List<Usuario> pesquisa(){
     try {
         List<Usuario> contatos = new ArrayList<Usuario>();
         PreparedStatement sql = this.con.
                 prepareStatement("select * from usuario");
         ResultSet rs = sql.executeQuery();
 
         while (rs.next()) {
             // criando o objeto Contato
             Usuario contato = new Usuario();
           //  contato.setId(rs.getLong("id"));
             contato.setNome(rs.getString("us_nome"));
             contato.setEmail(rs.getString("us_email"));
             
             
        
 
             // adicionando o objeto à lista
             contatos.add(contato);
         }
         rs.close();
         sql.close();
         return contatos;
     } catch (SQLException e) {
         throw new RuntimeException(e);
     }
        
       }
        
        public void altera(Usuario contato) {
     
     try {
         PreparedStatement sql = con .prepareStatement("update usuario set us_nome=?, us_email=?, us_senha=?" );
         sql.setString(1, contato.getNome());
         sql.setString(2, contato.getEmail());
         sql.setString(3, contato.getSenha());
         //sql.setLong(4, contato.getId());
         sql.execute();
         sql.close();
     } catch (SQLException e) {
         throw new RuntimeException(e);
     }
 }
    
       public void remove(Usuario contato){
    	   
    	   try{
    		   PreparedStatement stmt = con.prepareStatement("delete from usuario where us_email=?");
    		   stmt.setString(1, contato.getEmail());
    		   stmt.execute();
    		   stmt.close();
    	      
    	   } catch(SQLException e){ 
    		   
    		   throw new RuntimeException(e);
    	   }
    	   
    	   
    	   
    	   
       }
        	
        	
     
        
        
       public Long getId() {
           return id;
       }   
       
       public void setId(Long id) {
           this.id = id;
       }

    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
	public boolean existeUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		return false;
	}
    
    
    
}

