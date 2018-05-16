
package consultoriodental;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;

/**
 *
 * @author Armando
 */
public class FondoPanel extends javax.swing.JPanel {
 private String ru ;
    /**
     * Creates new form Panel
     */
    public FondoPanel(String ruta) {
        initComponents();
        this.setSize(400,400);
        this.ru = ruta;
        
    }
    
    
    
    public void paintComponent(Graphics g){
    Dimension tamanio = getSize();
    ImageIcon img = new ImageIcon(getClass().getResource(ru));
    g.drawImage(img.getImage(),0,0,tamanio.width,tamanio.height,null);
    setOpaque(false);
    super.paintComponent(g);   
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 767, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 475, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
