
class Address implements Cloneable{
    String home;

    public void setHome(String home) {
        this.home = home;
    }

    Address(String home){
        this.home = home;
    }

    @Override
    public String toString() {
        return home;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
class Resume2 implements Cloneable{
    private String name;
    private String sex;
    private String age;
    private String company;
    private Address address;

    Resume2(String name, String sex, String age, String company, String address){
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.company = company;
        this.address = new Address(address);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setAddress(String address) {
        this.address.setHome(address);
    }

    @Override
    public String toString() {
        return name + sex + age + company + address;
    }

    @Override
    public Object clone() {
        Resume2 resume = null;
        try {
            resume = (Resume2) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return resume;
    }
}

public class PrototypeDemo2 {
    public static void main(String[] args) {
        Resume2 r1 = new Resume2("大鸟", "男", "30", "天狗网", "大连甘井子");


        Resume2 r2 = (Resume2) r1.clone();
        r2.setName("菜鸟");
        r2.setAge("21");
        r2.setAddress("大连高新");

        System.out.println(r1);
        System.out.println(r2);

    }
}
