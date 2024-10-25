import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TelaDeMenu extends JFrame {
    public JMenu arquivoMenu;

    public JMenuItem abrirItem;
    public JMenuItem copiarItem;
    public JMenuItem moverItem;
    public JMenuItem apagarItem;
    public JMenuItem renomearItem;
    public JMenuItem sobreItem;
    public JMenuItem sairItem;

    public JMenuBar barraDeMenu;

    public JLabel lblTelaDeMenu;

    public TelaDeMenu() {
        super("Tela de Menu");

        barraDeMenu = new JMenuBar();

        arquivoMenu = new JMenu("Arquivo");

        sobreItem = new JMenuItem("Sobre");
        sairItem = new JMenuItem("Sair");

        abrirItem = new JMenuItem("Abrir");
        copiarItem = new JMenuItem("Copiar");
        moverItem = new JMenuItem("Mover");
        apagarItem = new JMenuItem("Apagar");
        renomearItem = new JMenuItem("Renomear");

        lblTelaDeMenu = new JLabel("Tela de Menu", SwingConstants.CENTER);

        arquivoMenu.add(abrirItem);
        arquivoMenu.add(copiarItem);
        arquivoMenu.add(moverItem);
        arquivoMenu.add(apagarItem);
        arquivoMenu.add(renomearItem);
        arquivoMenu.add(sobreItem);
        arquivoMenu.add(sairItem);

        arquivoMenu.setMnemonic('A');

        abrirItem.setMnemonic('b');
        copiarItem.setMnemonic('C');
        moverItem.setMnemonic('M');
        apagarItem.setMnemonic('p');
        renomearItem.setMnemonic('n');
        sobreItem.setMnemonic('S');
        sairItem.setMnemonic('r');

        barraDeMenu.add(arquivoMenu);

        setJMenuBar(barraDeMenu);

        add(lblTelaDeMenu, BorderLayout.CENTER);

        abrirItem.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    OpenFile.abrirArquivo();
                }
            }
        );

        copiarItem.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    CopyFile.copiarArquivo();
                }
            }
        );

        moverItem.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    MoveFile.moverArquivo();
                }
            }
        );

        apagarItem.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    DeleteFile.apagarArquivo();
                }
            }
        );

        renomearItem.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    RenameFile.renomearArquivo();
                }
            }
        );

        sobreItem.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    JOptionPane.showMessageDialog(null, "Manipulador de arquivos em java desktop");
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

        setSize(500,500);
        setVisible(true);
    }

    public static TelaDeMenu appTelaDeMenu;
    public static void main(String[] args) {
        appTelaDeMenu = new TelaDeMenu();
        appTelaDeMenu.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}