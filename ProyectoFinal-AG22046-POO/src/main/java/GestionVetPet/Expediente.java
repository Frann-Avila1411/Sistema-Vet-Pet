
/*Franklin Giovanny Avila Gonzalez
AG22046- POO- GT04*/

package GestionVetPet;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Expediente {
    private String nombrePaciente;
    private Date fechaCita;
    private String motivoCita;
    private String diagnostico;
    private List<String> medicamentos;
    private double cobro;

    public Expediente(String nombrePaciente, Date fechaCita, String motivoCita, String diagnostico,
                      List<String> medicamentos, double cobro) {
        this.nombrePaciente = nombrePaciente;
        this.fechaCita = fechaCita;
        this.motivoCita = motivoCita;
        this.diagnostico = diagnostico;
        this.medicamentos = medicamentos;
        this.cobro = cobro;
    }

    // Getters y setters

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    public Date getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(Date fechaCita) {
        this.fechaCita = fechaCita;
    }

    public String getMotivoCita() {
        return motivoCita;
    }

    public void setMotivoCita(String motivoCita) {
        this.motivoCita = motivoCita;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public List<String> getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(List<String> medicamentos) {
        this.medicamentos = medicamentos;
    }

    public double getCobro() {
        return cobro;
    }

    public void setCobro(double cobro) {
        this.cobro = cobro;
    }

    // Método para generar un nuevo expediente
    public static Expediente GenerarExpediente(String nombrePaciente, Date fechaCita, String motivoCita,
                                               String diagnostico, List<String> medicamentos, double cobro) {
        return new Expediente(nombrePaciente, fechaCita, motivoCita, diagnostico, medicamentos, cobro);
    }

    // Método para guardar los datos del expediente en el archivo "Expediente.txt"
    public void guardarExpedienteEnArchivo() {
        try (FileWriter writer = new FileWriter("Expediente.txt", true);
             BufferedWriter bufferedWriter = new BufferedWriter(writer);
             PrintWriter out = new PrintWriter(bufferedWriter)) {
            out.println(this.toCSV());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método estático para cargar expedientes desde un archivo
    public static List<Expediente> cargarExpedientesDesdeArchivo() {
            List<Expediente> expedientes = new ArrayList<>();

    try (BufferedReader reader = new BufferedReader(new FileReader("Expediente.txt"))) {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(", ");
            if (parts.length == 6) {
                try {
                    String nombrePaciente = parts[0].trim();
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    Date fechaCita = dateFormat.parse(parts[1].trim());
                    String motivoCita = parts[2].trim();
                    String diagnostico = parts[3].trim();
                    List<String> medicamentos = List.of(parts[4].trim().split(", "));
                    double cobro = Double.parseDouble(parts[5].trim());

                    Expediente expediente = new Expediente(nombrePaciente, fechaCita, motivoCita,
                            diagnostico, medicamentos, cobro);

                    expedientes.add(expediente);
                } catch (ParseException | NumberFormatException e) {
                    // Manejar la excepción
                    System.err.println("Error al procesar línea en el archivo Expediente.txt: " + line);
                    e.printStackTrace();
                }
            } else {
                System.err.println("Error: La línea en el archivo no tiene el formato correcto.");
            }
        }
    } catch (IOException e) {
        // Manejar la excepción
        e.printStackTrace();
    }

    return expedientes;
    }
    
    //Metodo para obtener el ultimo registro en el archivo txt
    public static Expediente obtenerUltimoExpediente() {
    List<Expediente> expedientes = cargarExpedientesDesdeArchivo();

    if (!expedientes.isEmpty()) {
        return expedientes.get(expedientes.size() - 1);
    } else {
        return null; // Devolver null si no hay expedientes disponibles
    }
}

    
    // Método para convertir los datos del expediente a formato CSV
    public String toCSV() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        // Convertir medicamentos a una cadena
        String medicamentosStr = String.join(", ", medicamentos);

        return String.format("%s, %s, %s, %s, %s, %.2f",nombrePaciente, dateFormat.format(fechaCita), motivoCita,
                diagnostico, medicamentosStr, cobro);
    }
}