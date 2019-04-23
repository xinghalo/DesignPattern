class Resume implements Cloneable{
    private String name;
    private String sex;
    private String age;
    private String company;

    Resume(String name, String sex, String age, String company){
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.company = company;
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

    @Override
    public String toString() {
        return name + sex + age + company;
    }

    @Override
    public Object clone() {
        Resume resume = null;
        try {
            resume = (Resume) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return resume;
    }
}

public class PrototypeDemo {
    public static void main(String[] args) {
        Resume r1 = new Resume("大鸟", "男", "30", "天狗网");
        System.out.println(r1);

        Resume r2 = (Resume) r1.clone();
        r2.setName("菜鸟");
        r2.setAge("21");
        System.out.println(r2);

    }
}
