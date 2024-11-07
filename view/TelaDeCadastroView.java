package view;
import controller.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TelaDeCadastroView extends JFrame
{
    public static JLabel lblImagem;
    public static String nomeDoArquivo;

    public static JButton btnCarregar;
    public static JButton btnRemover;

    public static JLabel lblNome;
    public static JTextField txtNome;

    public static JLabel lblEmail;
    public static JTextField txtEmail;

    public static JLabel lblSenha;
    public static JPasswordField txtSenha;

    public static JButton btnCadastrar;

    public static JLabel lblNotificacoes;

    public static GridBagLayout gbLayout;
    public static GridBagConstraints gbConstraints;
    
    public TelaDeCadastroView()
    {
        super("Tela de Cadastro");
        gbLayout = new GridBagLayout();
        setLayout(gbLayout);
        gbConstraints = new GridBagConstraints();

        lblImagem = new JLabel("", SwingConstants.CENTER);
        lblImagem.setIcon(InterfaceController.imgPadrao);
        addComponent(lblImagem, 0, 0, 2, 2);

        btnCarregar = new JButton("Carregar");
        addComponent(btnCarregar, 2, 0, 1, 1);

        btnRemover = new JButton("Remover");
        addComponent(btnRemover, 2, 1, 1, 1);

        lblNome = new JLabel("Nome:");
        addComponent(lblNome, 3, 0, 1, 1);

        txtNome = new JTextField(10);
        addComponent(txtNome, 3, 1, 1, 1);

        lblEmail = new JLabel("Email:");
        addComponent(lblEmail, 4, 0, 1, 1);

        txtEmail = new JTextField(10);
        addComponent(txtEmail, 4, 1, 1, 1);

        lblSenha = new JLabel("Senha:");
        addComponent(lblSenha, 5, 0, 1, 1);

        txtSenha = new JPasswordField(10);
        addComponent(txtSenha, 5, 1, 1, 1);

        btnCadastrar = new JButton("Cadastrar");
        addComponent(btnCadastrar, 6, 0, 2, 1);

        lblNotificacoes = new JLabel("Notificações", SwingConstants.CENTER);
        addComponent(lblNotificacoes, 7, 0, 2, 1);

        btnCadastrar.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    if (txtNome.getText().trim().length() <= 0) {
                        lblNotificacoes.setText(setHtmlFormat("É necessário digitar um Nome para o cadastro. Por favor, digite um nome e tente novamente."));
                        txtNome.requestFocus();
                        return;
                    }

                    if (txtEmail.getText().trim().length() <= 0) {
                        lblNotificacoes.setText(setHtmlFormat("É necessário digitar um Email para o cadastro. Por favor, digite um Email e tente novamente."));
                        txtEmail.requestFocus();
                        return;
                    }

                    if (String.valueOf(txtSenha.getPassword()).trim().length() <= 0) {
                        lblNotificacoes.setText(setHtmlFormat("É necessário digitar uma Senha para o cadastro. Por favor, digite uma Senha e tente novamente."));
                        txtSenha.requestFocus();
                        return;
                    }

                    lblNotificacoes.setText(TelaDeCadastroController.cadastrarController(txtNome.getText(), txtEmail.getText(), String.valueOf(txtSenha.getPassword())));
                    // Aqui deverá ser chamado o método da controller de cadastro
                }
            }
        );

        btnCarregar.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    TelaDeCadastroController.carregarImagem();
                }
            }
        );

        btnRemover.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    TelaDeCadastroController.removerImagem();
                }
            }
        );

        setSize(220, 280);
        setVisible(true);
    }

    public void addComponent(Component component, int row, int column, int width, int height) {
        try {
            if (height > 1 && height > 1) {
                gbConstraints.fill = GridBagConstraints.BOTH;
            } else if (height > 1) {
                gbConstraints.fill = GridBagConstraints.VERTICAL;
            } else {
                gbConstraints.fill = GridBagConstraints.HORIZONTAL;
            }

            gbConstraints.gridy = row;
            gbConstraints.gridx = column;
            gbConstraints.gridwidth = width;
            gbConstraints.gridheight = height;
            gbLayout.setConstraints(component, gbConstraints);
            add(component);
        } catch (Exception e) {
            System.err.println("Erro: " + e);
        }
    }

    public static void notificarUsuario(String txt) {
        lblNotificacoes.setText(setHtmlFormat(txt));
    }

    public static String setHtmlFormat(String strTexto) {
        return "<html><body>" + strTexto + "</body></html>";
    }

    public static TelaDeCadastroView appTelaDeCadastroView;
    public static void main(String[] args) {
        appTelaDeCadastroView = new TelaDeCadastroView();
        appTelaDeCadastroView.setDefaultCloseOperation(EXIT_ON_CLOSE);

        appTelaDeCadastroView.getRootPane().addComponentListener(
            new ComponentAdapter() {
                public void componentResized(ComponentEvent e) {
                    int larguraTela = appTelaDeCadastroView.getWidth();
                    int alturaTela = appTelaDeCadastroView.getHeight();
                    notificarUsuario(String.format("Largura: %s, Altura: %s", larguraTela, alturaTela));
                }
            }
        );
    }
}