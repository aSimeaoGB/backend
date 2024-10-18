package model;
import java.sql.*;
import java.util.*;
import controller.*;

public class TelaDeRemoverModel {
    public static void popularIdsModel() {
        try {
            ArrayList<String> idsTemp = new ArrayList<>();
            idsTemp.add("Selecione aqui o id");
            Connection conexao = MySQLConnector.conectar();
            String strSqlPopularIds = "select * from `db_senac`.`tbl_senac` order by `id` asc;";
            Statement stmSqlPopularIds = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rstSqlPopularIds = stmSqlPopularIds.executeQuery(strSqlPopularIds);
            while (rstSqlPopularIds.next()) {
                idsTemp.add(rstSqlPopularIds.getString("id"));
            }
            TelaDeRemoverController.enviarIds(idsTemp.toArray(new String[0]));
            stmSqlPopularIds.close();
        } catch (Exception e) {
            TelaDeRemoverController.notificarUsuario("Não foi possível encontrar os ids! Por favor, verifique e tente novamente.");
            System.err.println("Erro: " + e);
        }
    }

    public static void removerIdModel(String id) {
        try {
            Connection conexao = MySQLConnector.conectar();
            String strSqlRemoverId = "delete from `db_senac`.`tbl_senac` where `id` = " + id + ";";
            Statement stmSqlRemoverId = conexao.createStatement();
            stmSqlRemoverId.addBatch(strSqlRemoverId);
            stmSqlRemoverId.executeBatch();
            stmSqlRemoverId.close();

            TelaDeRemoverController.notificarUsuario("O id " + id + " foi removido com sucesso!");
            TelaDeRemoverController.limparCampos();
            TelaDeRemoverController.popularIds();            
        } catch (Exception e) { 
            TelaDeRemoverController.notificarUsuario("Não foi possível remover o id! Por favor, verifique e tente novamente.");
            System.err.println("Erro: " + e);
        }
    }
    
    public static void atualizarCamposModel(String id, boolean notificar) {
        try {
            Connection conexao = MySQLConnector.conectar();
            String strSqlAtualizarCampos = "select * from `db_senac`.`tbl_senac` where `id` = " + id + ";";
            Statement stmSqlAtualizarCampos = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rstSqlAtualizarCampos = stmSqlAtualizarCampos.executeQuery(strSqlAtualizarCampos);
            if (rstSqlAtualizarCampos.next()) {
                TelaDeRemoverController.preencherCampos(rstSqlAtualizarCampos.getString("nome"), rstSqlAtualizarCampos.getString("email"));
                if (notificar == true) {
                    TelaDeRemoverController.notificarUsuario("Campos atualizados com sucesso!");
                }
            } else {
                if (notificar == true) {
                    TelaDeRemoverController.notificarUsuario("Ops! Não foi encontrado o id selecionado. Por favor, verifique e tente novamente.");
                }
            }
            stmSqlAtualizarCampos.close();
        } catch (Exception e) {
            TelaDeRemoverController.notificarUsuario("Não foi possível encontrar os ids! Por favor, verifique e tente novamente.");
            System.err.println("Erro: " + e);
        }
    }
}