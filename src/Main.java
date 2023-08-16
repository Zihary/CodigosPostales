import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        String archivo = "codigos_postales_hmo";

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            Map<String, Integer> contadorPorCodigoPostal = new HashMap<>();

            while ((linea = br.readLine()) != null) {
                String[] campos = linea.split("\t");
                if (campos.length >= 1) {
                    String codigoPostal = campos[0];
                    contadorPorCodigoPostal.put(codigoPostal, contadorPorCodigoPostal.getOrDefault(codigoPostal, 0) + 1);
                }
            }

            for (Map.Entry<String, Integer> entry : contadorPorCodigoPostal.entrySet()) {
                String codigoPostal = entry.getKey();
                int cantidad = entry.getValue();
                System.out.println("Código Postal: " + codigoPostal + ", Cantidad de Asentamientos: " + cantidad);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}