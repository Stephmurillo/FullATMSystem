package system.presentation.RetiroDeDinero;

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

    public void show(Cliente cliente) {
        this.view.setVisible(true);
        model.setCliente(cliente);
        view.setSaldoCuenta(String.valueOf(model.getCliente().getSaldoCuenta()));
    }

    public void hide() {
        this.view.setVisible(false);
        Application.MENUES.show(model.getCliente());
    }

    public void retiro(double monto) throws Exception {
        try {
            Proxy.instance().retiro(monto);
            model.commit();
        } catch (Exception e) {}
    }

    public double balance() throws Exception {
        try {
            double balance = Proxy.instance().balance(model.getCliente().getUsuario());
            model.commit();
            return balance;
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
            return 0;
        }
    }
}
