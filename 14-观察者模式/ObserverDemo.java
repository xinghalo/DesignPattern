import java.util.ArrayList;
import java.util.List;

abstract class Observer{
    public abstract void update();
}
abstract class Subject {
    private List<Observer> observers = new ArrayList<>();
    public void attach(Observer observer){
        this.observers.add(observer);
    }
    public void dettach(Observer observer){
        this.observers.remove(observer);
    }
    public void Notify(){
        for(Observer observer : observers) {
            observer.update();
        }
    }
}
class ConcreteSubject extends Subject {
    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
class ConcreteObserver extends Observer {
    private String name;
    private String state;
    private ConcreteSubject subject;
    public ConcreteObserver(ConcreteSubject subject, String name){
        this.subject = subject;
        this.name = name;
    }
    @Override
    public void update() {
        state = subject.getState();
        System.out.println("观察者 "+name+" 的状态时 "+state);
    }
}
public class ObserverDemo {
    public static void main(String[] args) {
        ConcreteSubject s = new ConcreteSubject();
        s.attach(new ConcreteObserver(s, "X"));
        s.attach(new ConcreteObserver(s, "Y"));
        s.attach(new ConcreteObserver(s, "Z"));

        s.setState("111");
        s.Notify();
    }
}
