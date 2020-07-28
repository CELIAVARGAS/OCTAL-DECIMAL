/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package octal_decimal;

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.Scanner;

/**
 *
 * @author esmeralda
 */
public class Octal_Decimal {

    /**
     * @param args the command line arguments
     */
    static Scanner lectura = new Scanner(System.in);

    static void compiladorNumerosOctales() {
        try {
            String ruta = "src/octal_decimal/";
            String opcFlex[] = {ruta + "lexico.jflex", "-d", ruta};
            jflex.Main.generate(opcFlex);
            String opcCUP[] = {"-destdir", ruta, "-parser", "parseO", ruta + "sintactico.cup"};
            java_cup.Main.main(opcCUP);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void analisisOctal(String texto) {
        try {
            System.out.println("Inicia analisis...");
            scanner scan = new scanner(new BufferedReader(new StringReader(texto)));
            parseO parser = new parseO(scan);
            parser.parse();
            System.out.println("\n Finaliza analisis...");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // TODO code application logic here
        compiladorNumerosOctales();
        String numero;
        System.out.println(" CONVERSION DE OCTAL A DECIMAL ");
        System.out.println("Introduzca un numero octal.     Para salir presione 's'");
        do {
            numero = lectura.nextLine();
            analisisOctal(numero);
        } while (!"s".equals(numero));
    }

}
