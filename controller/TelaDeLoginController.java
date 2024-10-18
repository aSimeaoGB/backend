package controller;
import model.*;
import view.*;

public class TelaDeLoginController extends TelaDeLoginView {
    public static void notificarUsuario(String textoNotificacao) {
        lblNotificacoes.setText(setHtmlFormat(textoNotificacao));
    }

    public static void logarController(String login, String senha) {
        TelaDeLoginModel.logarModel(login, senha);
    }
}
