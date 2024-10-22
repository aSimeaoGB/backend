package controller;
import view.*;
import java.awt.event.*;

public class TelaDeMenuController extends TelaDeMenuView {
    public static void abrirTelaDeCadastroView() {
        TelaDeCadastroView.appTelaDeCadastroView = new TelaDeCadastroView();
        TelaDeCadastroView.appTelaDeCadastroView.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        appTelaDeMenuView.setVisible(false);

        TelaDeCadastroView.appTelaDeCadastroView.addWindowListener(
                new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    appTelaDeMenuView.setVisible(true);
                }
            }
        );
    }

    public static void abrirTelaDePesquisaView() {
        TelaDePesquisaView.appTelaDePesquisaView = new TelaDePesquisaView();
        TelaDePesquisaView.appTelaDePesquisaView.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        appTelaDeMenuView.setVisible(false);
    
        TelaDePesquisaView.appTelaDePesquisaView.addWindowListener(
                new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    appTelaDeMenuView.setVisible(true);
                }
            }
        );
    }

    public static void abrirTelaDeAtualizarView() {
        TelaDeAtualizacaoView.appTelaDeAtualizacaoView = new TelaDeAtualizacaoView();
        TelaDeAtualizacaoView.appTelaDeAtualizacaoView.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        appTelaDeMenuView.setVisible(false);
    
        TelaDeAtualizacaoView.appTelaDeAtualizacaoView.addWindowListener(
                new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    appTelaDeMenuView.setVisible(true);
                }
            }
        );
    }

    public static void abrirTelaDeRemoverView() {
        TelaDeRemoverView.appTelaDeRemoverView = new TelaDeRemoverView();
        TelaDeRemoverView.appTelaDeRemoverView.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        appTelaDeMenuView.setVisible(false);
    
        TelaDeRemoverView.appTelaDeRemoverView.addWindowListener(
                new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    appTelaDeMenuView.setVisible(true);
                }
            }
        );
    }
}
