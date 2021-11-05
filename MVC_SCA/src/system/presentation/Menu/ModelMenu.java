package system.presentation.Menu;

import java.util.Observable;
import java.util.Observer;

public class ModelMenu extends Observable{
    
    // Model attributes here
    // Model gets and sets here

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
