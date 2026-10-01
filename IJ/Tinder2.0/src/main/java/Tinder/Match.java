package Tinder;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Clase para los matches entre dos usuarios.
 */
public class Match implements Comparable<Match> {
    // Variables
    private String usuarios;
    private ArrayList<String> aficionesComunes = new ArrayList<>();

    /**
     * Constructor de la clase Match.
     * @param usu1
     * @param usu2
     * @param aficionesComunes
     */
    public Match(int usu1, int usu2, ArrayList<String> aficionesComunes) {
        setUsuarios("U" + usu1 + " U" + usu2);
        setAficionesComunes(aficionesComunes);
    }

    /**
     * Metodo toString para representar el objeto Match como una cadena de texto.
     * @return
     */
    @Override
    public String toString() {
        return usuarios + " " + aficionesToString();
    }

    /**
     * Metodo compareTo para comparar dos objetos Match en base al número de aficiones comunes.
     * @param match2
     * @return
     */
    @Override
    public int compareTo(Match match2) {
        return Integer.compare(getAficionesComunes().size(), match2.getAficionesComunes().size());
    }

    // Getters y Setters
    public String getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(String usuarios) {
        this.usuarios = usuarios;
    }

    public ArrayList<String> getAficionesComunes() {
        return aficionesComunes;
    }

    public void setAficionesComunes(ArrayList<String> aficionesComunes) {
        this.aficionesComunes = aficionesComunes;
    }

    /**
     * Metodo para representar las aficiones comunes como una cadena de texto.
     * @return
     */
    public String aficionesToString() {
        StringBuilder sb = new StringBuilder();
        for (String aficion : aficionesComunes) {
            sb.append(aficion).append(" ");
        }

        return sb.toString();
    }
}
