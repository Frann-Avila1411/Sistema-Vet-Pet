/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package InterfacesVetPet;

import java.util.Date;
import GestionVetPet.Cita;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;


public class GestionarCita extends javax.swing.JFrame {

    /**
     * Creates new form GestionarCita
     */
    public GestionarCita() {
        initComponents();
        this.setLocationRelativeTo(null);
        textAreaMostrar.setEditable(false);
    }
    
private void mostrarCitas() {
        ArrayList<Cita> citas = Cita.cargarCitasDesdeArchivo();

        // Limpiar el textArea antes de mostrar las citas
        textAreaMostrar.setText("");

// Mostrar cada cita en el textArea
    for (Cita cita : citas) {
        // Formatear la salida de la cita
        String citaFormateada = String.format(
                "Fecha de Cita: %s\n" +
                "Nombre del Paciente: %s\n" +
                "Motivo: %s\n\n",
                new SimpleDateFormat("yyyy-MM-dd").format(cita.getFecha()),
                cita.getNombrePaciente(), cita.getMotivo()
        );

        // Agregar la cita formateada al textArea
        textAreaMostrar.append(citaFormateada);
    }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        textAreaMostrar = new java.awt.TextArea();
        btnCerrar = new javax.swing.JButton();
        Citas = new javax.swing.JLabel();
        Fecha = new javax.swing.JLabel();
        Nombre = new javax.swing.JLabel();
        motivo = new javax.swing.JLabel();
        Txt1 = new javax.swing.JTextField();
        Txt2 = new javax.swing.JTextField();
        Txt3 = new javax.swing.JTextField();
        btnGuardarCita = new javax.swing.JButton();
        verCitas = new javax.swing.JButton();
        EliminarCita = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(464, 550));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        textAreaMostrar.setVisible(false);
        getContentPane().add(textAreaMostrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 420, 320));

        btnCerrar.setText("Cerrar");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 0, -1, -1));

        Citas.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        Citas.setText("Citas");
        getContentPane().add(Citas, new org.netbeans.lib.awtextra.AbsoluteConstraints(205, 30, -1, -1));

        Fecha.setText("Fecha de Cita:");
        getContentPane().add(Fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 97, -1, -1));

        Nombre.setText("Nombre del Paciente:");
        getContentPane().add(Nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 154, -1, -1));

        motivo.setText("Motivo de la Cita:");
        getContentPane().add(motivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 257, -1, -1));

        Txt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Txt1ActionPerformed(evt);
            }
        });
        getContentPane().add(Txt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(136, 91, 263, 27));
        getContentPane().add(Txt2, new org.netbeans.lib.awtextra.AbsoluteConstraints(133, 150, 270, 28));
        getContentPane().add(Txt3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 210, 263, 109));

        btnGuardarCita.setText("Agendar Cita");
        btnGuardarCita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarCitaActionPerformed(evt);
            }
        });
        getContentPane().add(btnGuardarCita, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, -1, -1));

        verCitas.setText("Ver Citas");
        verCitas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verCitasActionPerformed(evt);
            }
        });
        getContentPane().add(verCitas, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 390, -1, -1));

        EliminarCita.setText("Eliminar Cita");
        EliminarCita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarCitaActionPerformed(evt);
            }
        });
        getContentPane().add(EliminarCita, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 390, -1, -1));

        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });
        getContentPane().add(btnVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 440, 79, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
      dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void Txt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Txt1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Txt1ActionPerformed

    private void btnGuardarCitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarCitaActionPerformed
        
        Date fecha = obtenerFechaDesdeTextField(Txt1);
        String nombrePaciente = Txt2.getText();
        String motivo = Txt3.getText();
        
        // Crear un nuevo objeto Cita con los datos ingresados
    Cita nuevaCita = new Cita(fecha, nombrePaciente, motivo);

    // Guardar el nuevo paciente en el archivo
    nuevaCita.guardarCitaEnArchivo();
    
    // Limpiar los campos después de guardar
    Txt1.setText("");
    Txt2.setText("");
    Txt3.setText("");
    
    }//GEN-LAST:event_btnGuardarCitaActionPerformed

    private void verCitasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verCitasActionPerformed
        textAreaMostrar.setVisible(true); 
        mostrarCitas();
    }//GEN-LAST:event_verCitasActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        InterfazPacientes a = new InterfazPacientes();
        a.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnVolverActionPerformed

    private void EliminarCitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarCitaActionPerformed
        // Solicitar información para identificar la cita a eliminar
    String nombrePacienteEliminar = JOptionPane.showInputDialog(this, "Ingrese el nombre del paciente a eliminar:");

    // Cargar las citas desde el archivo
    ArrayList<Cita> citas = Cita.cargarCitasDesdeArchivo();

    // Buscar y eliminar la cita
    for (Iterator<Cita> iterator = citas.iterator(); iterator.hasNext();) {
        Cita cita = iterator.next();
        if (cita.getNombrePaciente().equalsIgnoreCase(nombrePacienteEliminar)) {
            iterator.remove(); // Eliminar la cita del ArrayList
            break; // Terminar el bucle al encontrar la primera coincidencia
        }
    }

    // Guardar las citas actualizadas en el archivo
    guardarCitasEnArchivo(citas);

    // Actualizar la visualización de las citas en el JTextArea
    mostrarCitas();
}

private void guardarCitasEnArchivo(ArrayList<Cita> citas) {
    // Guardar las citas actualizadas en el archivo
    try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("Citas.txt")))) {
        for (Cita cita : citas) {
            writer.println(cita.toCSV());
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    
    }//GEN-LAST:event_EliminarCitaActionPerformed
    private Date obtenerFechaDesdeTextField(javax.swing.JTextField textField) {
    try {
        return new SimpleDateFormat("yyyy-MM-dd").parse(textField.getText());
    } catch (ParseException e) {
        e.printStackTrace();
        return null;
        }
    }
    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Citas;
    private javax.swing.JButton EliminarCita;
    private javax.swing.JLabel Fecha;
    private javax.swing.JLabel Nombre;
    private javax.swing.JTextField Txt1;
    private javax.swing.JTextField Txt2;
    private javax.swing.JTextField Txt3;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnGuardarCita;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel motivo;
    private java.awt.TextArea textAreaMostrar;
    private javax.swing.JButton verCitas;
    // End of variables declaration//GEN-END:variables
}
