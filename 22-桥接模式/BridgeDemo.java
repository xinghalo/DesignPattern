interface Implementor {
    public void operation();
}
class ConcreateImplementorA implements Implementor {
    @Override
    public void operation() {
        System.out.println("具体实现A的方法执行");
    }
}
class ConcreateImplementorB implements Implementor {
    @Override
    public void operation() {
        System.out.println("具体实现B的方法执行");
    }
}
class Abstraction {
    protected Implementor implementor;

    public void setImplementor(Implementor implementor) {
        this.implementor = implementor;
    }

    public void operation(){
        implementor.operation();
    }
}
class RefinedAbstraction extends Abstraction {
    @Override
    public void operation(){
        implementor.operation();
    }
}
public class BridgeDemo {
    public static void main(String[] args) {
        Abstraction ab = new RefinedAbstraction();

        ab.setImplementor(new ConcreateImplementorA());
        ab.operation();

        ab.setImplementor(new ConcreateImplementorB());
        ab.operation();
    }
}
