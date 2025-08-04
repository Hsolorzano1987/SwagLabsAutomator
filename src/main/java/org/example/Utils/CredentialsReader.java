package org.example.Utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class CredentialsReader {

    private static final Properties properties = new Properties();

    static {
        try (InputStream input = CredentialsReader.class.getClassLoader()
                .getResourceAsStream("config/credentials.properties")) {
            if (input != null) {
                properties.load(input);
            } else {
                throw new RuntimeException("No se encontró el archivo credentials.properties");
            }
        } catch (IOException ex) {
            throw new RuntimeException("Error al leer las credenciales", ex);
        }
    }

    public static String getUsuario() {
        return properties.getProperty("usuario");
    }

    public static String getContrasena() {
        return properties.getProperty("contrasena");
    }
}
