
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class conectaDAO {
    
    private Connection conexao;

    public conectaDAO() {
    }

    public conectaDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public Connection getConexao() {
        return conexao;
    }

    public void setConexao(Connection conexao) {
        this.conexao = conexao;
    }

    public void connectDB(){
       
        try {
        
            conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/uc11","root","stefani123");
            System.out.println("Conexão realizada com sucesso");
            
        } catch (SQLException erro){
            JOptionPane.showMessageDialog(null, "Erro ConectaDAO" + erro.getMessage());
        }

    }
    
     public void desconectar(){
        try{
            if (conexao != null && !conexao.isClosed()){
                conexao.close();
                System.out.println("desconectado");
            }
        } catch (SQLException ex){
            System.out.println("erro ao desconectar");
        }
    
     }
}
