package system.presentation.Login;

import system.Aplicacion;
import system.Cliente;
import system.logic.Proxy;
import system.logic.xmlPersister;

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
        Aplicacion.MENUES.show();

    }

    public void exit() {
        //Service.instance().store();
    }
    
     public void login() throws Exception{
        Cliente u = new Cliente(view.usuario.getText(),new String(view.clave.getPassword()),0);
        Cliente logged = Proxy.instance().login(u);
        model.setCliente(logged);
        
        try{
             if(logged != null){
                 xmlPersister x = new xmlPersister(model.getCliente().getUsuario());
                 model.setCliente(x.load());
                 }
        }catch(Exception e){
            System.out.println("No se cargo");
        }
        
        model.commit();
    }
}
