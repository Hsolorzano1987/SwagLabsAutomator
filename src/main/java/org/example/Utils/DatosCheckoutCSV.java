package org.example.Utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class DatosCheckoutCSV {
    public static Map<String, String> obtenerDatos() {
        Map<String, String> datos = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader("src/test/resources/config/datos_checkout.csv"))) {
            String encabezado = br.readLine(); // Saltar encabezado
            String linea = br.readLine();      // Leer la primera fila
            String[] valores = linea.split(",");

            datos.put("First Name", valores[0]);
            datos.put("Last Name", valores[1]);
            datos.put("Zip/Postal Code", valores[2]);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return datos;
    }
}

