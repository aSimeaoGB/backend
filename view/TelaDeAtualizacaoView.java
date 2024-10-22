package view;
import controller.*;

// Importaçao de biblioteca
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TelaDeAtualizacaoView extends JFrame { // Classe TelaDeAtualização que herdara a JFrame
    
    // Declaração dos componentes da interface
    public static JLabel lblId;  // Rótulo para ID
    public static JComboBox<String> cbxId;  // ComboBox para seleção de ID
    public static String[] ids;  // Array de IDs

    public static JLabel lblNome;  // Rótulo para Nome
    public static JTextField txtNome;  // Campo de texto para Nome
    public static String nomeAtual;  // Nome atual do registro

    public static JLabel lblEmail;  // Rótulo para Email
    public static JTextField txtEmail;  // Campo de texto para Email
    public static String emailAtual;  // Email atual do registro

    public static JLabel lblSenha;  // Rótulo para Senha
    public static JPasswordField txtSenha;  // Campo de senha para Senha
    public static String senhaAtual;  // Senha atual do registro

    public static JLabel lblNotificacoes;  // Rótulo para mensagens de notificação

    public static JButton btnAtualizar;  // Botão para atualizar o registro
    public static JButton btnCancelar;  // Botão para cancelar a operação

    public static int tamanhoInputs = 20;  // Tamanho padrão dos campos de entrada

    // Construtor da classe
    public TelaDeAtualizacaoView() {
        super("Tela de Atualização");  // Título da janela
        setLayout(new GridLayout(6, 1, 5, 5));  // Layout da tela

        // Painel para entrada de ID
        JPanel linha_id = new JPanel(new GridLayout(1, 2));
        lblId = new JLabel("Id:", SwingConstants.RIGHT);  // Rótulo do ID
        linha_id.add(lblId);

        // Popula os IDs a partir da base de dados
        TelaDeAtualizacaoController.popularIds();
        cbxId = new JComboBox<String>(ids);  // ComboBox com os IDs
        linha_id.add(cbxId);

        add(linha_id);  // Adiciona o painel à tela

        // Painel para entrada de Nome
        JPanel linha_nome = new JPanel(new GridLayout(1, 2));
        lblNome = new JLabel("Nome:", SwingConstants.RIGHT);  // Rótulo do Nome
        linha_nome.add(lblNome);

        txtNome = new JTextField(tamanhoInputs);  // Campo de texto para Nome
        linha_nome.add(txtNome);

        add(linha_nome);  // Adiciona o painel à tela

        // Painel para entrada de Email
        JPanel linha_email = new JPanel(new GridLayout(1, 2));

        lblEmail = new JLabel("Email:", SwingConstants.RIGHT);  // Rótulo do Email
        linha_email.add(lblEmail);

        txtEmail = new JTextField(tamanhoInputs);  // Campo de texto para Email
        linha_email.add(txtEmail);

        add(linha_email);  // Adiciona o painel à tela

        // Painel para entrada de Senha
        JPanel linha_senha = new JPanel(new GridLayout(1, 2));

        lblSenha = new JLabel("Senha:", SwingConstants.RIGHT);  // Rótulo da Senha
        linha_senha.add(lblSenha);

        txtSenha = new JPasswordField(tamanhoInputs);  // Campo de senha para Senha
        linha_senha.add(txtSenha);

        add(linha_senha);  // Adiciona o painel à tela

        // Painel para botões
        JPanel linha_botoes = new JPanel(new GridLayout(1, 2));

        btnAtualizar = new JButton("Atualizar");  // Botão de Atualizar
        linha_botoes.add(btnAtualizar);

        btnCancelar = new JButton("Cancelar");  // Botão de Cancelar
        linha_botoes.add(btnCancelar);

        add(linha_botoes);  // Adiciona o painel à tela

        // Painel para notificações
        JPanel linha_notificacoes = new JPanel(new GridLayout(1, 1));

        lblNotificacoes = new JLabel("Notificações", SwingConstants.CENTER);  // Rótulo de notificações
        linha_notificacoes.add(lblNotificacoes);

        add(linha_notificacoes);  // Adiciona o painel à tela

        // Ação do botão Atualizar
        btnAtualizar.addActionListener(
            new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                TelaDeAtualizacaoController.atualizarId();  // Chama o método para atualizar o registro
            }
        });

        // Ação do botão Cancelar
        btnCancelar.addActionListener(
            new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                TelaDeAtualizacaoController.limparCampos();  // Chama o método para limpar os campos
            }
        });

        // Ação quando um item é selecionado no ComboBox
        cbxId.addItemListener(
            new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent event) {
                if (event.getStateChange() == ItemEvent.SELECTED) {
                    TelaDeAtualizacaoController.atualizarCampos(cbxId.getSelectedItem().toString());  // Atualiza os campos com os dados do ID selecionado
                }
            }
        });

        // Configurações da janela
        setSize(250, 300);  // Tamanho da janela
        setVisible(true);  // Torna a janela visível
        cbxId.requestFocus();  // Foca no ComboBox de IDs
    }

    // Método para formatar texto em HTML
    public static String setHtmlFormat(String strTexto) {
        return "<html><body>" + strTexto + "</body></html>";  // Retorna o texto formatado
    }

    

    // Método principal para execução da aplicação
    public static TelaDeAtualizacaoView appTelaDeAtualizacaoView;
    public static void main(String[] args) {
        appTelaDeAtualizacaoView = new TelaDeAtualizacaoView();  // Cria uma nova instância da tela
        appTelaDeAtualizacaoView.setDefaultCloseOperation(EXIT_ON_CLOSE);  // Define a operação de fechamento
    }
}
