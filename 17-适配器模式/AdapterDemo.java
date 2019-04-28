abstract class Target {
    public void request(){
        System.out.println("普通请求");
    }
}
class Adaptee {
    public void specificRequest(){
        System.out.println("特殊的请求");
    }
}
class Adapter extends Target {
    private Adaptee adaptee = new Adaptee();

    @Override
    public void request(){
        adaptee.specificRequest();
    }
}

public class AdapterDemo {
    public static void main(String[] args) {
        Target target = new Adapter();
        target.request();
    }
}
