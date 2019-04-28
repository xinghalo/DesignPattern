import java.util.ArrayList;
import java.util.List;

abstract class Iterator {
    public abstract Object first();
    public abstract Object next();
    public abstract Boolean isDone();
    public abstract Object current();
}
abstract class Aggregate {
    public abstract Iterator createIterator();
}
class ConcreteIterator extends Iterator {

    private ConcreteAggregate aggregate;
    private Integer current = 0;

    public ConcreteIterator(ConcreteAggregate aggregate) {
        this.aggregate = aggregate;
    }

    @Override
    public Object first() {
        return this.aggregate.get(0);
    }

    @Override
    public Object next() {
        Object ret = null;
        current++;
        if (current < aggregate.size()) {
            ret = aggregate.get(current);
        }
        return ret;
    }

    @Override
    public Boolean isDone() {
        return current >= aggregate.size();
    }

    @Override
    public Object current() {
        return this.aggregate.get(current);
    }
}
class ConcreteAggregate extends Aggregate {
    private List<Object> items = new ArrayList<>();

    @Override
    public Iterator createIterator() {
        return new ConcreteIterator(this);
    }
    public Object get(Integer index){
        return items.get(index);
    }
    public void add(Object o){
        this.items.add(o);
    }
    public Integer size(){
        return items.size();
    }
}
public class IteratorDemo {
    public static void main(String[] args) {
        ConcreteAggregate a = new ConcreteAggregate();
        a.add("大鸟");
        a.add("小菜");
        a.add("行李");
        a.add("老外");
        a.add("内部员工");
        a.add("小偷");

        Iterator i = a.createIterator();

        Object item = i.first();

        while(!i.isDone()){
            System.out.println(i.current());
            i.next();
        }

    }
}
