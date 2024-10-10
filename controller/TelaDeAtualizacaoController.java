package controller;
import model.*;
import view.*;
import java.sql.*;
import java.util.*;

public class TelaDeAtualizacaoController extends TelaDeAtualizacaoView {
    // Método que populará uma lista de IDs a partir da base de dados
    public static void popularIds() {
        try {
            // Cria uma lista temporária para armazenar os IDs
            ArrayList<String> idsTemp = new ArrayList<>();
            idsTemp.add("Selecione aqui o id"); // Opção inicial

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
        } catch (Exception e) {
            // Notifica o usuário em caso de erro e registra o erro no console
            lblNotificacoes.setText(setHtmlFormat("Não foi possível encontrar os ids! Por favor, verifique e tente novamente."));
            System.err.println("Erro: " + e);
        }
    }

    // Método que atualiza os dados de um registro no banco de dados
    public static void atualizarId() {
        try {
            String atualizarNome = "";
            String atualizarEmail = "";
            String atualizarSenha = "";

            // Verifica se o nome foi alterado
            if (txtNome.getText().trim().equals(nomeAtual) == false) {
                atualizarNome = "`nome` = '" + txtNome.getText() + "'";
            }

            // Verifica se o email foi alterado
            if (txtEmail.getText().trim().equals(emailAtual) == false) {
                if (atualizarNome.length() > 0) {
                    atualizarEmail = " and ";
                }
                atualizarEmail += "`email` = '" + txtEmail.getText() + "'";
            }

            // Verifica se a senha foi alterada
            if (String.valueOf(txtSenha.getPassword()).trim().equals(senhaAtual) == false) {
                if (atualizarNome.length() > 0 || atualizarEmail.length() > 0) {
                    atualizarSenha = " and ";
                }
                atualizarSenha += "`senha` = '" + String.valueOf(txtSenha.getPassword()) + "'";            }

            // Se houver alterações, realiza a atualização no banco de dados
            if (atualizarNome.length() > 0 || atualizarEmail.length() > 0 || atualizarSenha.length() > 0) {
                Connection conexao = MySQLConnector.conectar();
                String strSqlAtualizarId = "update `db_senac`.`tbl_senac` set " + atualizarNome + atualizarEmail + atualizarSenha + " where `id` = " + cbxId.getSelectedItem().toString() + ";";
                Statement stmSqlAtualizarId = conexao.createStatement();
                stmSqlAtualizarId.addBatch(strSqlAtualizarId);
                stmSqlAtualizarId.executeBatch();
                
                // Atribuição de valores 
                nomeAtual = txtNome.getText();
                emailAtual = txtEmail.getText();
                senhaAtual = String.valueOf(txtSenha.getPassword());
                stmSqlAtualizarId.close();
                
                // Notifica o usuário sobre a atualização
                lblNotificacoes.setText("O id " + cbxId.getSelectedItem().toString() + " foi atualizado com sucesso!");
            } else {
                lblNotificacoes.setText("Não foram encontradas alterações para atualizar o id " + cbxId.getSelectedItem().toString());
            }
        } catch (Exception e) {
            // Notifica o usuário em caso de erro
            lblNotificacoes.setText(setHtmlFormat("Não foi possível atualizar o id! Por favor, verifique e tente novamente."));
            System.err.println("Erro: " + e);
        }
    }

    // Limpa os campos de entrada
    public static void limparCampos() {
        txtNome.setText("");
        txtEmail.setText("");
        txtSenha.setText("");
        cbxId.setSelectedIndex(0);
    }

    // Atualiza os campos de entrada com os dados de um registro selecionado
    public static void atualizarCampos(String id) {
        try {
            // Verifica se um ID foi selecionado
            if (cbxId.getSelectedIndex() > 0) {
                Connection conexao = MySQLConnector.conectar();
                String strSqlAtualizarCampos = "select * from `db_senac`.`tbl_senac` where `id` = " + id + ";";
                Statement stmSqlAtualizarCampos = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                ResultSet rstSqlAtualizarCampos = stmSqlAtualizarCampos.executeQuery(strSqlAtualizarCampos);
                
                // Preenche os campos com os dados do registro
                if (rstSqlAtualizarCampos.next()) {
                    txtNome.setText(rstSqlAtualizarCampos.getString("nome"));
                    nomeAtual = txtNome.getText();
                    txtEmail.setText(rstSqlAtualizarCampos.getString("email"));
                    emailAtual = txtEmail.getText();
                    txtSenha.setText(rstSqlAtualizarCampos.getString("senha"));
                    senhaAtual = String.valueOf(txtSenha.getPassword());
                    lblNotificacoes.setText("Campos atualizados com sucesso!");
                } else {
                    lblNotificacoes.setText("Ops! Não foi encontrado o id selecionado. Por favor, verifique e tente novamente.");
                }
                stmSqlAtualizarCampos.close();
            } else {
                lblNotificacoes.setText("Selecione um id para continuar.");
                limparCampos();
            }
        } catch (Exception e) {
            // Notifica em caso de erro
            lblNotificacoes.setText(setHtmlFormat("Não foi possível encontrar os ids! Por favor, verifique e tente novamente."));
            System.err.println("Erro: " + e);
        }
    }
    
}
