package calculator;

public class DivideOperator{
    private int a=0;
    private int b=0;

    DivideOperator(int a, int b){
        this.a = a;
        this.b = b;
    }
    public int operator(){
        return this.a / this.b;
    }
}
