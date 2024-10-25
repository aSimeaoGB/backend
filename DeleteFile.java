import javax.swing.*;
import java.nio.file.*;

public class DeleteFile {
    public static void apagarArquivo() {
        try {
            JFileChooser chooser = new JFileChooser();

            chooser.setDialogTitle("Selecione o arquivo que deseja apagar");
            chooser.setApproveButtonText("apagar arquivo");
            int returnVal1 = chooser.showOpenDialog(null);
            String fileFullPath = "";
            if (returnVal1 == JFileChooser.APPROVE_OPTION) {
                fileFullPath = chooser.getSelectedFile().getAbsolutePath();
            } else {
                System.out.println("Que pena!");
            }

            Path pathOrigin = Paths.get(fileFullPath);
            Files.delete(pathOrigin);
            System.out.println("Arquivo apagado com sucesso!");
        } catch (Exception e) {
            System.err.println("Não foi possível apagar o arquivo.");
        }
    }
}
