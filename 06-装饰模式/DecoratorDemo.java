class Person{
    private String name;
    public Person(){}
    public Person(String name){
        this.name = name;
    }
    public void show(){
        System.out.println("装扮的"+name);
    }
}
class Finery extends Person {
    protected Person component;
    public void decorate(Person component){
        this.component = component;
    }
    @Override
    public void show(){
        if (component != null) {
            component.show();
        }
    }
}
class TShirts extends Finery {
    @Override
    public void show(){
        System.out.println("T恤");
        super.show();
    }
}
class BigTrousers extends Finery {
    @Override
    public void show(){
        System.out.println("垮裤");
        super.show();
    }
}
class Sneaker extends Finery {
    @Override
    public void show(){
        System.out.println("破球鞋");
        super.show();
    }
}
class LeatherShoes extends Finery {
    @Override
    public void show(){
        System.out.println("皮鞋");
        super.show();
    }
}
class Tie extends Finery {
    @Override
    public void show() {
        System.out.println("领带");
        super.show();
    }
}
class Suit extends Finery {
    @Override
    public void show() {
        System.out.println("西装");
        super.show();
    }
}
public class DecoratorDemo {
    public static void main(String[] args) {
        // 为已有的方法，动态的添加其他的功能

        Person xc = new Person("小菜");
        System.out.println("第一种装扮");

        Sneaker f1 = new Sneaker();
        BigTrousers f2 = new BigTrousers();
        TShirts f3 = new TShirts();

        f1.decorate(xc);
        f2.decorate(f1);
        f3.decorate(f2);
        f3.show();


    }
}
