package sevento;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class  Evento {
    Connection con = null;
    private String titulo;
    private String local;
    private String tipo;
    
    private Long id;
	private String descricao;
	

        public Evento(){
        	super();
            this.con = new Conexao().getConnection();
        }
    
        public Evento(String titulo, String tipo, String local, String descricao) {  
            super();  
           // this.id = id;  
            this.titulo = titulo;  
           this.tipo = tipo;  
            this.local = local;
            this.descricao = descricao;
         }  

        
        public void adiciona(Evento evento){
        try {
            PreparedStatement sql = con .prepareStatement("insert into eventos (ev_titulo,ev_tipo, ev_local,ev_descricao)"
                    + "values (?,?,?,?)");
       
            
       
        sql.setString(1,evento.getTitulo());
        sql.setString(2,evento.getTipo());
        sql.setString(3,evento.getLocal());
        sql.setString(4,evento.getDescricao());
       
       
       
        
        sql.execute();
        sql.close();
      
        } catch (SQLException e) {
             throw new RuntimeException(e);
            }
        }
    
        

		

	/*	public List<Evento> pesquisa(){
     try {
         List<Evento> contatos = new ArrayList<Evento>();
         PreparedStatement sql = this.con.
                 prepareStatement("select * from evento");
         ResultSet rs = sql.executeQuery();
 
         while (rs.next()) {
             // criando o objeto Contato
             Usuario contato = new Usuario();
           //  contato.setId(rs.getLong("id"));
             contato.setTitulo(rs.getString("us_nome"));
             contato.setLocal(rs.getString("us_email"));
             contato.setDescricao(rs.getString("us_nome"));
             contato.setTipo(rs.getString("us_email"));
             
        
 
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
        	
        	
     
      */  
        
       public Long getId() {
           return id;
       }   
       
       public void setId(Long id) {
           this.id = id;
       }

    
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setLocal(String local) {
       this.local = local;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    
   public String getDescricao() {
		
		return descricao;
	}

   public String getTitulo() {
		
		return titulo;
	}

   public String getLocal() {
		
		return local;
	}
   public String getTipo() {
		
		return tipo;
	}
   
  
    
    
	public boolean existeUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		return false;
	}
    
    
    
}

