package EstadosDeUnProceso;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


    public class EstadosDeUnProceso {

        public static void main(String[] args) {

            // Creamos el proceso que ejecutara el comando ping.
            ProcessBuilder constructor = new ProcessBuilder("ping", "-c", "4", "localhost");

            try {

                // Iniciamos el proceso.
                Process proceso = constructor.start();

                // Comprobamos si el proceso sigue vivo.
                System.out.println("¿El proceso está vivo?: " + proceso.isAlive());

                // Mostramos información del proceso.
                System.out.println("PID: " + proceso.pid());
                System.out.println("Comando: " + constructor.command());
                System.out.println("Argumentos: " + constructor.command().subList(1, constructor.command().size()));
                System.out.println("Usuario: " + proceso.info().user().orElse("Desconocido"));

                // Leemos y mostramos el resultado del ping.
                BufferedReader lector = new BufferedReader(
                        new InputStreamReader(proceso.getInputStream())
                );

                String linea;

                System.out.println("\nResultado del ping:");

                while ((linea = lector.readLine()) != null) {
                    System.out.println(linea);
                }

                // Esperamos a que el proceso termine.
                int resultado = proceso.waitFor();

                System.out.println("\nEl proceso ha finalizado.");
                System.out.println("Código de salida: " + resultado);

                // Comprobamos si continúa vivo después de finalizar.
                System.out.println("¿El proceso sigue vivo?: " + proceso.isAlive());

            } catch (IOException e) {

                // Controlamos errores al iniciar o leer el proceso.
                System.out.println("Error al ejecutar el proceso: " + e.getMessage());

            } catch (InterruptedException e) {

                // Controlamos si el hilo principal es interrumpido.
                System.out.println("El proceso ha sido interrumpido.");
                Thread.currentThread().interrupt();

            }
        }
    }


