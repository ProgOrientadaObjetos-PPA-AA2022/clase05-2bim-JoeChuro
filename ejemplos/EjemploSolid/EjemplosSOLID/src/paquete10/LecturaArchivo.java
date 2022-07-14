/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete10;

/**
 *
 * @author SALA I
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import java.util.ArrayList;
import java.util.Arrays;

public class LecturaArchivo {

    private Scanner entrada;
    private String nombreArchivo;
    private String rutaArchivo;
    private ArrayList<APIMovie> lista;

    public ArchivoLectura(String n) {
        nombreArchivo = n;
        rutaArchivo = String.format("data/%s", nombreArchivo);
        // data/profesores.txt
        File f = new File(rutaArchivo); // data/profesores.txt
        if (f.exists()) {
            try {
                entrada = new Scanner(new File(rutaArchivo));
                // entrada = new Scanner(System.in);
                // entrada = new Scanner(f);
            } // fin de try
            catch (FileNotFoundException e) {
                System.err.println("Error al leer del archivo: " + e);

            } // fin de catch
        }
    }

    public void establecerNombreArchivo(String n) {
        nombreArchivo = n;
    }

    public void establecerRutaArchivo() {
        rutaArchivo = String.format("data/%s.txt",
                obtenerNombreArchivo());;
    }

    public String obtenerNombreArchivo() {
        return nombreArchivo;
    }

    public String obtenerRutaArchivo() {
        return rutaArchivo;
    }

    // establecer valores de cada línea
    // en la lista de tipo Profesor
    public void establecerLista() {
        lista = new ArrayList<>();
        File f = new File(rutaArchivo);

        if (f.exists()) {

            while (entrada.hasNext()) {
                String linea = entrada.nextLine(); // Tara Hernandez;contratado

                ArrayList<String> linea_partes = new ArrayList<>(
                        Arrays.asList(linea.split(";")) // ["Tara Hernandez", "contratado"]
                );
                APIMovie p = new APIMovie(linea_partes.get(0), // Tara Hernandez
                        linea_partes.get(1) // contratado
                );
                lista.add(p);

            } // fin de while
        }
    }

    public ArrayList<APIMovie> obtenerLista() {

        return lista;
    }

    public void cerrarArchivo() {
        if (entrada != null) {
            entrada.close();
        } // cierra el archivo

    }

    @Override
    public String toString() {
        String cadena = "Lista API\n";
        for (int i = 0; i < obtenerLista().size(); i++) {
            APIMovie profTemporal = obtenerLista().get(i); // Obj. Profesor
            cadena = String.format("%s(%d) %s\n", cadena,
                    i + 1,
                    profTemporal.obtenerApiKey());  // obtenerLista().get(i).obtenerTipo());
        }
        return cadena;
    }
}
