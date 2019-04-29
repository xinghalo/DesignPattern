import javax.sound.midi.Receiver;

abstract class Command {
    protected Reciever receiver;

    public Command(Reciever receiver) {
        this.receiver = receiver;
    }

    abstract public void execute();
}
class ConcreteCommand extends Command {
    public ConcreteCommand(Reciever receiver) {
        super(receiver);
    }

    @Override
    public void execute() {
        receiver.action();
    }
}
class Invoker {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void executeCommand(){
        this.command.execute();
    }
}
class Reciever {
    public void action(){
        System.out.println("执行请求!");
    }
}
public class CommandDemo {
    public static void main(String[] args) {
        Reciever r = new Reciever();
        Command c = new ConcreteCommand(r);
        Invoker i = new Invoker();

        i.setCommand(c);
        i.executeCommand();
    }
}
