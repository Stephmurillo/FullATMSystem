package system.logic;

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

import java.util.ArrayList;
import java.util.List;
import sistema.logic.Cliente;
import system.data.ClienteDAO;

public class Service {

    // Singleton implementation
    private static Service theInstance;

    public static Service instance() {
        if (theInstance == null) {
            theInstance = new Service();
        }
        return theInstance;
    }

    // Service data
    ClienteDAO cDao;

    // Service methods
    public Cliente clienteGet(String user) throws Exception {
        return cDao.read(user);
    }

    public List<Cliente> clienteSearch(String user) {
        return cDao.findByCedula(user);
    }

    public List<Cliente> clienteAll() {
        return cDao.findAll();
    }

    public void clienteAdd(Cliente cliente) throws Exception {
        cDao.create(cliente);
    }

    public Service() {
        try {
            usuarios = new ArrayList<>();
            cDao = new ClienteDAO();
        } catch (Exception e) {
        }
    }

    public Cliente login(Cliente u) throws Exception {
        return cDao.login(u);
    }

    public double balance(String user) throws Exception {
        return cDao.balance(user);
    }

    public void retiro(String user, double monto) throws Exception {
        cDao.retiro(user, monto);
    }

    public void cambioClave(String user, String nueva) throws Exception {
        cDao.cambioClave(user, nueva);
    }

    List<Cliente> usuarios;
}
