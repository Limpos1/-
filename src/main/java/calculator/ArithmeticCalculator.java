package calculator;

import java.util.Objects;

public class ArithmeticCalculator extends Calculator{


    public int calculate(int a, int b,char operator)throws Exception  {// throws Exception -> 이 메서드를 호출한 곳에서 오류를 처리해야 한다는 의미
        int res = 0;

        OperatorType type;
        type = OperatorType.getOperatorType(operator);
        if(type == null){ // switch문은 null값을 처리하지 못하고 오류가 나므로 if에서 검사한다.
            throw new Exception("사칙 연산 기호가 아닙니다 (+, -, *, /, %) 중 하나를 입력하세요");
        }


        switch (type) {
            case ADD:{
                    AddOperator add = new AddOperator(a,b);
                    res = add.operator();
                    break;
                }
            case SUB:{
                    SubtractOperator sub = new SubtractOperator(a,b);
                    res = sub.operator();
                    break;
                }
                case MUL:{
                    MultiplyOperator mul = new MultiplyOperator(a,b);
                    res =mul.operator();
                    break;
                }
                case DIV:{
                    if(b==0){
                        throw new Exception("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다."); // 오류 메시지를 만들어서 호출한 곳으로 보낸다.
                    }
                    DivideOperator div = new DivideOperator(a,b);
                    res =div.operator();
                    break;
                }
                case MOD:{
                    if(b==0){
                        throw new Exception("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다."); // 오류 메시지를 만들어서 호출한 곳으로 보낸다.
                    }
                    ModOperator mod = new ModOperator(a,b);
                    res = mod.operator();
                    break;
                }
                default:{
                    throw new Exception("사칙 연산 기호가 아닙니다 (+, -, *, /, %) 중 하나를 입력하세요");// 오류 메시지를 만들어서 호출한 곳으로 보낸다.
                }
            }



        return res;
    }

    public int Getter(int index){
        return super.Getter(index);
    }

    public void Setter(int num){
        super.Setter(num);
    }

    public void inquiryResults(){
        super.inquiryResults();
    }
    public void removeResult(){
        super.removeResult();
    }

}

