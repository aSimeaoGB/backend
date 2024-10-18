package model;
import controller.*;
import java.sql.*;

public class TelaDeLoginModel {
    public static void logarModel(String login, String senha) {
        try {
            Connection conexao = MySQLConnector.conectar();
            String strSqlLogin = "select * from `db_senac`.`tbl_senac` where `email` = '" + login + "' and `senha` = '" + senha + "';";
            Statement stmSqlLogin = conexao.createStatement();
            ResultSet rstSqlLogin = stmSqlLogin.executeQuery(strSqlLogin);
            if (rstSqlLogin.next()) {
                TelaDeLoginController.notificarUsuario("Conectado com sucesso!!!");
            } else {
                TelaDeLoginController.notificarUsuario("Login e/ou senha não encontrada! Por Fabor, verigique e tente novamente.");
            }
            stmSqlLogin.close();
        } catch (Exception e) {
            TelaDeLoginController.notificarUsuario("Hove um problema e não será possivel realizar o login agora. Por favor, tente novamente mais tarde.");
            System.err.println("Veja o erro" + e);
        }
    }
}
