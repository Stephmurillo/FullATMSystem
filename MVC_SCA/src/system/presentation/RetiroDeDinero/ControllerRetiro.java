package system.presentation.RetiroDeDinero;

import system.Aplicacion;

public class ControllerRetiro {
    ModelRetiro model;
    ViewRetiro view;

    public ControllerRetiro(ModelRetiro model, ViewRetiro view) {
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
}
