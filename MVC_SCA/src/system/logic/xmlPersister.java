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

import java.io.FileInputStream;
import java.io.FileOutputStream;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import sistema.logic.Cliente;

public class xmlPersister {
    private String path;

    public xmlPersister(String p){
        path = p;
    }
    
    public Cliente load()throws Exception{
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