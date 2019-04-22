/**
 * 抽象类
 */
abstract class Operator {
    private Integer num1;
    private Integer num2;

    public Integer getNum1() {
        return num1;
    }

    public void setNum1(Integer num1) {
        this.num1 = num1;
    }

    public Integer getNum2() {
        return num2;
    }

    public void setNum2(Integer num2) {
        this.num2 = num2;
    }

    abstract public Integer getResult();
}

class Add extends Operator {
    @Override
    public Integer getResult() {
        return getNum1() + getNum2();
    }
}

class Sub extends Operator {
    @Override
    public Integer getResult() {
        return getNum1() - getNum2();
    }
}

class Mul extends Operator {
    @Override
    public Integer getResult() {
        return getNum1() * getNum2();
    }
}

class Div extends Operator {
    @Override
    public Integer getResult() {
        return getNum1() / getNum2();
    }
}

class OperationFactory {

    public static Operator createOperator(String operator){
        Operator op = null;

        switch (operator) {
            case "+":
                op = new Add();
                break;
            case "-":
                op = new Sub();
                break;
            case "*":
                op = new Mul();
                break;
            case "/":
                op = new Div();
                break;
            default:
                // NOTHING
        }
        return op;
    }
}

public class SimpleFactory {
    public static void main(String[] args) {
        Operator op = OperationFactory.createOperator("+");
        op.setNum1(10);
        op.setNum2(5);
        System.out.println(op.getResult());

        op = OperationFactory.createOperator("*");
        op.setNum1(10);
        op.setNum2(5);
        System.out.println(op.getResult());
    }
}
