class PlayContext {
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
abstract class Expression {
    public void interpret(PlayContext context){
        if (context.getText().length() == 0) {
            return;
        }else{
            String playKey = context.getText().substring(0, 1);
            context.setText(context.getText().substring(2));

            Double playValue = Double.valueOf(context.getText().substring(0, context.getText().indexOf(" ")));
            context.setText(context.getText().substring(context.getText().indexOf(" ")+1));

            execute(playKey, playValue);

        }
    }
    public abstract void execute(String key, Double value);
}
class Note extends Expression {
    @Override
    public void execute(String key, Double value) {
        String note = "";
        switch (key) {
            case "C":
                note = "1";
                break;
            case "D":
                note = "2";
                break;
            case "E":
                note = "3";
                break;
            case "F":
                note = "4";
                break;
            case "G":
                note = "5";
                break;
            case "A":
                note = "6";
                break;
            case "B":
                note = "7";
                break;
            default:
                //nothing
        }
        System.out.println(note+" ");
    }
}
class Scale extends Expression {
    @Override
    public void execute(String key, Double value) {
        String scale = "";
        switch (value.intValue()){
            case 1:
                scale = "低音";
                break;
            case 2:
                scale = "中音";
                break;
            case 3:
                scale = "高音";
                break;
            default:
                // nothing
        }
        System.out.println(scale + " ");
    }
}
class Speed extends Expression {
    @Override
    public void execute(String key, Double value) {
        String speed;
        if (value < 500) {
            speed = "快速";
        } else if (value >= 1000) {
            speed = "慢速";
        } else {
            speed = "中速";
        }
        System.out.println(speed + " ");
    }
}
public class InterpreterDemo {
    public static void main(String[] args) {
        PlayContext context = new PlayContext();
        System.out.println("上海滩:");
        context.setText("T 500 O 2 E 0.5 G 0.5 A 3 E 0.5 G 0.5 D 3 E 0.5 G 0.5 A 0.5 O 3 C 1 O 2");
        Expression expression = null;

        try {
            while (context.getText().length() > 0) {
                String str = context.getText().substring(0, 1);

                switch (str){
                    case "O":
                        expression = new Scale();
                        break;
                    case "T":
                        expression = new Speed();
                        break;
                    case "C":
                    case "D":
                    case "E":
                    case "F":
                    case "G":
                    case "A":
                    case "B":
                    case "P":
                        expression = new Note();
                        break;
                    default:
                        // nothing
                }

                expression.interpret(context);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
