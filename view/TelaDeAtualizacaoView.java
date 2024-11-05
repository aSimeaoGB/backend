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
        gbConstraints = new GridBagConstraints(); // define o valor 
        //setLayout(new GridLayout(7,1,5,5));

        lblId = new JLabel("Id:", SwingConstants.RIGHT);
        //gbConstraints.fill = GridBagConstraints.HORIZONTAL;
        addComponent(lblId, 0,1,1,1);

        TelaDeAtualizacaoController.popularIds();
        cbxId = new JComboBox<String>(ids);
        //gbConstraints.fill = GridBagConstraints.HORIZONTAL;
        addComponent(cbxId, 0,2,1,1);

        lblImagem = new JLabel(InterfaceController.imgPadrao);
        addComponent(lblImagem, 0,0,1,7);        

        btnCarregarImagem = new JButton("Carregar Imagem");
        //gbConstraints.fill = GridBagConstraints.HORIZONTAL;
        addComponent(btnCarregarImagem, 1,1,1,1);

        btnRemoverImagem = new JButton("Remover Imagem");
        //gbConstraints.fill = GridBagConstraints.HORIZONTAL;
        addComponent(btnRemoverImagem, 1,2,1,1);        

        lblNome = new JLabel("Nome:", SwingConstants.RIGHT);
        //gbConstraints.fill = GridBagConstraints.HORIZONTAL;
        addComponent(lblNome, 2,1,1,1);

        txtNome = new JTextField(tamanhoInputs);
        gbConstraints.fill = GridBagConstraints.HORIZONTAL;
        addComponent(txtNome, 2,2,1,1);

        lblEmail = new JLabel("Email:", SwingConstants.RIGHT);
        //gbConstraints.fill = GridBagConstraints.HORIZONTAL;
        addComponent(lblEmail, 3,1,1,1);

        txtEmail = new JTextField(tamanhoInputs);
        //gbConstraints.fill = GridBagConstraints.HORIZONTAL;
        addComponent(txtEmail, 3,2,1,1);

        lblSenha = new JLabel("Senha:", SwingConstants.RIGHT);
        //gbConstraints.fill = GridBagConstraints.HORIZONTAL;
        addComponent(lblSenha, 4,1,1,1);

        txtSenha = new JPasswordField(tamanhoInputs);
       // gbConstraints.fill = GridBagConstraints.HORIZONTAL;
        addComponent(txtSenha, 4,2,1,1);

        btnAtualizar = new JButton("Atualizar");
        //gbConstraints.fill = GridBagConstraints.HORIZONTAL;
        addComponent(btnAtualizar,5,1,1,1);

        btnCancelar = new JButton("Cancelar");
        //gbConstraints.fill = GridBagConstraints.HORIZONTAL;
        addComponent(btnCancelar, 5,2,1,1);

        lblNotificacoes = new JLabel("Notificações", SwingConstants.CENTER);
        //gbConstraints.fill = GridBagConstraints.HORIZONTAL;
        addComponent(lblNotificacoes, 6,1,2,1);

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
                        TelaDeAtualizacaoController.atualizarCampos(cbxId.getSelectedItem().toString());
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

    public static String setHtmlFormat(String strTexto) {
        return "<html><body>" + strTexto + "</body></html>";
    }

    public void addComponent(Component component, int row, int column, int width, int height) {
        if (height > 1){
            gbConstraints.fill = GridBagConstraints.BOTH;
        } else {
            gbConstraints.fill = GridBagConstraints.HORIZONTAL;
        }
        // onde
        gbConstraints.gridy = row; // define a posição Y (vertical) linhas
        gbConstraints.gridx = column; // define a posição X (horizontal) colunas
        // o que e como
        gbConstraints.gridwidth = width; //
        gbConstraints.gridheight = height; // define a altura em relação a grade
        gbLayout.setConstraints(component, gbConstraints); 
        add(component);
    }

    public static TelaDeAtualizacaoView appTelaDeAtualizacaoView;
    public static void main(String[] args) {
        appTelaDeAtualizacaoView = new TelaDeAtualizacaoView();
        appTelaDeAtualizacaoView.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}