import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Random;

class GenerarLlave{

  boolean esLongitudValida(int longitud) {
          return longitud >= 8 && longitud <= 128 && (longitud & (longitud - 1)) == 0;
      }

   static void limpiarArchivo(String archivo) {
          try {
              Files.deleteIfExists(Paths.get(archivo));
          } catch (IOException e) {
              System.out.println("Error al limpiar el archivo: " + e.getMessage());
          }
      }
  

      String generarLlave(int longitud) {
          String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
          StringBuilder llave = new StringBuilder();
          Random random = new Random();

          for (int i = 0; i < longitud; i++) {
              int index = random.nextInt(caracteres.length());
              llave.append(caracteres.charAt(index));
          }

          return llave.toString();
      }

      void guardarLlaveEnArchivo(String llave) {
        limpiarArchivo("llave.txt");

          try {
              Files.write(Paths.get("llave.txt"), llave.getBytes(), StandardOpenOption.CREATE);
          } catch (IOException e) {
              System.out.println("Error al guardar la llave en el archivo: " + e.getMessage());
          }
      }
  }