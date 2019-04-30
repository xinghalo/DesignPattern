import java.util.ArrayList;
import java.util.List;

interface Visitor{
    public void visitConcreteElementA(ConcreteElementA concreteElementA);
    public void visitConcreteElementB(ConcreteElementB concreteElementB);
}
class ConcreteVisitor1 implements Visitor {
    @Override
    public void visitConcreteElementA(ConcreteElementA concreteElementA) {

    }

    @Override
    public void visitConcreteElementB(ConcreteElementB concreteElementB) {

    }
}
class ConcreteVisitor2 implements Visitor {
    @Override
    public void visitConcreteElementA(ConcreteElementA concreteElementA) {

    }

    @Override
    public void visitConcreteElementB(ConcreteElementB concreteElementB) {

    }
}
interface Element {
    public void accept(Visitor visitor);
}
class ConcreteElementA implements Element {
    @Override
    public void accept(Visitor visitor) {
        visitor.visitConcreteElementA(this);
    }
    public void operationA(){

    }
}
class ConcreteElementB implements Element {
    @Override
    public void accept(Visitor visitor) {
        visitor.visitConcreteElementB(this);
    }
    public void operationB(){

    }
}
class ObjectStructure {
    private List<Element> elementList = new ArrayList<>();

    public void attach(Element element) {
        elementList.add(element);
    }

    public void detach(Element element) {
        elementList.remove(element);
    }

    public void accept(Visitor visitor){
        for(Element e : elementList) {
            e.accept(visitor);
        }
    }
}
public class VisitorDemo {
    public static void main(String[] args) {
        ObjectStructure o = new ObjectStructure();

        o.attach(new ConcreteElementA());
        o.attach(new ConcreteElementB());

        ConcreteVisitor1 v1 = new ConcreteVisitor1();
        ConcreteVisitor2 v2 = new ConcreteVisitor2();

        o.accept(v1);
        o.accept(v2);
    }
}
