package view;
import javax.swing.*;
import controller.*;
import javax.imageio.*;
import java.awt.image.*;
import java.io.*;

public class InterfaceView extends JFrame {
    public static void definirIcone(JFrame frame) {
        try {
            InputStream imageInputStream = frame.getClass().getResourceAsStream("senac-logo.png");
            BufferedImage bufferedImage = ImageIO.read(imageInputStream);
            frame.setIconImage(bufferedImage);
        } catch (Exception e) {
            System.err.println("Erro: " + e);
        }
    }

    public static void removerImagensInuteis() {
        InterfaceController.verificarApagarImagensInuteis();
    }
}