package consultoriodental;

import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.net.Socket;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JDesktopPane;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

/**
 *
 * @author Armando
 */
public class Agregar_cita extends javax.swing.JInternalFrame {

    String url = "jdbc:mysql://localhost:3306/clinicadental?user=root&password=panda101";
    int auxID = 0;
    MenuPrincipal mp;
    MenuSecretaria ms;
    boolean isAdmin;

    public Agregar_cita(boolean permisos,JFrame menu) {
        initComponents();
        if(permisos){
            mp=(MenuPrincipal)menu;
            isAdmin=true;
        }else{
            ms=(MenuSecretaria)menu;
            isAdmin=false;
        }
        ManejadorTecla mt = new ManejadorTecla();
        setTitle("Agregar nueva cita ");
        FondoPanel fp = new FondoPanel("/fondo/fondoverde.jpg");
        fp.setSize(794, 509);
        this.add(fp, BorderLayout.CENTER);
        //  this.setBounds(0, 0, 200, 200);
        this.setLocked(true);
        iNombre.setFocusable(true);
        this.pack();

    }

    public java.util.Date obtenerFechaActual() {
        java.util.Date date = new java.util.Date();
        SimpleDateFormat fdate = new SimpleDateFormat("dd");
        SimpleDateFormat fMes = new SimpleDateFormat("MM");

        int dia = (Integer.parseInt(fdate.format(date)));
        int mes = (Integer.parseInt(fMes.format(date)));
        if (mes == 02) {
            if (dia < 28) {
                dia += 1;
            } else {
                dia = 1;
                mes += 1;
            }
        }
        if (mes == 01 && mes == 03 && mes == 05 && mes == 07 && mes == 8 && mes == 10 && mes == 12) {
            if (dia < 31) {
                dia += 1;
            } else {
                dia = 1;
                mes += 1;
            }
        } else if (dia < 30) {
            dia += 1;
        } else {
            dia = 1;
            mes += 1;
        }

        Calendar min = Calendar.getInstance();
        min.setTime(date);
        min.set(Calendar.MONTH, mes - 1);
        min.set(Calendar.DATE, dia);
        System.out.println("fecha actual : "+min.getTime().toString());
        return min.getTime();
    }

    private boolean locked = false;

