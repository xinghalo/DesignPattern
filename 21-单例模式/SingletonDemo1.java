class Singleton1 {
    private static volatile Singleton1 instance = null;

    private Singleton1(){}

    public static Singleton1 getInstance(){
        if(instance == null){
            synchronized (Singleton1.class){
                if(instance == null){
                    instance = new Singleton1();
                }
            }
        }
        return instance;
    }
}

class Singleton7 {
    private Singleton7(){}

    public static Singleton7 getInstance(){
        return InstanceHolder.instance;
    }

    static class InstanceHolder{
        private static Singleton7 instance = new Singleton7();
    }
}
public class SingletonDemo1 {
    public static void main(String[] args) {
        Singleton1 singleton21 = Singleton1.getInstance();
        Singleton1 singleton211 = Singleton1.getInstance();
        System.out.println(singleton21);
        System.out.println(singleton211);

        Singleton7 singleton1 = Singleton7.getInstance();
        Singleton7 singleton11 = Singleton7.getInstance();
        System.out.println(singleton1);
        System.out.println(singleton11);
    }
}
