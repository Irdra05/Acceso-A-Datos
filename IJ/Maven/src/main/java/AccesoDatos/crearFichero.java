package AccesoDatos;

import java.io.*;
import java.nio.file.FileAlreadyExistsException;

public class crearFichero {
    static void main(String[] args) {
        String ruta = "datos/otro.txt";

        //Crear Fichero
        try (FileWriter fw = new FileWriter(ruta, true)) {
            fw.write("Hello World :)\n");
            fw.write("World Hello :(\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //Leer Fichero
        try(BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //Eliminar Fichero
        File file = new File(ruta);
        if (file.delete()) {
            System.out.println("¡Rico, bum, bum!");
        } else {
            System.out.println("¡Tranquilo Rico espera tu momento!");
        }
    }
}
