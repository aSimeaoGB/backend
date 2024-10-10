package controller;
import model.*;
import view.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;

public class TelaDeRemoverController extends TelaDeRemoverView {
    
    // Método que populará uma lista de IDs a partir da base de dados
    public static void popularIds() {
        try {
            // Cria uma lista temporária para armazenar os IDs
            ArrayList<String> idsTemp = new ArrayList<>();
            idsTemp.add("Selecione aqui o id");// Opção inicial

            // Conecta ao banco de dados
            Connection conexao = MySQLConnector.conectar();

            // Consulta SQL para selecionar todos os IDs da tabela
            String strSqlPopularIds = "select * from `db_senac`.`tbl_senac` order by `id` asc;";
            Statement stmSqlPopularIds = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rstSqlPopularIds = stmSqlPopularIds.executeQuery(strSqlPopularIds);
            // Itera sobre os resultados e adiciona os IDs à lista
            while (rstSqlPopularIds.next()) {
                idsTemp.add(rstSqlPopularIds.getString("id"));
            }
            // Converte a lista para um array e atribui à variável ids
            ids = idsTemp.toArray(new String[0]);
            stmSqlPopularIds.close();
            if (cbxId != null) {
                if (cbxId.getItemCount() > 0) {
                    cbxId.removeAllItems();
                    DefaultComboBoxModel<String> newMod = new DefaultComboBoxModel<String>(ids);
                    cbxId.setModel(newMod);
                    // cbxId = new JComboBox<String>(ids);
                }
            }
        } catch (Exception e) {
            // Notifica o usuário em caso de erro e registra o erro no console
            lblNotificacoes.setText(setHtmlFormat("Não foi possível encontrar os ids! Por favor, verifique e tente novamente."));
            System.err.println("Erro: " + e);
        }
    }

    // Método que atualiza os dados de um registro no banco de dados
    public static void removerId() {
        try {
                Connection conexao = MySQLConnector.conectar();
                String strSqlRemoverId = "delete from `db_senac`.`tbl_senac` where `id` = " + cbxId.getSelectedItem().toString() + ";";
                // System.out.println(strSqlRemoverId);
                Statement stmSqlRemoverId = conexao.createStatement();
                stmSqlRemoverId.addBatch(strSqlRemoverId);
                stmSqlRemoverId.executeBatch();
                stmSqlRemoverId.close();
                lblNotificacoes.setText("O id " + cbxId.getSelectedItem().toString() + " foi removido com sucesso!");
                limparCampos();
                popularIds();                
            } catch (Exception e) { 
                // Notifica o usuário em caso de erro
                lblNotificacoes.setText(setHtmlFormat("Não foi possível remover o id! Por favor, verifique e tente novamente."));
                System.err.println("Erro: " + e);
            }
        }

        // Limpa os campos de entrada
        public static void limparCampos() {
            txtNome.setText("");
            txtEmail.setText("");
            cbxId.setSelectedIndex(0);
        }

    // Atualiza os campos de entrada com os dados de um registro selecionado
    public static void atualizarCampos(boolean notificar) {
        try {
            // Verifica se um ID foi selecionado
            if (cbxId.getSelectedIndex() > 0) {
                Connection conexao = MySQLConnector.conectar();
                String strSqlAtualizarCampos = "select * from `db_senac`.`tbl_senac` where `id` = " + cbxId.getSelectedItem().toString() + ";";
                Statement stmSqlAtualizarCampos = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                ResultSet rstSqlAtualizarCampos = stmSqlAtualizarCampos.executeQuery(strSqlAtualizarCampos);                
                // Preenche os campos com os dados do registro
                if (rstSqlAtualizarCampos.next()) {
                    txtNome.setText(rstSqlAtualizarCampos.getString("nome"));
                    txtEmail.setText(rstSqlAtualizarCampos.getString("email"));
                    if (notificar == true) {
                    lblNotificacoes.setText("Campos atualizados com sucesso!");
                    }
                } else {
                        if (notificar == true) {
                        lblNotificacoes.setText("Ops! Não foi encontrado o id selecionado. Por favor, verifique e tente novamente.");
                    }
                }
                stmSqlAtualizarCampos.close();
            } else {
                if (notificar == true) {
                    lblNotificacoes.setText("Selecione um id para continuar.");
                    limparCampos();
                }
            }
        } catch (Exception e) {
            // Notifica em caso de erro
            lblNotificacoes.setText(setHtmlFormat("Não foi possível encontrar os ids! Por favor, verifique e tente novamente."));
            System.err.println("Erro: " + e);
        }
    }
    
}
