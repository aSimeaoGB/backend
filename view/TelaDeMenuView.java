package view;
import controller.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TelaDeMenuView extends JFrame {
    public JMenu cadastroMenu;

    public JMenuItem novoItem;
    public JMenuItem pesquisarItem;
    public JMenuItem atualizarItem;
    public JMenuItem removerItem;
    
    public JMenuBar barraDeMeunu;

    public JLabel lblTelaDeMenu;

    public TelaDeMenuView() {
        super("Menu Principal"); // título
        
        barraDeMeunu = new JMenuBar();

        cadastroMenu = new JMenu("Cadastro");
        
        novoItem = new JMenuItem("Novo");
        pesquisarItem = new JMenuItem("Pesquisar");
        atualizarItem = new JMenuItem("Atualizar");
        removerItem = new JMenuItem("Remover");

        lblTelaDeMenu = new JLabel("Tela De Menu", SwingConstants.CENTER);

        cadastroMenu.add(novoItem);
        cadastroMenu.add(pesquisarItem);
        cadastroMenu.add(atualizarItem);
        cadastroMenu.add(removerItem);

        cadastroMenu.setMnemonic('C');
        novoItem.setMnemonic('N');
        pesquisarItem.setMnemonic('P');
        atualizarItem.setMnemonic('A');
        removerItem.setMnemonic('R');
    
        barraDeMeunu.add(cadastroMenu);

        setJMenuBar(barraDeMeunu);

        add(lblTelaDeMenu, BorderLayout.CENTER);

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
                    TelaDeMenuController.abrirTelaDeAtualizarView();
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

        setSize(300, 300);
        setVisible(true);
    }

    public static TelaDeMenuView appTelaDeMenuView;
    public static void main(String[] args) {
        appTelaDeMenuView = new TelaDeMenuView();
        appTelaDeMenuView.setDefaultCloseOperation(EXIT_ON_CLOSE);

    }
}
