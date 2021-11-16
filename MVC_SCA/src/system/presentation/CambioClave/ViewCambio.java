package system.presentation.CambioClave;

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
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ViewCambio extends javax.swing.JFrame implements java.util.Observer {

    public ViewCambio() {
        initComponents();
        this.setIconImage(new ImageIcon(getClass().getResource("claveIcon.png")).getImage());
    }

    ControllerCambio controller;
    ModelCambio model;

    public void setController(ControllerCambio controller) {
        this.controller = controller;
    }

    public ControllerCambio getController() {
        return controller;
    }

    public void setModel(ModelCambio model) {
        this.model = model;
        model.addObserver(this);
    }

    public ModelCambio getModel() {
        return model;
    }

    @Override
    public void update(Observable o, Object arg) {

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        limpiar = new javax.swing.JButton();
        Aceptar = new javax.swing.JButton();
        regresar = new javax.swing.JButton();
        claveActual = new javax.swing.JPasswordField();
        nuevaClave = new javax.swing.JPasswordField();
        confirmacionClave = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Cambio de Clave");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Clave Actual");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Nueva Clave");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Confirme su clave");

        limpiar.setText("Limpiar");
        limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiarActionPerformed(evt);
            }
        });

        Aceptar.setText("Aceptar");
        Aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AceptarActionPerformed(evt);
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
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(limpiar)
                    .addComponent(jLabel2))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(Aceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(regresar))
                    .addComponent(claveActual)
                    .addComponent(nuevaClave)
                    .addComponent(confirmacionClave))
                .addGap(32, 32, 32))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(claveActual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(nuevaClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(confirmacionClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(limpiar)
                    .addComponent(regresar)
                    .addComponent(Aceptar))
                .addGap(37, 37, 37))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void regresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regresarActionPerformed
        controller.hide();
    }//GEN-LAST:event_regresarActionPerformed

    private void AceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AceptarActionPerformed
        char ch;
        boolean capitalFlag = false;
        boolean lowerCaseFlag = false;
        boolean numberFlag = false;
        try {
            
            if (model.getCliente().getClave().compareTo(String.valueOf(claveActual.getPassword())) == 0) {
                if (String.valueOf(nuevaClave.getPassword()).compareTo(String.valueOf(confirmacionClave.getPassword())) == 0) {
                    String password = String.valueOf(nuevaClave.getPassword());
                    if (password.length() >= 8) {
                        for (int i = 0; i < password.length(); i++) {
                            ch = password.charAt(i);
                            if (Character.isDigit(ch)) {
                                numberFlag = true;
                            } else if (Character.isUpperCase(ch)) {
                                capitalFlag = true;
                            } else if (Character.isLowerCase(ch)) {
                                lowerCaseFlag = true;
                            }
                        }
                        if (numberFlag && capitalFlag && lowerCaseFlag) {
                            controller.cambio(password);
                            this.cleanForm();
                            this.MSJSistemaCambioClave(0);
                            controller.showLogin();
                        } else {
                            this.MSJSistemaCambioClave(1);
                        }
                    } else {
                        this.MSJSistemaCambioClave(1);
                    }
                } else {
                    this.MSJSistemaCambioClave(2);
                }
            } else {
                this.MSJSistemaCambioClave(3);
            }
        } catch (Exception ex) {}
    }//GEN-LAST:event_AceptarActionPerformed

    private void cleanForm() {
        nuevaClave.setText("");
        confirmacionClave.setText("");
        claveActual.setText("");
    }

    private void limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiarActionPerformed
        nuevaClave.setText("");
        confirmacionClave.setText("");
        claveActual.setText("");
    }//GEN-LAST:event_limpiarActionPerformed

    public void MSJSistemaCambioClave(int i) {
        JFrame frame = new JFrame("ERROR");
        JFrame frame1 = new JFrame("CONFIRMACION");
        if (i == 0) {
            JOptionPane.showMessageDialog(frame1, "CLAVE MODIFICADA EXITOSAMENTE");
        } else if (i == 1) {
            JOptionPane.showMessageDialog(frame, "LA CLAVE NO ES SEGURA", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else if (i == 2) {
            JOptionPane.showMessageDialog(frame, "LA CLAVE NUEVA NO COINCIDE", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else if (i == 3) {
            JOptionPane.showMessageDialog(frame, "LA CLAVE ACTUAL NO COINCIDE", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Aceptar;
    private javax.swing.JPasswordField claveActual;
    private javax.swing.JPasswordField confirmacionClave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton limpiar;
    private javax.swing.JPasswordField nuevaClave;
    private javax.swing.JButton regresar;
    // End of variables declaration//GEN-END:variables
}
