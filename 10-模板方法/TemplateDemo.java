abstract class Paper {
    void question1(){
        System.out.println("你的名字是什么？");
    }
    void question2(){
        System.out.println("你的单位叫什么？");
    }
    void question3(){
        System.out.println("你的家乡是哪里？");
    }

    abstract void answer1();
    abstract void answer2();
    abstract void answer3();

    void result(){
        question1();
        answer1();

        question2();
        answer2();

        question3();
        answer3();
    }
}

class APaper extends Paper{

    @Override
    void answer1() {
        System.out.println("苏大强");
    }

    @Override
    void answer2() {
        System.out.println("XX小学");
    }

    @Override
    void answer3() {
        System.out.println("苏州");
    }
}

class BPaper extends Paper{

    @Override
    void answer1() {
        System.out.println("嬴政");
    }

    @Override
    void answer2() {
        System.out.println("秦国");
    }

    @Override
    void answer3() {
        System.out.println("赵国");
    }
}

public class TemplateDemo {
    public static void main(String[] args) {
        new APaper().result();
        new BPaper().result();
    }
}
