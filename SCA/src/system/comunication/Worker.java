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
import java.net.Socket;
import sistema.comunication.Protocol;
import sistema.logic.Cliente;

public class Worker {

    private boolean condition = false;

    Socket s;
    ObjectInputStream in;
    ObjectOutputStream out;
    Cliente usuario;

    public Worker(Socket s, ObjectInputStream in, ObjectOutputStream out, Cliente usuario) {
        this.s = s;
        this.in = in;
        this.out = out;
        this.usuario = usuario;
    }

    public void start() {
        System.out.println("Worker " + usuario.getUsuario() + " atendiendo peticiones...");
        Runnable tarea = new Runnable() {
            public void run() {
                while (condition) {
                    HeyListen();
                }
                System.out.println("Worker " + usuario.getUsuario() + " finalizo...");
            }
        };
        Thread hilo = new Thread(tarea);
        condition = true;
        hilo.start();
    }

    public void HeyListen() { //operaciones especificas nada mas porque el cliente esta logueado
        int method;
        String parameter = "";
        try {
            method = in.readInt();
            System.out.println("Operación: " + method + " (" + usuario.getUsuario() + ")");
            switch (method) {
                case Protocol.WITHDRAWAL:
                   double monto = in.readDouble();
                try {
                    String result = Service.instance().withdrawal(parameter);
                    out.writeInt(Protocol.STATUS_OK);
                    out.writeObject(result);
                } catch (Exception ex) {
                    out.writeInt(Protocol.STATUS_ERROR);
                }
                    break;
               
                case Protocol.CHANGE:
                    try {
                   String  password = (String) in.readObject();
                } catch (ClassNotFoundException ex) {
                }
                try {
                    String result = Service.instance().change(parameter);
                    out.writeInt(Protocol.STATUS_OK);
                    out.writeObject(result);
                } catch (Exception ex) {
                    out.writeInt(Protocol.STATUS_ERROR);
                }
                    break;
                
                case Protocol.BALANCE:
                try {
                    String result = Service.instance().balance(usuario.getUsuario()); //No sé si consulta deba llevar un usuario como parametro o no.
                    out.writeInt(Protocol.STATUS_OK);
                    out.writeObject(result);
                } catch (Exception ex) {
                    out.writeInt(Protocol.STATUS_ERROR);
                }
                    break;
                case Protocol.LOGOUT:
                    s.close();
                    condition = false;
                    return;
            }
            out.flush();
        } catch (IOException ex) {
            System.out.println(ex);
            condition = false;
        }
    }
}
