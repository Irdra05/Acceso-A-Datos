package AccesoDatos;

import java.io.*;

public class ficheroUsuario {
    static void main(String[] args) {
        int opcion;
        String nombreFichero;
        do {
            opcion = Integer.parseInt(IO.readln("""
            Elige una opción:
            1. Crear Fichero.
            2. Leer Fichoro.
            3. Escribir en Fichero.
            4. Eliminar fichero.
            5. Exit.
            Opción:
            """));

            switch (opcion) {
                case 1 -> {
                    nombreFichero = IO.readln("Introduce el nombre del fichero que deseas crear en la carpeta datos: ");

                    try (FileWriter fw = new FileWriter("datos/" + nombreFichero + ".txt")) {
                        System.out.println("Fichero creado en la carpeta de datos.");
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }

                case 2 -> {
                    nombreFichero = IO.readln("Introduce el nombre del fichero que deseas leer de la carpeta datos: ");

                    try (BufferedReader br = new BufferedReader(new FileReader("datos/" + nombreFichero + ".txt"))) {
                        String linea;
                        System.out.println("Contenido del fichero " + nombreFichero + ":");
                        while ((linea = br.readLine()) != null) {
                            System.out.println(linea);
                        }
                    } catch (FileNotFoundException e) {
                        throw new RuntimeException(e);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }

                case 3 -> {
                    nombreFichero = IO.readln("Introduce el nombre del fichero que deseas modificar de la carpeta datos: ");

                    try (FileWriter fw = new FileWriter("datos/" + nombreFichero + ".txt", true)) {
                        String texto;
                        char sn;
                        do {
                            texto = IO.readln("Introduce la frase que deseas añadir: ");
                            fw.write(texto);
                            sn = IO.readln("¿Deseas introducir otra frase? (S/N): ").toLowerCase().charAt(0);
                        } while (sn == 's');
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }

                case 4 -> {
                    nombreFichero = IO.readln("Introduce el nombre del fichero a eliminar de la carpeta datos: ");
                    File file = new File("datos/" + nombreFichero + ".txt");
                    if (file.delete()) {
                        System.out.println("El fichero ha sido eliminado enhorabuena.");
                    } else {
                        System.out.println("El fichero se nos ha escapado lo sentimos.");
                    }
                }

                case 5 -> System.out.println("Adioooooossss. 😎");

                default -> System.out.println("No has introducido una opción valida.");
            }
        } while (opcion != 5);
    }
}
