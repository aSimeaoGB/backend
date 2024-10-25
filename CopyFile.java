import javax.swing.*;
import static java.nio.file.StandardCopyOption.*;
import java.nio.file.*; // nio = imput e output

public class CopyFile {
    public static void copiarArquivo() {
        try {
            JFileChooser chooser = new JFileChooser();

            chooser.setDialogTitle("Selecione o arquivo que deseja copiar");
            chooser.setApproveButtonText("Copiar arquivo");
            int returnVal1 = chooser.showOpenDialog(null);
            String fileFullPath = "";
            String fileName = "";
            if (returnVal1 == JFileChooser.APPROVE_OPTION) {
                fileFullPath = chooser.getSelectedFile().getAbsolutePath();
            }
        }
    }
}
