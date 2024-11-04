package controller;

import model.*;
import view.*;
import java.io.*;
import java.util.*;
import javax.swing.*;


public class InterfaceController extends InterfaceView {
    
    // Caminho para a pasta local que contém as imagens da interface
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
        
    public static final Icon imgPadrao = new ImageIcon(InterfaceView.class.getResource("imagem-padrao.jpg"));

   
    public static void verificarApagarImagensInuteis() {
        final File folder = new File(localViewImgFolder);
        ArrayList<String> strImagens = listFilesForFolder(folder);
        InterfaceModel.validarImagens(strImagens);
    }

    public static ArrayList<String> listFilesForFolder(final File folder) {
        ArrayList<String> strFiles = new ArrayList<String>();
        // Itera sobre cada entrada no diretório especificado
        for (final File fileEntry : folder.listFiles()) {
            // Verifica se a entrada é um diretório, se sim, chama recursivamente a função
            if (fileEntry.isDirectory()) {
                listFilesForFolder(fileEntry);
            } else {
                // Adiciona o nome do arquivo à lista e imprime no console
                strFiles.add(fileEntry.getName());
                // System.out.println(fileEntry.getName());
            }
        }
        return strFiles;
    }
    
    public static String gerarNomeAleatorio() {
        return String.format("file-%d", Math.random());
    }
}