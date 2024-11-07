package model;
import controller.*;

import java.sql.*;
import java.nio.file.*;
import java.util.*;

public class InterfaceModel {
    public static void validarImagens(ArrayList<String> strImagens) {
        for (int i = 0; i < strImagens.size(); i++) {
            try {
                String imgAtual = strImagens.get(i);
                String strSqlValidarImagem = "select * from `db_senac`.`tbl_senac` where `img` = '" + imgAtual + "';";
                Connection conexao = MySQLConnector.conectar();
                Statement stmSqlValidarImagem = conexao.createStatement();
                ResultSet rstSqlValidarImagem = stmSqlValidarImagem.executeQuery(strSqlValidarImagem);
                if (!rstSqlValidarImagem.next()) {
                    Path pathOrigin = Paths.get(InterfaceController.localViewImgFolder + "\\" + imgAtual);
                    Files.delete(pathOrigin);
                    System.out.println("Arquivo " + imgAtual + "apagado com sucesso!");
                }
            } catch (Exception e) {
                System.err.println("Erro: " + e);
            }
        }
    }
}