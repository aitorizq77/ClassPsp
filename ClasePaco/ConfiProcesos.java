package ClasePaco;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

public class ConfiProcesos {
    public static void main(String[] args) {
//capurar directorios del sistema
        String userHome = System.getProperty("user.home");
        String usarDir = System.getProperty("user.dir");
        //pantalla
        System.out.println(("Directorio de usuario: " + userHome));
        System.out.println(("Directorio de trabajo: " + usarDir));
        try {
 ProcessBuilder pBuilder = new ProcessBuilder("ls", "-l");
 pBuilder.directory(new File(userHome));
 //creo nuevo proceso
            BufferedReader reader = new BufferedReader(new InputStreamReader(pBuilder.start().getInputStream()));
            reader.lines().forEach(System.out::println);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
