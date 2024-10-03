
/*Franklin Giovanny Avila Gonzalez
AG22046- POO- GT04*/

package GestionVetPet;

import java.util.Date;

public class Vacuna {
    private Date fechaVacuna;
    private String nombreVacuna;
    private double peso;
    private double altura;
    private int edad;

    public Vacuna(Date fechaVacuna, String nombreVacuna, double peso, double altura, int edad) {
        this.fechaVacuna = fechaVacuna;
        this.nombreVacuna = nombreVacuna;
        this.peso = peso;
        this.altura = altura;
        this.edad = edad;
    }

    // Getters y setters
    public Date getFechaVacuna() {
        return fechaVacuna;
    }

    public void setFechaVacuna(Date fechaVacuna) {
        this.fechaVacuna = fechaVacuna;
    }

    public String getNombreVacuna() {
        return nombreVacuna;
    }

    public void setNombreVacuna(String nombreVacuna) {
        this.nombreVacuna = nombreVacuna;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    // Método para registrar una nueva vacuna
    public static Vacuna RegistrarVacuna(Date fechaVacuna, String nombreVacuna, double peso, double altura, int edad) {
        return new Vacuna(fechaVacuna, nombreVacuna, peso, altura, edad);
    }
}
