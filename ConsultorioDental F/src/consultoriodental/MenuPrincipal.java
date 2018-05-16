
package consultoriodental;
import java.awt.BorderLayout;
import java.awt.Image;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 *
 * @author Armando
 */
public class MenuPrincipal extends javax.swing.JFrame {

  
    public MenuPrincipal() {
        initComponents();
        
   
        setLocationRelativeTo(this);
        setTitle("Menu principal");
          FondoPanel fp  = new FondoPanel("/fondo/fon11.png");
        fp.setSize(1062,656);
      
        this.add(fp,BorderLayout.CENTER);        
        
        FondoPanel fpl  = new FondoPanel("/fondo/r.png");
        fpl.setSize(110,125);
        logo.add(fpl,BorderLayout.CENTER);
        logo.add(fpl);
        
        this.pack();       
        escritorio.setVisible(false);
        
    }
     private boolean locked = false;
@Override
public void reshape(int x, int y, int width, int height) {
if (!locked) {
super.reshape(x, y, width, height);}
}
public boolean isLocked() {return locked;}
public void setLocked(boolean locked) {this.locked = locked;}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        agregar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        consultar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        escritorio = new javax.swing.JDesktopPane();
        cambiarUsuario = new javax.swing.JButton();
        logo = new javax.swing.JPanel();
        agregarPaciente = new javax.swing.JButton();
        buscarPAciente = new javax.swing.JButton();
        listarCitas = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        agregar.setBackground(new java.awt.Color(0, 102, 0));
        agregar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        agregar.setForeground(new java.awt.Color(255, 255, 255));
        agregar.setText("Generar nueva cita");
        agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("SISTEMA DE CITAS");

        consultar.setBackground(new java.awt.Color(0, 102, 0));
        consultar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        consultar.setForeground(new java.awt.Color(255, 255, 255));
        consultar.setText("Consultar cita");
        consultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultarActionPerformed(evt);
            }
        });

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        escritorio.setBackground(new java.awt.Color(202, 233, 250));
        escritorio.setForeground(new java.awt.Color(205, 239, 250));

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 775, Short.MAX_VALUE)
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 517, Short.MAX_VALUE)
        );

        cambiarUsuario.setBackground(new java.awt.Color(0, 102, 0));
        cambiarUsuario.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cambiarUsuario.setForeground(new java.awt.Color(255, 255, 255));
        cambiarUsuario.setText("Cambiar de usuario");
        cambiarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cambiarUsuarioActionPerformed(evt);
            }
        });

        logo.setBackground(new java.awt.Color(255, 255, 255));
        logo.setOpaque(false);

        javax.swing.GroupLayout logoLayout = new javax.swing.GroupLayout(logo);
        logo.setLayout(logoLayout);
        logoLayout.setHorizontalGroup(
            logoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 131, Short.MAX_VALUE)
        );
        logoLayout.setVerticalGroup(
            logoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 177, Short.MAX_VALUE)
        );

        agregarPaciente.setBackground(new java.awt.Color(0, 102, 0));
        agregarPaciente.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        agregarPaciente.setForeground(new java.awt.Color(255, 255, 255));
        agregarPaciente.setText("Registrar paciente");
        agregarPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarPacienteActionPerformed(evt);
            }
        });

        buscarPAciente.setBackground(new java.awt.Color(0, 102, 0));
        buscarPAciente.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        buscarPAciente.setForeground(new java.awt.Color(255, 255, 255));
        buscarPAciente.setText("Buscar paciente");
        buscarPAciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarPAcienteActionPerformed(evt);
            }
        });

        listarCitas.setBackground(new java.awt.Color(0, 102, 0));
        listarCitas.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        listarCitas.setForeground(new java.awt.Color(255, 255, 255));
        listarCitas.setText("Ver citas del dia");
        listarCitas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listarCitasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(consultar, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(agregarPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buscarPAciente, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cambiarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(listarCitas, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(escritorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(85, 85, 85))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(326, 326, 326))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(escritorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(agregar)
                        .addGap(26, 26, 26)
                        .addComponent(consultar)
                        .addGap(26, 26, 26)
                        .addComponent(agregarPaciente)
                        .addGap(26, 26, 26)
                        .addComponent(buscarPAciente)
                        .addGap(18, 18, 18)
                        .addComponent(listarCitas)
                        .addGap(187, 187, 187)
                        .addComponent(cambiarUsuario)))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarActionPerformed

        escritorio.removeAll();
        Agregar_cita ac = new Agregar_cita();
       ac = new  Agregar_cita();
      escritorio.add(ac);
       ac.show();
       escritorio.setVisible(true);
       revalidate();
       repaint();
    }//GEN-LAST:event_agregarActionPerformed

    private void consultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultarActionPerformed
     escritorio.removeAll();
        BuscarCita bc = new BuscarCita();
     bc= new  BuscarCita();
      escritorio.add(bc);
     bc.show();
       escritorio.setVisible(true);
       revalidate();
       repaint();
    }//GEN-LAST:event_consultarActionPerformed

    private void cambiarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cambiarUsuarioActionPerformed
         dispose();
        Login l= new Login(); 
        l.setVisible(true);
    }//GEN-LAST:event_cambiarUsuarioActionPerformed

    private void agregarPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarPacienteActionPerformed
          escritorio.removeAll();
          AgregarPaciente ap = new AgregarPaciente();
       ap = new AgregarPaciente();
      escritorio.add(ap);
      ap.show();
       escritorio.setVisible(true);
       revalidate();
       repaint();
    }//GEN-LAST:event_agregarPacienteActionPerformed

    private void buscarPAcienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarPAcienteActionPerformed
          escritorio.removeAll();
          BuscarPaciente bp = new BuscarPaciente();
      bp = new BuscarPaciente();
       escritorio.add(bp);
      bp.show();
       escritorio.setVisible(true);
       revalidate();
       repaint();
    }//GEN-LAST:event_buscarPAcienteActionPerformed

    private void listarCitasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listarCitasActionPerformed
                                                
        escritorio.removeAll();
        ListarCita lc =new ListarCita();
      lc= new  ListarCita();
       escritorio.add(lc);
       lc.show();
       escritorio.setVisible(true);
       revalidate();
       repaint();
        
    }//GEN-LAST:event_listarCitasActionPerformed
   
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregar;
    private javax.swing.JButton agregarPaciente;
    private javax.swing.JButton buscarPAciente;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton cambiarUsuario;
    private javax.swing.JButton consultar;
    private javax.swing.JDesktopPane escritorio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton listarCitas;
    private javax.swing.JPanel logo;
    // End of variables declaration//GEN-END:variables
}
