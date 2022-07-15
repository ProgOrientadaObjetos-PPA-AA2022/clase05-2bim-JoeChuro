/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete10;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

/**
 *
 * @author JOE
 */
public class LecturaArchivoSecuencial {
     private ObjectInputStream entrada;
    private ArrayList<GeneradorPeliculas> listas;
    private String nombreArchivo;

    public LecturaArchivoSecuencial(String n) {
        nombreArchivo = n;
        File f = new File(obtenerNombreArchivo());
        if (f.exists()) {
            try // abre el archivo
            {
                entrada = new ObjectInputStream(
                        new FileInputStream(n));
            } // fin de try
            catch (IOException ioException) {
                System.err.println("Error al abrir el archivo.");

            } // fin de catch
        }
    }

    public void establecerNombreArchivo(String n) {
        nombreArchivo = n;
    }

    public void establecerLista) {
        // 
        listas = new ArrayList<>();
        File f = new File(obtenerNombreArchivo());
        if (f.exists()) {

            while (true) {
                try {
                    GeneradorPeliculas registro = (GeneradorPeliculas) entrada.readObject();
                    listas.add(registro);
                } catch (EOFException endOfFileException) {
                    return; // se llegó al fin del archivo

                } catch (IOException ex) {
                    System.err.println("Error al leer el archivo: " + ex);
                } catch (ClassNotFoundException ex) {
                    System.err.println("No se pudo crear el objeto: " + ex);
                } catch (Exception ex) {
                    // System.err.println("No hay datos en el archivo: " + ex);
                    break;
                }
            }
        }

    }

    public ArrayList<GeneradorPeliculas> obtenerListaPeliculas() {
        return listas;
    }

    public String obtenerNombreArchivo() {
        return nombreArchivo;
    }

    @Override
    public String toString() {
        String cadena = "Lista de Peliculas\n";
        for (int i = 0; i < obtenerListaPeliculas().size(); i++) {
            GeneradorPeliculas p = obtenerListaPeliculas().get(i);
            cadena = String.format("%s%s\n", cadena,
                    p.toString());
        }

        return cadena;
    }

    // cierra el archivo y termina la aplicación
    public void cerrarArchivo() {
        try // cierra el archivo y sale
        {
            if (entrada != null) {
                entrada.close();
            }
            System.exit(0);
        } // fin de try
        catch (IOException ioException) {
            System.err.println("Error al cerrar el archivo.");
            System.exit(1);
        } // fin de catch
    } // fin del método cerrarArchivo
}