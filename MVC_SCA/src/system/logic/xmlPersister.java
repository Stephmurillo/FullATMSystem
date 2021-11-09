


package system.logic;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import system.Cliente;

/*
 *
 * @author Esteban
 */
public class xmlPersister {
    private String path;
    //private static xmlPersister theInstance;
    /*
    public static xmlPersister instance(){
        if(theInstance == null){
            theInstance = new xmlPersister("xmlData");
        }
        return theInstance;
    }
    */
    public xmlPersister(String p){
        path = p;
    }
    
    public Cliente  load()throws Exception{
        JAXBContext jaxbContext = JAXBContext.newInstance(Cliente .class);
        FileInputStream is = new FileInputStream(path);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        Cliente  result = (Cliente) unmarshaller.unmarshal(is);
        is.close();
        return result;
    }
    
    public void store(Cliente  d)throws Exception{
        JAXBContext jaxbContext = JAXBContext.newInstance(Cliente.class);
        FileOutputStream os = new FileOutputStream(path);
        Marshaller marshaller = jaxbContext.createMarshaller();  
        marshaller.marshal(d,os);
        os.flush();
        os.close();
        
    }
}