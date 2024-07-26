package calculator;

public class AddOperator <T extends Number, U extends Number> implements Operator {
    private T a;
    private U b;

    AddOperator(T a, U b){
        this.a = a;
        this.b = b;
    }


    @Override
    public Number operator(){
        if(this.a instanceof Integer && this.b instanceof Integer){
            return a.intValue() + b.intValue();
        }
        else
            return a.doubleValue() + b.doubleValue();

    }
}

