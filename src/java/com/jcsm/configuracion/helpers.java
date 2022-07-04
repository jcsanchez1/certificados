/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcsm.configuracion;

import java.util.concurrent.ThreadLocalRandom;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

/**
 *
 * @author juanc
 */
public class helpers {

    public String cadenaAleatoria(int longitud) {
        // El banco de caracteres
        String banco = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        // La cadena en donde iremos agregando un carácter aleatorio
        String cadena = "";
        for (int x = 0; x < longitud; x++) {
            int indiceAleatorio = numeroAleatorioEnRango(0, banco.length() - 1);
            char caracterAleatorio = banco.charAt(indiceAleatorio);
            cadena += caracterAleatorio;
        }
        return cadena;
    }

    public int numeroAleatorioEnRango(int minimo, int maximo) {
        // nextInt regresa en rango pero con límite superior exclusivo, por eso sumamos 1
        return ThreadLocalRandom.current().nextInt(minimo, maximo + 1);
    }

    public int findRandom() {

        // Generate the random number
        int num = (1 + (int) (Math.random() * 100)) % 2;

        // Return the generated number
        return num;
    }

    public String generateBinaryString() {
        // Stores the empty string
        String S = "";
        // Iterate over the range [0, N - 1]
        for (int i = 0; i < 30; i++) {
            // Store the random number
            int x = findRandom();
            // Append it to the string
            S = S + String.valueOf(x);
        }
        // Print the resulting string
        return S;
    }

    public String generartoken() {
        String token;
        String a1 = Integer.toString(Integer.parseInt(generateBinaryString(), 2), 16);
        String a2 = Integer.toString(Integer.parseInt(generateBinaryString(), 2), 16);
        String a3 = Integer.toString(Integer.parseInt(generateBinaryString(), 2), 16);
        String a4 = Integer.toString(Integer.parseInt(generateBinaryString(), 2), 16);
        token = a1 + "-" + a2 + "-" + a3 + "-" + a4;
        return token;

    }

    public String limpiracadena(String cadena) {
        String cadena2 = "";
        cadena2 = cadena2.trim();
        cadena2 = cadena2.replace("\\", "");
        cadena2 = cadena2.replace("<script>", "");
        cadena2 = cadena2.replace("<script>", "");
        cadena2 = cadena2.replace("</script>", "");
        cadena2 = cadena2.replace("<script src>", "");
        cadena2 = cadena2.replace("<script type=>", "");
        cadena2 = cadena2.replace("SELECT * FROM", "");
        cadena2 = cadena2.replace("DELETE FROM", "");
        cadena2 = cadena2.replace("INSERT INTO", "");
        cadena2 = cadena2.replace("SELECT COUNT(*) FROM", "");
        cadena2 = cadena2.replace("DROP TABLE", "");
        cadena2 = cadena2.replace("OR '1'='1", "");
        cadena2 = cadena2.replace("OR 1 = 1", "");
        cadena2 = cadena2.replace("OR '1'='1'", "");
        cadena2 = cadena2.replace("is NULL; --", "");
        cadena2 = cadena2.replace("is NULL; --", "");
        cadena2 = cadena2.replace("LIKE '", "");
        cadena2 = cadena2.replace("LIKE '", "");
        cadena2 = cadena2.replace("LIKE ´", "");
        cadena2 = cadena2.replace("OR 'a'='a", "");
        cadena2 = cadena2.replace("OR 'a'='a'", "");
        cadena2 = cadena2.replace("OR ´a´=´a", "");
        cadena2 = cadena2.replace("OR ´a´=´a", "");
        cadena2 = cadena2.replace("--", "");
        cadena2 = cadena2.replace("^", "");
        cadena2 = cadena2.replace("[", "");
        cadena2 = cadena2.replace("]", "");
        cadena2 = cadena2.replace("==", "");
        return cadena2;

    }

    public String getMd5(String input) {
        try {

            // Static getInstance method is called with hashing MD5
            MessageDigest md = MessageDigest.getInstance("MD5");

            // digest() method is called to calculate message digest
            //  of an input digest() return array of byte
            byte[] messageDigest = md.digest(input.getBytes());

            // Convert byte array into signum representation
            BigInteger no = new BigInteger(1, messageDigest);

            // Convert message digest into hex value
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        } // For specifying wrong message digest algorithms
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
