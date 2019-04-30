interface UnitedNations {
    public void declare(String message, Country country);
}
abstract class Country {
    protected UnitedNations mediator;

    public Country(UnitedNations mediator) {
        this.mediator = mediator;
    }
}
class USA extends Country {
    public USA(UnitedNations mediator) {
        super(mediator);
    }

    public void declare(String message) {
        mediator.declare(message, this);
    }

    public void getMessage(String message) {
        System.out.println("美国获得对方信息:"+message);
    }
}
class Iraq extends Country {
    public Iraq(UnitedNations mediator) {
        super(mediator);
    }

    public void declare(String message) {
        mediator.declare(message, this);
    }

    public void getMessage(String message) {
        System.out.println("伊拉克获得对方信息:"+message);
    }
}
class UnitedNationsSecurityCouncil implements UnitedNations {
    private USA country1;
    private Iraq country2;

    public void setCountries(USA country1, Iraq country2) {
        this.country1 = country1;
        this.country2 = country2;
    }

    @Override
    public void declare(String message, Country country) {
        if (country == this.country1) {
            this.country2.getMessage(message);
        }else{
            this.country1.getMessage(message);
        }
    }
}
public class MediatorDemo {
    public static void main(String[] args) {

        UnitedNationsSecurityCouncil UNSC = new UnitedNationsSecurityCouncil();

        USA c1 = new USA(UNSC);
        Iraq c2 = new Iraq(UNSC);

        UNSC.setCountries(c1, c2);

        c1.declare("不准制造核武器，否则发动战争！");
        c2.declare("我们没有核武器，也不怕战争！");
    }
}
