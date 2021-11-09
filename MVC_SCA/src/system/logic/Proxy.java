package system.logic;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.ModuleLayer.Controller;
import system.Cliente;
import java.net.Socket;
import sistema.comunication.Protocol;
import sistema.logic.IService;

// EJEMPLO DEL PROFE
//        Socket socket = new Socket("127.0.0.1", 20000);
//        BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
//        out.write("Hello Server\n");
//        out.flush();
//        String msg = is.readLine();
//        System.out.println(msg);        
//        out.cloute();

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

    private void connect() throws Exception{
        try{
        socket = new Socket(Protocol.SERVER,Protocol.PORT);
        out = new ObjectOutputStream(socket.getOutputStream() );
        in = new ObjectInputStream(socket.getInputStream());   } 
        catch(IOException e){
            System.out.println("Error en la comunicacion");
            System.exit(-1);
        }
    }

    private void disconnect() throws Exception{
        socket.shutdownOutput();
        socket.close();
    }
    
    public Cliente login(Cliente u) throws Exception{
        connect();
            out.writeInt(Protocol.LOGIN);
            out.writeObject(u);
            out.flush();
            int response = in.readInt();
            switch (response){
                case Protocol.STATUS_OK:
                    Cliente u1 =(Cliente) in.readObject();
                    return u1;
                
                case Protocol.STATUS_ERROR:
                    disconnect();
                    throw new Exception("Error en la accion de Login");
                
                default: 
                    return null;
            }   
    }
    
    public String retiro(String parametro) throws Exception{
            out.writeInt(Protocol.LOGIN);
            out.writeObject(parametro);
            out.flush();
            int response = in.readInt();
            switch (response){
                case Protocol.STATUS_OK:
                     return (String) in.readObject();
                 
                case Protocol.STATUS_ERROR:
                    disconnect();
                    throw new Exception("Error en el intento de retiro");
                
                default: 
                    return null;
            }   
    }
    
    
     public void stop(){
        continuar=false;
    }
     
     public void logout(Cliente u) throws Exception{
        out.writeInt(Protocol.LOGOUT);
        out.writeObject(u);
        out.flush();
        this.stop();
        this.disconnect();
    }
    
    
   boolean continuar = true;    
   public void start(){
        Thread t = new Thread(new Runnable(){
            public void run(){
                listen();
            }
        });
        continuar = true;
        t.start();
    } 

   public void listen(){
        int method;
        while (continuar) {
            try {
                method = in.readInt();
                switch(method){
                case Protocol.RETIRO:
                    try {
                        String message=(String)in.readObject();
                      
                    } 
                    catch (ClassNotFoundException ex) {}
                    break;
                    
                case Protocol.CAMBIOC:
                    try{
                        String nombre=(String)in.readObject();
                        
                    }
                    catch (ClassNotFoundException ex) {}
                    break;
                    
                case Protocol.CONSULTA:
                    try{
                        String nombre=(String)in.readObject();
                    }
                    catch (ClassNotFoundException ex) {}
                    break;
                }
                out.flush();
            } catch (IOException  ex) {
                continuar = false;
            }                        
        }
    }

}
  