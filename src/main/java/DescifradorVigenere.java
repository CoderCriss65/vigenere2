import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class DescifradorVigenere {
    public String descifrarTexto(String texto, String llaveria) {
        String res = "";
        String llave = llaveria;
        int indiceClave = 0;

        try {
            File archivoLlave = new File(llaveria);
            Scanner scanner = new Scanner(archivoLlave);

            if (scanner.hasNextLine()) {
                llave = scanner.nextLine();
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        for (int pos = 0; pos < texto.length(); pos++) {
            char letraTexto = texto.charAt(pos);
            if (Character.isWhitespace(letraTexto)) {
                res += letraTexto; // Agregar espacio en blanco sin descifrar
                continue; // Saltar al siguiente carácter
            }
            char letraClave = llave.charAt(indiceClave % llave.length());
            indiceClave++;
            char descifrado = ' ';
            if (Character.isLetter(letraTexto)) { // Si el carácter es una letra
                if (Character.isLowerCase(letraTexto)) {
                    letraClave = Character.toLowerCase(letraClave);
                    int valor = (((letraTexto - 'a') - (letraClave - 'a') + 26) % 26) + 'a';
                    descifrado = (char) valor;
                } else {
                    int valor = (((letraTexto - 'A') - (letraClave - 'A') + 26) % 26) + 'A';
                    descifrado = (char) valor;
                }
            } else if (Character.isDigit(letraTexto)) { // Si el carácter es un dígito
                int valor = (((letraTexto - '0') - (letraClave - 'A') + 10) % 10) + '0';
                descifrado = (char) valor;
            } else { 
              // Si el carácter es un signo de puntuación
              
              
            }
            res += descifrado;
        }
        return res;
    }
}
