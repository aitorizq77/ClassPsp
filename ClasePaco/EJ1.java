package ClasePaco;
import java.io.IOException;
public class EJ1 {




        public static void main(String[] args) {

            try {
                // Obtener el sistema operativo
                String sistemaOperativo = System.getProperty("os.name").toLowerCase();

                String comando;
                String directorio;

                // Comprobar si estamos en Windows o Linux
                if (sistemaOperativo.contains("win")) {

                    comando = "cmd /c dir";
                    directorio = "C:/temp";

                } else if (sistemaOperativo.contains("linux")) {

                    comando = "sh -c ls";
                    directorio = "/tmp";

                } else {
                    System.out.println("Sistema operativo no compatible.");
                    return;
                }

                // Separar el comando en partes
                String[] comandoSeparado = comando.split("\\s");

                // Crear el proceso
                ProcessBuilder proceso = new ProcessBuilder(comandoSeparado);

                // Cambiar el directorio de trabajo
                proceso.directory(new java.io.File(directorio));

                // Ejecutar el proceso
                Process procesoEjecutado = proceso.start();

                // Esperar a que termine
                procesoEjecutado.waitFor();

                // Mostrar el resultado
                java.io.BufferedReader lector = new java.io.BufferedReader(
                        new java.io.InputStreamReader(procesoEjecutado.getInputStream())
                );

                String linea;

                while ((linea = lector.readLine()) != null) {
                    System.out.println(linea);
                }

            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

