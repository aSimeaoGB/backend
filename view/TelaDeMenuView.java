package view;
import controller.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TelaDeMenuView extends JFrame {
    public JMenu cadastroMenu;
    public JMenu arquivoMenu;

    public JMenuItem novoItem;
    public JMenuItem pesquisarItem;
    public JMenuItem atualizarItem;
    public JMenuItem removerItem;

    public JMenuItem sobreItem;
    public JMenuItem sairItem;

    public JMenuBar barraDeMenu;

    public JLabel lblTelaDeMenu;

    public TelaDeMenuView() {
        super("Tela de Menu");

        barraDeMenu = new JMenuBar();

        arquivoMenu = new JMenu("Arquivo");
        cadastroMenu = new JMenu("Cadastro");

        sobreItem = new JMenuItem("Sobre");
        sairItem = new JMenuItem("Sair");

        novoItem = new JMenuItem("Novo");
        pesquisarItem = new JMenuItem("Pesquisar");
        atualizarItem = new JMenuItem("Atualizar");
        removerItem = new JMenuItem("Remover");

        lblTelaDeMenu = new JLabel("Tela de Menu", SwingConstants.CENTER);

        arquivoMenu.add(sobreItem);
        arquivoMenu.add(sairItem);

        cadastroMenu.add(novoItem);
        cadastroMenu.add(pesquisarItem);
        cadastroMenu.add(atualizarItem);
        cadastroMenu.add(removerItem);

        arquivoMenu.setMnemonic('A');
        sobreItem.setMnemonic('S');
        sairItem.setMnemonic('r');

        cadastroMenu.setMnemonic('C');
        novoItem.setMnemonic('N');
        pesquisarItem.setMnemonic('P');
        atualizarItem.setMnemonic('A');
        removerItem.setMnemonic('R');

        barraDeMenu.add(cadastroMenu);
        barraDeMenu.add(arquivoMenu);

        setJMenuBar(barraDeMenu);

        add(lblTelaDeMenu, BorderLayout.CENTER);

        sobreItem.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    JOptionPane.showMessageDialog(null, "Sistema de Cadastro Senac 2024");
                }
            }
        );

        sairItem.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    System.exit(0);
                }
            }
        );

        novoItem.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    TelaDeMenuController.abrirTelaDeCadastroView();
                }
            }
        );

        pesquisarItem.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    TelaDeMenuController.abrirTelaDePesquisaView();
                }
            }
        );

        atualizarItem.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    TelaDeMenuController.abrirTelaDeAtualizacaoView();
                }
            }
        );

        removerItem.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    TelaDeMenuController.abrirTelaDeRemoverView();
                }
            }
        );

        setSize(300,300);
        setVisible(true);
    }

    public static TelaDeMenuView appTelaDeMenuView;
    public static void main(String[] args) {
        appTelaDeMenuView = new TelaDeMenuView();
        appTelaDeMenuView.setDefaultCloseOperation(EXIT_ON_CLOSE);

        appTelaDeMenuView.addWindowListener(
            new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    InterfaceView.removerImagensInuteis();
                }
            }
        );

    }
}