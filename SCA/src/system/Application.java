package system;

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
import system.comunication.Server;

public class Application {

    public static void main(String[] args) throws IOException, Exception {
        Server server = new Server();
        server.run();
        
    }
}
