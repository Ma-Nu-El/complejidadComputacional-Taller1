package jose.manu.camilo;
/**
 * @author Sepúlveda-Jose_Fuica-Manuel_Hijerra-Camilo
 */


public class Main {

    public static CSVreader csvReader;

    public static void main(String args[]) {
        // Método de ordenamiento QuickSort3.
        quickSort();

        //Método de ordenamiento InsertionSort.
        insertSort();

        //Insertar Cola.
        queue theQueue = insertarCola();
        //Eliminar Cola.
        eliminarCola(theQueue, 18249);

    }

    public static void quickSort() {
        int nElements = 18249;
        /*
        Se declaran las variables para calcular el tiempo.
         */
        long TInicioQ1, TFinQ1, tiempoQ1; //Variables para determinar el tiempo de ejecución

        CSVreader var = new CSVreader();
        // importar el archivo '.csv' a un arreglo de
        String[][] matrizCargada = var.csvAArreglo();
        String[] arregloVolumen = new String[nElements];
        double[] arregloVolumenInt = new double[nElements];

        for (int i = 0; i < matrizCargada.length; i++) {
            arregloVolumen[i] = matrizCargada[i][3];
        }
        for (int i = 0; i < 10; i++) {
            arregloVolumenInt[i] = Double.valueOf(arregloVolumen[i]);
        }
        /* EN ESTE PASO SE ORDENARÁ UN ARREGLO AUXILIAR CON EL METODO DE ORNDENAMIENTO QUICKSORT3,
        LUEGO MEDIANTE COMPARACIONES SE ORDENARAN LAS FILAS DE LA MATRIZ INICIAL*/
        QuickSort3 Q3 = new QuickSort3(nElements);
        Q3 = llenarQuick3(Q3, arregloVolumenInt);

        TInicioQ1 = System.nanoTime(); //Tomamos la hora en que inicio el algoritmo y la almacenamos en la variable inicio
        Q3.quickSortMayorMenor();
        /*
        Se finaliza el calculo del tiempo transcurrido.
         */
        TFinQ1 = System.nanoTime(); //Tomamos la hora en que finalizó el algoritmo y la almacenamos en la variable T
        tiempoQ1 = TFinQ1 - TInicioQ1; //Calculamos los milisegundos de diferencia
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("TIEMPO DE EJECUCIÓN DE LA CLASE QuickSort3: " + tiempoQ1 + " NanoSegundos.");
        System.out.println("--------------------------------------------------------------------------");
    }

    public static void insertSort() {
        int nElements = 18249;
        /*
        Se declaran las variables para calcular el tiempo.
         */
        long TInicioQ1, TFinQ1, tiempoQ1; //Variables para determinar el tiempo de ejecución

        CSVreader var = new CSVreader();
        // importar el archivo '.csv' a un arreglo de
        String[][] matrizCargada = var.csvAArreglo();
        String[] arregloVolumen = new String[nElements];
        double[] arregloVolumenInt = new double[nElements];

        for (int i = 0; i < matrizCargada.length; i++) {
            arregloVolumen[i] = matrizCargada[i][3];
        }
        for (int i = 0; i < 10; i++) {
            arregloVolumenInt[i] = Double.valueOf(arregloVolumen[i]);
        }
        /* EN ESTE PASO SE ORDENARÁ UN ARREGLO AUXILIAR CON EL METODO DE ORNDENAMIENTO QUICKSORT3,
        LUEGO MEDIANTE COMPARACIONES SE ORDENARAN LAS FILAS DE LA MATRIZ INICIAL*/
        InsertionSort I1 = new InsertionSort(arregloVolumenInt.length);
        I1 = llenarInsert(I1, arregloVolumenInt);

        TInicioQ1 = System.nanoTime(); //Tomamos la hora en que inicio el algoritmo y la almacenamos en la variable inicio
        I1.insertionSortMayorMenor();
        /*
        Se finaliza el calculo del tiempo transcurrido.
         */
        TFinQ1 = System.nanoTime(); //Tomamos la hora en que finalizó el algoritmo y la almacenamos en la variable T
        tiempoQ1 = TFinQ1 - TInicioQ1; //Calculamos los milisegundos de diferencia
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("TIEMPO DE EJECUCIÓN DE LA CLASE InsertionSort: " + tiempoQ1 + " NanoSegundos.");
        System.out.println("--------------------------------------------------------------------------");
    }


