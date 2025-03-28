package buoi11.designparttern.observers;


import buoi11.designparttern.observers.model.Observer;

public interface Subject {

    void attach(Observer observer);
    void detach(Observer observer);
    void notifyAllObservers();
}
