package system.presentation.Menu;

import java.util.Observable;
import javax.swing.ImageIcon;

public class ViewMenu extends javax.swing.JFrame implements java.util.Observer  {

    public ViewMenu() {
        initComponents();
        this.setIconImage(new ImageIcon(getClass().getResource("homeIcon.png")).getImage());
    }
    
    ControllerMenu controller;
    ModelMenu model;
    
    public void setController(ControllerMenu controller){
        this.controller=controller;
    }

    public ControllerMenu getController() {
        return controller;
    }
    
    public void setModel(ModelMenu model){
        this.model=model;
         model.addObserver(this);
    }

    public ModelMenu getModel() {
        return model;
    }
    
    @Override
    public void update(Observable o, Object arg) {
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        irRetiro = new javax.swing.JButton();
        irCambioC = new javax.swing.JButton();
        salir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Pantalla Principal");
        setLocationByPlatform(true);

        irRetiro.setText("Realizar Retiro");
        irRetiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                irRetiroActionPerformed(evt);
            }
        });

        irCambioC.setText("Cambio de clave");
        irCambioC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                irCambioCActionPerformed(evt);
            }
        });

        salir.setText("Salir");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(75, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(irCambioC, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                    .addComponent(irRetiro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(salir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(65, 65, 65))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(48, Short.MAX_VALUE)
                .addComponent(irRetiro, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(irCambioC, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(salir, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void irRetiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_irRetiroActionPerformed
        controller.retirosShow();
    }//GEN-LAST:event_irRetiroActionPerformed

    private void irCambioCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_irCambioCActionPerformed
        controller.cambioClaveShow();
    }//GEN-LAST:event_irCambioCActionPerformed

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        controller.exit();
    }//GEN-LAST:event_salirActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton irCambioC;
    private javax.swing.JButton irRetiro;
    private javax.swing.JButton salir;
    // End of variables declaration//GEN-END:variables
}
