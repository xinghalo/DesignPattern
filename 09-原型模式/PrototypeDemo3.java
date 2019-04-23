
class Resume3 implements Cloneable{
    private String name;
    private String sex;
    private String age;
    private String company;
    private Address address;

    Resume3(String name, String sex, String age, String company, String address){
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

    public void setAddress(Address address) {
        this.address = address;
    }

    public void updateAddress(String address) {
        this.address.setHome(address);
    }

    @Override
    public String toString() {
        return name + sex + age + company + address;
    }

    @Override
    public Object clone() {
        Resume3 resume = null;
        try {
            resume = (Resume3) super.clone();
            resume.setAddress((Address)this.address.clone());

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return resume;
    }
}

public class PrototypeDemo3 {
    public static void main(String[] args) {
        Resume3 r1 = new Resume3("大鸟", "男", "30", "天狗网", "大连甘井子");


        Resume3 r2 = (Resume3) r1.clone();
        r2.setName("菜鸟");
        r2.setAge("21");
        r2.updateAddress("大连高新");

        System.out.println(r1);
        System.out.println(r2);

    }
}
