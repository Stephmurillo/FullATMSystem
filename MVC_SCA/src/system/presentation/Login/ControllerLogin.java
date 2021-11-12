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
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import sistema.logic.Cliente;
import system.Aplicacion;
import system.logic.Proxy;
import system.logic.xmlPersister;

public class ControllerLogin {

    ViewLogin view;
    public ModelLogin model;
    
    Proxy localService;

    public ControllerLogin(ModelLogin model, ViewLogin view) throws IOException {
        this.view = view;
        this.model = model;
        view.setController(this);
        localService = (Proxy) Proxy.instance();
        localService.setController(view.getController());
        view.setModel(model);  
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

    public void login(String usuario, String clave) throws Exception {
        Cliente u = new Cliente(usuario, clave, 10000);
        Cliente logged = Proxy.instance().login(u);
        model.setCliente(logged);

        try {
            if (logged != null) {
                xmlPersister x = new xmlPersister(model.getCliente().getUsuario());
                model.setCliente(x.load());
            }
        } catch (Exception e) {
            System.out.println("No se cargo");
        }

        model.commit();
        
//        Cliente aux = Proxy.instance().clienteGet(user);
//        try {
//            if (aux != null && password.compareTo(aux.getClave()) == 0) {
//                Cliente logged = (Cliente) Proxy.instance().login(aux);
//                model.setCliente(logged);
//                try {
//                    if (logged != null) {
//                        xmlPersister x = new xmlPersister(model.getCliente().getUsuario());
//                        model.setCliente((Cliente) x.load());
//                    }
//                } catch (Exception e) {
//                    System.out.println("No se cargo.");
//                }
//                model.commit();
//                return logged;
//            }
//        } catch (Exception ex) {}
//        return null;
    }
}
