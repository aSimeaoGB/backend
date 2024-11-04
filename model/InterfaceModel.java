package model;

import controller.*;
import java.sql.*;
import java.nio.file.*;
import java.util.*;

/**
 * Classe responsável pela lógica de validação de imagens no sistema.
 */
public class InterfaceModel {

    /**
     * Valida as imagens fornecidas em relação a um banco de dados.
     * Se uma imagem não for encontrada no banco, ela será removida do sistema.
     * 
     * @param strImagens Lista de nomes de imagens a serem validadas.
     */
    public static void validarImagens(ArrayList<String> strImagens) {
        for (int i = 0; i < strImagens.size(); i++) {
            try {
                String imgAtual = strImagens.get(i);
                // Consulta SQL para verificar a existência da imagem no banco de dados
                String strSqlValidarImagem = "select * from `db_senac`.`tbl_senac` where `img` = '" + imgAtual + "'";
                
                // Estabelece conexão com o banco de dados
                Connection conexao = MySQLConnector.conectar();
                Statement stmSqlValidarImagem = conexao.createStatement();
                ResultSet rstSqlValidarImagem = stmSqlValidarImagem.executeQuery(strSqlValidarImagem);
                
                // Verifica se a imagem existe no resultado da consulta
                if (!rstSqlValidarImagem.next()) {
                    // Se a imagem não existe, deleta o arquivo correspondente
                    Path pathOrigin = Paths.get(InterfaceController.localViewImgFolder + "\\" + imgAtual);
                    Files.delete(pathOrigin);
                    System.out.println("Arquivo " + imgAtual + " apagado com sucesso!");
                }
            } catch (Exception e) {
                // Captura e imprime erros que possam ocorrer durante o processo
                System.err.println("Erro: " + e);
            }
        }
    }
}
