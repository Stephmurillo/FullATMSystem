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

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.ModuleLayer.Controller;
import sistema.logic.Cliente;
import java.net.Socket;
import sistema.comunication.Protocol;

public class Proxy {

    // Singleton implementation
    private static Proxy theInstance;

    Socket socket;
    ObjectInputStream in;
    ObjectOutputStream out;

    public static Proxy instance() throws IOException {
        if (theInstance == null) {
            theInstance = new Proxy();
        }
        return theInstance;
    }

    Controller controller;

    public Proxy() {
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }
    
     public Cliente clienteGet(String user) throws Exception {
        Cliente clien = null;
        //Que reciba un string
        //Busque el usuario
        //Y retorne al cliente
        //Tiene que usar el clienteGet de la clase Service
        return clien; 
    }

    private void connect() throws Exception {
        socket = new Socket(Protocol.SERVER, Protocol.PORT);
        out = new ObjectOutputStream(socket.getOutputStream());
        in = new ObjectInputStream(socket.getInputStream());

    }

    private void logout() throws Exception {
        socket.shutdownOutput();
        socket.close();
    }

    public Cliente login(Cliente u) throws Exception {
        try {
            connect();
        } catch (IOException e) {
            System.out.println("Error en la comunicación.");
            System.exit(-1);
        }
        out.writeInt(Protocol.LOGIN);
        out.writeObject(u);
        out.flush();
        int status = in.readInt();
        switch (status) {
            case Protocol.STATUS_OK:
                Cliente u1 = (Cliente) in.readObject();
                return u1;
            case Protocol.STATUS_ERROR:
                logout();
                throw new Exception("ERROR: No se realizó el login.");
            default:
                return null;
        }
    }

    public String retiro(String parametro) throws Exception {
        out.writeInt(Protocol.WITHDRAWAL);
        out.writeObject(parametro);
        out.flush();
        int status = in.readInt();
        switch (status) {
            case Protocol.STATUS_OK:
                return (String) in.readObject();
            case Protocol.STATUS_ERROR:
                logout();
                throw new Exception("ERROR: El retiro no se realizó.");
            default:
                return null;
        }
    }

    public String cambio(String parametro) throws Exception {
        out.writeInt(Protocol.CHANGE);
        out.writeObject(parametro);
        out.flush();
        int status = in.readInt();
        switch (status) {
            case Protocol.STATUS_OK:
                return (String) in.readObject();
            case Protocol.STATUS_ERROR:
                logout();
                throw new Exception("ERROR: La clave no fue cambiada.");
            default:
                return null;
        }
    }
    
    public String consulta(String parametro) throws Exception {
        out.writeInt(Protocol.BALANCE);
        out.writeObject(parametro);
        out.flush();
        int status = in.readInt();
        switch (status) {
            case Protocol.STATUS_OK:
                return (String) in.readObject();
            case Protocol.STATUS_ERROR:
                logout();
                throw new Exception("ERROR: No se puede consultar el saldo.");
            default:
                return null;
        }
    }
}