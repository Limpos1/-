package calculator;

public class MultiplyOperator implements Operator{
    private int a=0;
    private int b=0;

    MultiplyOperator(int a, int b){
        this.a = a;
        this.b = b;
    }

    @Override
    public int operator(){
        return this.a * this.b;
    }
}
