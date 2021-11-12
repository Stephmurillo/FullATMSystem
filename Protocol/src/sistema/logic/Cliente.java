package sistema.logic;

import java.io.Serializable;

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

public class Cliente implements Serializable{

    public Cliente(String usuario, String clave, double saldoCuenta) {
        this.usuario = usuario;
        this.clave = clave;
        this.saldoCuenta = saldoCuenta;
    }
    
    public Cliente() {
        this.usuario = "";
        this.clave = "";
        this.saldoCuenta = 0;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public double getSaldoCuenta() {
        return saldoCuenta;
    }

    public void setSaldoCuenta(double saldoCuenta) {
        this.saldoCuenta = saldoCuenta;
    }
    
    public String usuario;
    public String clave;
    public double saldoCuenta;
    
}
