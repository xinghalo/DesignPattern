interface LeiFeng {
    void sweep();
    void wash();
    void buyRice();
}
class Undergraduate implements LeiFeng {
    @Override
    public void sweep() {
        System.out.println("大学生 帮忙 扫地");
    }

    @Override
    public void wash() {
        System.out.println("大学生 帮忙 洗衣");
    }

    @Override
    public void buyRice() {
        System.out.println("大学生 帮忙 买米");
    }
}
class Volunteer implements LeiFeng {
    @Override
    public void sweep() {
        System.out.println("志愿者 帮忙 扫地");
    }

    @Override
    public void wash() {
        System.out.println("志愿者 帮忙 洗衣");
    }

    @Override
    public void buyRice() {
        System.out.println("志愿者 帮忙 买米");
    }
}
interface IFactory {
    LeiFeng createLeiFeng();
}

class UndergraduaateFactory implements IFactory {
    @Override
    public LeiFeng createLeiFeng() {
        return new Undergraduate();
    }
}
class VolunteerFactory implements IFactory {
    @Override
    public LeiFeng createLeiFeng() {
        return new Volunteer();
    }
}

public class FactoryDemo {
    public static void main(String[] args) {
        IFactory factory = new UndergraduaateFactory();
        LeiFeng leiFeng1 = factory.createLeiFeng();
        leiFeng1.sweep();

        factory = new VolunteerFactory();
        LeiFeng leiFeng2 = factory.createLeiFeng();
        leiFeng2.buyRice();
    }
}
