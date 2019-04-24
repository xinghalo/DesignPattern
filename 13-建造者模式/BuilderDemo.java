import java.util.ArrayList;
import java.util.List;

class Product {
    List<String> parts = new ArrayList<String>();
    public void add(String part){
        this.parts.add(part);
    }
    public void show(){
        System.out.println("产品创建");
        for(String part : parts) {
            System.out.println(part);
        }
    }
}
abstract class Builder {
    public abstract void buildPartA();
    public abstract void buildPartB();
    public abstract Product GetResult();
}
class ConcreteBuilder1 extends Builder {
    private Product product = new Product();
    @Override
    public void buildPartA() {
        product.add("部件A");
    }
    @Override
    public void buildPartB() {
        product.add("部件B");
    }
    @Override
    public Product GetResult() {
        return product;
    }
}
class ConcreteBuilder2 extends Builder {
    private Product product = new Product();
    @Override
    public void buildPartA() {
        product.add("部件1");
    }
    @Override
    public void buildPartB() {
        product.add("部件2");
    }
    @Override
    public Product GetResult() {
        return product;
    }
}
class Director {
    public void construct(Builder builder) {
        builder.buildPartA();
        builder.buildPartB();
    }
}
public class BuilderDemo {
    public static void main(String[] args) {
        Director director = new Director();

        Builder b1 = new ConcreteBuilder1();
        director.construct(b1);
        Product p1 = b1.GetResult();
        p1.show();

        Builder b2 = new ConcreteBuilder2();
        director.construct(b2);
        Product p2 = b2.GetResult();
        p2.show();
    }
}
