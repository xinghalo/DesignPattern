import java.util.ArrayList;
import java.util.List;

abstract class Component {
    protected String name;

    public Component(String name) {
        this.name = name;
    }

    public abstract void add(Component c);
    public abstract void remove(Component c);
    public abstract void display(int depth);
}
class Leaf extends Component {
    public Leaf(String name) {
        super(name);
    }

    @Override
    public void add(Component c) {
        System.out.println("can not add to a leaf");
    }

    @Override
    public void remove(Component c) {
        System.out.println("can not remove from a leaf");
    }

    @Override
    public void display(int depth) {
        String prefix = "";
        for (int i =0;i<depth;i++){
            prefix += "-";
        }
        System.out.println(prefix+name);
    }
}
class Composite extends Component {

    private List<Component> children = new ArrayList<>();

    public Composite(String name) {
        super(name);
    }

    @Override
    public void add(Component c) {
        this.children.add(c);
    }

    @Override
    public void remove(Component c) {
        this.children.remove(c);
    }

    @Override
    public void display(int depth) {
        String prefix = "";
        for (int i =0;i<depth;i++){
            prefix += "-";
        }
        System.out.println(prefix+name);

        for(Component child : children) {
            child.display(depth+2);
        }
    }
}
public class CompositeDemo {
    public static void main(String[] args) {
        Composite root = new Composite("root");
        root.add(new Leaf("Leaf A"));
        root.add(new Leaf("Leaf B"));

        Composite comp = new Composite("Composite X");
        comp.add(new Leaf("Leaf XA"));
        comp.add(new Leaf("Leaf XB"));

        root.add(comp);

        Composite comp2 = new Composite("Composite XY");
        comp2.add(new Leaf("Leaf XYA"));
        comp2.add(new Leaf("Leaf XYB"));

        root.add(comp2);

        Leaf leaf = new Leaf("Leaf D");
        root.add(leaf);

        root.display(1);


        System.out.println();


        root.remove(leaf);
        root.display(1);

    }
}
