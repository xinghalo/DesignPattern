import java.io.*;

class Resume4 implements Cloneable{
    private String name;
    private String sex;
    private String age;
    private String company;
    private Address address;

    Resume4(String name, String sex, String age, String company, String address){
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
        Resume4 resume = null;
        try {

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(this);

            // 将流序列化成对象
            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bais);
            resume = (Resume4) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resume;
    }
}

public class PrototypeDemo4 {
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
