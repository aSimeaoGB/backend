package view;
import controller.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TelaDeAtualizacaoView extends JFrame {
    public static JLabel lblId;
    public static JComboBox<String> cbxId;
    public static String[] ids;

    public static JLabel lblImagem;
    public static JButton btnCarregarImagem;
    public static JButton btnRemoverImagem;
    public static final JTextField txtImagem = new JTextField();

    public static JLabel lblNome;
    public static JTextField txtNome;
    public static String nomeAtual;

    public static JLabel lblEmail;
    public static JTextField txtEmail;
    public static String emailAtual;

    public static JLabel lblSenha;
    public static JPasswordField txtSenha;
    public static String senhaAtual;

    public static JLabel lblNotificacoes;

    public static JButton btnAtualizar;
    public static JButton btnCancelar;

    public static int tamanhoInputs = 20;

    public static GridBagLayout gbLayout;
    public static GridBagConstraints gbConstraints;

    public TelaDeAtualizacaoView()
    {
        super("Tela de Atualização");
        gbLayout = new GridBagLayout();
        setLayout(gbLayout);
        gbConstraints = new GridBagConstraints();

        lblId = new JLabel("Id:", SwingConstants.RIGHT);
        addComponent(lblId,0,1,1,1);

        TelaDeAtualizacaoController.popularIds();
        cbxId = new JComboBox<String>(ids);
        addComponent(cbxId,0,2,1,1);

        lblImagem = new JLabel(InterfaceController.imgPadrao);
        addComponent(lblImagem, 0, 0, 1, 7);

        btnCarregarImagem = new JButton("Carregar Imagem");
        addComponent(btnCarregarImagem, 1, 1, 1, 1);

        btnRemoverImagem = new JButton("Remover Imagem");
        addComponent(btnRemoverImagem, 1, 2, 1, 1);

        lblNome = new JLabel("Nome:", SwingConstants.RIGHT);
        addComponent(lblNome, 2, 1, 1, 1);

        txtNome = new JTextField(tamanhoInputs);
        addComponent(txtNome, 2, 2, 1, 1);

        lblEmail = new JLabel("Email:", SwingConstants.RIGHT);
        addComponent(lblEmail, 3, 1, 1, 1);

        txtEmail = new JTextField(tamanhoInputs);
        addComponent(txtEmail, 3, 2, 1, 1);

        lblSenha = new JLabel("Senha:", SwingConstants.RIGHT);
        addComponent(lblSenha, 4, 1, 1, 1);

        txtSenha = new JPasswordField(tamanhoInputs);
        addComponent(txtSenha, 4, 2, 1, 1);

        btnAtualizar = new JButton("Atualizar");
        addComponent(btnAtualizar, 5, 1, 1, 1);

        btnCancelar = new JButton("Cancelar");
        addComponent(btnCancelar, 5, 2, 1, 1);

        lblNotificacoes = new JLabel("Notificações", SwingConstants.CENTER);
        addComponent(lblNotificacoes, 6, 1, 2, 1);

        btnAtualizar.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    TelaDeAtualizacaoController.atualizarId();
                }
            }
        );

        btnCancelar.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    TelaDeAtualizacaoController.limparCampos();
                }
            }
        );

        cbxId.addItemListener(
            new ItemListener() {
            @Override
                public void itemStateChanged(ItemEvent event) {
                    if (event.getStateChange() == ItemEvent.SELECTED) {
                        TelaDeAtualizacaoController.atualizarCampos(String.valueOf(cbxId.getSelectedItem()));
                    }
                } 
            }
        );

        btnCarregarImagem.addActionListener(
            new ActionListener() {
            @Override
                public void actionPerformed(ActionEvent event) {
                    TelaDeAtualizacaoController.carregarImagem();
                } 
            }
        );

        btnRemoverImagem.addActionListener(
            new ActionListener() {
            @Override
                public void actionPerformed(ActionEvent event) {
                    TelaDeAtualizacaoController.removerImagem();
                } 
            }
        );

        setSize(450, 200);
        ImageIcon img = new ImageIcon("./senac-logo.png");
        setIconImage(img.getImage());
        setVisible(true);
        cbxId.requestFocus();
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

    public static String setHtmlFormat(String strTexto) {
        return "<html><body>" + strTexto + "</body></html>";
    }

    public static TelaDeAtualizacaoView appTelaDeAtualizacaoView;
    public static void main(String[] args) {
        appTelaDeAtualizacaoView = new TelaDeAtualizacaoView();
        appTelaDeAtualizacaoView.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}