package calculator;

public class ModOperator implements Operator {
    private int a=0;
    private int b=0;

    ModOperator(int a, int b){
        this.a = a;
        this.b = b;
    }

    @Override
    public int operator(){
        return this.a % this.b;
    }
}
