import java.util.HashMap;

class User1{
    private String name;

    public User1(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
interface WebSite {
    public void use(User1 user);
}
class ConcreteWebSite implements WebSite {
    private String name = "";

    public ConcreteWebSite(String name) {
        this.name = name;
    }

    @Override
    public void use(User1 user) {
        System.out.println("网站分类:"+name+" 用户:"+user.getName());
    }
}
class WebSiteFactory {
    private HashMap<String, WebSite> flyweights = new HashMap<>();

    public WebSite getWebSiteCategory(String key){
        if (!flyweights.containsKey(key)){
            flyweights.put(key, new ConcreteWebSite(key));
        }
        return flyweights.get(key);
    }

    public Integer getWebSiteCount(){
        return flyweights.size();
    }
}
public class FlyWeightDemo {
    public static void main(String[] args) {
        WebSiteFactory factory = new WebSiteFactory();

        WebSite fx = factory.getWebSiteCategory("产品展示");
        fx.use(new User1("小菜"));

        WebSite fy = factory.getWebSiteCategory("产品展示");
        fy.use(new User1("大鸟"));

        WebSite fz = factory.getWebSiteCategory("产品展示");
        fz.use(new User1("娇娇"));

        WebSite fl = factory.getWebSiteCategory("博客");
        fl.use(new User1("老顽童"));

        WebSite fm = factory.getWebSiteCategory("博客");
        fm.use(new User1("桃谷六仙"));

        WebSite fn = factory.getWebSiteCategory("博客");
        fn.use(new User1("南海鳄神"));

        System.out.println("得到网站分类总数为:"+factory.getWebSiteCount());
    }
}
