package jose.manu.camilo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class CSVreader {
    // https://www.youtube.com/watch?v=-Aud0cDh-J8
    // https://www.youtube.com/watch?v=w-9ZTeO7q_E

    String archivo = "C:\\Users\\Jose\\OneDrive - Universidad de La Frontera\\Ramos\\Complejidad Computacional\\Jose.Manuel.Camilo\\src\\jose\\manu\\camilo\\palta.csv";
    String lineaEnCsv;

    // filas, columnas
    String[][] matrizPrincipal = new String[18249][13];
    String[] lineaEnArreglo = new String[13];

    //numero,Date,AveragePrice,Total Volume,4046,4225,4770,Total Bags,Small Bags,Large Bags,XLarge Bags,type,year,region
    public String[][] csvAArreglo() {

        try {
            BufferedReader br = new BufferedReader(new FileReader(archivo));
            // lee el archivo

            while ((lineaEnCsv = br.readLine()) != null) {
                // mientras la linea en archivo CSV no este vacia

                // asigna valor de linea en CSV a linea en arreglo
                // separando por comas
                lineaEnArreglo = lineaEnCsv.split(",");

                System.out.println("Leyendo archivo:" + archivo);

                // Luego, en arreglo principal
                // cada fila del arreglo corresponde a una
                // fila en lineaEnArreglo
                for (int i = 0; i < matrizPrincipal.length; i++) {
                    for (int j = 0; j < matrizPrincipal[i].length; j++) {
                        matrizPrincipal[i][j] = lineaEnArreglo[j];
                    }
                }
                break;
            }

        } catch (FileNotFoundException e) {
            System.out.println("Error " + e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Error " + e.getMessage());
            e.printStackTrace();
        }

        return matrizPrincipal;

    }

    public void imprimeVolumen() {
        System.out.println("Lista de volumenes: ");

        for (int i = 0; i < matrizPrincipal.length; i++) {
            for (int j = 0; j < matrizPrincipal[i].length; j++) {
                // imprime la segunda columna
                System.out.println(matrizPrincipal[i][3]);
                // la segunda columna es el volumen
            }
        }

    }

    public void imprimeATxt() {
        // https://www.youtube.com/watch?v=-FDphiTnmCE
        try {
            PrintWriter outputfile = new PrintWriter("volumen.txt");

            outputfile.println("Lista de volumenes:");
            for (int i = 0; i < matrizPrincipal.length; i++) {
                outputfile.println(matrizPrincipal[i][1]);
                // la tercera columna es el volumen
            }
            outputfile.close();

        } catch (FileNotFoundException e) {
            System.out.println("Error " + e.getMessage());
            e.printStackTrace();
        }

    }

}