    /*   Metodo que rellena nuestra variable Q3 con los numeros generados Aleatoriamente.

     */
    public static QuickSort3 llenarQuick3(QuickSort3 quickSort3, double[] arreglo) {
        for (int i = 0; i < arreglo.length; i++) {
            quickSort3.insert((long) arreglo[i]);
        }
        return quickSort3;
    }

    /*
    Metodo que rellena nuestra variable I1 con los numeros generados Aleatoriamente.
     */
    public static InsertionSort llenarInsert(InsertionSort insertionSort, double[] arreglo) {
        for (int i = 0; i < arreglo.length; i++) {
            insertionSort.insert((long) arreglo[i]);
        }
        return insertionSort;
    }

    public static queue insertarCola() {
        int nElements = 18249;
        /*LECTURA DEL ARCHIVO CSV E INCERSIÓN DE LOS DATOS HACIA UNA MATRIZ DE TIPO String*/
        CSVreader var = new CSVreader();
        // importar el archivo '.csv' a un arreglo de
        String[][] matrizCargada = var.csvAArreglo();
        String[] arregloVolumen = new String[nElements];
        double[] arregloVolumenInt = new double[nElements];
        /*INSERCION DE LOS DATOS COMPLETOS DE LA MATRIZ CSV HACIA UN ARREGLO DE TIPO String QUE 
        CONTENDRÁ SOLO VOLUMEN*/
        for (int i = 0; i < matrizCargada.length; i++) {
            arregloVolumen[i] = matrizCargada[i][3];
        }
        /*EN ESTE CICLO COMO SE SABE QUE LA COLUMNA 4 (3) DEL ARCHIVO CSV CONTIENE LOS DATOS DE 
        VOLUMEN EN FORMATO DECIMAL, SE HIZO UNA CONVERSION DE String a double, para que las clases
        QuickSort3, InsertionSort y queue lograran utilizarlo de acuerdo a sus métodos nativos.*/
        for (int i = 0; i < 10; i++) {
            arregloVolumenInt[i] = Double.valueOf(arregloVolumen[i]);
        }

        queue theQueue = new queue(nElements);
        System.out.println("");
        System.out.println("-----------------------------------------------------------------");
        System.out.println("La cola inicialmente posee: " + theQueue.size() + " datos.");
        for (int i = 0; i < arregloVolumenInt.length; i++) {
            theQueue.insert((long) arregloVolumenInt[i]);
        }

        System.out.println("LA COLA EXISTINTE POSEE " + theQueue.size() + " DATOS INSERTADOS.");
        System.out.println("-----------------------------------------------------------------");

        //RETORNO DE UNA VARIABLE queue PARA SER UTILIZADO CON EL MÉTODO PROPIO DE LA CLASE PARA
        //REMOVER DICHOS ELEMENTOS.
        return theQueue;
    }

    public static void eliminarCola(queue theQueue, int nElements) {
        System.out.println("");
        System.out.println("-----------------------------------------------------------------");
        System.out.println("Datos incialmente en la cola: " + theQueue.size());
        for (int i = 0; i < nElements; i++) {
            theQueue.remove();
        }
        System.out.println("La cantidad de datos existentes en la cola son: " + theQueue.size());
        System.out.println("Por lo que la cola ha sido eliminada completamente.");
        System.out.println("-----------------------------------------------------------------");
    }
}
