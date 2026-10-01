package EjercicioGestionEmpleados;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class GestionEmpleados {
    ArrayList<Empleado> listaEmpleados;

    public GestionEmpleados() {
        setListaEmpleados(new ArrayList<>());
    }

    public ArrayList<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }

    public void setListaEmpleados(ArrayList<Empleado> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }

    public void anyadirEmpleado(Empleado empleado) {
        getListaEmpleados().add(empleado);
    }

    public void ordenarEmpleados(char opcion) {
        switch (opcion) {
            case 'd' -> Collections.sort(getListaEmpleados());
            case 'n' -> Collections.sort(getListaEmpleados(), Comparator.comparing(Empleado::getNombre));
            case 'a' -> Collections.sort(getListaEmpleados(), Comparator.comparing(Empleado::getApellido));
            case 't' -> Collections.sort(getListaEmpleados(), Comparator.comparing(Empleado::getTelefono));
            case 's' -> Collections.sort(getListaEmpleados(), Comparator.comparing(Empleado::getSalario));
            default -> System.out.println("ERROR: Opcion no valida.");
        }
    }

    public void mostrarEmpleados() {
        int contador = 1;

        for (Empleado emp : listaEmpleados) {
            System.out.printf("Empleado %d: %s\n", contador, emp);
            contador++;
        }
    }
}

