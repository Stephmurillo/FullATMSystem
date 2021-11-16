package system.presentation.Menu;

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

import sistema.logic.Cliente;
import system.Application;
import system.logic.Proxy;

public class ControllerMenu {
    ModelMenu model;
    ViewMenu view;

    public ControllerMenu(ModelMenu model, ViewMenu view) {
        this.model = model;
        this.view = view;
        view.setModel(model);
        view.setController(this);
    }
    
    public void show(Cliente cliente){
        this.view.setVisible(true);
        model.setCliente(cliente);
    }
    
    public void hide(){
        this.view.setVisible(false);
    }
    
    public void exit(){
       System.exit(0);
    }
    
    public void logout() {
        try {
            Proxy.instance().logout();
            
        } catch (Exception ex) {
        }
        model.setCliente(null);
        model.commit();
    }
        
    // Controller methods that respond to View events
    // probably invoke methods from Service,
    // and set data to Model, which in turn causes the View to update 
    
    public void retirosShow(){
        this.hide();
        Application.RETIROS.show(model.getCliente());
    }
    
    public void cambioClaveShow(){
        this.hide();
        Application.CAMBIOCLAVE.show(model.getCliente());
    }    
}
