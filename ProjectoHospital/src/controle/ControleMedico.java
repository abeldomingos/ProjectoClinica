
package controle;

//Aqui terá todos os metodos no control medico, como salvar, cancelar etc...

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.ModeloMedico;


public class ControleMedico {
    ConexaoBD conex = new ConexaoBD();
    ModeloMedico mod = new ModeloMedico();
    
    public void salvar(ModeloMedico mod){
        conex.conexao();
        try {
           PreparedStatement pst = conex.con.prepareStatement("insert into medicos(nome_medico,especialidade_medico,cpl_medico) values(? ,? ,? )");
           pst.setString(1,mod.getNome());
           pst.setString(2,mod.getEspecialidade());
           pst.setInt(3, mod.getCpl());
           pst.execute();
           JOptionPane.showMessageDialog(null, "Dados Inseridos Com Sucesso");
           
        } catch (SQLException ex) {
              JOptionPane.showMessageDialog(null, "Falha Ao Inserir Dados\n"+ex);
        }
        conex.desconecta();
    }   
}
