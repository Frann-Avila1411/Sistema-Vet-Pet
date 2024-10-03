
/*Franklin Giovanny Avila Gonzalez
AG22046- POO- GT04*/

package GestionVetPet;
import java.util.Date;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Paciente {
    private String nombre;
    private String nombreDueño;
    private int edad;
    private String categoria;
    private String raza;
    private String sexo;
    private Date fechaInscripcion;
    private double altura;
    private double peso;
    private int idUnico;
    private String pelaje;
    private Date fechaNacimiento;

    public Paciente(String nombre, String nombreDueño, int edad, String categoria, String raza, String sexo,
                    Date fechaInscripcion, double altura, double peso, int idUnico, String pelaje, Date fechaNacimiento) {
        this.nombre = nombre;
        this.nombreDueño = nombreDueño;
        this.edad = edad;
        this.categoria = categoria;
        this.raza = raza;
        this.sexo = sexo;
        this.fechaInscripcion = fechaInscripcion;
        this.altura = altura;
        this.peso = peso;
        this.idUnico = idUnico;
        this.pelaje = pelaje;
        this.fechaNacimiento = fechaNacimiento;
    }

    // Getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreDueño() {
        return nombreDueño;
    }

    public void setNombreDueño(String nombreDueño) {
        this.nombreDueño = nombreDueño;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Date getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(Date fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int getIdUnico() {
        return idUnico;
    }

    public void setIdUnico(int idUnico) {
        this.idUnico = idUnico;
    }

    public String getPelaje() {
        return pelaje;
    }

    public void setPelaje(String pelaje) {
        this.pelaje = pelaje;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    
    //Guardar Paciente en un txt
    
    public void guardarPacienteEnArchivo() {
        try (FileWriter writer = new FileWriter("Pacientes.txt", true);
             BufferedWriter bufferedWriter = new BufferedWriter(writer);
             PrintWriter out = new PrintWriter(bufferedWriter)) {
            out.println(this.toCSV());
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Paciente> cargarPacientesDesdeArchivo() {
        ArrayList<Paciente> pacientes = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("Pacientes.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",  ");
                if (parts.length == 12) {
                    try {
                        Paciente paciente = new Paciente(
                                parts[0].trim(), parts[1].trim(), Integer.parseInt(parts[2].trim()),
                                parts[3].trim(), parts[4].trim(), parts[5].trim(),
                                new SimpleDateFormat("yyyy-MM-dd").parse(parts[6].trim()),
                                Double.parseDouble(parts[7].trim()), Double.parseDouble(parts[8].trim()),
                                Integer.parseInt(parts[9].trim()), parts[10].trim(),
                                new SimpleDateFormat("yyyy-MM-dd").parse(parts[11].trim())
                        );
                        pacientes.add(paciente);
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
        return pacientes;
    }

    public String toCSV() {
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    return String.format("%s,  %s,  %d,  %s,  %s,  %s,  %s,  %.2f,  %.2f,  %d,  %s,  %s",
            nombre, nombreDueño, edad, categoria, raza, sexo,
            dateFormat.format(fechaInscripcion), altura, peso, idUnico, pelaje,
            dateFormat.format(fechaNacimiento));
}
    // Método para buscar un paciente por su ID único
    public static Paciente buscarPacientePorId(ArrayList<Paciente> pacientes, int idUnico) {
        for (Paciente paciente : pacientes) {
            if (paciente.getIdUnico() == idUnico) {
                return paciente;
            }
        }
        return null; // Si no se encuentra el paciente
    }

    // Método para eliminar un paciente por su ID único
    public static void eliminarPacientePorId(ArrayList<Paciente> pacientes, int idUnico) {
        Paciente pacienteAEliminar = buscarPacientePorId(pacientes, idUnico);
        if (pacienteAEliminar != null) {
            pacientes.remove(pacienteAEliminar);
        }
    }
    // Agregar un nuevo paciente
    public static Paciente AgregarPacienteNuevo(String nombre, String nombreDueño, int edad, String categoria,
                                                String raza, String sexo, Date fechaInscripcion, double altura,
                                                double peso, int idUnico, String pelaje, Date fechaNacimiento) {
        Paciente nuevoPaciente = new Paciente(nombre, nombreDueño, edad, categoria, raza, sexo, fechaInscripcion,
                altura, peso, idUnico, pelaje, fechaNacimiento);

        return nuevoPaciente;
    }
    // Método para guardar la lista de pacientes en el archivo
    public static void guardarPacientesEnArchivo(ArrayList<Paciente> pacientes) {
        try (PrintWriter writer = new PrintWriter("Pacientes.txt")) {
            for (Paciente paciente : pacientes) {
                writer.println(paciente.toCSV());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Editar información de un paciente
    public void EditarInformacionPaciente(String nombre, String nombreDueño, int edad, String categoria, String raza,
                                          String sexo, double altura, double peso, String pelaje) {
        this.nombre = nombre;
        this.nombreDueño = nombreDueño;
        this.edad = edad;
        this.categoria = categoria;
        this.raza = raza;
        this.sexo = sexo;
        this.altura = altura;
        this.peso = peso;
        this.pelaje = pelaje;

    }
}