package calculator;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    //-------------------------------------------------------------------------------------------
    public final List<Number> list;
    public final List<Double> circlelist;
    // final 사용 이유 : 참조형 변수의 경우 final을 사용하면 한번 할당한 주소를 변경하지 못하게한다. 밑에 생성자에서 할당을 받으면 이제 어디서도 이 참조형 변수가 바라보는 주소를 바꿀 수 없다.
    // 단, final을 사용했다고 해도 내부의 내용(list의 요소들)은 변경 할 수 있다. 단지 다른곳에서 "list = new ArrayList<>()"같이 새로운 주소를 절대 참조하지 못하게 할 뿐이다.
    //-------------------------------------------------------------------------------------------

    //--------------------------------------------------------------------------------------------
    static final double PI = Math.PI; // static = 전역변수 객체를 만들지 않고도 클래스 수준으로 모두 공유된다. 즉, 다른 클래스에서 객체 생성 없이 "Claculator.PI" 를 통해 접근할 수 있다. 절대적인 값이므로 static으로 선언하여
    // 어디서든 편하게 사용하기 위해 선언했다.

    // final = 변수를 상수화 한것으로 파이는 변하면 안되므로 변경할 수 없도록 상수화 하였다.
    //------------------------------------------------------------------------------------------
    public Calculator() {
        this.list = new ArrayList<Number>();
        this.circlelist = new ArrayList<Double>();
        // 생성자를 통한 초기화 final이 선언된 참조형 변수들이기 때문에 더이상 새로운 주소를 할당 할 수 없다.
    }


    public Number Getter(int index){
        return list.get(index);
    }

    public double Cgetter(int index){ // 원의 넓이 리스트 요소를 반환해주는 메서드
        return circlelist.get(index);
    }

    public void Setter(Number num){
        list.add(num);
    }
    public void Setter(double num){
        circlelist.add(num);
        
    }

    public void removeResult(){
        for(int i=0;i<list.size()-1;i++){
            list.set(i,list.get(i+1));
        }
        list.remove(list.size()-1);
    }

    public void inquiryResults(){
        for(Number i : list){
            System.out.print(i+" ");
        }
        System.out.println();
    }
    public void CinquiryResults(){ // 원의 넓이 목록 출력
        for(double i : circlelist){
            System.out.print(i+" ");
        }
        System.out.println();
    }
}

