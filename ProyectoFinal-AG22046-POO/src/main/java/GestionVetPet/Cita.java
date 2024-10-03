/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/*Franklin Giovanny Avila Gonzalez
AG22046- POO- GT04*/

package GestionVetPet;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class Cita {
    private Date fecha;
    private String nombrePaciente;
    private String motivo;

    public Cita(Date fecha, String nombrePaciente, String motivo) {
        this.fecha = fecha;
        this.nombrePaciente = nombrePaciente;
        this.motivo = motivo;
    }

    // Getters y setters
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }
    
    // Guardar Citas en un txt
    public void guardarCitaEnArchivo() {
        try (FileWriter writer = new FileWriter("Citas.txt", true);
             BufferedWriter bufferedWriter = new BufferedWriter(writer);
             PrintWriter out = new PrintWriter(bufferedWriter)) {
            out.println(this.toCSV());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Cita> cargarCitasDesdeArchivo() {
        ArrayList<Cita> citas = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("Citas.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    try {
                        Date fecha = new SimpleDateFormat("yyyy-MM-dd").parse(parts[0].trim());
                        String nombrePaciente = parts[1].trim();
                        String motivo = parts[2].trim();

                        Cita cita = new Cita(fecha, nombrePaciente, motivo);
                        citas.add(cita);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.err.println("Error: La línea en el archivo no tiene el formato correcto.");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return citas;
    }

    public String toCSV() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return String.format("%s,%s,%s", dateFormat.format(fecha), nombrePaciente, motivo);
    }
    
    // Método para agendar una cita
    public static Cita AgendarCita(Date fecha, String nombrePaciente, String motivo) {
        return new Cita(fecha, nombrePaciente, motivo);
    }

    // Método para editar una cita
    public void EditarCita(Date fecha, String motivo) {
        this.fecha = fecha;
        this.motivo = motivo;
    }

    // Método para eliminar una cita
    public void EliminarCita() {
        this.fecha = null;
        this.nombrePaciente = null;
        this.motivo = null;
    }
}