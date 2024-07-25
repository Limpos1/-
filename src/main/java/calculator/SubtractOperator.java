package calculator;

public class SubtractOperator implements Operator {
    private int a=0;
    private int b=0;

    SubtractOperator(int a, int b){
        this.a = a;
        this.b = b;
    }

    @Override
    public int operator(){
        return this.a - this.b;
    }
}
