abstract class Manager {
    protected String name;
    protected Manager superior;

    public Manager(String name) {
        this.name = name;
    }

    public void setSuperior(Manager superior){
        this.superior = superior;
    }

    abstract public void requestApplications(Request request);
}
class CommonManager extends Manager {
    public CommonManager(String name) {
        super(name);
    }

    @Override
    public void requestApplications(Request request) {
        if ("请假".equals(request.getRequestType()) && request.getNumber() <= 2) {
            System.out.println(name + ":" + request.getRequestContent() + "数量"+request.getNumber()+"被批准");
        } else {
            if (superior != null) {
                superior.requestApplications(request);
            }
        }
    }
}
class Majordomo extends Manager {
    public Majordomo(String name) {
        super(name);
    }

    @Override
    public void requestApplications(Request request) {
        if ("请假".equals(request.getRequestType()) && request.getNumber() <= 5) {
            System.out.println(name + ":" + request.getRequestContent() + "数量"+request.getNumber()+"被批准");
        } else {
            if (superior != null) {
                superior.requestApplications(request);
            }
        }
    }
}
class GeneralManager extends Manager {
    public GeneralManager(String name) {
        super(name);
    }

    @Override
    public void requestApplications(Request request) {
        if ("请假".equals(request.getRequestType())) {
            System.out.println(name + ":" + request.getRequestContent() + "数量"+request.getNumber()+"被批准");
        } else if ("加薪".equals(request.getRequestType()) && request.getNumber() <= 500) {
            System.out.println(name + ":" + request.getRequestContent() + "数量"+request.getNumber()+"被批准");
        } else if ("加薪".equals(request.getRequestType()) && request.getNumber() > 500) {
            System.out.println(name + ":" + request.getRequestContent() + "数量"+request.getNumber()+"再说吧");
        }
    }
}
class Request {
    private String requestType;
    private Integer number;
    private String requestContent;

    public String getRequestContent() {
        return requestContent;
    }

    public void setRequestContent(String requestContent) {
        this.requestContent = requestContent;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

}

public class ChainOfResponsibilityDemo {
    public static void main(String[] args) {
        CommonManager jinli = new CommonManager("经理");
        Majordomo zongjian = new Majordomo("总监");
        GeneralManager zongjingli = new GeneralManager("总经理");

        jinli.setSuperior(zongjian);
        zongjian.setSuperior(zongjingli);

        Request request = new Request();
        request.setRequestType("请假");
        request.setRequestContent("小菜请假");
        request.setNumber(1);
        jinli.requestApplications(request);

        Request request2 = new Request();
        request2.setRequestType("请假");
        request2.setRequestContent("小菜请假");
        request2.setNumber(4);
        jinli.requestApplications(request2);

        Request request3 = new Request();
        request3.setRequestType("加薪");
        request3.setRequestContent("小菜请求加薪");
        request3.setNumber(500);
        jinli.requestApplications(request3);

        Request request4 = new Request();
        request4.setRequestType("加薪");
        request4.setRequestContent("小菜请求加薪");
        request4.setNumber(1000);
        jinli.requestApplications(request4);
    }
}
