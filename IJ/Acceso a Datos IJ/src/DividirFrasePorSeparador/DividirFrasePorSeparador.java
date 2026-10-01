package DividirFrasePorSeparador;

public class DividirFrasePorSeparador {
    static void main(String[] args) {
        //StringBuilder sb = new StringBuilder();
        String frase;
        frase = IO.readln("Introduce una cadena: ");
        frase = frase.replace(' ', '\n');
        System.out.println(frase);

//        for (int i = 0; i < frase.length(); i++) {
//            char caracter = frase.charAt(i);
//            if (caracter == ' ') sb.append('\n');
//            else sb.append(caracter);
//        }
//
//        System.out.print(sb);
    }
}
