package system.presentation.Login;

import system.Aplicacion;

public class ControllerLogin {
    ModelLogin model;
    ViewLogin view;

    public ControllerLogin(ModelLogin model, ViewLogin view) {
       this.model = model;
        this.view = view;
        // invoke Model sets for initialization before linking to the view
        // problably get the data from Service
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
        Aplicacion.MENUES.show();

    }

    public void exit() {
        //Service.instance().store();
    }
}
