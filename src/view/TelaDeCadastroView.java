package view;
import controller.*;

//iportação da biblioteca
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TelaDeCadastroView extends JFrame // criação da classe que herda JFrame
{
    private final JLabel lblNome;
    private final JTextField txtNome;
    private final JLabel lblEmail;
    private final JTextField txtEmail;
    private final JLabel lblSenha;
    private final JPasswordField txtSenha;
    private final JButton btnCadastrar;
    private final JLabel lblNotificacoes;
    
    public TelaDeCadastroView() // construtor
    {
        super("Tela de Cadastro"); // titulo
        setLayout(new GridLayout(4, 2, 5, 5));  //estilo do layoute

        lblNome = new JLabel("Nome:");
        add(lblNome);

        txtNome = new JTextField(10);
        add(txtNome);

        lblEmail = new JLabel("Email:");
        add(lblEmail);

        txtEmail = new JTextField(10);
        add(txtEmail);

        lblSenha = new JLabel("Senha:");
        add(lblSenha);

        txtSenha = new JPasswordField(10);
        add(txtSenha);

        btnCadastrar = new JButton("Cadastrar");
        add(btnCadastrar);

        lblNotificacoes = new JLabel("Notificações", SwingConstants.CENTER);
        add(lblNotificacoes);

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
                    //Aqui devera ser chamado o metodo da controller de cadastro
                }
            }
        );

        setSize(300, 350); // tamanho da tela
        setVisible(true); //torna visivel a tela
    }

    private String setHtmlFormat(String strTexto) {
        return "<html><body>" + strTexto + "</body></html>"; // quebra de linha
    }

    public static void main(String[] args) {
        TelaDeCadastroView appTelaDeCadastroView = new TelaDeCadastroView();
        appTelaDeCadastroView.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
