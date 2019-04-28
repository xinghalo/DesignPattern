class Originator {
    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Memento createMemento(){
        return new Memento(state);
    }

    public void setMemento(Memento memento) {
        state = memento.getState();
    }

    public void show(){
        System.out.println("state = "+state);
    }
}

class Memento {
    private String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}

class Caretaker {
    private Memento memento;

    public Memento getMemento() {
        return memento;
    }

    public void setMemento(Memento memento) {
        this.memento = memento;
    }
}

public class MemntoDemo {
    public static void main(String[] args) {
        Originator o = new Originator();
        o.setState("On");
        o.show();

        Caretaker c = new Caretaker();
        c.setMemento(o.createMemento());
        o.setState("Off");
        o.show();

        o.setMemento(c.getMemento());
        o.show();
    }
}
