package calculator;

public class CircleCalculator extends Calculator{
    public double calculateCircleArea(double radius){ //원의 넓이를 구하는 메서드
        return PI*(radius*radius);
    }
    public void Setter(double num){
        super.Setter(num);
    }

    public double Cgetter(int num){
        return super.Cgetter(num);
    }
}
