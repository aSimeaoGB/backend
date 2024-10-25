import javax.swing.*;
import static java.nio.file.StandardCopyOption.*;
import java.nio.file.*;

public class MoveFile {
    public static void moverArquivo() {
        try {
            JFileChooser chooser = new JFileChooser();

            chooser.setDialogTitle("Selecione o arquivo que deseja mover");
            chooser.setApproveButtonText("Selecionar arquivo");
            int returnVal1 = chooser.showOpenDialog(null);
            String fileFullPath = "";
            String fileName = "";
            if(returnVal1 == JFileChooser.APPROVE_OPTION) {
                fileFullPath = chooser.getSelectedFile().getAbsolutePath();
                fileName = chooser.getSelectedFile().getName();
            } else {
                System.out.println("Que pena!");
            }

            chooser.setDialogTitle("Selecione a pasta de destino.");
            chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            chooser.setApproveButtonText("Mover aqui");
            int returnVal2 = chooser.showOpenDialog(null);
            String folderFullPath = "";
            if(returnVal2 == JFileChooser.APPROVE_OPTION) {
                folderFullPath = chooser.getSelectedFile().getAbsolutePath();
            } else {
                System.out.println("Que pena!");
            }

            Path pathOrigin = Paths.get(fileFullPath);
            Path pathDestination = Paths.get(folderFullPath + "\\" + fileName);
            if (fileFullPath.length() > 0 && folderFullPath.length() > 0) {
                Files.move(pathOrigin, pathDestination, REPLACE_EXISTING);
                System.out.println("Arquivo " + fileName + " movido com sucesso!");
            } else {
                System.out.println("Ops! Não foi possível mover o arquivo. Por favor, verifique e tente novamente.");
            }
        } catch (Exception e) {
            System.err.println("Não foi possível mover o arquivo! Tente novamente mais tarde.");
        }
    }
}