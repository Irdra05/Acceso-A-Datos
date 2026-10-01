package EjercicioGestionEmpleados;

public class Principal {
    static void main(String[] args) {
        GestionEmpleados gestion = new GestionEmpleados();
        gestion.anyadirEmpleado(new Empleado("12345678a", "Juan", "Pérez", 5551234f, 3000.0));
        gestion.anyadirEmpleado(new Empleado("12345678b", "Ana", "García", 5555678f, 2500.0));
        gestion.anyadirEmpleado(new Empleado("12345679a", "Pedro", "López", 5558765f, 2800.0));

        System.out.println("Empleados antes de ordenar:");
        gestion.mostrarEmpleados();

        System.out.println("\nEmpleados ordenados por DNI:");
        gestion.ordenarEmpleados('d');
        gestion.mostrarEmpleados();

        System.out.println("\nEmpleados ordenados por salario:");
        gestion.ordenarEmpleados('s');
        gestion.mostrarEmpleados();

        System.out.println("\nEmpleados ordenados por nombre:");
        gestion.ordenarEmpleados('n');
        gestion.mostrarEmpleados();

        System.out.println("\nEmpleados ordenados por apellido:");
        gestion.ordenarEmpleados('a');
        gestion.mostrarEmpleados();

        System.out.println("\nEmpleados ordenados por teléfono:");
        gestion.ordenarEmpleados('t');
        gestion.mostrarEmpleados();
    }
}
