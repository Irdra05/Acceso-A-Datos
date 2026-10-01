package Tinder;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Clase principal del programa.
 * Se encarga de gestionar la aplicación y la interacción con el usuario.
 */
public class Principal {
    /**
     * Metodo principal que inicia la aplicación.
     * @param args
     */
    static void main(String[] args) {
        // Variables
        String nFichero;
        BufferedReader br = null;
        boolean ficheroExiste;
        File[] archivosCDatos = new File("datos").listFiles();
        int opcion;

        //Solicitud de nombre de fichero y comprobación de que exista
        nFichero = IO.readln("Introduce el nombre del fichero de usuarios: ");
        do {
            try {
                br = new BufferedReader(new FileReader("datos/" + nFichero + ".txt"));
                System.out.println("Fichero encontrado.");
                ficheroExiste = true;
            } catch (IOException e) {
                StringBuilder sb = new StringBuilder();
                for (File archivo : archivosCDatos) {
                    sb.append(archivo).append("\n");
                }

                nFichero = IO.readln(String.format("""
                        Fichero no existe en la carpeta de datos, estos son los ficheros disponibles: 
                        %s
                        Escribe otro nombre: 
                        """, sb));
                ficheroExiste = false;
            }
        } while (!ficheroExiste);

        //App
        do {
            //Menú
            do {
                try {
                    opcion = Integer.parseInt(IO.readln("""
                            ========== MENÚ PRINCIPAL ==========
                            1. Añadir usuario.
                            2. Mostrar usuarios introducidos.
                            3. Generar fichero de concordancias.
                            4. Salir.
                            ====================================
                            Seleccione una opción:
                            """));
                } catch (Exception e) {
                    System.out.println("Eso no es un numero intentalo de nuevo.");
                    opcion = 0;
                }
            } while (opcion == 0);

            //Opciones
            switch (opcion) {
                //Añadir usuario
                case 1 -> {
                    //Variables
                    long numeroID;
                    String aficiones;

                    //Introducir aficiones
                    do {
                        aficiones = IO.readln("Introduce tus aficiones separadas por espacios: ").toUpperCase();
                        if (aficiones.isBlank()) System.out.println("No has introducido ninguna afición.");
                    } while (aficiones.isBlank());

                    //Obtener el último ID y sumarle 1
                    try {
                        br = new BufferedReader(new FileReader("datos/" + nFichero + ".txt"));
                        String linea, ultimaLinea = "";
                        while ((linea = br.readLine()) != null) ultimaLinea = linea;

                        numeroID = Integer.parseInt(ultimaLinea.split(" ")[0].substring(1)) + 1;
                    } catch (FileNotFoundException e) {
                        throw new RuntimeException(e);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                    //Añadir usuario al fichero
                    try (FileWriter fw = new FileWriter("datos/" + nFichero + ".txt", true)){
                        fw.write(String.format("U%d %s\n", numeroID, aficiones));
                        System.out.println("Se ha añadido el usuario.");
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }

                //Mostrar usuarios
                case 2 -> {
                    try {
                        br = new BufferedReader(new FileReader("datos/" + nFichero + ".txt"));
                        String linea;
                        while ((linea = br.readLine()) != null) {
                            System.out.println(linea);
                        }
                    } catch (FileNotFoundException e) {
                        throw new RuntimeException(e);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                }

                //Generar fichero de concordancias
                case 3 -> {
                    //Variables
                    int concordancias;
                    ArrayList<Usuario> usuarios = new ArrayList<>();
                    ArrayList<Match> matches = new ArrayList<>();

                    //Recibir el número mínimo de concordancias
                    do {
                        try {
                            concordancias = Integer.parseInt(IO.readln("Introduce el número mínimo de concordancias: "));
                        } catch(Exception e) {
                            System.out.println("Eso no es un numero intentalo de nuevo.");
                            concordancias = 0;
                        }
                    } while(concordancias == 0);

                    //Añadir usuarios a la lista de usuarios
                    try {
                        br = new BufferedReader(new FileReader("datos/" + nFichero + ".txt"));
                        String linea;
                        while ((linea = br.readLine()) != null) usuarios.add(new Usuario(linea));
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }

                    //Comparar usuarios y añadir matches a la lista de matches
                    for (int i = 0; i < usuarios.size(); i++) {
                        for (int j = i + 1; j < usuarios.size(); j++) {
                            Usuario usuario1 = usuarios.get(i);
                            Usuario usuario2 = usuarios.get(j);
                            ArrayList<String> aficionesComunes = new ArrayList<>();

                            for (int k = 0; k < usuario1.getAficiones().size(); k++) {
                                for (int l = 0; l < usuario2.getAficiones().size(); l++) {
                                    String aficion1 = usuario1.getAficiones().get(k);
                                    String aficion2 = usuario2.getAficiones().get(l);

                                    if (aficion1.equals(aficion2)) aficionesComunes.add(aficion1);
                                }
                            }

                            if (aficionesComunes.size() >= concordancias) matches.add(new Match(
                                                usuario1.getId(),
                                                usuario2.getId(),
                                                aficionesComunes));
                        }
                    }

                    Collections.sort(matches, Collections.reverseOrder());

                    //Mostrar matches y escribirlos en un fichero
                    if (matches.isEmpty()) {
                        System.out.println("No ha habido Matches.");
                    } else {
                        try (FileWriter fw = new FileWriter("match/concordancias.txt")) {
                            for (Match match : matches) {
                                fw.write(match.toString() + "\n");
                            }
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }

                        System.out.printf("Hay %d Matches.\n", matches.size());
                    }
                }

                //Salir
                case 4 -> System.out.println("Adios, vuelve pronto. 🥳");
                default -> System.out.println("Opción no valida.");
            }
        } while (opcion != 4);
    }
}
