package calculator;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    List<Integer> list = new ArrayList<Integer>();

    public int calculate(int a, int b,char operator)throws Exception  {// throws Exception -> 이 메서드를 호출한 곳에서 오류를 처리해야 한다는 의미
        switch (operator) {
            case '+':{
                list.add(a+b);
                break;
            }
            case '-':{
                list.add(a-b);
                break;
            }
            case '*':{
                list.add(a*b);
                break;
            }
            case '/':{
                if(b==0){
                    throw new Exception("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다."); // 오류 메시지를 만들어서 호출한 곳으로 보낸다.
                }
                list.add(a/b);
                break;
            }
            default:{
                throw new Exception("사칙 연산 기호가 아닙니다 (+, -, *, /) 중 하나를 입력하세요");// 오류 메시지를 만들어서 호출한 곳으로 보낸다.
            }
        }
        return list.get(list.size()-1);
    }
}
