package controller;
import model.*;
import view.*;
import java.awt.event.*;

public class TelaDeLoginController extends TelaDeLoginView {
    public static void notificarUsuario(String textoNotificacao) {
        lblNotificacoes.setText(setHtmlFormat(textoNotificacao));
    }

    public static void logarController(String login, String senha) {
        TelaDeLoginModel.logarModel(login, senha);
    }

    public static void abrirTelaDeMenu() {
        TelaDeMenuView.appTelaDeMenuView = new TelaDeMenuView();
        TelaDeMenuView.appTelaDeMenuView.setDefaultCloseOperation(EXIT_ON_CLOSE);

        // O método abaixo irá executar o método removerImagensInuteis() da classe InterfaceView, antes de fechar totalmente a tela de menu
        TelaDeMenuView.appTelaDeMenuView.addWindowListener(
            new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    InterfaceView.removerImagensInuteis();
                }
            }
        );

        InterfaceView.definirIcone(TelaDeMenuView.appTelaDeMenuView);

        appTelaDeLoginView.dispose();
    }
}