interface CashSuper {
    Double acceptCash(Double money);
}

class CashNormal implements CashSuper {
    @Override
    public Double acceptCash(Double money) {
        return money;
    }
}

class CashRebate implements CashSuper {
    private Double ratio;
    public CashRebate(Double ratio){
        this.ratio = ratio;
    }
    @Override
    public Double acceptCash(Double money) {
        return money * ratio;
    }
}

class CashReturn implements CashSuper {
    private Double total;
    private Double sub;
    public CashReturn(Double total, Double sub){
        this.total = total;
        this.sub = sub;
    }

    @Override
    public Double acceptCash(Double money) {
        if (money > this.total) {
            return money - this.sub;
        }
        return money;
    }
}

class CashContext {
    private CashSuper cs;

    public CashContext(String type){
        switch (type) {
            case "正常收费":
                cs = new CashNormal();
                break;
            case "满300返100":
                cs = new CashReturn(300d, 100d);
                break;
            case "打八折":
                cs = new CashRebate(0.8);
                break;
            default:
                //NOTHING
        }
    }

    public Double getResult(Double money){
        return cs.acceptCash(money);
    }

}

public class Demo {
    public static void main(String[] args) {
        CashContext cc = new CashContext("打八折");
        System.out.println(cc.getResult(400d));

        cc = new CashContext("满300返100");
        System.out.println(cc.getResult(400d));

        cc = new CashContext("正常收费");
        System.out.println(cc.getResult(400d));
    }
}
