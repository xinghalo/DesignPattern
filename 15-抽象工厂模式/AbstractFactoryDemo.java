import java.util.Date;

class Login {
    private int id;
    private Date date;
}
class User {
    private int uid;
    private String uname;

}
interface IUser {
    public void insert(User user);
    public User getUser(int uid);

}
class MysqlUser implements IUser{
    @Override
    public void insert(User user){
        System.out.println("对 MySQL 里的 User 表插入了一条数据");
    }
    @Override
    public User getUser(int uid){
        System.out.println("通过 uid 在 MySQL 里的 User 表得到了一条数据");
        return null;
    }
}
class OracleUser implements IUser{
    @Override
    public void insert(User user) {
        System.out.println("对 Oracle 里的 User 表插入了一条数据");
    }
    @Override
    public User getUser(int uid) {
        System.out.println("通过 uid 在 Oracle 里的 User 表得到了一条数据");
        return null;
    }
}
interface ILogin {
    public void insert(Login login);
    public Login getLogin(int id);
}
class MysqlLogin implements ILogin{
    @Override
    public void insert(Login login) {
        System.out.println("对 MySQL 里的 Login 表插入了一条数据");
    }
    @Override
    public Login getLogin(int id) {
        System.out.println("通过 uid 在 MySQL 里的 Login 表得到了一条数据");
        return null;
    }
}
class OracleLogin implements ILogin{
    @Override
    public void insert(Login login) {
        System.out.println("对 Oracle 里的 Login 表插入了一条数据");
    }
    @Override
    public Login getLogin(int id) {
        System.out.println("通过 uid 在 Oracle 里的 Login 表得到了一条数据");
        return null;
    }
}
interface IFactory2 {
    IUser createUser();
    ILogin createLogin();
}
class MysqlFactory implements IFactory2{
    @Override
    public IUser createUser() {
        return new MysqlUser();
    }
    @Override
    public ILogin createLogin() {
        return new MysqlLogin();
    }
}
class OracleFactory implements IFactory2{
    @Override
    public IUser createUser() {
        return new OracleUser();
    }
    @Override
    public ILogin createLogin() {
        return new OracleLogin();
    }
}
public class AbstractFactoryDemo {
    public static void main(String[] args) {
        User user=new User();
        Login login = new Login();

        // 只需要确定实例化哪一个数据库访问对象给factory
        IFactory2 factory=new MysqlFactory();
        //IFactory2 factory=new OracleFactory();

        // 已与具体的数据库访问解除了耦合
        IUser userOperation=factory.createUser();

        userOperation.getUser(1);
        userOperation.insert(user);

        // 已与具体的数据库访问解除了耦合
        ILogin loginOperation=factory.createLogin();

        loginOperation.insert(login);
        loginOperation.getLogin(1);
    }
}
