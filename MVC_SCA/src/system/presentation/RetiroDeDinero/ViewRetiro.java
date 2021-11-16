package system.presentation.RetiroDeDinero;

/*
* (c) 2021
* @author Yoselin Rojas, Cinthya Murillo
* @version 1.0.0 2021-10-24
*
* -----------------------------------------------
* EIF206 Programación III
* 2do Ciclo 2021
* II Proyecto
*
* 207700499 Rojas Fuentes, Yoselin - Grupo 04
* 305260682 Murillo Hidalgo, Cinthya - Grupo 03
* -----------------------------------------------
 */
import java.util.Observable;
import javax.swing.ImageIcon;

public class ViewRetiro extends javax.swing.JFrame implements java.util.Observer {

    public ViewRetiro() {
        initComponents();
        this.setIconImage(new ImageIcon(getClass().getResource("atmIcon.png")).getImage());
    }

    ControllerRetiro controller;
    ModelRetiro model;

    public void setController(ControllerRetiro controller) {
        this.controller = controller;
    }

    public ControllerRetiro getController() {
        return controller;
    }

    public void setModel(ModelRetiro model) {
        this.model = model;
        model.addObserver(this);
    }

    public ModelRetiro getModel() {
        return model;
    }

    public void setSaldoCuenta(String saldo) {
        saldoCuenta.setText(saldo);
    }

    @Override
    public void update(Observable o, Object arg) {
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        saldo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        saldoCuenta = new javax.swing.JTextField();
        montoRetiro = new javax.swing.JTextField();
        limpiar = new javax.swing.JButton();
        aceptar = new javax.swing.JButton();
        regresar = new javax.swing.JButton();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Pantalla de Retiro de Dinero");
        setResizable(false);

        saldo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        saldo.setText("Saldo de cuenta");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Monto a Retirar");

        saldoCuenta.setEditable(false);

        limpiar.setText("Limpiar");
        limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiarActionPerformed(evt);
            }
        });

        aceptar.setText("Aceptar");
        aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarActionPerformed(evt);
            }
        });

        regresar.setText("Regresar");
        regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(limpiar)
                .addGap(43, 43, 43)
                .addComponent(aceptar)
                .addGap(39, 39, 39)
                .addComponent(regresar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 79, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(saldo)
                        .addGap(140, 140, 140))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(montoRetiro, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(saldoCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(72, 72, 72))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(139, 139, 139))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(saldo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(saldoCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(montoRetiro, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(aceptar)
                    .addComponent(regresar)
                    .addComponent(limpiar))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiarActionPerformed
        try {
            this.montoRetiro.setText("");
        } catch (Exception ex) {}
    }//GEN-LAST:event_limpiarActionPerformed

    private void regresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regresarActionPerformed
        controller.hide();
    }//GEN-LAST:event_regresarActionPerformed

    private void aceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarActionPerformed
        try {
            controller.retiro(Double.valueOf(montoRetiro.getText()));
            this.saldoCuenta.setText(String.valueOf(controller.balance()));
        } catch (Exception ex) {}
    }//GEN-LAST:event_aceptarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aceptar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton limpiar;
    private javax.swing.JTextField montoRetiro;
    private javax.swing.JButton regresar;
    private javax.swing.JLabel saldo;
    private javax.swing.JTextField saldoCuenta;
    // End of variables declaration//GEN-END:variables
}
