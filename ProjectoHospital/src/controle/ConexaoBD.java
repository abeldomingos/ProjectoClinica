

package controle;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class ConexaoBD {
    
   public Statement stm; // Responsavel por realizar a pesquisa no BD. Sempre que a gente fazer uma pesquisa vamos usar o Statement
   public ResultSet rs; // Permine armazenar o resultado dessa pesquisa ou do que a gente busca no BD
   private String driver = "org.postgresql.Driver"; // O Driver identifica o nosso serviço. Nosso serviço do BD. Ele é padrão
   private String caminho = "jdbc:postgresql://localhost:5433/clinicahospital"; //Vai Dizer qual o caminho do BD, onde ele está alocado.
   private String usuario = "postgres"; // É O postgren vindo da intalação do BD
   private String senha = "923585667"; // É a mesma usado ao configurar o BD
   public Connection con;  // Responsavel por realizar a conexão com o BD
   
   //Método Conexão,faz a coneção com BD
   public void conexao(){
       
       try {
           System.setProperty("jdbc.Drivers", driver); //Responsavel por setar as propriedades do drivers de conexão
           con=DriverManager.getConnection(caminho, usuario, senha);
           //JOptionPane.showMessageDialog(null, "Conexão Efetuada Com Sucesso");
       } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Falha Na Conexão:\n"+ex.getMessage());
       }
   
   }
    //Método Desconectar
  public void desconecta(){
       try {
           con.close();
          // JOptionPane.showMessageDialog(null, "BD Desconectado Com Sucesso");
       } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Falha Ao Desconectar o BD\n"+ex.getMessage());
       }
  
  }
    
}
