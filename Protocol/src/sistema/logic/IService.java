package sistema.logic;

import system.Cliente;

public interface IService {
    public Cliente login(Cliente u) throws Exception;
    public void logout(Cliente u) throws Exception; 
    
}
