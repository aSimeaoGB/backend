package model;
import java.sql.*;
import controller.*;

public class TelaDeLoginModel {
    public static void logarModel(String login, String senha) {
        try {
            Connection conexao = MySQLConnector.conectar();
            String strSqlLogin = "select * from `db_senac`.`tbl_senac` where `email` = '" + login + "' and `senha` = '" + senha + "';";
            Statement stmSqlLogin = conexao.createStatement();
            ResultSet rstSqlLogin = stmSqlLogin.executeQuery(strSqlLogin);
            if (rstSqlLogin.next()) {
                TelaDeLoginController.notificarUsuario("Login realizado com sucesso!!!");
                TelaDeLoginController.abrirTelaDeMenu();
            } else {
                TelaDeLoginController.notificarUsuario("Login e/ou senha não encontrados! Por favor, verifique e tente novamente.");
            }
            stmSqlLogin.close();
        } catch (Exception e) {
            TelaDeLoginController.notificarUsuario("Houve um problema e não será possível realizar o login agora. Por favor, tente novamente mais tarde.");
            System.err.println("Veja o erro: " + e);
        }
    }
}