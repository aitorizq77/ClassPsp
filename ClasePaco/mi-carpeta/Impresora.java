package CrearHilosImpresora;


/**
 * Clase que representa una impresora que trabaja en un hilo.
 * Cada impresora imprime un número determinado de páginas.
 */
public class Impresora implements Runnable {

    // Nombre de la impresora.
    private String nombre;

    // Número total de páginas que debe imprimir.
    private int numeroPaginas;

    /**
     * Constructor de la impresora.
     *
     * @param nombre Nombre de la impresora.
     * @param numeroPaginas Número de páginas que debe imprimir.
     */
    public Impresora(String nombre, int numeroPaginas) {
        this.nombre = nombre;
        this.numeroPaginas = numeroPaginas;
    }

    /**
     * Método que ejecuta la impresión de las páginas.
     */
    @Override
    public void run() {

        // Recorremos todas las páginas que tiene que imprimir.
        for (int pagina = 1; pagina <= numeroPaginas; pagina++) {

            // Mostramos la impresora y la página actual.
            System.out.println(nombre + " imprimiendo página "
                    + pagina + " de " + numeroPaginas);

            try {
                // Simulamos el tiempo necesario para imprimir una página.
                Thread.sleep(1000);

            } catch (InterruptedException e) {

                // Restablecemos el estado de interrupción del hilo.
                Thread.currentThread().interrupt();

                // Terminamos la impresión si el hilo es interrumpido.
                System.out.println(nombre + " ha sido interrumpida.");
                return;
            }
        }

        // Avisamos cuando termina de imprimir todas las páginas.
        System.out.println(nombre + " ha terminado de imprimir.");
    }
}
