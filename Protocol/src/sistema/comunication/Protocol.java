package sistema.comunication;

public class Protocol {

    public static final String SERVER = "localhost";
    public static final int PORT = 1234;

    public static final int LOGIN=1;
    public static final int LOGOUT=2;    
    public static final int CAMBIOC=3;
    public static final int RETIRO=4;   
    public static final int CONSULTA=5; 

    
    public static final int STATUS_ERROR=0;
    public static final int STATUS_OK=1;
}