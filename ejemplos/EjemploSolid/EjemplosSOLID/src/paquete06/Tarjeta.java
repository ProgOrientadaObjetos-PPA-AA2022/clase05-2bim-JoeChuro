/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete06;

/**
 *
 * @author SALA I
 */
public class Tarjeta {
    private String nombre;
    private String banco;
    private double cupoMaximo;
    
    public Tarjeta(String n, String b, double cm){
    nombre = n;
    banco = b;
    cupoMaximo = cm;
    }
    
    public void establecerNombre(String n){
        nombre = n;
    }
    public void establecerBanco(String n){
        banco = n;
    }
    public void establecerCupoMaximo(double n){
        cupoMaximo = n;
    }
    public String obtenerNombre(){
        return nombre;
    }
    public String obtenerBanco(){
        return banco;
    }
    public double obtenerCupoMaximo(){
        return cupoMaximo;
    }
    public String toString(){
    String cadena = String.format("Nombre: %s\nBanco: %s\nCupo: %.2f", 
            nombre,banco,cupoMaximo);
    return cadena;
    }
}
