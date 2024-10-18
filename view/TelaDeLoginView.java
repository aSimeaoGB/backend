package view;
import controller.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TelaDeLoginView extends JFrame
{
    private final JLabel lblLogin;
    public final JTextField txtLogin;

    private final JLabel lblSenha;
    public final JPasswordField txtSenha;
    
    private final JButton btnEntrar;

    public static JLabel lblNotificacoes;

    public TelaDeLoginView()
    {
        super("Tela de Login");
        setLayout(new FlowLayout());

        lblLogin = new JLabel("Login:");
        add(lblLogin);

        txtLogin = new JTextField(10);
        add(txtLogin);

        lblSenha = new JLabel("Senha:");
        add(lblSenha);

        txtSenha = new JPasswordField(10);
        add(txtSenha);

        btnEntrar = new JButton("Entrar");
        add(btnEntrar);

        lblNotificacoes = new JLabel("Notificações", SwingConstants.CENTER);
        add(lblNotificacoes);

        btnEntrar.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    TelaDeLoginController.logarController(txtLogin.getText(), String.valueOf(txtSenha.getPassword()));
                }
            }
        );

        setSize(150, 200);
        setVisible(true);
    }
    public static String setHtmlFormat(String strTexto){
        return "<html><body>" + strTexto + "</body></html>";
    }

    public static TelaDeLoginView appTelaDeLoginView;
    public static void main(String[] args) {
        appTelaDeLoginView = new TelaDeLoginView();
        appTelaDeLoginView.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}

