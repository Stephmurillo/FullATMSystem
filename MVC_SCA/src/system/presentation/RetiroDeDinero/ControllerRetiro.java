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
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import sistema.logic.Cliente;
import system.Aplicacion;
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
    }

    public void hide() {
        this.view.setVisible(false);
        Aplicacion.MENUES.show(model.getCliente());
    }

    public void retiro(double monto) throws Exception {
        try {
            Proxy.instance().retiro(model.getCliente().getUsuario(), monto);
            model.commit();
            MSJSistema(1);
        } catch (Exception e) {
            MSJSistema(0);
        }
    }
    
    public double balance() throws Exception {
        double balance = 0;
        try {
            balance = Double.valueOf(Proxy.instance().balance(model.getCliente().getUsuario()));
            model.commit();
        } catch (Exception e) {}
        return balance;
    }

    public void MSJSistema(int i) {
        JFrame frame = new JFrame("ERROR");
        JFrame frame1 = new JFrame("CONFIRMACION");
        if (i == 0) {
            JOptionPane.showMessageDialog(frame, "No se realizó el retiro", "ERROR",
                    JOptionPane.ERROR_MESSAGE);
        } else if (i == 1) {
            JOptionPane.showMessageDialog(frame1, "RETIRO REALIZADO");
        }
    }
}
