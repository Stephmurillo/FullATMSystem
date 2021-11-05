package system.presentation.Menu;

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
