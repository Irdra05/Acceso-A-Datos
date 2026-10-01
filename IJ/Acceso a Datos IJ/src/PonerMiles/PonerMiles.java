package PonerMiles;

public class PonerMiles {
    static void main(String[] args) {
        String numero = IO.readln("Introduce un número: ");
        StringBuilder sb = new StringBuilder();
        int contador = 0;

        for (int i = numero.length() - 1; i >= 0; i--) {
            if (contador == 3) {
                sb.insert(0, '.');
                contador = 0;
            }
            char digito = numero.charAt(i);
            sb.insert(0, digito);
            contador++;
        }

        System.out.println(sb);
    }
}
