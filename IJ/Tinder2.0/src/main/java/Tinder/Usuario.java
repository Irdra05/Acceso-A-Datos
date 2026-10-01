package Tinder;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Clase para representar un usuario.
 */
public class Usuario {
    // Variables
    private int id;
    private ArrayList<String> aficiones = new ArrayList<>();

    /**
     * Constructor de la clase Usuario.
     * @param datos
     */
    public Usuario (String datos) {
        String[] datosSplit = datos.split(" ");
        setId(datosSplit[0]);

        aficiones.addAll(Arrays.asList(datosSplit).subList(1, datosSplit.length));
    }

    //Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(String id) {
        this.id = Integer.parseInt(id.substring(1));
    }

    public ArrayList<String> getAficiones() {
        return aficiones;
    }

    public void setAficiones(ArrayList<String> aficiones) {
        this.aficiones = aficiones;
    }
}
