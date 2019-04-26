interface State {
    void writeProgram(Work w);
}
class ForenoonState implements State {
    @Override
    public void writeProgram(Work w) {
        if (w.getHour() < 12) {
            System.out.println("当前时间: "+w.getHour()+" 点，上午工作，精神百倍");
        } else {
            w.setState(new NoonState());
            w.writeProgram();
        }
    }
}
class NoonState implements State {
    @Override
    public void writeProgram(Work w) {
        if (w.getHour() < 13) {
            System.out.println("当前时间: "+w.getHour()+" 点 饿了，午饭；犯困，午休。");
        } else {
            w.setState(new AfternoonState());
            w.writeProgram();
        }
    }
}
class AfternoonState implements State {
    @Override
    public void writeProgram(Work w) {
        if (w.getHour() < 17) {
            System.out.println("当前时间: "+w.getHour()+" 点 下午状态还不错，继续努力");
        } else {
            w.setState(new EveningState());
            w.writeProgram();
        }
    }
}
class EveningState implements State {
    @Override
    public void writeProgram(Work w) {
        if (w.getFinish()) {
            w.setState(new RestState());
            w.writeProgram();
        } else {
            if (w.getHour() < 21) {
                System.out.println("当前时间: "+w.getHour()+" 点 加班哦，疲累之极");
            } else {
                w.setState(new SleepingState());
                w.writeProgram();
            }
        }
    }
}
class SleepingState implements State {
    @Override
    public void writeProgram(Work w) {
        System.out.println("当前时间: "+w.getHour()+"点不行了，睡着了。");
    }
}
class RestState implements State {
    @Override
    public void writeProgram(Work w) {
        System.out.println("当前时间: "+w.getHour()+" 点下班回家了");
    }
}
class Work {
    private State current;
    private Integer hour;
    private Boolean finish = false;

    public Integer getHour() {
        return hour;
    }

    public void setHour(Integer hour) {
        this.hour = hour;
    }

    public Boolean getFinish() {
        return finish;
    }

    public void setFinish(Boolean finish) {
        this.finish = finish;
    }

    public void setState(State s){
        this.current = s;
    }

    public void writeProgram(){
        current.writeProgram(this);
    }

    public Work(){
        current = new ForenoonState();
    }
}
public class StateDemo {
    public static void main(String[] args) {
        Work emergencyProjects = new Work();
        emergencyProjects.setHour(9);
        emergencyProjects.writeProgram();
        emergencyProjects.setHour(10);
        emergencyProjects.writeProgram();
        emergencyProjects.setHour(11);
        emergencyProjects.writeProgram();
        emergencyProjects.setHour(12);
        emergencyProjects.writeProgram();
        emergencyProjects.setHour(13);
        emergencyProjects.writeProgram();
        emergencyProjects.setHour(14);
        emergencyProjects.writeProgram();
        emergencyProjects.setHour(17);

        emergencyProjects.setFinish(false);
        emergencyProjects.writeProgram();
        emergencyProjects.setHour(19);
        emergencyProjects.writeProgram();
        emergencyProjects.setHour(22);
        emergencyProjects.writeProgram();
    }
}
