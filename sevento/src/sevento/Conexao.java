package sevento;

import java.sql.*;

public class Conexao {
    static String status="";
    String url = "jdbc:mysql://localhost/scultura";
    String user = "root";
    String senha = "";
    protected Statement stmt = null;
    protected ResultSet rs = null;
  public Connection connection = null; 
    public Connection getConnection()  {
       
    	 
    	try {
    		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        	
        	
            return DriverManager.getConnection(url, user, senha);
         }
    	catch (SQLException e) {
		   status = e.getMessage();
        	throw new RuntimeException(e);
		}
   
    }
    
    public void closeConection() {
    	 try{
    	 if( this.rs != null ){
    	 this.rs.close();
    	 }
    	 if( this.stmt != null ){
    	 this.stmt.close();
    	 }
    	 if( this.connection != null ){
    	 this.closeConection();
    	 }
    	 }catch (SQLException sEx) {
    	 sEx.printStackTrace();
    	 } 

}
    
}