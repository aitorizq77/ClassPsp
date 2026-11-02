import CrearHilosImpresora.Impresora;

/**
 * Clase principal que inicia las tres impresoras
 * para que trabajen simultáneamente.
 */


    public static void main(String[] args) {

        // Creamos las tres tareas de impresión.
        Impresora impresoraA = new Impresora("Impresora A", 3);
        Impresora impresoraB = new Impresora("Impresora B", 5);
        Impresora impresoraC = new Impresora("Impresora C", 4);

        // Creamos un hilo para cada impresora.
        Thread hiloA = new Thread(impresoraA);
        Thread hiloB = new Thread(impresoraB);
        Thread hiloC = new Thread(impresoraC);

        // Iniciamos los tres hilos.
        hiloA.start();
        hiloB.start();
        hiloC.start();
    }

