package factory;

import Observer.IPublisher;
import Observer.ISubscriber;
import gui.MainWindow;

import java.util.ArrayList;
import java.util.List;

public class FactoryError implements IPublisher {
    private static FactoryError instance = null;
    private List<ISubscriber> subscribers;
    private MyError merror;

    private FactoryError(){}

    public static FactoryError getInstance(){
        if(instance == null){
            instance = new FactoryError();

        }
        return instance;
    }
    public void generateError (String s){

        if(s.equals("workspace")){merror = new MyError("Ne mozete izbrisati Workspace.");}
        if(s.equals("slovo")){merror = new MyError("Morate upisati broj.");}
        if(s.equals("slideshow")){merror = new MyError("Niste napravili prezentaciju sa slajdovima, ne mozete pozvati SlideShow.");}
        if(s.equals("imageprez")){merror = new MyError("Morate selektovati prezentaciju.");}
        this.notifySubscribers(merror);

    }

    @Override
    public void addSubscriber(ISubscriber sub) {
        if(sub == null)
            return;
        if(this.subscribers ==null)
            this.subscribers = new ArrayList<>();
        if(this.subscribers.contains(sub))
            return;
        this.subscribers.add(sub);
    }

    @Override
    public void removeSubscriber(ISubscriber sub) {
        if(sub == null || this.subscribers == null || !this.subscribers.contains(sub))
            return;
        this.subscribers.remove(sub);
    }

    @Override
    public void notifySubscribers(Object notification) {
        if (notification == null || this.subscribers == null || this.subscribers.isEmpty())
            return;
        for(ISubscriber listener : subscribers){
            listener.update(notification);
        }
    }
}
