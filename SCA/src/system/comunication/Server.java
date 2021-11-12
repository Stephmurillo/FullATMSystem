package system.comunication;

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

import system.logic.Service;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import sistema.comunication.Protocol;
import sistema.logic.Cliente;

public class Server {

    ServerSocket ss;

    public Server() throws IOException {
        ss = new ServerSocket(Protocol.PORT);
        System.out.println("Servidor iniciado...");
    }

    public void run() {
        boolean continuar = true;
        Cliente usuario = null;
        Socket s;
        ObjectInputStream in;
        ObjectOutputStream out;
        int method;
        while (continuar) {
            try {
                s = ss.accept();
                out = new ObjectOutputStream(s.getOutputStream());
                in = new ObjectInputStream(s.getInputStream());
                try {
                    method = in.readInt();
                    usuario = (Cliente) in.readObject();
                    usuario = Service.instance().login(usuario);
                    out.writeInt(Protocol.STATUS_OK);
                    out.writeObject(usuario);
                    out.flush();
                    
                    System.out.println("Conexion Establecida...");
                    Worker worker = new Worker(s, in, out, usuario);
                    worker.start();
                } catch (Exception ex) {
                    out.writeInt(Protocol.STATUS_ERROR);
                    out.flush();
                    s.close();
                }
            } catch (IOException ex) {
            }
        }
    }

}
