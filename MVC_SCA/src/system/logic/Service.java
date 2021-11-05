package system.logic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.List;
import system.Cliente;
import java.net.Socket;

// EJEMPLO DEL PROFE
//        Socket socket = new Socket("127.0.0.1", 20000);
//        BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//        BufferedWriter os = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
//        os.write("Hello Server\n");
//        os.flush();
//        String msg = is.readLine();
//        System.out.println(msg);        
//        os.close();

public class Service {
    
    // Singleton implementation
    private static Service theInstance;
    
    List<Cliente> clientes;
    Cliente client = new Cliente();
    
    Socket socket = new Socket("127.0.0.1", 20000);
    BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream()));  
    BufferedWriter os = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
    
    public static Service instance() throws IOException {
        if (theInstance == null) {
            theInstance = new Service();
        }
        return theInstance;
    }

    // Service methods
    public Cliente clienteGet(String user) throws Exception {
        os.write(user); // Cómo hago para el otro Service use el método que quiero?
        os.flush();
        String msg = is.readLine(); // client = is.readLine();
        os.close();
        return client;
    }

    public List<Cliente> clienteSearch(String user) {
        //Añadir las peticiones
        return clientes;
    }

    public List<Cliente> clienteAll() {
        //Añadir las peticiones
        return clientes;
    }

    public void clienteAdd(Cliente cliente) throws Exception {
        //Añadir las peticiones
    }
    
    public Cliente login(Cliente u) throws Exception{
        //Añadir las peticiones
        return client;
    }
     
    public Service() throws IOException {}
}
