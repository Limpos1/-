package calculator;

public class MultiplyOperator{
    private int a=0;
    private int b=0;

    MultiplyOperator(int a, int b){
        this.a = a;
        this.b = b;
    }
    public int operator(){
        return this.a * this.b;
    }
}
