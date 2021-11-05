package system.presentation.Login;

import java.util.Observable;
import java.util.Observer;
import system.Cliente;

public class ModelLogin extends Observable {
    
    // Model attributes here
    
    Cliente cliente;

    
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public synchronized void addObserver(Observer o) {
        super.addObserver(o);
        this.commit();
    }

    public void commit() {
        this.setChanged();
        this.notifyObservers();
    }
    
}

