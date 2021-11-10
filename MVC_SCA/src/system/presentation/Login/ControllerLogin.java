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
import system.Aplicacion;
import sistema.logic.Cliente;
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

    public void login(String user, String password) throws Exception {
        Cliente aux = Proxy.instance().clienteGet(user);
        if (aux != null && password == aux.getClave()) {
            Cliente logged = (Cliente) Proxy.instance().login(aux);
            model.setCliente(logged);
            try {
                if (logged != null) {
                    xmlPersister x = new xmlPersister(model.getCliente().getUsuario());
                    model.setCliente((Cliente) x.load());
                }
            } catch (Exception e) {
                System.out.println("No se cargo.");
            }
        }
        else{
            System.out.println("Usuario no encontrado.");
        }
        model.commit();
    }
}
