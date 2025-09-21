import java.io.*;

public class Corrector {
    public static void main(String[] args) throws Exception {
        // Ejecutar el main de Fundacion
        ProcessBuilder pb = new ProcessBuilder(
                "java", "-cp", "out/production/ConCorrectorTratamientoSangre", "Fundacion"
        );
        pb.directory(new File(System.getProperty("user.dir")));
        pb.redirectErrorStream(true);
        Process process = pb.start();

        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        StringBuilder output = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            output.append(line).append("\n");
        }
        process.waitFor();

        String salida = output.toString();
        System.out.println("Salida del alumno:\n" + salida);

        int puntos = 0;
        if (salida.contains("Tu tratamiento tardar")) {
            System.out.println("✅ Niño mayor de 3 años OK");
            puntos++;
        }
        if (salida.contains("es chico para probar") || salida.contains("Aún es chico")) {
            System.out.println("✅ Niño menor de 3 años OK");
            puntos++;
        }
        if (salida.contains("costoso, pero lo vamos a lograr")) {
            System.out.println("✅ Joven tratamiento OK");
            puntos++;
        }
        if (salida.contains("Lamentamos comunicarte")) {
            System.out.println("✅ Joven no aplica OK");
            puntos++;
        }
        if (salida.contains("Cantidad de pacientes")) {
            System.out.println("✅ Conteo adultos/gerontes OK");
            puntos++;
        }

        System.out.println("\nPuntaje final: " + puntos + "/5");
    }
}

