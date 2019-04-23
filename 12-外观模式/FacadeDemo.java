class SubSystemOne {
    public void methodOne(){
        System.out.println("子系统1的方法");
    }
}
class SubSystemTwo {
    public void methodTwo(){
        System.out.println("子系统2的方法");
    }
}
class SubSystemThree {
    public void methodThree(){
        System.out.println("子系统3的方法");
    }
}
class SubSystemFour {
    public void methodFour(){
        System.out.println("子系统4的方法");
    }
}
class Facade {
    SubSystemOne subSystemOne;
    SubSystemTwo subSystemTwo;
    SubSystemThree subSystemThree;
    SubSystemFour subSystemFour;

    public Facade () {
        subSystemOne = new SubSystemOne();
        subSystemTwo = new SubSystemTwo();
        subSystemThree = new SubSystemThree();
        subSystemFour = new SubSystemFour();
    }

    public void methodA() {
        System.out.println("方法A");
        subSystemOne.methodOne();
        subSystemTwo.methodTwo();
    }

    public void methodB() {
        System.out.println("方法B");
        subSystemThree.methodThree();
        subSystemFour.methodFour();
    }
}

public class FacadeDemo {
    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.methodA();
        facade.methodB();
    }
}
