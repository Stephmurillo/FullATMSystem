package sistema.comunication;

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

public class Protocol {
    
    //Datos del servidor
    public static final String SERVER = "localhost";
    public static final int PORT = 1234;
    
    //Datos de envio
    public static final int LOGIN = 1;
    public static final int LOGOUT = 2;
    public static final int CHANGE = 3; //Cambio de clave
    public static final int WITHDRAWAL = 4; //Retiro de dinero
    public static final int BALANCE = 5; //Consulta de saldo
    
    //Datos recibidos
    public static final int STATUS_ERROR = 0;
    public static final int STATUS_OK = 1;
}
