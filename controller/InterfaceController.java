package controller;
import model.*;
import view.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;

public class InterfaceController extends InterfaceView {
    public static final String localViewImgFolder = System.getProperty("user.dir") 
        + "\\" 
        + "src"
        + "\\" 
        + "view"
        + "\\"
        + "img";

    public static final String localViewFolder = System.getProperty("user.dir") 
        + "\\" 
        + "src"
        + "\\" 
        + "view";

    public static final Icon imgPadrao = new ImageIcon(new ImageIcon(localViewFolder + "\\imagem-padrao.png").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));

    public static void verificarApagarImagensInuteis() {
        final File folder = new File(localViewImgFolder);
        ArrayList<String> strImagens = listFilesForFolder(folder);
        InterfaceModel.validarImagens(strImagens);
    }

    public static ArrayList<String> listFilesForFolder(final File folder) {
        ArrayList<String> strFiles = new ArrayList<String>();
        for (final File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                listFilesForFolder(fileEntry);
            } else {
                strFiles.add(fileEntry.getName());
            }
        }
        return strFiles;
    }

    public static String gerarNomeAleatorio() {
        return String.format("file-%s", Math.random());
    }

    public static void addComponent(JFrame frame, GridBagLayout gbLayout, GridBagConstraints gbConstraints, Component component, int row, int column, int width, int height) {
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
            frame.add(component);
        } catch (Exception e) {
            System.err.println("Erro: " + e);
        }
    }
}