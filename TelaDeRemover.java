// Importaçao de biblioteca
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TelaDeRemover extends JFrame { // Classe TelaDeAtualização que herdara a JFrame
    
    // Declaração dos componentes da interface
    public static JLabel lblId;  // Rótulo para ID
    public static JComboBox<String> cbxId;  // ComboBox para seleção de ID
    public static String[] ids;  // Array de IDs

    public static JLabel lblNome;  // Rótulo para Nome
    public static JTextField txtNome;  // Campo de texto para Nome

    public static JLabel lblEmail;  // Rótulo para Email
    public static JTextField txtEmail;  // Campo de texto para Email

    public static JLabel lblNotificacoes;  // Rótulo para mensagens de notificação

    public static JButton btnRemover;  // Botão para atualizar o registro
    public static JButton btnCancelar;  // Botão para cancelar a operação

    public static int tamanhoInputs = 20;  // Tamanho padrão dos campos de entrada

    // Construtor da classe
    public TelaDeRemover() {
        super("Tela de Atualização");  // Título da janela
        setLayout(new GridLayout(5, 1, 5, 5));  // Layout da tela

        // Painel para entrada de ID
        JPanel linha_id = new JPanel(new GridLayout(1, 2));
        lblId = new JLabel("Id:", SwingConstants.RIGHT);  // Rótulo do ID
        linha_id.add(lblId);

        // Popula os IDs a partir da base de dados
        NavegadorDeRegistro.popularIds();
        cbxId = new JComboBox<String>(ids);  // ComboBox com os IDs
        linha_id.add(cbxId);

        add(linha_id);  // Adiciona o painel à tela

        // Painel para entrada de Nome
        JPanel linha_nome = new JPanel(new GridLayout(1, 2));
        lblNome = new JLabel("Nome:", SwingConstants.RIGHT);  // Rótulo do Nome
        linha_nome.add(lblNome);

        txtNome = new JTextField(tamanhoInputs);  // Campo de texto para Nome
        txtNome.setEditable(false);  // Campo de texto para Nome não editável
        linha_nome.add(txtNome);

        add(linha_nome);  // Adiciona o painel à tela

        // Painel para entrada de Email
        JPanel linha_email = new JPanel(new GridLayout(1, 2));

        lblEmail = new JLabel("Email:", SwingConstants.RIGHT);  // Rótulo do Email
        linha_email.add(lblEmail);

        txtEmail = new JTextField(tamanhoInputs);  // Campo de texto para Email
        txtEmail.setEditable(false); // Campo de texto para Email não editável
        linha_email.add(txtEmail);

        add(linha_email);  // Adiciona o painel à tela

        // Painel para botões
        JPanel linha_botoes = new JPanel(new GridLayout(1, 2));

        btnRemover = new JButton("Remover");  // Botão de Remoção
        linha_botoes.add(btnRemover);

        btnCancelar = new JButton("Cancelar");  // Botão de Cancelar
        linha_botoes.add(btnCancelar);

        add(linha_botoes);  // Adiciona o painel à tela

        // Painel para notificações
        JPanel linha_notificacoes = new JPanel(new GridLayout(1, 1));

        lblNotificacoes = new JLabel("Notificações", SwingConstants.CENTER);  // Rótulo de notificações
        linha_notificacoes.add(lblNotificacoes);

        add(linha_notificacoes);  // Adiciona o painel à tela

        // Ação do botão Atualizar
        btnRemover.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    NavegadorDeRegistro.removerId();  // Chama o método para atualizar o registro
                }
            }
        );

        // Ação do botão Cancelar
        btnCancelar.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    NavegadorDeRegistro.limparCampos();  // Chama o método para limpar os campos
                }
            }
        );

        // Ação quando um item é selecionado no ComboBox
        cbxId.addItemListener(
            new ItemListener() {
            @Override
                public void itemStateChanged(ItemEvent event) {
                    if (event.getStateChange() == ItemEvent.SELECTED) {
                        NavegadorDeRegistro.atualizarCampos(false);  // Atualiza os campos com os dados do ID selecionado
                    }
                }
            }
        );

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
    public static void main(String[] args) {
        TelaDeRemover appTelaDeRemover = new TelaDeRemover();  // Cria uma nova instância da tela
        appTelaDeRemover.setDefaultCloseOperation(EXIT_ON_CLOSE);  // Define a operação de fechamento
    }
}
