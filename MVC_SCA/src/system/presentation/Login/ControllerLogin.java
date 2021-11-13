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

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import sistema.logic.Cliente;
import system.Aplicacion;
import system.logic.Proxy;

public class ControllerLogin {

    ModelLogin model;
    ViewLogin view;

    public ControllerLogin(ModelLogin model, ViewLogin view) {
        this.model = model;
        this.view = view;
        // invoke Model sets for initialization before linking to the view
        // problably get the data from Proxy
        view.setModel(model);
        view.setController(this);
    }

    public void show() {
        this.view.setVisible(true);
    }

    public void hide() {
        this.view.setVisible(false);
    }

    public void menuShow() {
        this.hide();
        Aplicacion.MENUES.show(model.getCliente());
    }

    public void exit() {
        System.exit(0);
    }

    public void login(String user, String password) throws Exception {
            try {
                Cliente aux = new Cliente (user, password, 0);
                Cliente logged = (Cliente) Proxy.instance().login(aux);
                model.setCliente(logged);
                model.commit();
                MSJSistema(1);
                this.menuShow();
            } catch (Exception e) {
                MSJSistema(0);
            }
    }
    
    public void logout() {
        try {
            Proxy.instance().logout();
            
        } catch (Exception ex) {
        }
        model.setCliente(null);
        model.commit();
    }
    
    public void MSJSistema(int i){
        JFrame frame = new JFrame("ERROR");
        JFrame frame1 = new JFrame("CONFIRMACION");
        if(i == 0){
            JOptionPane.showMessageDialog(frame,"No coincide con la base de datos", "ERROR",
                    JOptionPane.ERROR_MESSAGE);
        }
        else if(i == 1){
            JOptionPane.showMessageDialog(frame1,"ACCESO CONCEDIDO"); 
        }
    }
}
