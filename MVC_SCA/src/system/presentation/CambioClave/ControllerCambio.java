package system.presentation.CambioClave;

import system.Aplicacion;

public class ControllerCambio {
    ModelCambio model;
    ViewCambio view;

    public ControllerCambio(ModelCambio model, ViewCambio view) {
        this.model = model;
        this.view = view;
        // invoke Model sets for initialization before linking to the view
        // problably get the data from Service
        view.setModel(model);
        view.setController(this);
    }
    
    public void show(){
        this.view.setVisible(true);
    }
    
    public void hide(){
        this.view.setVisible(false);
        Aplicacion.MENUES.show();
    }    
    // Controller methods that respond to View events
    // probably invoke methods from Service,
    // and set data to Model, which in turn causes the View to update 
    
    
}
