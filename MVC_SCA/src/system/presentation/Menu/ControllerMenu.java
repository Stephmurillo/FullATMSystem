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

import system.Aplicacion;

public class ControllerMenu {
    ModelMenu model;
    ViewMenu view;

    public ControllerMenu(ModelMenu model, ViewMenu view) {
        this.model = model;
        this.view = view;
        view.setModel(model);
        view.setController(this);
    }
    
    public void show(){
        this.view.setVisible(true);
    }
    
    public void hide(){
        this.view.setVisible(false);
    }
    
    public void exit(){
       // Service.instance().store();
    }
    
    // Controller methods that respond to View events
    // probably invoke methods from Service,
    // and set data to Model, which in turn causes the View to update 
    
    public void retirosShow(){
        this.hide();
        Aplicacion.RETIROS.show();
    }
    
    public void cambioClaveShow(){
        this.hide();
        Aplicacion.CAMBIOCLAVE.show();
    }    
    
}
