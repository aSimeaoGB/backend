package controller;
import view.*;
import model.*;
import static java.nio.file.StandardCopyOption.*;
import java.nio.file.*;
import javax.swing.*;
import java.awt.*;

public class TelaDeCadastroController extends TelaDeCadastroView {
    public static String[] retornoUsuario = {
        "Email já cadastrado! Favor digitar outro email e tentar novamente.", // resposta 0
        "Não foi possível realizar o seu cadastro, por uma falha no servidor! Por favor, tente novamente mais tarde.", // resposta 1
        "Cadastro realizado com sucesso" // resposta 2
    };

    public static String cadastrarController(String nome, String email, String senha) {
        return retornoUsuario[TelaDeCadastroModel.cadastrarModel(nome, email, senha, nomeDoArquivo)];
    }

    public static void carregarImagem() {
        // aqui vai carregar a imagem para a tela de atualização
        String fileName = "";
        String newFileName = "";
        try {
            JFileChooser chooser = new JFileChooser();

            chooser.setDialogTitle("Selecione o arquivo que deseja carregar");
            chooser.setApproveButtonText("Carregar arquivo");
            int returnVal1 = chooser.showOpenDialog(null);
            String fileFullPath = "";
            if (returnVal1 == JFileChooser.APPROVE_OPTION) {
                fileFullPath = chooser.getSelectedFile().getAbsolutePath();
                fileName = chooser.getSelectedFile().getName();
            } else {
                System.out.println("Que pena!");
                return;
            }

            String folderFullPath = InterfaceController.localViewImgFolder;

            newFileName = InterfaceController.gerarNomeAleatorio() + "-" + fileName;

            Path pathOrigin = Paths.get(fileFullPath);
            Path pathDestination = Paths.get(folderFullPath + "\\" + newFileName);
            if (fileFullPath.length() > 0 && folderFullPath.length() > 0) {
                Files.copy(pathOrigin, pathDestination, REPLACE_EXISTING);
                System.out.println("Arquivo " + fileName + " copiado/colado com sucesso!");
            } else {
                System.out.println("Ops! Não foi possível copiar o arquivo. Por favor, verifique e tente novamente.");
            }
        } catch (Exception e) {
            System.err.println("Não foi possível copiar o arquivo! Tente novamente mais tarde.");
        }

        Icon imgCarregada = new ImageIcon(new ImageIcon(InterfaceController.localViewImgFolder + "\\" + newFileName).getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));

        lblImagem.setIcon(imgCarregada);
        nomeDoArquivo = newFileName;
    }

    public static void removerImagem() {
        nomeDoArquivo = "";
        lblImagem.setIcon(InterfaceController.imgPadrao);
    }
}