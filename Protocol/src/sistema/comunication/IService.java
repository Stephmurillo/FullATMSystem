package sistema.comunication;

import sistema.logic.Cliente;

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

public interface IService {
    public Cliente login(Cliente u) throws Exception;
    public void logout() throws Exception; 
    public void retiro(String user, Double monto) throws Exception;
    public void cambioClave(String password, String nueva) throws Exception;
    public double balance(String user) throws Exception;
}
