package system.presentation.Login;

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
import java.awt.Color;
import java.util.Arrays;
import java.util.Observable;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import sistema.logic.Cliente;

public class ViewLogin extends javax.swing.JFrame implements java.util.Observer {

    public ViewLogin() {
        initComponents();
        this.setIconImage(new ImageIcon(getClass().getResource("loginIcon.png")).getImage());
    }

    ControllerLogin controller;
    ModelLogin model;

    public void setController(ControllerLogin controller) {
        this.controller = controller;
    }

    public ControllerLogin getController() {
        return controller;
    }

    public void setModel(ModelLogin model) {
        this.model = model;
        model.addObserver(this);
    }

    public ModelLogin getModel() {
        return model;
    }

    @Override
    public void update(Observable o, Object arg) {

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        usuario = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        ingresar = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();
        clave = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Pantalla de Login");
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("loginIcon.png")).getImage());

        jLabel1.setText("Usuario");

        jLabel2.setText("Contraseña");

        ingresar.setText("Ingresar");
        ingresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ingresarActionPerformed(evt);
            }
        });

        cancelar.setText("Cancelar");
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(96, 96, 96))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(usuario, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(ingresar)
                            .addGap(42, 42, 42)
                            .addComponent(cancelar))
                        .addComponent(clave))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(83, 83, 83)))
                .addContainerGap(140, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(clave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ingresar)
                    .addComponent(cancelar))
                .addGap(68, 68, 68))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ingresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ingresarActionPerformed
        try {
            controller.login(usuario.getText(), new String(clave.getPassword()));
            usuario.setBackground(Color.white);
            clave.setBackground(Color.white);
            usuario.setText("");
            clave.setText("");
        } catch (Exception ex) {
            usuario.setBackground(Color.pink);
            clave.setBackground(Color.pink);
        }
    }//GEN-LAST:event_ingresarActionPerformed

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        usuario.setText("");
        clave.setText("");
        usuario.setBackground(Color.WHITE);
        clave.setBackground(Color.WHITE);

    }//GEN-LAST:event_cancelarActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelar;
    private javax.swing.JPasswordField clave;
    private javax.swing.JButton ingresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    public javax.swing.JTextField usuario;
    // End of variables declaration//GEN-END:variables
}
