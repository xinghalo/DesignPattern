interface IGiveGift {
    void GiveDolls();
    void GiveFlowers();
    void GiveChcolate();
}
class Pursuit implements IGiveGift {

    SchoolGirl mm;

    public Pursuit(SchoolGirl mm) {
        this.mm = mm;
    }

    @Override
    public void GiveDolls() {
        System.out.println(mm.getName() + " 送你洋娃娃");
    }

    @Override
    public void GiveFlowers() {
        System.out.println(mm.getName() + " 送你花");
    }

    @Override
    public void GiveChcolate() {
        System.out.println(mm.getName() + " 送你巧克力");
    }
}

class Proxy implements IGiveGift {

    Pursuit gg;

    public Proxy(SchoolGirl mm){
        gg = new Pursuit(mm);
    }

    @Override
    public void GiveDolls() {
        System.out.println("借由proxy之手");
        gg.GiveDolls();
    }

    @Override
    public void GiveFlowers() {
        System.out.println("借由proxy之手");
        gg.GiveFlowers();
    }

    @Override
    public void GiveChcolate() {
        System.out.println("借由proxy之手");
        gg.GiveChcolate();
    }
}

class SchoolGirl {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

public class ProxyDemo {
    public static void main(String[] args) {
        SchoolGirl jiaojiao = new SchoolGirl();
        jiaojiao.setName("娇娇");

        Proxy daili = new Proxy(jiaojiao);
        daili.GiveDolls();
        daili.GiveFlowers();
        daili.GiveChcolate();
    }
}
