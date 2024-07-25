package calculator;

public class AddOperator{
    private int a=0;
    private int b=0;

    AddOperator(int a, int b){
        this.a = a;
        this.b = b;
    }
    public int operator(){
        return this.a + this.b;
    }
}
