
import java.util.Scanner;

class Main {
  public static void main(String[] args) {

    /// Generando la llave a partir de la longitud ingresada por el usuario
    Scanner scanner = new Scanner(System.in);
    int longitud;
    GenerarLlave generadorLlave = new GenerarLlave();

    // Solicitar al usuario la longitud de la llave
    do {
      System.out.print("Ingrese la longitud de la llave (entre 8 y 128, potencia de 2): ");
      longitud = scanner.nextInt();
    } while (!generadorLlave.esLongitudValida(longitud));

    scanner.close();

    // Generar la llave
    String llave = generadorLlave.generarLlave(longitud);

    // Guardar la llave en un archivo de texto
    generadorLlave.guardarLlaveEnArchivo(llave);

    System.out.println("Llave generada y guardada en el archivo.");

    String nombreEntradaMiarchivo = "src/input.txt";

    // Leer el archivo de entrada

    CifradorVigenere cifrador = new CifradorVigenere();

    String cadena = cifrador.leerArchivo(nombreEntradaMiarchivo);

    String textoCifrado = cifrador.cifrarTexto(cadena, "llave2.txt");

    System.out.println(" \n Texto cifrado: \n " + textoCifrado);

    cifrador.escribirEnArchivo(textoCifrado,"src/main/java/output.txt");
    //cifrador.escribirEnArchivo(textoCifrado,"src/main/java/expected_output.txt");
    // Escribir el archivo de salida
    DescifradorVigenere descifrador = new DescifradorVigenere();
    String textoDescifrado = descifrador.descifrarTexto(textoCifrado, "llave2.txt");
    System.out.println(" \n Texto descifrado: \n " + textoDescifrado);

  }
}
