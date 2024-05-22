import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.lang.NumberFormatException;


public class ProdutosDAO {
    
    PreparedStatement prep;
    ResultSet resultset;
    ArrayList<ProdutosDTO> listagem = new ArrayList<>();
    
    public boolean cadastrarProduto (ProdutosDTO produto){
        try{
         conectaDAO conexao = new conectaDAO();
            conexao.connectDB();
        //instrução sql que vai ser executada
            String sql = "insert into produtos(nome, valor, status) values (?,?,?);";

            // usar a string e transformar em sql
            prep = conexao.getConexao().prepareStatement(sql);
            
            //começa do 1 pois a posição 0 é ocupada pelo id que é auto_increment
            prep.setString(1, produto.getNome());
            prep.setString(2, Integer.toString(produto.getValor()));
            prep.setString(3, produto.getStatus());

            // executar a ação sql
            prep.execute();

            // desconectar do banco
            conexao.desconectar();
            return true;
        }catch (SQLException | NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar. Por favor, insira um valor inteiro!", "Erro!", 2, null);
            return false;
             }
        
    }
    
   //public ArrayList<ProdutosDTO> listarProdutos(){
        
        //return listagem;
    //} 
}

