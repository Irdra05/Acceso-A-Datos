package EjercicioGestionEmpleados;

public class ComparadorCadenas {
    public int compararCadenas(Empleado emp1, Empleado emp2) {
        int num1, num2;
        char letra1, letra2;

        num1 = Integer.parseInt(emp1.dni.substring(0,7));
        num2 = Integer.parseInt(emp2.dni.substring(0,7));
        letra1 = emp1.dni.charAt(8);
        letra2 = emp2.dni.charAt(8);

        if (num1 != num2) return num1 < num2 ? 0 : 1;
        return letra1 < letra2 ? 0 : 1;
    }
}

