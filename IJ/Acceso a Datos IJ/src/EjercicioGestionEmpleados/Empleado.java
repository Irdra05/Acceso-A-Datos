package EjercicioGestionEmpleados;

public class Empleado implements Comparable {
    String dni, nombre, apellido;
    float telefono;
    double salario;

    public Empleado (String dni, String nombre, String apellido, float telefono, double salario){
        setDni(dni);
        setNombre(nombre);
        setApellido(apellido);
        setTelefono(telefono);
        setSalario(salario);
    }

    @Override
    public String toString() {
        return String.format("[DNI=%s, Nombre=%s, Apellido=%s, Teléfono=%.0f, Salario=%.1f]", getDni(), getNombre(), getApellido(), getTelefono(), getSalario());
    }

    @Override
    public int compareTo(Object emp) {
        ComparadorCadenas comparadorCadenas = new ComparadorCadenas();
        if (emp == null || getClass() != emp.getClass()) {
            System.out.println("ERROR: Empleado 2 no es un empleado.");
            return 2;
        }
        return comparadorCadenas.compararCadenas(this, (Empleado) emp);
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        boolean dniCorrecto;
        do {
            while (dni.length() != 9) {
                dni = IO.readln("DNI no valido introduce un nuevo dni: ");
            }

            try {
                Integer.parseInt(dni.substring(0,7));
                char letra = dni.charAt(8);
                if (!Character.isLetter(letra)) throw new Exception();
                dniCorrecto = true;
            } catch (Exception e) {
                dni = IO.readln("DNI no valido introduce un nuevo dni: ");
                dniCorrecto = false;
            }
        } while (!dniCorrecto);
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public float getTelefono() {
        return telefono;
    }

    public void setTelefono(float telefono) {
        this.telefono = telefono;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}
