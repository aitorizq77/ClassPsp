package ClasePaco;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        try {
            //llamo al metodo que lanza el proceso

            ProcessBuilder pBuilder = new ProcessBuilder("ls", "-l");
            //creo nuevo proceso
            Process process = pBuilder.start();
            //Stream del proceso
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            reader.lines().forEach(System.out::println);
        }catch (Exception e) {
            e.printStackTrace();
    }
}
}
