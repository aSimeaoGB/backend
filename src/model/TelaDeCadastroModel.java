package model;
import java.sql.*;

public class TelaDeCadastroModel {
    public static int cadastrarModel(String nome, String email, String senha) {
        try {
            Connection conexao = MySQLConnector.conectar();
            String strSqlEmail = "select * from `db_senac`.`tbl_senac` where `email` = '" + email + "';";
            Statement stmSqlEmail = conexao.createStatement();
            ResultSet rstSqlEmail = stmSqlEmail.executeQuery(strSqlEmail);
            if (rstSqlEmail.next()) {
                stmSqlEmail.close();
                return 0;
            } else {
                String strSqlCadastrar = "insert into `db_senac`.`tbl_senac` (`nome`, `email`, `senha`) values ('" + nome + "', '" + email + "', '" + senha + "');";
                Statement stmSqlCadastrar = conexao.createStatement();
                stmSqlCadastrar.addBatch(strSqlCadastrar);
                stmSqlCadastrar.executeBatch();
                stmSqlEmail.close();
                return 2;
            }
        } catch (Exception e) {
            System.err.println("Erro: " + e);
            return 1;
        }
    }
}