    @Override
    public void reshape(int x, int y, int width, int height) {
        if (!locked) {
            super.reshape(x, y, width, height);
        }
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    private void EnviarMailConfirmacion(String to) {
        String para=to;
        String Mensage="Querido usuario:  "+iNombre+".\n su cita se a agendado para el dia: "+iFecha.getDate().getTime()+""
                    + "\n a la hora: "+iHora.getSelectedItem().toString()+".\nGracias por su preferencia.";
        String Asunto="CITA AGENDADA EXITOSAMENTE";
        EnviarMail env = new EnviarMail(para, Mensage, Asunto);
        env.SendMail();        
    
    }

    private class ManejadorTecla implements KeyListener {//clase interna

        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                Robot Tecla = null;
                try {
                    Tecla = new Robot();
                } catch (AWTException e1) {
                    e1.printStackTrace();
                }
                Tecla.keyPress(KeyEvent.VK_TAB);

            }
        }

        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyReleased(KeyEvent e) {
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoMotivo = new javax.swing.ButtonGroup();
        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        agregar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        dolormuela = new javax.swing.JRadioButton();
        limpieza = new javax.swing.JRadioButton();
        ajuste = new javax.swing.JRadioButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        iHora = new javax.swing.JComboBox<>();
        ajuste1 = new javax.swing.JRadioButton();
        ajuste2 = new javax.swing.JRadioButton();
        ajuste3 = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        iNombre = new javax.swing.JTextField();
        iApPaterno = new javax.swing.JTextField();
        iApMaterno = new javax.swing.JTextField();
        iFecha = new com.toedter.calendar.JDateChooser();

        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("jRadioButtonMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);

        jLabel2.setText("Nombre: ");

        jLabel3.setText("Fecha: ");

        jLabel4.setText("Hora:");

        agregar.setBackground(new java.awt.Color(168, 202, 235));
        agregar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        agregar.setText("agregar");
        agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(168, 202, 235));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        grupoMotivo.add(dolormuela);
        dolormuela.setSelected(true);
        dolormuela.setText("Dolor de muela");

        grupoMotivo.add(limpieza);
        limpieza.setText("Limpieza general");

        grupoMotivo.add(ajuste);
        ajuste.setText("Ajuste de brackets");

        jLabel8.setText("Apellido paterno:");

        jLabel9.setText("Apellido materno:");

        iHora.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "9:00", "9:30", "10:00", "10:30", "11:00", "11:30", "12:00", "12:30", "13:00", "13:30", "14:00", "14:30", "15:00", "15:30", "16:00" }));

        grupoMotivo.add(ajuste1);
        ajuste1.setText("Consulta con medico cirujano");

        grupoMotivo.add(ajuste2);
        ajuste2.setText("Consulta con medico ortodoncista");

        grupoMotivo.add(ajuste3);
        ajuste3.setText("Consulta general");

        jLabel7.setText("Motivo:");

        iNombre.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        iApPaterno.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        iApPaterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iApPaternoActionPerformed(evt);
            }
        });

        iApMaterno.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        iApMaterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iApMaternoActionPerformed(evt);
            }
        });

        iFecha.setDate(obtenerFechaActual());
        iFecha.setMaxSelectableDate(new java.util.Date(1546671675000L));
        iFecha.setMinSelectableDate(obtenerFechaActual());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 451, Short.MAX_VALUE)
                .addComponent(agregar)
                .addGap(99, 99, 99)
                .addComponent(jButton2)
                .addGap(56, 56, 56))
            .addGroup(layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(iFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(iNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(iApPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(iApMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addComponent(jLabel7))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(iHora, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(102, 102, 102)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dolormuela)
                            .addComponent(ajuste)
                            .addComponent(ajuste3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(limpieza)
                            .addComponent(ajuste2)
                            .addComponent(ajuste1))))
                .addContainerGap(97, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(iNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(iApPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(iApMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(iFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(iHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jLabel7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(dolormuela)
                            .addComponent(ajuste2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ajuste)
                            .addComponent(limpieza))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ajuste3)
                            .addComponent(ajuste1))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 155, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(agregar)
                    .addComponent(jButton2))
                .addGap(77, 77, 77))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarActionPerformed
        if(iNombre.getText().isEmpty()||iApPaterno.getText().isEmpty()||iApMaterno.getText().isEmpty()||iFecha.getDate()==null){
            JOptionPane.showMessageDialog(this, "RELLENE TODOS LOS CAMPOS ANTES DE CONTINUAR");
        }else{
            String Correo="";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection co = DriverManager.getConnection(url);

            Statement stm = co.createStatement();
            ResultSet rs;
            try {
                rs = stm.executeQuery("Select * from paciente where nombre='" + iNombre.getText() + "' and apellido_Paterno='" + iApPaterno.getText() + "'and apellido_materno='" + iApMaterno.getText() + "'");
                
                while (rs.next()) {
                    auxID = rs.getInt("id_paciente");
                    Correo=rs.getString("email");
                    System.out.println(rs.getString("nombre"));
                    System.out.println(rs.getString("apellido_Paterno"));
                    System.out.println(rs.getString("apellido_materno"));
                }
                rs.close();
            } catch (SQLException ex) {
                System.out.println("no esta");
                Logger.getLogger(Agregar_cita.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (auxID != 0) {
                PreparedStatement pstm = co.prepareStatement("insert into clinicadental.cita(fecha_cita,hora_cita,motivo,id_paciente,id_medico) "
                        + "values(?,?,?,?,?)");

                java.util.Date f = iFecha.getDate();
                java.sql.Date d = new java.sql.Date(f.getTime());

                pstm.setDate(1, d);
                pstm.setString(2, iHora.getSelectedItem().toString());
                if (dolormuela.isSelected()) {
                    pstm.setString(3, "dolor de muela");
                }
                if (limpieza.isSelected()) {
                    pstm.setString(3, "limpieza general");
                } else {
                    pstm.setString(3, "ajuste de brackets");
                }
                pstm.setInt(4, auxID);
                pstm.setInt(5, 1);
                pstm.executeUpdate();
                pstm.close();
                
                try {
                    Socket s = new Socket("www.gmail.com", 80);
                    if (s.isConnected()) {
                        EnviarMailConfirmacion(Correo);
                    }
                } catch (IOException ex) {
                    Logger.getLogger(AgregarPaciente.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            } else {
                int reply = JOptionPane.showConfirmDialog(this, "El paciente no esta registrado en nuestra Base de Datos,\n ¿DESEA REGISTRARLO? ",
                        "El paciente no esta registrado en nuestra Base de Datos", JOptionPane.OK_CANCEL_OPTION);
                //JOptionPane.showMessageDialog(null, "El paciente no esta registrada en nuestra Base de Datos");
                if(reply==0){
                    AgregarPaciente ap=new AgregarPaciente(isAdmin,(isAdmin?mp:ms));
                    ap.asignarValor(iNombre.getText(), iApPaterno.getText(), iApMaterno.getText()); 
                    JDialog frame= new JDialog();
                    frame.setModal(true);
                    frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
                    JDesktopPane desk= new JDesktopPane();
                    desk.removeAll();
                    ap.panelPadre(frame);
                    frame.setLocation((isAdmin?mp.localizacion():ms.localizacion()));
                    desk.add(ap);
                    frame.add(desk);
                    ap.setSize(757, 493);
                    desk.setSize(757, 493);
                    frame.setSize(757, 493);
                    ap.show();
                    desk.setVisible(true);
                    desk.show();
                    frame.validate();
                    frame.repaint();
                    frame.setVisible(true);
                    
                }                
            }
            co.close();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Agregar_cita.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        }

    }//GEN-LAST:event_agregarActionPerformed

    private void iApMaternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iApMaternoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_iApMaternoActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void iApPaternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iApPaternoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_iApPaternoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregar;
    private javax.swing.JRadioButton ajuste;
    private javax.swing.JRadioButton ajuste1;
    private javax.swing.JRadioButton ajuste2;
    private javax.swing.JRadioButton ajuste3;
    private javax.swing.JRadioButton dolormuela;
    private javax.swing.ButtonGroup grupoMotivo;
    private javax.swing.JTextField iApMaterno;
    private javax.swing.JTextField iApPaterno;
    private com.toedter.calendar.JDateChooser iFecha;
    private javax.swing.JComboBox<String> iHora;
    private javax.swing.JTextField iNombre;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    private javax.swing.JRadioButton limpieza;
    // End of variables declaration//GEN-END:variables
}
