package system.presentation.CambioClave;

import java.util.Observable;
import java.util.Observer;

public class ModelCambio extends Observable{
       @Override
    public synchronized void addObserver(Observer o) {
        super.addObserver(o); 
        this.commit();
    }
    
    public void commit(){
        this.setChanged();
        this.notifyObservers();
    }
}
